# JianMu
a web application for teaming.

### 环境要求

MySQL 8.0

Maven 3.6

Java 1.8

Apache Tomcat 9.0.38



### 使用说明

1. 创建数据库 jianmu ，导入 initialize.sql 。
2. 修改 src/main/resources/jdbc.properties 中的相关设置。
3. 使用命令行 `mvn package` 生成 war 包。
4. 使用 tomcat 部署 war 包。

