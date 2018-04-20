# qtyd-v2

<div><h3>一、项目结构</h3></div>
<br/>
<div>qtyd-v2项目根目录</div>
<br/>
<div>代码pull下来之后直接编译根目录pom.xml</div>
<br/>
<div>jar公共包管理全部在根目录，如果只有子项目使用架包，可单独在子项目pom下引入架包，版本号还是在根目录pom下管理</div>
<br/>
<div>服务注册</div>
<br/>
<div>qtyd-server</div>
<br/>
<div>网关服务</div>
<br/>
<div>qtyd-zuul</div>
<br/>
<div>活动模块提供者</div>
<br/>
<div>qtyd-activity-service</div>
<br/>
<div>活动服务代码中用到redis，安装启动本地redis，默认端口6379，密码test</div>
<br/>
<div>可以到配置文件application-test.properties修改</div>
<br/>
<div>服务消费者，测试API用</div>
<br/>
<div>qtyd-test</div>
<br/>






