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
2.`新增utils包`，内含MybatisUtils类，用于获取SqlSession对象。    
3.在resources文件夹中的com/system/mapper中存放SQL映射xml文件，`不要放在其他地方`，因为我们在mybatis的配置xml文件中使用包检索来加载SQL映射。

*5月18日更新日志*
-----------------
1.将原来BS架构的前端相关代码删除。    
2.添加了pages这一文件夹，用来存放前端相关代码，目前已经写好登陆页面（loginPage），`需要后端提供三个函数来判断用户名（管理员、老师、学生）和密码的匹配问题`。  
3.添加了Springboot的依赖，并且在Controller包中写了Application启动类。  

*5月27日更新日志*
-----------------
1.前端采用vue框架，将原来的前端代码使用vue框架的格式重写。  
2.登陆匹配逻辑稍有变动，现在我会将用户选择了哪一个按钮传递给后端（student、teacher、admin），需要后端传递一个值给前端，1代表学生匹配成功，2老师，3代表管理员，其余值视为匹配不成功。  
3.目前前端使用vue-CLI脚手架，服务器即为自己的电脑，在下好配置文件后浏览器上输入http://localhost/即可运行，之后可能考虑进一步使用Tomcat。  
4.使用了axios来实现数据传输，传输方法统一放在Pages/vue-project/src/api/function.js里，默认axios配置在Pages/vue-project/src/utils/request.js里。  

*6月1日更新日志*
-----------------
1.新增了service包，用以将Dao和entity类整合起来，进行再次封装，封装成一个方法，我们调用这个方法，就实现了对某个表的增删改查操作。  
2.添加了tk.mybatis的依赖，令各个mapper接口继承Mapper，以方便进行增删查改，但具体使用方法还在学习。

*6月2日更新日志*
-----------------
1.在LoginController中获取从前端传来的用户名和密码，在LoginService中对用户身份（管理员，学生，教师）进行了验证

*6月3日更新日誌*
----------------
1.寫完了學生，老師，管理員的Mapper接口，使用***註解開發***。  
2.後端的人員請使用 ***curl*** 工具進行HTTP請求與響應的測試，***curl*** 的安裝和用法見b站https://www.bilibili.com/video/BV15x411f7Sm/?spm_id_from=333.337.search-card.all.click&vd_source=e5c3c6df9632109b43734c40eacd4c46  
3.編寫更新日誌時，***打兩個空格就能換行***。

*6月4日更新日志*
--------------
1.写完了登录验证的后端代码。接口的定义，访问地址以及用法见**service**包中的接口。  
2.加了一个**User**类，**Student**，**Teacher**和**Administrator**类继承自user类。  
3.加了一个**Result**类，它规定了**controller**层返回给前端的HTTP响应的统一格式  
格式为{  "code":  
        "msg":  
        "data":{}  
     }  
其中code是状态码，1代表响应成功，0代表失败；msg是响应失败时返回的错误信息；data是返回的数据。    
4.对6月2日的**controller**和**service**进行了改写，现在我们根据**pojo**类来命名**controller**和**service**的类。  
