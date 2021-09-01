# JianMu v1.0

BUAA 2020 数据库课程设计项目，使用最简单的 Servlet、Tomcat 等技术实现的简易 Web 程序。用于课程活动发布和招募。
目前没有进行维护的打算（必要），毕竟使用的技术比较落后。

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

