# qtyd-v2

项目结构
qtyd-v2项目根目录
代码pull下来之后直接编译根目录pom.xml


jar公共包管理全部在根目录，如果只有子项目使用架包，可单独在子项目pom下引入架包，版本号还是在根目录pom下管理


服务注册
qtyd-server


<div>网关服务</div>
qtyd-zuul


活动模块提供者
qtyd-activity-service
活动服务代码中用到redis，安装启动本地redis，默认端口6379，密码test
可以到配置文件application-test.properties修改



服务消费者，测试API用
qtyd-test






