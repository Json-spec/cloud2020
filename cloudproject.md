# 项目描述:
cloud-common-project                  此模块中放了一些在项目测试所用到的一些公共的实体类和返回实体类工具类等代码。
cloud-eureka-server7001               此模块是springCloud中的eureka的注册中心服务端启动服务后客户端将会像注册中心服务端注册。
cloud-eureka-server7002               此模块是springCloud中的eureka的注册中心服务端启动服务后客户端将会像注册中心服务端注册 7001和7002在一起使用是为了测试注册中心的集群环境。
cloud-consumerForConsul-server8007    此模块是springboot整合consul的注册中心模块使用consul作为注册中心原理和springcloud的Eureka一样。
cloud-providerForConsul-paymentServer8006                此模块是使用consul注册中心的客户端提供数据。
cloud-consumerForZookeeper-server8005 此模块是springboot整合Zookeeper的注册中心模块使用Zookeeper作为注册中心原理和springcloud的Eureka一样。
cloud-providerForZookeeper-server8004                    此模块是使用Zookeeper注册中心的客户端提供数据。
cloud-hystrix-test-dashboard          此模块是springboot测试hystrix整合dashboard图形化界面直观反映。
cloud-hystrix-test-server9000         此模块是springboot整合springcloud中hystrix的组件测试hystrix熔断,服务降级的使用。
cloud-provider-payment-hystrix-server8003 此模块是测试hystrix组件的数据提供者实现类hytrix的熔断，降级等。
cloud-provider-payment8001和cloud-provider-payment8002  这两个模块是用来作为消费端的提供测试数据的当两个模块同时启动用相应的yml配置文件则是集群环境。
cloud-provider-payment-fegin-hystrix-server8008          此模块是springboot整合springcloud中的openFegin组件此模块只有相应的openFegin的提供的相关接口以及接口的实现类(服务降级)。
cloud-gateway-gateway9527                                此模块是springcloud中的gateway的网关模块用爱来路由到各个服务模块中。
cloud-config-center-3344                                 此模块是springcloud中config组件是永安里做分布式配置中心的服务端
cloud-config-centerToClient-3345 和 cloud-config-centerToClient-3346 这两个模块是分布式配置中心的服务端多个服务同时在config服务端上获取配置其中测试了分布式配置中心的自动刷新。
cloudalibaba-provider-payment9001                        此模块是测试springclouAlibaba的nacos的discovery的基本功能。
cloud-consumer-order8000               此模块是网关路由的服务通过路由地址调相应的服务，也是opfengin的调用服务的入口然后找到相应的服务提供数据(与前台交互的一个模块)。



