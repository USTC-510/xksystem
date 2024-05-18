项目更新日志
============  

本项目的技术栈：  
后端：Mybatis框架,Springboot框架,Mysql，http协议,Junit单元测试(可选)    
前端:HTML5,css,javascript,http协议,vue框架(可选)  

在进行代码编写时，记得先在Github Desktop上拉取(Fetch origin)最近的更新，以免不同开发人员在不同的版本中提交项目修改，造成冲突。    
在Github Desktop上打开项目的方法：Current responsitory xksystem - 右键xksystem - Open in IDEA  
在Github Desktop上上传项目修改的方法：Commit to main(上传到本地仓库.需要填写Summary) - Push origin(将本地git仓库中的修改推送到云端git仓库，也就是github)  
后端的类和接口放在src/java/com中，里面有几个包：pojo,controller,service,dao,这几个包的名字不懂可以百度。后续可能还会添加exception等包。  
controller，service，dao包的编写需要学习Mybatis,Springboot和http协议，所以请尽快学习(学习用时不会很长)。  

*5月17日更新日志* 
-----------------
1.`dao包名字改为mapper包`，因为我们使用Mybatis框架中的Mapper代理。
2.新增utils包，内含MybatisUtils类，用于获取SqlSession对象。  
3.在resources文件夹中的com/system/mapper中存放SQL映射xml文件，不要放在其他地方，因为我们在mybatis的配置xml文件中使用包检索来加载SQL映射。

*5月18日更新日志*
-----------------
1.将原来BS架构的前端相关代码删除。    
2.添加了pages这一文件夹，用来存放前端相关代码，目前已经写好登陆页面（loginPage），需要后端提供三个函数来判断用户名（管理员、老师、学生）和密码的匹配问题


