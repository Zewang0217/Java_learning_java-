# 安装与配置

> 这段内容是 **Apache Maven 的官方安装指南**，解释了如何在不同操作系统（macOS/Linux/Windows）上安装 Maven。
>
> 
>
> ###  Windows 安装 Maven 的推荐方法
>
> #### **(1) 手动安装（适合所有用户）（下面有详细步骤）**
>
> 1. **下载 Maven**：  
>    从 [官网](https://maven.apache.org/download.cgi) 下载 `apache-maven-3.9.9-bin.zip`。
> 2. **解压到本地目录**：  
>    例如 `C:\Program Files\apache-maven-3.9.9`。
> 3. **配置环境变量**：  
>    - 添加 `MAVEN_HOME` = `C:\Program Files\apache-maven-3.9.9`  
>    - 在 `Path` 中添加 `%MAVEN_HOME%\bin`  
> 4. **验证安装**：  
>    打开命令提示符，运行：
>    ```bash
>    mvn -v
>    ```
>    看到版本信息即成功。
>
> #### **(2) 通过 Chocolatey 安装（需管理员权限）**
> 如果你已经安装了 [Chocolatey](https://chocolatey.org/)（Windows 包管理器），直接运行：
> ```bash
> choco install maven
> ```
>
> #### **(3) 通过 Scoop 安装（适合开发者）**
> 如果你更喜欢 Scoop，需先安装 Scoop，再装 Maven：
> ```bash
> # 1. 安装 Scoop（需 PowerShell）
> Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
> irm get.scoop.sh | iex
> 
> # 2. 安装 Maven
> scoop install main/maven
> ```
>
> ---
>
> ### **4. 其他操作系统的安装方式**
> | 系统      | 推荐安装方法                 | 命令                     |
> | --------- | ---------------------------- | ------------------------ |
> | **macOS** | Homebrew                     | `brew install maven`     |
> | **Linux** | 系统包管理器（apt/yum/dnf）  | `sudo apt install maven` |
> | **通用**  | 手动下载配置（任何系统均可） | 见上文手动               |

## 手动安装过程

> 以下是 **手动安装 Apache Maven** 的详细步骤（适用于 **Windows/macOS/Linux**），无需依赖第三方包管理器（如 Scoop/Chocolatey/Homebrew）：
>
> ---
>
> ### **1. 下载 Maven**
> 1. 访问 [Apache Maven 官网下载页](https://maven.apache.org/download.cgi)。  
> 2. 选择最新稳定版本的 **二进制压缩包**（如 `apache-maven-3.9.9-bin.zip` 或 `.tar.gz`）。
>
> ---
>
> ### **2. 解压到本地目录**
>
> #### **Windows**
> - 将下载的 `apache-maven-3.9.9-bin.zip` 解压到任意目录（建议路径简单，如 `C:\Program Files\apache-maven-3.9.9`）。  
>   - 右键压缩包 → `解压到当前文件夹`。
>
> #### **macOS/Linux**
>
> - 打开终端，运行以下命令（以 `.tar.gz` 为例）：
>   ```bash
>   tar -xzvf apache-maven-3.9.9-bin.tar.gz -C /opt
>   ```
>   - 解压后路径：`/opt/apache-maven-3.9.9`。
>
> ---
>
> ### **配置环境变量**
>
> **Windows**
>
> 1. **添加 `MAVEN_HOME`**：
>    - 打开 **系统设置** → **高级系统设置** → **环境变量**。
>    - 在 **系统变量** 中点击 **新建**：
>      - 变量名：`MAVEN_HOME`
>      - 变量值：`C:\Program Files\apache-maven-3.9.9`（你的 Maven 解压路径）。
>
> 2. **编辑 `PATH` 变量**：
>
>    - 在 `Path` 变量中点击 **编辑** → **新建**，添加：
>      ```
>      C:\Program Files\apache-maven-3.9.9\bin
>      ```
>
> 3. **验证配置**：
>    - 打开 **新的 PowerShell 窗口**（重要！旧的窗口不会加载新配置）。
>    - 运行：
>      ```powershell
>      echo $env:MAVEN_HOME  # 应输出 Maven 路径
>      echo $env:PATH        # 检查是否包含 %MAVEN_HOME%\bin
>      ```
>
> #### **macOS/Linux**
> 1. 编辑 shell 配置文件（如 `~/.bashrc`、`~/.zshrc` 或 `~/.bash_profile`）：  
>    ```bash
>    export MAVEN_HOME=/opt/apache-maven-3.9.9  # 替换为你的路径
>    export PATH=$MAVEN_HOME/bin:$PATH
>    ```
> 2. 使配置生效：  
>    ```bash
>    source ~/.bashrc  # 根据你修改的文件调整
>    ```
>
> ---
>
> ### **4. 验证安装**
> 打开终端（Windows 为 CMD/PowerShell），运行：
> ```bash
> mvn -v // mvn
> mvnd -v // mvnd
> // 提前看好你的是mvn or mvnd
> ```
> 成功输出示例：
> ```
> Apache Maven 3.9.9 (...)
> Maven home: /opt/apache-maven-3.9.9
> Java version: 1.8.0_301, vendor: Oracle Corporation
> OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
> ```
>
> ------
>
> 



## `mvnd`

+ 若安装的是`mvnd`，将私有`mvn`替换为`mvnd`即可
+ `mvnd`是`mvn`的拓展版，功能更加强大

## 配置阿里云镜像服务器 （推荐）

> 在 Maven 或 `mvnd` 下载依赖时**立即切换阿里云镜像**，可以通过以下两种方式实现：
>
> ---
>
> ### **方法 1：临时单次使用阿里云（不修改配置）**
> 在命令行直接指定阿里云仓库地址（适用于当前命令）：
> ```powershell
> # 使用 mvnd（Maven Daemon）
> mvnd clean install -Dmaven.repo.remote=https://maven.aliyun.com/repository/public
> 
> # 使用传统 mvn（需提前安装标准 Maven）
> mvn clean install -Dmaven.repo.remote=https://maven.aliyun.com/repository/public
> ```
>
> **效果**：  
> 仅本次构建从阿里云下载依赖，不修改全局配置。
>
> ---
>
> ### **方法 2：永久配置阿里云镜像（推荐）**
> 修改 Maven 的 `settings.xml` 文件（对` mvnd` 和 `mvn` 均生效）：
>
> #### **步骤 1：找到配置文件**
> - **`mvnd` 的 `settings.xml` 路径**：  
>   `maven-mvnd-1.0.2-windows-amd64\mvn\conf\settings.xml`  
> - **传统 Maven 的 `settings.xml` 路径**：  
>   `~/.m2/settings.xml`（用户目录下，若不存在需新建）
>
> #### **步骤 2：添加阿里云镜像**
> 用文本编辑器打开 `settings.xml`，在 `<mirrors>` 标签内添加：
> ```xml
> <mirror>
>   <id>aliyun</id>
>   <name>Aliyun Maven Mirror</name>
>   <url>https://maven.aliyun.com/repository/public</url>
>   <mirrorOf>central</mirrorOf>
> </mirror>
> ```
>
> #### **步骤 3：验证是否生效**
>
> + 如果项目还没创建，不执行，跳转到[五分钟开始Maven](#五分钟开始Maven)
>
> 运行以下命令，观察日志中是否出现 `Downloading from aliyun`：
> ```powershell
> mvnd clean install
> # 或
> mvn clean install
> ```
>
> ---
>
> ### **方法 3：强制覆盖仓库地址（极端情况）**
> 如果镜像不生效，直接在 `pom.xml` 中强制指定阿里云仓库（不推荐长期使用）：
> ```xml
> <project>
>   ...
>   <repositories>
>     <repository>
>       <id>aliyun</id>
>       <url>https://maven.aliyun.com/repository/public</url>
>     </repository>
>   </repositories>
>   <pluginRepositories>
>     <pluginRepository>
>       <id>aliyun</id>
>       <url>https://maven.aliyun.com/repository/public</url>
>     </pluginRepository>
>   </pluginRepositories>
> </project>
> ```
>
> ---
>
> ### **注意事项**
> 1. **确保网络无代理/VPN干扰**：  
>    如果公司网络有限制，可能需要配置代理：
>    ```powershell
>    set HTTP_PROXY=http://your-proxy:port
>    set HTTPS_PROXY=http://your-proxy:port
>    ```
> 2. **首次下载仍慢？**  
>    本地仓库（`~/.m2/repository`）是空的时，首次下载会较慢，后续构建会直接使用缓存。
>
> 3. **检查镜像是否生效**：  
>    如果日志中仍显示 `Downloading from central`，说明镜像配置未生效，检查 `settings.xml` 路径是否正确。
>
> ---
>
> ### **总结**
> | 方案                  | 适用场景                 | 效果          |
> | --------------------- | ------------------------ | ------------- |
> | **临时命令行参数**    | 紧急加速单次构建         | ⭐⭐⭐⭐          |
> | **修改 settings.xml** | 永久加速所有构建（推荐） | ⭐⭐⭐⭐⭐（极快） |
> | **强制修改 pom.xml**  | 特殊项目临时需求         | ⭐⭐⭐           |
>
> **推荐操作**：直接修改 `settings.xml`，一劳永逸！



# 五分钟开始Maven

+ [点击跳转到官方文档](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

> # Maven 5分钟快速入门指南
>
> ## 准备工作
>
> 1. **安装Java**：确保已安装JDK（Java开发工具包）
> 2. **验证Java安装**：在命令行输入 `java -version` 应显示版本信息
>
> ## 安装Maven
> 1. 下载Maven压缩包并解压到指定目录（如 `D:\apache-maven`）
> 2. 将Maven的bin目录（如 `D:\apache-maven\bin`）添加到系统PATH环境变量
> 3. 验证安装：命令行输入 `mvn --version` 应显示Maven和Java版本信息
>
> ## 创建第一个项目
> 1. 在命令行执行以下命令创建项目：
>    ```bash
>    mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
>    ```
>    - 首次运行会下载依赖，可能需要较长时间
>    - 如果超时，可重复执行命令
>
> 2. 进入项目目录：
>    ```bash
>    cd my-app
>    ```
>
> ## 项目结构说明
> ```
> my-app
> |-- pom.xml            # 项目配置文件
> `-- src
>     |-- main           # 主代码目录
>     |   `-- java
>     |       `-- com
>     |           `-- mycompany
>     |               `-- app
>     |                   `-- App.java
>     `-- test          # 测试代码目录
>         `-- java
>             `-- com
>                 `-- mycompany
>                     `-- app
>                         `-- AppTest.java
> ```
>
> ## 构建项目
> 1. 在项目目录下执行打包命令：
>    ```bash
>    mvn package
>    ```
>    - 这会执行编译、测试和打包操作
>    - 成功后会在target目录生成JAR文件
>
> 2. 运行程序：
>    ```bash
>    java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
>    ```
>    输出应为：`Hello World!`
>
> + 附上我的命令行：
>
>   ![PixPin_2025-03-30_13-25-15](D:\Zewang\PROJECTS\mvnd_first_project\learning note\PixPin_2025-03-30_13-25-15.png)
>
> ## 常用Maven命令
>
> - `mvn compile`：编译源代码
> - `mvn test`：运行测试
> - `mvn clean`：清理target目录
> - `mvn install`：安装到本地仓库
> - `mvn site`：生成项目文档网站
>
> ## Java 9+支持
> 在pom.xml中添加以下配置可支持Java 11：
> ```xml
> <properties>
>     <maven.compiler.release>11</maven.compiler.release>
> </properties>
> <build>
>     <pluginManagement>
>         <plugins>
>             <plugin>
>                 <groupId>org.apache.maven.plugins</groupId>
>                 <artifactId>maven-compiler-plugin</artifactId>
>                 <version>3.8.1</version>
>             </plugin>
>         </plugins>
>     </pluginManagement>
> </build>
> ```
>
> ## 注意事项
> 1. 首次运行会下载大量依赖，请耐心等待
> 2. 如果网络问题导致失败，可配置国内镜像
> 3. Windows用户可能需要配置防火墙允许Java访问网络
>
> 这个快速指南涵盖了Maven的基本使用，更多详细信息可参考官方文档。

# Mevan入门指南 （精简版）

## 什么是 Maven？

Maven 是一个项目管理和构建自动化工具，主要功能包括：

- 项目构建
- 依赖管理
- 文档生成
- 项目报告
- 发布管理

## Pom文件简述

`pom.xml` 是 Maven 项目的核心配置文件，主要元素：

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.mycompany.app</groupId>  <!-- 组织标识 -->
  <artifactId>my-app</artifactId>      <!-- 项目标识 -->
  <version>1.0-SNAPSHOT</version>      <!-- 版本号 -->
  
  <dependencies>                       <!-- 项目依赖 -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  
  <build>                             <!-- 构建配置 -->
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```



## 常用命令

| 命令          | 功能描述         |
| :------------ | :--------------- |
| `mvn compile` | 编译主代码       |
| `mvn test`    | 运行测试         |
| `mvn package` | 打包项目         |
| `mvn install` | 安装到本地仓库   |
| `mvn clean`   | 清理 target 目录 |
| `mvn site`    | 生成项目文档     |
| `mvn deploy`  | 部署到远程仓库   |

## 依赖管理

添加依赖示例（在 pom.xml 中）：

```xml
<dependencies>
  <!-- Log4j 依赖 -->
  <dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
  </dependency>
  
  <!-- MySQL 驱动 -->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.23</version>
  </dependency>
</dependencies>
```



依赖范围（scope）：

- `compile`：默认范围，所有阶段有效
- `provided`：编译和测试有效，运行时由容器提供
- `runtime`：运行时需要
- `test`：仅测试有效
- `system`：系统范围，需指定 systemPath

## 多模块项目

父项目 pom.xml：

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.mycompany</groupId>
  <artifactId>parent-project</artifactId>
  <version>1.0.0</version>
  <packaging>pom</packaging>
  
  <modules>
    <module>module1</module>
    <module>module2</module>
  </modules>
</project>
```



子模块需添加：

```xml
<parent>
  <groupId>com.mycompany</groupId>
  <artifactId>parent-project</artifactId>
  <version>1.0.0</version>
</parent>
```



## 构建 WAR 项目

创建 Web 项目：

```bash
mvn archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DarchetypeArtifactId=maven-archetype-webapp \
  -DgroupId=com.mycompany \
  -DartifactId=my-webapp
```

关键配置：

```html
<packaging>war</packaging>

<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>
```



## 常见问题解决

1. **下载慢**：配置国内镜像

   ```html
   <!-- settings.xml -->
   <mirror>
     <id>aliyun</id>
     <mirrorOf>central</mirrorOf>
     <name>Aliyun Maven</name>
     <url>https://maven.aliyun.com/repository/central</url>
   </mirror>
   ```

   

2. **编译版本问题**：

   ```xml
   <properties>
     <maven.compiler.source>1.8</maven.compiler.source>
     <maven.compiler.target>1.8</maven.compiler.target>
   </properties>
   ```

   

3. **资源过滤**：

   ```xml
   <resources>
     <resource>
       <directory>src/main/resources</directory>
       <filtering>true</filtering>
     </resource>
   </resources>
   ```

   

## 最佳实践

1. 遵循标准目录结构
2. 使用明确的版本号（避免 LATEST）
3. 合理划分模块
4. 持续集成环境配置 settings.xml
5. 定期清理本地仓库（`mvn dependency:purge-local-repository`）

通过本指南，您应该已经掌握了 Maven 的基本用法。如需更深入的学习，可以参考：

- 官方文档：https://maven.apache.org/guides/
- Maven 实战（许晓斌著）