ch01-hello-mybatis: 第一个入门的mybatis例子

实现步骤：
1.新建的student表
2.加入maven的mybatis坐标，mysql驱动的坐标
3.创建实体类，Student--保存表中的一行数据的
4.创建持久层的dao接口，定义操作数据库的方法
5.创建一个mybatis使用的配置文件
    叫做sql映射文件：写上去了语句的。一般一个表一个sql映射文件。
    这个文件是xml文件。
6.创建mybatis的主配置文件：
    一个项目就一个配置文件。
    主配置文件提供了数据库的连接信息和失去了映射文件的位置信息
7.创建使用mybatis类，
同mybatis访问数据库