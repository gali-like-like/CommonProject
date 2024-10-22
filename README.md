# 通用基础框架
## Orm
*MybatisPlus*
## DataBase
*MySQL*
## 日志框架
*LogBack*
## 包介绍
| 包名 | 说明 | 详细说明 |
| :---: | --- | --- |
| org.example.controller | 接口类 | 关于员工接口的类 |
| org.example.config | 配置类 | Swagger,DataSource,WebMvcConfig的配置 |
| org.example.service | 业务类 | 处理相关接口的业务 |
| org.example.mapper | 数据访问层 | 读取数据库的相关数据 |
| org.example.inteceptor | 拦截器 | 用于获取访问信息 |
| org.example.exceptor | 异常处理类 | 处理数据库异常和数据校验异常 |
| org.example.entity | 实体类 | 用户类,统一结果类 |
## 功能
+ 可以对员工进行操作
+ 可以访问到[接口文档](http://localhost:8080/doc.html),***前提是前运行这个项目,且配置文件没改端口***
+ 记录了sql执行的日志
+ 记录了sql异常的日志
+ 记录了数据源，线程池的日志
+ 记录了访问日志
> **注意事项**
> 需要配置环境变量,LOCALHOST_MYSQL_PASSWORD=root用户的密码
