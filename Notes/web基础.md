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