# CompanyManagementSystem

如何运行项目
1.使用数据库管理软件，导入3张数据库表

2.修改配置好后端的yml文件，运行后端项目

3.vscode打开前端项目，在左下角找到dev，点击类似播放按钮

4.在浏览器打开所给地址就可以了


项目架构：

1.技术选型
采用目前最主流的前后端分离技术，请求我们用的是简洁优雅的风格restful风格

2.前端:vue工程构建加nginx部署，通过axios与后端交互数据

3.数据库表的设计 及源码
数据库表的设计我们用到了3张表
1.部门表
2.员工表
3.操作记录表，可以看到记录每一次操作的操作名，员工信息，内容，返回结构，时间，耗时

4.前端页面源码
界面视图在views文件夹下面

5.后端整体架构思想


Allexception用于给未定义的异常一个通用的报错提醒

Aop用于存放进行切面编程的类，operation的类可以用于记录用户的操作
Time的类可以用于在日志里记录方法操作所用的时间，用于后续的优化

Controller类里面存放了4个控制器，分别处理部门请求，员工请求，登陆请求，上传图片请求

Dto里存放了数据传输的对象，其中pagebean是前端请求分页操作是我们将数据库里查询到的数据封装成pagebean返回给前端，

Entity内装了3个实体类，其中operateLog是用于将我们收集到的操作数据，以OperateLog的对象的形式保存给数据库的

Interceptor是用于进行全局拦截的，将所有非login请求且没有的有效jwt令牌（token）的请求转到login页面去


Repository是用于存储和数据库进行操作的对象，这里用到的是mybatis技术，分别处理部门，员工还有操作记录与数据库的交互

Response是我们将返回给前端的请求统一封装成一个标准的result请求

Service层我们采用的是标准的service接口定义方法加impl是接口的实现类给出具体的数据处理业务实现的代码

Util层是工具类，这里的话我们将频繁使用的业务如将图片上传到阿里云对象存储服务器和jwt令牌的加密和解密做成工具类

然后的话webconfig包是用于配置拦截器的如拦截的地址和跳转的地址


然后引文员工的查询sql语句比较繁琐我们把其提取到xml文件，然后的话要注意resource下的包的名字要和对应的mapper的名称一样

同时为了后续方便维护，我们把一个固定的数据存放到application.yml里面，比如阿里云的oss的密钥和jwt解密的密钥
