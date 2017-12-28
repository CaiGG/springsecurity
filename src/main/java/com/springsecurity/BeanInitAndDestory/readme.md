实际开发中，经常会遇到在Bean在使用之前或者之后做一些必要的操作  
spring对Bean的生命周期的操作提供了支持，在使用Java配置和注解配置下提供如下两种方式：
1. Java配置方式：使用@Bean的 initMethod 和 DestroyMethod(相当于XML配置的init-method和destroy-method)
2. 注解方式：利JSR-250的@PostConstruct和@ProDestroy