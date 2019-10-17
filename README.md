# msc_project
基于elasticsearch的腾讯娱乐搜索引擎。

运用技术点：
Springboot+ssm+redis+mybatis+mysql+elk+springclould

项目流程：
1、爬取指定数据，去重复，并存储到mysql。
Springboot+ssm+定时(定时器)爬取+redis去重+mybatis保存。
2、搭建elk平台，把mysql中数据导入es中
3、开发服务提供者（8001），读取es中数据，提供关键字查询功能。
4、搭建分布式架构，把3中开发的服务提供者，注册到eureka server(三台，7001,7002,7003)
5、开发服务消费者(可以直接访问3中的服务)，调试成功后，开始6
6、通过feign技术，开发服务消费者，并注册到eureka server中。
7、实现数据显示(jsp/html+js+css等)

