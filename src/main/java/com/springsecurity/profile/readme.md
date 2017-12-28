###Profile
Profile为了在不同环境下使用不同的配置提供了支持（开发环境下的配置和生产环境下的配置肯定是不同的。例如数据库的配置）。
1. 通过设定Environment 的ActiveProfiles来设置当前的context需要使用的配置环境。在开发中使用@Profile注解类或者方法，达到在不同情况下选择实例化不同的Bean.
2. 通过设定JVM的spring.profiles.active参数来设置配置环境。
3. Web项目设置在Servlet的context paramenter中。