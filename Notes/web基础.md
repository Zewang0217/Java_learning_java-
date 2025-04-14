### 入门程序

- 构建 spring boot， maven， spring web
- 请求处理类 `@ResrConstroller`
- 用`@RequestMapping` 标识请求路径
- 官方脚手架连接不上时，使用 `start.aliyun.com`

### HTTP

- 获取请求数据 → `HttpServletRequest`
- 响应状态码： 2 - 成功， 3 - 重定向，再一次， 4 - 客户端错误， 5 - 服务器错误
- 设置响应数据：`HttpServletResponse` 或 `*ResponseEntity`  （一般不手动设置）*
- 静态资源存放位置： resources/static

## 请求响应获取

- `@RestController` ： 封装了`ResponseBody`  -> 将controller方法的返回值直接作为响应体的数据直接响应；返回值是对象/集合->`json`->响应
- `@RestController`  = `@Controller` + `@RespnseBody`

## 工具类

- `hutool`

  - 获取数据：

    ```java
    InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
    ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
    ```

- `lombok` 依赖

  - `@NoArgsConstructor`
  - `@AllArgsConstructor`
  - 注释器的设置

### 分层解耦

- 三层架构

  - 数据访问、逻辑处理、接受请求和响应数据 → 单一职责原则

  1. controller
  2. Service
  3. Dao (Data Access Object) （多种实现，网络、文本、数据库等等 → 统一接口）

- 项目结构示例

  ![分层案例](D:\Zewang\Java_learning_java学习笔记\Notes\images\分层案例.png)

- 分层解耦

  - 耦合：衡量软件中各个层/模块的依赖关系程度
  - 内聚：软件中各个功能模块内部的功能联系
  - 原则：高内聚，低耦合
  - 步骤
    - **控制反转 IOC： 对象的创建权由程序自身转移到外部（容器）**
    - **依赖注入 DI ： 容器为应用程序提供运行时所依赖的资源**
  - Bean对象：IOC容器中创建、管理的对象

- 步骤：

  1. 为Service 和 Dao 的类 加上 `@Component` 注释，为其分配IOC容器管理
  2. 给Controller 和 Service 中接口类的声明前加上 `@AutoWired` 注释，注入对象

### IOC详解

+ 将某个对象交给IOC容器管理：

| 注解        | 说明                 | 位置                       |
| ----------- | -------------------- | -------------------------- |
| @Component  | 声明bean的基础注解   | 不属于以下三种，用此注解   |
| @Controller | @Component的衍生注解 | 标注在控制层类上           |
| @Service    | @Component的衍生注解 | 标注在业务层类上           |
| @Repository | @Component的衍生注解 | 标注在数据访问层类上（少） |

+  声明bean的时候，可以通过注解的value属性指定bean的名字，否则默认首字母小写
+ 组件扫描 `@ComponentScan` ，启动类的注解 `@SpringBootApplication`默认扫描范围时启动类所在包及其子包

### DI详解

+ 基于`@Autowired`进行依赖注入的常见方法：

  + 属性注入
    ```java
    @RestController
    public class UserController {
        @Autowired
        private UserService userService;
    }
    ```

    + 优点：代码简洁，方便快速开发
    + 缺点：隐藏了类之间的依赖关系、可能破坏封装性

  + 构造函数注入
    ```java
    @ResrController
    public class UserController {
        private final UserService userService;
        @Autowired // 如果当前类中只存在一个构造函数，则@Autowired可以省略
        public UserController(UserService userService) {
            this.userService = userService;
        }
    }
    ```

    + 优点：能清晰看到类的依赖关系、提高了代码安全性（final）
    + 缺点：代码繁琐、如果构造函数过多，可能会导致构造函数臃肿

  + setter注入
    ```java
    @ResrController
    public class UserController {
        private UserService userService;
        @Autowired
        public void setUserController(UserService userService) {
            this.userService = userService;
        }
    }
    ```

    + 优点：保证类的封装性、依赖关系清晰
    + 缺点：要额外写setter方法，增加代码量

  + 开发中选择：构造函数注入（官方推荐）、属性注入（开发过程）

  + 存在多个相同类型的bean时：
    + 在要使用的类前加上 `@Primary `，提升优先级
    + 在使用这个类的类中，`@Autowired` 注释前加上`@Qualifier("bean类名") `（指定注入哪一个bean）
    + `@Resource(name ="bean名字")` 