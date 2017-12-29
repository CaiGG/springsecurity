如果需要用到spring容器本身的功能资源，这时你的Bean必须要意识到Spring容器的存在，才能调用Spring所提供的资源，这就是作为的Spring Aware
Spring 提供的Aware接口  
`BeanNameAware`      获得到容器中Bean的名称   
`BeanFactoryAware`   获得当前bean factory, 这样可以调用容器的服务
`ApplicationContextAware*` 当前的application context,这样可以调用容器的服务
`MessageSourceAware` 获得message source,这样可以获得文本信息
`ApplicationEventPublisherAware` 应用实践发布器，可以发布事件DemoPublisher也可以实现这个接口来发布事件
`ResourceLoaderAware` 获得资源加载器，可以获得外部资源文件。
