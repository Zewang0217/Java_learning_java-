[TOC]

## SQL 聚合函数

+ 聚合函数对一组值执行计算并返回单个值。

- **常用场景**  
  通常与 `SELECT` 语句的 `GROUP BY` 子句配合使用，按组计算并返回结果。

- **核心聚合函数**  
  - `MIN()`：返回选定列的最小值  
  - `MAX()`：返回选定列的最大值  
  - `COUNT()`：返回行数（包含 NULL 值）  
  - `SUM()`：返回数值列的总和  
  - `AVG()`：返回数值列的平均值  

- **注意**  
  除 `COUNT()` 外，其他聚合函数自动忽略 NULL 值。
  
  ------
  
  

## MIN( ) and MAX( )

 - `MIN()` 返回选定列的最小值  
  - `MAX()` 返回选定列的最大值  

- **基础语法**  

```sql
  SELECT MIN(列名) FROM 表名 WHERE 条件;
  SELECT MAX(列名) FROM 表名 WHERE 条件;
```

- **示例**

  - 查询最低价格：

    ```sql
    SELECT MIN(Price) FROM Products;
    ```

  - 查询最高价格：

    ```sql
    SELECT MAX(Price) FROM Products;
    ```

- **设置列别名（AS）**

  ```sql
  SELECT MIN(Price) AS SmallestPrice FROM Products;
  ```

- **结合 `GROUP BY` 使用**
  按分类查询最低价格：

  ```sql
  SELECT MIN(Price) AS SmallestPrice, CategoryID 
  FROM Products 
  GROUP BY CategoryID;
  ```

- **注意**
  聚合函数默认返回的列名无描述性，**建议用 `AS` 命名**。

  ------



## count

+ 返回符合指定条件的**行数**

- **基础语法** 

```sql
 SELECT COUNT(列名) FROM 表名 WHERE 条件;
```

- **常用用法**

  - 计算总行数：

    ```sql
    SELECT COUNT(*) FROM Products;
    ```

  - 计算非NULL值行数：

    ```sql
    SELECT COUNT(ProductName) FROM Products;
    ```

  - 带条件计数：

    ```sql
    SELECT COUNT(ProductID) FROM Products WHERE Price > 20;
    ```

  - 计算唯一值数量：

    ```sql
    SELECT COUNT(DISTINCT Price) FROM Products;
    ```

- **设置列别名**

  ```sql
  SELECT COUNT(*) AS [Number of records] FROM Products;
  ```

- **结合 `GROUP BY` 使用**
  按分类统计产品数量：

  ```sql
  SELECT COUNT(*) AS [Number of records], CategoryID
  FROM Products
  GROUP BY CategoryID;
  ```

- **注意**

  - `COUNT(*)` 计算所有行（含NULL）

  - `COUNT(列名)` 忽略NULL值

  - 可用 `DISTINCT` 计算唯一值

    ------

  ## SUM( )

  + 返回数值列的总和

  - **基础语法**  

  ```sql
  SELECT SUM(列名) FROM 表名 WHERE 条件;
  ```

  - **核心用法**

    - 计算总和：

      ```sql
      SELECT SUM(Quantity) FROM OrderDetails;
      ```

    - 带条件求和：

      ```sql
      SELECT SUM(Quantity) FROM OrderDetails WHERE ProductID = 11;
      ```

    - 设置列别名：

      ```sql
      SELECT SUM(Quantity) AS total FROM OrderDetails;
      ```

  - **高级用法**

    - 分组统计求和（相同`OrderID`的计算一个Total Quantity）：

      ```sql
      SELECT OrderID, SUM(Quantity) AS [Total Quantity]
      FROM OrderDetails
      GROUP BY OrderID;
      ```

    - 表达式求和：

      ```sql
      SELECT SUM(Quantity * 10) FROM OrderDetails;
      ```

    - 多表联合计算：

      ```sql
      SELECT SUM(Price * Quantity)
      FROM OrderDetails
      LEFT JOIN Products ON OrderDetails.ProductID = Products.ProductID;
      ```

  - **注意**
    仅适用于数值类型列，自动忽略NULL值

    ------

  ## AVG( )

   返回数值列的平均值（自动忽略NULL值）

  - **基础语法**  

  ```sql
  SELECT AVG(列名) FROM 表名 WHERE 条件;
  ```

  - **典型用法**

    - 计算所有产品均价：

      ```sql
      SELECT AVG(Price) FROM Products;
      ```

    - 带条件计算：

      ```sql
      SELECT AVG(Price) FROM Products WHERE CategoryID = 1;
      ```

    - 设置列别名：

      ```sql
      SELECT AVG(Price) AS [average price] FROM Products;
      ```

  - **高级应用**

    - 筛选高于均价的产品：

      ```sql
      SELECT * FROM Products 
      WHERE price > (SELECT AVG(price) FROM Products);
      ```

    - 分组计算：

      ```sql
      SELECT AVG(Price) AS AveragePrice, CategoryID
      FROM Products
      GROUP BY CategoryID;
      ```

  - **注意**
    结果包含小数，可用`ROUND()`函数四舍五入

    ------

  ## LIKE

  用于在WHERE子句中按模式搜索列内容

  - **核心通配符**  
    - `%` 匹配任意长度字符（包括零个字符）  
    - `_` 匹配单个字符  

  - **基础用法**  

  ```sql
  SELECT * FROM 表名 WHERE 列名 LIKE '模式';
  ```

  - **典型搜索模式**

    - 开头匹配：

      ```sql
      WHERE CustomerName LIKE 'a%'  -- 以"a"开头
      ```

    - 结尾匹配：

      ```sql
      WHERE CustomerName LIKE '%a'  -- 以"a"结尾
      ```

    - 包含匹配：

      ```sql
      WHERE City LIKE '%L%'        -- 包含字母"L"
      ```

    - 精确长度匹配：

      ```sql
      WHERE City LIKE 'L_nd__'     -- 如"London"
      ```

  - **组合用法**

    - 多条件组合：

      ```sql
      WHERE CustomerName LIKE 'a%' OR LIKE 'b%'
      ```

    - 复合模式：

      ```sql
      WHERE CustomerName LIKE 'b%s'  -- 以"b"开头且以"s"结尾
      ```

    - 字符位置匹配：

      ```sql
      WHERE CustomerName LIKE '_r%'  -- 第二个字母是"r"
      ```

  - **精确匹配**

    ```sql
    WHERE Country LIKE 'Spain'  -- 等同于 WHERE Country = 'Spain'
    ```

------

## Wildcards

 与`LIKE`运算符配合使用，用于模糊匹配字符串

- **核心通配符**  
  - `%` 匹配任意数量字符（0个或多个）
  - `_` 匹配单个字符
  - `[]` 匹配括号内任意单个字符（部分数据库不支持）
  - `-` 匹配指定范围内的字符（如`[a-f]`）

- **常用示例**  

-   -- % 用法

  ```sql
    WHERE name LIKE 'a%'   -- 以a开头
    WHERE name LIKE '%es'  -- 以es结尾
    WHERE name LIKE '%mer%' -- 包含mer
  ```

- -- _ 用法  

  ```sql
    WHERE city LIKE '_ondon'  -- 如"London"
    WHERE city LIKE 'L___on'  -- L开头on结尾的6字符城市名
  ```

-   -- 组合用法

  ```sql
    WHERE name LIKE 'a__%'  -- 以a开头且至少3个字符
    WHERE name LIKE '_r%'   -- 第二个字母是r
  ```

-  **`[]` 匹配示例**  
    ```sql
    -- 匹配客户名以b、s或p开头的记录
      SELECT * FROM Customers
      WHERE CustomerName LIKE '[bsp]%';

- ```sql
  -- 匹配城市名为"Berlin"或"London"的记录
    SELECT * FROM Customers
    WHERE City LIKE '[BL]%';
  ```

  **`-` 范围匹配示例**

  ```sql
  -- 匹配客户名以a-f字母开头的记录
  SELECT * FROM Customers
  WHERE CustomerName LIKE '[a-f]%';
  
  -- 匹配客户名第二个字符是1-5数字的记录
  SELECT * FROM Customers
  WHERE CustomerName LIKE '_[1-5]%';
  ```

  **组合使用示例**

  ```sql
  -- 匹配客户名以a-c开头且第3个字符是m-p的记录
  SELECT * FROM Customers
  WHERE CustomerName LIKE '[a-c]_[m-p]%';
  ```

- **注意**

  - `[]`和`-`在MySQL/PostgreSQL中不可用

  - Access数据库使用`*`代替`%`，`?`代替`_`

    ------

  ## IN

   用于在WHERE子句中指定多个可能值，是**多个OR条件的简写形式**

  - **基础语法**  

  ```sql
    SELECT 列名 FROM 表名 
    WHERE 列名 IN (值1, 值2, ...);
  ```

  - **核心用法**

    - 多值匹配：

      ```sql
      SELECT * FROM Customers
      WHERE Country IN ('Germany', 'France', 'UK');
      ```

    - 反向匹配：

      ```sql
      SELECT * FROM Customers
      WHERE Country NOT IN ('Germany', 'France', 'UK');
      ```

  - **高级用法**

    - 子查询匹配：

      ```sql
      SELECT * FROM Customers
      WHERE CustomerID IN (SELECT CustomerID FROM Orders);
      ```

    - 子查询排除：

      ```sql
      SELECT * FROM Customers
      WHERE CustomerID NOT IN (SELECT CustomerID FROM Orders);
      ```

  - **优势**
    比多个OR条件更简洁高效，特别是处理大量可选值时

    ------

    

    ## BETWEEN

    用于选取指定范围内的值（包含边界值），支持**数字、文本和日期**

    - **基础语法**  

    ```sql
      SELECT 列名 FROM 表名 
      WHERE 列名 BETWEEN 值1 AND 值2;
    ```

    - **核心用法**

      - 数字范围：

        ```sql
        SELECT * FROM Products 
        WHERE Price BETWEEN 10 AND 20;
        ```

      - 文本范围（按字母顺序）：

        ```sql
        SELECT * FROM Products
        WHERE ProductName BETWEEN 'Carnarvon Tigers' AND 'Mozzarella di Giovanni';
        ```

      - 日期范围：

        ```sql
        SELECT * FROM Orders
        WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31';
        -- 或者
        WHERE OrderDate BETWEEN #07/01/1996# AND #07/31/1996#;
        ```

    - **反向匹配**

      ```sql
      SELECT * FROM Products
      WHERE Price NOT BETWEEN 10 AND 20;
      ```

    - **组合使用**

      ```sql
      SELECT * FROM Products
      WHERE Price BETWEEN 10 AND 20
      AND CategoryID IN (1,2,3);
      ```

    - **注意**
      边界值包含在结果中，相当于 `>=` 和 `<=` 的组合

------

## Aliases

用于为表或列创建临时名称，提高查询可读性

- **列别名**  

- 基础语法（AS可选）

    ```sql
    SELECT CustomerID AS ID FROM Customers;
    SELECT CustomerID ID FROM Customers; -- AS 可以省略
    ```

-  含空格的别名

  ```sql
  SELECT ProductName AS [Product Name] FROM Products;  -- SQL Server
  SELECT ProductName AS "Product Name" FROM Products; -- MySQL
  ```

+  列合并与计算字段

  ```sql
  -- MySQL连接字符串
  SELECT 
      CustomerName,
      CONCAT(Address, ' ', City) AS Address
  FROM Customers;
  
  -- SQL Server连接字符串
  SELECT
      CustomerName,
      Address + ' ' + City AS Address
  FROM Customers;
  
  -- 带计算的价格字段
  SELECT 
      ProductName,
      Price,
      Price * 0.9 AS 折扣价
  FROM Products;
  ```

- **表别名**

  ```sql
  -- 简化多表查询
  SELECT o.OrderID, c.CustomerName
  FROM Customers AS c, Orders AS o
  WHERE c.CustomerID = o.CustomerID;
  
  -- 等效无别名写法
  SELECT Orders.OrderID, Customers.CustomerName
  FROM Customers, Orders
  WHERE Customers.CustomerID = Orders.CustomerID;
  ```

- **使用场景**

  - 多表关联查询时简化表名
  - 对计算字段或函数结果命名
  - 合并多个列时
  - 列名过长或不清晰时