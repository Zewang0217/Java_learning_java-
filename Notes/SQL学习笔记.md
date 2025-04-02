[点击跳转到w3school的SQL学习界面](https://www.w3schools.com/sql/default.asp)

------

# 目录：

+ [SQL简介](#SQL简介)
+ [基本语法与语句详解](#SQL 语法基础)



## SQL简介

SQL是一种用于访问和操作数据库的标准语言。  

### 什么是SQL？

- SQL全称为**结构化查询语言**（Structured Query Language）  
- SQL可用于访问和操作数据库  
- SQL于1986年成为美国国家标准协会（ANSI）标准，并于1987年成为国际标准化组织（ISO）标准  

  ------

  

### SQL能做什么？  
- 对数据库执行查询  
- 从数据库中检索数据  
- 向数据库中插入记录  
- 更新数据库中的记录  
- 删除数据库中的记录  
- 创建新数据库  
- 在数据库中创建新表  
- 在数据库中创建存储过程  
- 在数据库中创建视图  
- 对表、存储过程和视图设置权限  

  ------

  

### SQL是标准，但……

尽管SQL是ANSI/ISO标准，但不同数据库系统存在不同的SQL版本。  

不过，为了符合ANSI标准，所有SQL实现至少支持主要命令（如`SELECT`、`UPDATE`、`DELETE`、`INSERT`、`WHERE`），且用法相似。  

注意：大多数SQL数据库程序除了支持标准SQL外，还有各自的专有扩展功能！  

------



### 在网站中使用SQL

要构建一个从数据库显示数据的网站，您需要：  
1. 一个RDBMS数据库程序（如MS Access、SQL Server、MySQL）  
2. 使用服务器端脚本语言（如PHP或ASP）  
3. 使用SQL获取所需数据  
4. 使用HTML/CSS设计页面样式  

   ------

   

### RDBMS

RDBMS代表**关系型数据库管理系统**（Relational Database Management System）。  

RDBMS是SQL的基础，也是所有现代数据库系统（如MS SQL Server、IBM DB2、Oracle、MySQL和Microsoft Access）的核心。  

RDBMS中的数据存储在称为**表**的数据库对象中。表是相关数据项的集合，由列和行组成。  

以“Customers”表为例：  

```sql
SELECT * FROM Customers;
```

每个表被划分为更小的单元称为**字段**。Customers表中的字段包括CustomerID（客户ID）、CustomerName（客户名称）、ContactName（联系人）、Address（地址）、City（城市）、PostalCode（邮政编码）和Country（国家）。字段是表中的列，用于存储表中每条记录的特定信息。  

**记录**（也称为行）是表中每个独立的条目。例如，上述Customers表中有91条记录。记录是表中的水平实体。  

**列**是表中的垂直实体，包含与表中特定字段关联的所有信息。

------



## SQL 语法基础

### SQL 语句

大多数数据库操作都是通过 SQL 语句完成的。SQL 语句由易于理解的关键字组成。  

**示例：** 从 `Customers` 表中选择所有记录  
```sql
SELECT * FROM Customers;
```

---

### 数据库表（Tables）  
数据库通常包含一个或多个表，每个表都有一个名称（如 `Customers` 或 `Orders`），并包含数据记录（行）。  

**示例：** `Customers` 表的部分数据  

| CustomerID | CustomerName                       | ContactName        | Address                       | City        | PostalCode | Country |
| ---------- | ---------------------------------- | ------------------ | ----------------------------- | ----------- | ---------- | ------- |
| 1          | Alfreds Futterkiste                | Maria Anders       | Obere Str. 57                 | Berlin      | 12209      | Germany |
| 2          | Ana Trujillo Emparedados y helados | Ana Trujillo       | Avda. de la Constitución 2222 | México D.F. | 05021      | Mexico  |
| 3          | Antonio Moreno Taquería            | Antonio Moreno     | Mataderos 2312                | México D.F. | 05023      | Mexico  |
| 4          | Around the Horn                    | Thomas Hardy       | 120 Hanover Sq.               | London      | WA1 1DP    | UK      |
| 5          | Berglunds snabbköp                 | Christina Berglund | Berguvsvägen 8                | Luleå       | S-958 22   | Sweden  |

- **5 条记录**（每行代表一个客户）  
- **7 列**（CustomerID、CustomerName、ContactName 等）  

---

### 注意事项  
1. **SQL 关键字不区分大小写**  
   - `SELECT` 和 `select` 是相同的。  
   - 本教程中，SQL 关键字使用大写字母。  

2. **SQL 语句末尾的分号**  
   - 某些数据库系统要求 SQL 语句以分号 `;` 结尾。  
   - 分号用于分隔同一请求中的多个 SQL 语句。  
   - 本教程中，所有 SQL 语句均以分号结尾。  

---

### **最重要的 SQL 命令**

| 命令              | 说明                 |
| ----------------- | -------------------- |
| `SELECT`          | 从数据库提取数据     |
| `UPDATE`          | 更新数据库中的数据   |
| `DELETE`          | 删除数据库中的数据   |
| `INSERT INTO`     | 向数据库插入新数据   |
| `CREATE DATABASE` | 创建新数据库         |
| `ALTER DATABASE`  | 修改数据库           |
| `CREATE TABLE`    | 创建新表             |
| `ALTER TABLE`     | 修改表结构           |
| `DROP TABLE`      | 删除表               |
| `CREATE INDEX`    | 创建索引（加速搜索） |
| `DROP INDEX`      | 删除索引             |

---

### 练习  
**问题：** 哪条 SQL 语句用于从 `Customers` 表中选择所有记录？  

- [ ] `SELECT FROM Customers;`  
- [ ] `SELECT ALL FROM Customers;`  
- [ ] `SELECT * FROM Customers;` 
- [ ] `GET ALL FROM Customers;`  

**答案：** `SELECT * FROM Customers;`

------

## SQL SELECT 语句详解

### SELECT 语句的作用

### Example

Return data from the Customers table:

SELECT CustomerName, City FROM Customers;

✅ **正确答案：To select data from a database**  
SELECT 语句专门用于从数据库中查询/选择数据，这是它唯一且最重要的功能。

------

### 基础语法

```sql
SELECT column1, column2, ...
FROM table_name;
```

+ **选择** 列 **从** 列表

------

### 实际案例演示

以示例数据库中的 Customers 表为例：

| CustomerID | CustomerName                       | City        |
| ---------- | ---------------------------------- | ----------- |
| 1          | Alfreds Futterkiste                | Berlin      |
| 2          | Ana Trujillo Emparedados y helados | México D.F. |
| 3          | Antonio Moreno Taquería            | México D.F. |

1. **选择特定列**（推荐方式）
```sql
SELECT CustomerName, City FROM Customers;
```
→ 只返回客户名称和城市两列数据

2. **选择所有列**（谨慎使用）
```sql
SELECT * FROM Customers;
```
→ 返回表中所有列（当表有几十列时可能导致**性能问题**）

------

### 关键注意事项

1. **性能优化**：生产环境中应避免使用 SELECT *，明确指定需要的列
2. **大小写不敏感**：SELECT 和 select 等效，但保持统一风格更专业
3. **分号使用**：多数数据库要求语句以分号结尾

   ------

   ### 与其他语句的对比

| 语句        | 功能         | 示例                    |
| ----------- | ------------ | ----------------------- |
| SELECT      | 查询数据     | SELECT * FROM Products  |
| INSERT INTO | 插入新数据   | INSERT INTO...VALUES... |
| UPDATE      | 修改已有数据 | UPDATE...SET...WHERE... |
| DELETE      | 删除数据     | DELETE FROM...WHERE...  |

------

### 进阶用法提示

• 可以使用 WHERE 添加条件筛选  
• 结合 ORDER BY 对结果排序  
• 使用 LIMIT/OFFSET 控制返回行数

------

### Exercise

What is the purpose of the SQL `SELECT` statement?

- [ ] To insert data into a database

- [x] To select data from a database

- [ ] To delete data from a database

- [ ] To update data in a database

**练习解析**：题目明确询问 SELECT 语句的用途，其核心功能就是从数据库读取数据，不涉及增删改操作。

------

## SQL SELECT DISTINCT 语句详解

### DISTINCT 的作用

Select all the different countries from the "Customers" table:

```sql
SELECT DISTINCT Country FROM Customers;
```

  DISTINCT 关键字用于**返回列中唯一不重复的值**，消除结果集中的重复项。

### 基础语法

```sql
SELECT DISTINCT column1, column2, ...
FROM table_name;
```

### 实际案例演示

以 Customers 表为例：

| Country |
| ------- |
| Germany |
| Mexico  |
| Mexico  |
| UK      |
| Sweden  |

1. **普通 SELECT 查询**（含重复值）
```sql
SELECT Country FROM Customers;
```
→ 返回所有记录，包含重复的"Mexico"

2. **DISTINCT 查询**（去重）
```sql
SELECT DISTINCT Country FROM Customers;
```
→ 返回：Germany, Mexico, UK, Sweden（无重复）

3. **统计不重复值数量**
```sql
SELECT COUNT(DISTINCT Country) FROM Customers;
```
→ 返回：4（表示有4个不同的国家）

### 特殊注意事项

1. **Access 数据库的替代方案**：
```sql
SELECT Count(*) AS DistinctCountries
FROM (SELECT DISTINCT Country FROM Customers);
```

2. **多列去重**：
```sql
SELECT DISTINCT City, Country FROM Customers;
```
→ 只有当城市和国家组合重复时才会被过滤

3. **性能影响**：DISTINCT 操作需要额外计算资源，大数据表慎用

### 常见误区

× `SELECT UNIQUE Country...` → UNIQUE 不是标准SQL关键字  
× `WHERE Country IS UNIQUE` → 无效语法  
× 认为 DISTINCT 对 NULL 值也有效（实际上NULL被视为相同值）

### 与其他去重方法对比

| 方法                 | 特点                     | 示例                      |
| -------------------- | ------------------------ | ------------------------- |
| DISTINCT             | 标准SQL语法              | SELECT DISTINCT...        |
| GROUP BY             | 可实现类似效果但用途不同 | SELECT City GROUP BY City |
| ROW_NUMBER()窗口函数 | 更灵活的高级去重方式     | 需要OVER子句配合使用      |

**练习**：

Which of the following SQL statements would return a list of all unique countries from a table named 'Customers'?

- [ ] SELECT UNIQUE Country FROM Customers;

- [ ] SELECT Country FROM Customers;

- [x] SELECT DISTINCT Country FROM Customers;

- [ ] SELECT * FROM Customers WHERE Country IS UNIQUE;

题目要求返回唯一国家列表，标准SQL语法应使用DISTINCT关键字。虽然某些数据库可能支持UNIQUE作为DISTINCT的同义词，但不是所有DBMS都支持，因此DISTINCT是通用标准答案。

------

## SQL WHERE 子句

### WHERE 子句的作用

WHERE 子句用于**筛选**记录，仅提取满足**指定条件**的记录。

### 示例

选择所有来自墨西哥的客户：

```sql
SELECT * FROM Customers
WHERE Country='Mexico';
```

### 语法

```sql
SELECT 列名1, 列名2, ...
FROM 表名
WHERE 条件;
```

> 注意：WHERE 子句不仅用于SELECT语句，还用于UPDATE、DELETE等操作！

### 演示数据库

以下是示例中使用的Customers表的部分数据：

| CustomerID | CustomerName                       | ContactName        | Address                       | City        | PostalCode | Country |
| :--------- | :--------------------------------- | :----------------- | :---------------------------- | :---------- | :--------- | :------ |
| 1          | Alfreds Futterkiste                | Maria Anders       | Obere Str. 57                 | Berlin      | 12209      | Germany |
| 2          | Ana Trujillo Emparedados y helados | Ana Trujillo       | Avda. de la Constitución 2222 | México D.F. | 05021      | Mexico  |
| 3          | Antonio Moreno Taquería            | Antonio Moreno     | Mataderos 2312                | México D.F. | 05023      | Mexico  |
| 4          | Around the Horn                    | Thomas Hardy       | 120 Hanover Sq.               | London      | WA1 1DP    | UK      |
| 5          | Berglunds snabbköp                 | Christina Berglund | Berguvsvägen 8                | Luleå       | S-958 22   | Sweden  |

### 文本字段与数字字段的区别

SQL要求在文本值周围使用单引号（大多数数据库系统也允许双引号），而数字字段不应加引号：

### 示例

```sql
SELECT * FROM Customers
WHERE CustomerID = 1;
```

### **WHERE** 子句中的运算符

除了等号(=)运算符外，还可以使用其他运算符来筛选数据。

### 示例

选择CustomerID大于80的所有客户：

```sql
SELECT * FROM Customers
WHERE CustomerID > 80;
```

### 可用运算符

| 运算符      | 描述                              | 示例                                 |
| :---------- | :-------------------------------- | :----------------------------------- |
| **=**       | 等于                              |                                      |
| >           | 大于                              |                                      |
| <           | 小于                              |                                      |
| >=          | 大于或等于                        |                                      |
| <=          | 小于或等于                        |                                      |
| **<>**      | 不等于（某些SQL版本中可能写作!=） | WHERE Price <> 18;                   |
| **BETWEEN** | 在某个范围内                      | WHERE Price BETWEEN 50 AND 60;       |
| **LIKE**    | 搜索某种模式                      | WHERE City LIKE 's%'; (s 开头的城市) |
| **IN**      | 指定列的多个可能值                | WHERE City IN ('Paris','London');    |

### 练习

❓ WHERE子句的主要用途是什么？

- [ ] 指定要从中选择数据的表

- [x] 筛选满足指定条件的记录

- [ ] 连接多个表

- [ ] 按升序排序记录

  ------

  

## SQL ORDER BY 关键字

### ORDER BY 的作用

ORDER BY 关键字用于对**结果集**进行**升序**或**降序**排序。

### 示例

按价格对产品进行排序：

```sql
SELECT * FROM Products
ORDER BY Price;
```

### 语法

```sql
SELECT 列名1, 列名2, ...
FROM 表名
ORDER BY 列名1, 列名2, ... 升序|降序;
```

演示数据库

以下是示例中使用的Products表的部分数据：

| ProductID | ProductName                  | SupplierID | CategoryID | Unit                | Price |
| :-------- | :--------------------------- | :--------- | :--------- | :------------------ | :---- |
| 1         | Chais                        | 1          | 1          | 10 boxes x 20 bags  | 18    |
| 2         | Chang                        | 1          | 1          | 24 - 12 oz bottles  | 19    |
| 3         | Aniseed Syrup                | 1          | 2          | 12 - 550 ml bottles | 10    |
| 4         | Chef Anton's Cajun Seasoning | 2          | 2          | 48 - 6 oz jars      | 22    |
| 5         | Chef Anton's Gumbo Mix       | 2          | 2          | 36 boxes            | 21.35 |

### 降序排序

ORDER BY 关键字**默认按升序**排序。要按降序排序，需使用 DESC 关键字。

### 示例

按价格从高到低排序产品：

```sql
SELECT * FROM Products
ORDER BY Price DESC;
```

### 字母顺序排序

对于字符串值，ORDER BY 关键字会按字母顺序排序：

### 示例

按产品名称字母顺序排序：

```sql
SELECT * FROM Products
ORDER BY ProductName;
```

### 字母逆序排序

要按字母逆序排序，使用 DESC 关键字：

### 示例

按产品名称字母逆序排序：

```sql
SELECT * FROM Products
ORDER BY ProductName DESC;
```

### 多列排序

以下SQL语句从"Customers"表中选择所有客户，先按"Country"排序，如果**某些行Country相同，则按"CustomerName"排序**：

### 示例

```sql
SELECT * FROM Customers
ORDER BY Country, CustomerName;
```

### 混合使用ASC和DESC

以下SQL语句从"Customers"表中选择所有客户，按"Country"升序排序，按"CustomerName"降序排序：

### 示例

```sql
SELECT * FROM Customers
ORDER BY Country ASC, CustomerName DESC;
```

### 练习

❓ SQL ORDER BY 关键字的主要用途是什么？

- [ ] 根据条件筛选记录

- [ ] 将具有相同值的记录分组

- [x] 按升序或降序对记录进行排序

  ------

## SQL AND 运算符

### AND 运算符的作用

WHERE 子句可以包含一个或多个 AND 运算符。AND 运算符用于基于多个条件**筛选**记录，例如您想返回所有来自西班牙且名称以字母'G'开头的客户：

示例

选择所有来自西班牙且名称以'G'开头的客户：

```sql
SELECT *
FROM Customers
WHERE Country = 'Spain' AND CustomerName LIKE 'G%';
```

### 语法

```sql
SELECT 列名1, 列名2, ...
FROM 表名
WHERE 条件1 AND 条件2 AND 条件3 ...;
```

### AND 与 OR 的区别

- AND 运算符：仅当所有条件都为 TRUE 时显示记录
- OR 运算符：只要任一条件为 TRUE 就显示记录

### 演示数据库

以下是示例中使用的Customers表的部分数据：

| CustomerID | CustomerName                       | ContactName        | Address                       | City        | PostalCode | Country |
| :--------- | :--------------------------------- | :----------------- | :---------------------------- | :---------- | :--------- | :------ |
| 1          | Alfreds Futterkiste                | Maria Anders       | Obere Str. 57                 | Berlin      | 12209      | Germany |
| 2          | Ana Trujillo Emparedados y helados | Ana Trujillo       | Avda. de la Constitución 2222 | México D.F. | 05021      | Mexico  |
| 3          | Antonio Moreno Taquería            | Antonio Moreno     | Mataderos 2312                | México D.F. | 05023      | Mexico  |
| 4          | Around the Horn                    | Thomas Hardy       | 120 Hanover Sq.               | London      | WA1 1DP    | UK      |
| 5          | Berglunds snabbköp                 | Christina Berglund | Berguvsvägen 8                | Luleå       | S-958 22   | Sweden  |

### 所有条件必须为真

以下SQL语句选择Country为"Germany"、City为"Berlin"且PostalCode大于12000的所有客户记录：

### 示例

```sql
SELECT * FROM Customers
WHERE Country = 'Germany'
AND City = 'Berlin'
AND PostalCode > 12000;
```

### 组合使用 AND 和 OR

可以组合使用 AND 和 OR 运算符。

以下SQL语句选择所有来自西班牙且名称以"G"或"R"开头的客户。注意使用括号确保正确结果。

### 正确示例

选择所有名称以"G"或"R"开头的西班牙客户：

```sql
SELECT * FROM Customers
WHERE Country = 'Spain' AND (CustomerName LIKE 'G%' OR CustomerName LIKE 'R%');
```

### 错误示例（缺少括号）

如果不使用括号，查询将返回：

1. 所有来自西班牙且名称以"G"开头的客户
2. 所有名称以"R"开头的客户（不考虑国家）

```sql
SELECT * FROM Customers
WHERE Country = 'Spain' AND CustomerName LIKE 'G%' OR CustomerName LIKE 'R%';
```

### 练习

❓ 哪个SQL关键字用于基于多个条件筛选记录？

- [x] WHERE

- [ ] FILTER

- [ ] MULTI

- [ ] IN

  ------

  以下 OR 的内容有所重复，可以酌情跳过~~~

## SQL OR 运算符

### OR 运算符的作用

WHERE 子句可以包含一个或多个 OR 运算符。OR 运算符用于基于多个条件筛选记录，只要满足任一条件即可返回记录。例如，您想返回所有来自德国或西班牙的客户：

### 示例

选择所有来自德国或西班牙的客户：

```sql
SELECT *
FROM Customers
WHERE Country = 'Germany' OR Country = 'Spain';
```

### 语法

```sql
SELECT 列名1, 列名2, ...
FROM 表名
WHERE 条件1 OR 条件2 OR 条件3 ...;
```

### OR 与 AND 的区别

- OR 运算符：只要任一条件为 TRUE 就显示记录
- AND 运算符：仅当所有条件都为 TRUE 时显示记录

### 演示数据库

以下是示例中使用的Customers表的部分数据：

| CustomerID | CustomerName                       | ContactName        | Address                       | City        | PostalCode | Country |
| :--------- | :--------------------------------- | :----------------- | :---------------------------- | :---------- | :--------- | :------ |
| 1          | Alfreds Futterkiste                | Maria Anders       | Obere Str. 57                 | Berlin      | 12209      | Germany |
| 2          | Ana Trujillo Emparedados y helados | Ana Trujillo       | Avda. de la Constitución 2222 | México D.F. | 05021      | Mexico  |
| 3          | Antonio Moreno Taquería            | Antonio Moreno     | Mataderos 2312                | México D.F. | 05023      | Mexico  |
| 4          | Around the Horn                    | Thomas Hardy       | 120 Hanover Sq.               | London      | WA1 1DP    | UK      |
| 5          | Berglunds snabbköp                 | Christina Berglund | Berguvsvägen 8                | Luleå       | S-958 22   | Sweden  |

### 至少满足一个条件

以下SQL语句选择City为"Berlin"、或CustomerName以"G"开头、或Country为"Norway"的所有客户记录：

### 示例

```sql
SELECT * FROM Customers
WHERE City = 'Berlin' OR CustomerName LIKE 'G%' OR Country = 'Norway';
```

### 组合使用 AND 和 OR

可以组合使用 AND 和 OR 运算符。

以下SQL语句选择所有来自西班牙且名称以"G"或"R"开头的客户。注意使用括号确保正确结果。

### 正确示例

选择所有名称以"G"或"R"开头的西班牙客户：

```sql
SELECT * FROM Customers
WHERE Country = 'Spain' AND (CustomerName LIKE 'G%' OR CustomerName LIKE 'R%');
```

### 错误示例（缺少括号）

如果不使用括号，查询将返回：

1. 所有来自西班牙且名称以"G"开头的客户
2. 所有名称以"R"开头的客户（不考虑国家）

```sql
SELECT * FROM Customers
WHERE Country = 'Spain' AND CustomerName LIKE 'G%' OR CustomerName LIKE 'R%';
```

### 练习

❓ SQL OR 运算符的主要用途是什么？

- [x] 基于多个条件筛选记录，其中至少一个条件为真

- [ ] 基于多个条件筛选记录，其中所有条件必须为真

- [ ] 按降序对记录排序

- [ ] 计算表中的行数

  ------

  

## SQL NOT 运算符

## NOT 运算符的作用
NOT 运算符与其他运算符结合使用，返回相反（否定）的结果。

### 基本示例
选择所有不来自西班牙的客户：

```sql
SELECT * FROM Customers
WHERE NOT Country = 'Spain';
```

### 语法

```sql
SELECT 列名1, 列名2, ...
FROM 表名
WHERE NOT 条件;
```

### 演示数据库

以下是示例中使用的Customers表的部分数据：

| CustomerID | CustomerName                       | ContactName        | City        | Country |
| :--------- | :--------------------------------- | :----------------- | :---------- | :------ |
| 1          | Alfreds Futterkiste                | Maria Anders       | Berlin      | Germany |
| 2          | Ana Trujillo Emparedados y helados | Ana Trujillo       | México D.F. | Mexico  |
| 3          | Antonio Moreno Taquería            | Antonio Moreno     | México D.F. | Mexico  |
| 4          | Around the Horn                    | Thomas Hardy       | London      | UK      |
| 5          | Berglunds snabbköp                 | Christina Berglund | Luleå       | Sweden  |

### NOT 运算符的常见用法

#### 1. NOT LIKE

选择名称不以'A'开头的客户：

```sql
SELECT * FROM Customers
WHERE CustomerName NOT LIKE 'A%';
```

#### 2. NOT BETWEEN

选择CustomerID不在10到60之间的客户：

```sql
SELECT * FROM Customers
WHERE CustomerID NOT BETWEEN 10 AND 60; 
```

p.s: 1~9， 61 ~ * 

#### 3. NOT IN

选择不在巴黎或伦敦的客户：

```sql
SELECT * FROM Customers
WHERE City NOT IN ('Paris', 'London');
```

#### 4. NOT 与比较运算符

选择CustomerID不大于50的客户：

```sql
SELECT * FROM Customers
WHERE NOT CustomerID > 50;
/* 等效写法：WHERE CustomerID !> 50 */
```

选择CustomerID不小于50的客户：

```sql
SELECT * FROM Customers
WHERE NOT CustomerID < 50;
/* 等效写法：WHERE CustomerID !< 50 */
```

### 练习

❓ SQL NOT 运算符的主要用途是什么？

- [ ] 筛选符合指定条件的记录

- [x] 筛选不符合指定条件的记录

- [ ] 筛选符合多个条件的记录

- [ ] 筛选完全等于指定条件的记录

  ------



## SQL INSERT INTO 语句

### INSERT INTO 的作用

INSERT INTO 语句用于向表中插入新记录。

### 语法格式

有两种写法：

1. 指定列名和对应值：

```sql
INSERT INTO 表名 (列1, 列2, 列3, ...)
VALUES (值1, 值2, 值3, ...);
```

1. 为**所有列**插入值（需确保值顺序与列顺序一致）：

```sql
INSERT INTO 表名
VALUES (值1, 值2, 值3, ...);
```

### 演示数据库

Customers表部分数据：

| CustomerID | CustomerName         | ContactName     | Address                     | City     | PostalCode | Country |
| :--------- | :------------------- | :-------------- | :-------------------------- | :------- | :--------- | :------ |
| 89         | White Clover Markets | Karl Jablonski  | 305 - 14th Ave. S. Suite 3B | Seattle  | 98128      | USA     |
| 90         | Wilman Kala          | Matti Karttunen | Keskuskatu 45               | Helsinki | 21240      | Finland |

### 基本示例

插入新客户记录：

```sql
INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');
```

> 注意：CustomerID是自增字段，会自动生成
>
> 插入效果：
>
> | CustomerID | CustomerName         | ContactName     | Address                     | City      | PostalCode | Country |
> | :--------- | :------------------- | :-------------- | :-------------------------- | :-------- | :--------- | :------ |
> | 89         | White Clover Markets | Karl Jablonski  | 305 - 14th Ave. S. Suite 3B | Seattle   | 98128      | USA     |
> | 90         | Wilman Kala          | Matti Karttunen | Keskuskatu 45               | Helsinki  | 21240      | Finland |
> | 91         | Wolski               | Zbyszek         | ul. Filtrowa 68             | Walla     | 01-012     | Poland  |
> | 92         | Cardinal             | Tom B. Erichsen | Skagen 21                   | Stavanger | 4006       | Norway  |

### 部分列插入

只插入指定列数据（其他列为NULL）：

```sql
INSERT INTO Customers (CustomerName, City, Country)
VALUES ('Cardinal', 'Stavanger', 'Norway');
```

> 插入效果：
>
> | CustomerID | CustomerName         | ContactName     | Address                     | City      | PostalCode | Country |
> | :--------- | :------------------- | :-------------- | :-------------------------- | :-------- | :--------- | :------ |
> | 89         | White Clover Markets | Karl Jablonski  | 305 - 14th Ave. S. Suite 3B | Seattle   | 98128      | USA     |
> | 90         | Wilman Kala          | Matti Karttunen | Keskuskatu 45               | Helsinki  | 21240      | Finland |
> | 91         | Wolski               | Zbyszek         | ul. Filtrowa 68             | Walla     | 01-012     | Poland  |
> | 92         | Cardinal             | null            | null                        | Stavanger | null       | Norway  |

### 批量插入

一次插入多行数据：

```sql
INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES
('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway'),
('Greasy Burger', 'Per Olsen', 'Gateveien 15', 'Sandnes', '4306', 'Norway'),
('Tasty Tee', 'Finn Egan', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK');
```

### 练习

❓ SQL INSERT INTO 语句的主要用途是什么？

- [ ] 更新表中的记录
- [ ] 删除表中的记录
- [x] 向表中添加新记录
- [ ] 从表中检索记录

  ------

  ## NULL  Value

  字段的 **NULL 值** 表示该字段没有值。

  如果表中的字段是可选字段，可以在插入新记录或更新记录时不向该字段添加值。此时，该字段将以 NULL 值保存。

  > **注意**：  
  > NULL 值不同于：  
  > - 零值（0）  
  > - 包含空格的字段  
  > 真正的 NULL 值是创建记录时留空的字段！

  

  ### 如何检测 NULL 值？

  不能用常规比较运算符（如 `=`、`<` 或 `<>`）检测 NULL 值。

  必须使用以下特殊运算符：  
  - `IS NULL`  
  - `IS NOT NULL`  

  ### **IS** NULL 语法

```sql
SELECT column_names
FROM table_name
WHERE column_name IS NULL;
```

### IS NOT NULL 语法

```sql
SELECT column_names
FROM table_name
WHERE column_name IS NOT NULL;
```

------

### 演示数据库

以下是示例中使用的 Customers 表的部分数据：

| CustomerID | CustomerName                       | ContactName        | Address                       | City        | PostalCode | Country |
| :--------- | :--------------------------------- | :----------------- | :---------------------------- | :---------- | :--------- | :------ |
| 1          | Alfreds Futterkiste                | Maria Anders       | Obere Str. 57                 | Berlin      | 12209      | Germany |
| 2          | Ana Trujillo Emparedados y helados | Ana Trujillo       | Avda. de la Constitución 2222 | México D.F. | 05021      | Mexico  |
| 3          | Antonio Moreno Taquería            | Antonio Moreno     | Mataderos 2312                | México D.F. | 05023      | Mexico  |
| 4          | Around the Horn                    | Thomas Hardy       | NULL                          | London      | WA1 1DP    | UK      |
| 5          | Berglunds snabbköp                 | Christina Berglund | Berguvsvägen 8                | Luleå       | S-958 22   | Sweden  |

------

### IS NULL 运算符

用于检测空值（NULL 值）。

以下 SQL 列出 "Address" 字段为 NULL 的所有客户：

```sql
SELECT CustomerName, ContactName, Address
FROM Customers
WHERE Address IS NULL;
```

> **提示**：
> 始终使用 `IS NULL` 查找 NULL 值。

------

### IS NOT NULL 运算符

用于检测非空值（NOT NULL 值）。

以下 SQL 列出 "Address" 字段有值的所有客户：

```sql
SELECT CustomerName, ContactName, Address
FROM Customers
WHERE Address IS NOT NULL;
```

------

### 练习

❓ SQL 中的 NULL 值是什么？

- [x] 没有值的字段

- [ ] 值为零的字段

- [ ] 包含空格的字段

- [ ] 已被删除的字段

  ------

  ## UPDATE 语句

  UPDATE 语句用于**修改**表中的现有记录。

  ### UPDATE 语法

```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```

> **重要提示**：
> 更新表记录时请务必小心！UPDATE 语句中的 WHERE 子句指定了要更新的记录。**如果省略 WHERE 子句，表中的所有记录都将被更新！**

------

### 演示数据库

以下是示例中使用的 Customers 表的部分数据：

| CustomerID | CustomerName                       | ContactName        | Address                       | City        | PostalCode | Country |
| :--------- | :--------------------------------- | :----------------- | :---------------------------- | :---------- | :--------- | :------ |
| 1          | Alfreds Futterkiste                | Maria Anders       | Obere Str. 57                 | Berlin      | 12209      | Germany |
| 2          | Ana Trujillo Emparedados y helados | Ana Trujillo       | Avda. de la Constitución 2222 | México D.F. | 05021      | Mexico  |
| 3          | Antonio Moreno Taquería            | Antonio Moreno     | Mataderos 2312                | México D.F. | 05023      | Mexico  |
| 4          | Around the Horn                    | Thomas Hardy       | 120 Hanover Sq.               | London      | WA1 1DP    | UK      |
| 5          | Berglunds snabbköp                 | Christina Berglund | Berguvsvägen 8                | Luleå       | S-958 22   | Sweden  |

------

### 更新单个记录

以下 SQL 语句更新第一个客户（CustomerID = 1）的联系人和城市信息：

```sql
UPDATE Customers
SET ContactName = 'Alfred Schmidt', City = 'Frankfurt'
WHERE CustomerID = 1;
```

更新后的表数据：

| CustomerID | CustomerName        | ContactName    | Address       | City      | PostalCode | Country |
| :--------- | :------------------ | :------------- | :------------ | :-------- | :--------- | :------ |
| 1          | Alfreds Futterkiste | Alfred Schmidt | Obere Str. 57 | Frankfurt | 12209      | Germany |
| ...        | ...                 | ...            | ...           | ...       | ...        | ...     |

------

### 更新多个记录

WHERE 子句决定了有多少条记录会被更新。

以下 SQL 语句将所有墨西哥客户的 ContactName 更新为 "Juan"：

```sql
UPDATE Customers
SET ContactName = 'Juan'
WHERE Country = 'Mexico';
```

更新后的表数据：

| CustomerID | CustomerName                       | ContactName | Address                       | City        | PostalCode | Country |
| :--------- | :--------------------------------- | :---------- | :---------------------------- | :---------- | :--------- | :------ |
| 2          | Ana Trujillo Emparedados y helados | Juan        | Avda. de la Constitución 2222 | México D.F. | 05021      | Mexico  |
| 3          | Antonio Moreno Taquería            | Juan        | Mataderos 2312                | México D.F. | 05023      | Mexico  |
| ...        | ...                                | ...         | ...                           | ...         | ...        | ...     |

------

### 更新警告！

如果省略 WHERE 子句，将会更新表中的所有记录！

```sql
UPDATE Customers
SET ContactName = 'Juan';
```

更新后的表数据：

| CustomerID | CustomerName        | ContactName | Address       | City        | PostalCode | Country |
| :--------- | :------------------ | :---------- | :------------ | :---------- | :--------- | :------ |
| 1          | Alfreds Futterkiste | Juan        | Obere Str. 57 | Frankfurt   | 12209      | Germany |
| 2          | Ana Trujillo...     | Juan        | Avda...       | México D.F. | 05021      | Mexico  |
| ...        | ...                 | Juan        | ...           | ...         | ...        | ...     |

------

### 练习

❓ SQL UPDATE 语句的作用是什么？

- [ ] 向表中添加新记录

- [ ] 从表中删除记录

- [x] 修改表中的现有记录

- [ ] 从表中检索记录

  ------

  + **由于第一部分并不算难，建议直接阅读原文，其他关键字就不举例子了**

------



## DELETE 语句

### 基本语法

+ ```sql
  DELETE FROM 表名称 WHERE 条件;
  ```

  ### 关键说明

  1. **WHERE子句必须谨慎使用**
     - 指定要删除的具体记录
     - 若省略WHERE条件，将删除表中所有数据
  2. 与DROP TABLE的区别
     - DELETE只删除数据，保留表结构
     - DROP TABLE会完全删除表结构和数据

  ### 注意事项

  ⚠️ 执行DELETE前建议：

  - 先使用SELECT语句确认要删除的记录
  - 重要数据操作前进行备份
  - 在生产环境谨慎执行无WHERE条件的DELETE

  ### 使用示例

  ```sql
  -- 删除特定客户
  DELETE FROM Customers WHERE CustomerID = 1;
  
  -- 删除符合条件的所有记录
  DELETE FROM Orders WHERE OrderDate < '2020-01-01';
  ```

  ### 最佳实践

  1. 使用事务确保操作可回滚

  ```sql
  BEGIN TRANSACTION;
  DELETE FROM Products WHERE Discontinued = 1;
  -- 确认无误后
  COMMIT;
  -- 发现问题可回滚
  -- ROLLBACK;
  ```

  1. 考虑使用软删除(标记删除)替代物理删除

  ```sql
  UPDATE Customers SET IsDeleted = 1 WHERE CustomerID = 5;
  ```

  1. 大批量删除时考虑分批执行

  ```sql
  DELETE TOP (1000) FROM Logs WHERE CreateDate < DATEADD(year, -1, GETDATE());
  ```

------

## TOP, LIMIT, TETCH, FIRST or ROWNUM

用于指定返回的记录数量，适用于处理大型表（避免性能影响）。  

### 基础语法

#### SQL Server/MS Access

```sql
SELECT TOP number|percent column_name(s)
FROM table_name
WHERE condition;
```

#### MySQL

```sql
SELECT column_name(s)
FROM table_name
WHERE condition
LIMIT number;
```

#### Oracle 12+

```sql
SELECT column_name(s)
FROM table_name
FETCH FIRST number ROWS ONLY;
```

### 关键示例

1. **返回前3条记录**

   - SQL Server:

     ```sql
     SELECT TOP 3 * FROM Customers;
     ```

   - MySQL:

     ```sql
     SELECT * FROM Customers LIMIT 3;
     ```

   - Oracle:

     ```sql
     SELECT * FROM Customers FETCH FIRST 3 ROWS ONLY;
     ```

2. **按条件筛选**（返回德国客户的前3条）

   - SQL Server:

     ```sql
     SELECT TOP 3 * FROM Customers WHERE Country='Germany';
     ```

   - MySQL/Oracle: 替换为对应语法（`LIMIT`/`FETCH FIRST`）。

3. **排序后返回**（按客户名降序取前3条）

   - SQL Server:

     ```sql
     SELECT TOP 3 * FROM Customers ORDER BY CustomerName DESC;
     ```

### 注意事项

- 部分数据库不支持 `SELECT TOP`（如MySQL用 `LIMIT`，Oracle用 `FETCH FIRST`）。
- 旧版Oracle需使用 `ROWNUM` 或子查询实现。

  ------

- 以上就是关键字的全部内容，接下来开始聚合函数部分

- [点击跳转](SQL学习笔记2.md)

+ 下附总结表格：

| 关键字              | 语法                                             | 作用               |
| :------------------ | :----------------------------------------------- | :----------------- |
| **SQL SELECT**      | `SELECT 列名 FROM 表名`                          | 从数据库中选择数据 |
| **SELECT DISTINCT** | `SELECT DISTINCT 列名 FROM 表名`                 | 返回唯一不同的值   |
| **WHERE**           | `SELECT 列名 FROM 表名 WHERE 条件`               | 过滤记录           |
| **ORDER BY**        | `SELECT 列名 FROM 表名 ORDER BY 列名 [ASC|DESC]` | 结果排序           |
| **AND/OR/NOT**      | `WHERE 条件1 AND/OR/NOT 条件2`                   | 组合多个条件       |
| **INSERT INTO**     | `INSERT INTO 表名 (列1,列2) VALUES (值1,值2)`    | 插入新记录         |
| **NULL VALUES**     | `WHERE 列名 IS [NOT] NULL`                       | 空值检测           |
| **UPDATE**          | `UPDATE 表名 SET 列1=值1,列2=值2 WHERE 条件`     | 修改记录           |
| **DELETE**          | `DELETE FROM 表名 WHERE 条件`                    | 删除记录           |
| **SELECT TOP**      | `SELECT TOP 数量 列名 FROM 表名`                 | 限制返回行数       |
| **MIN/MAX**         | `SELECT MIN(列名)/MAX(列名) FROM 表名`           | 找最小/最大值      |
| **COUNT**           | `SELECT COUNT(列名) FROM 表名`                   | 计数               |
| **SUM**             | `SELECT SUM(列名) FROM 表名`                     | 求和               |
| **AVG**             | `SELECT AVG(列名) FROM 表名`                     | 求平均值           |
| **LIKE**            | `WHERE 列名 LIKE 模式`                           | 模式匹配           |
| **IN**              | `WHERE 列名 IN (值1,值2)`                        | 多值匹配           |
| **BETWEEN**         | `WHERE 列名 BETWEEN 值1 AND 值2`                 | 范围查询           |
| **AS (Aliases)**    | `SELECT 列名 AS 别名 FROM 表名`                  | 创建别名           |
| **JOINS**           | `SELECT 列名 FROM 表1 JOIN 表2 ON 表1.列=表2.列` | 连接多表           |
| **GROUP BY**        | `SELECT 列名 FROM 表名 GROUP BY 列名`            | 分组查询           |
| **HAVING**          | `GROUP BY 列名 HAVING 条件`                      | 分组后过滤         |
| **EXISTS**          | `WHERE EXISTS (子查询)`                          | 存在性检查         |
| **CASE**            | `CASE WHEN 条件1 THEN 结果1 ELSE 结果2 END`      | 条件表达式         |

------



+ 