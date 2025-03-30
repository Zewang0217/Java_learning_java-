[点击跳转到原文](https://www.w3schools.com/sql/default.asp)

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