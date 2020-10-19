# spring-mybatis

> class -> beanDefinition -> beanFactory -> beanFactoryPostProcessor -> Java 对象 -> 属性赋值 -> init -> aware -> bean ->springContext

自定义 mybatis-spring 相关实现类:

- MyMapperScan : 自定义包扫描注解
- MySelect : 自定义 sql 注解
- MyImportBeanDefinitionRegistrar : 继承自 ImportBeanDefinitionRegistrar ，注册 beanDefinition ，通过 @Import 注解交给 spring
- MyClassPathBeanDefinitionScanner : 继承自 ClassPathBeanDefinitionScanner ，利用 spring 自带工具扫描包并生成相应的 beanDefinition
- MybatisFactoryBean : mapper 动态代理工厂
- MyInvocationHandler : 继承自 InvocationHandler ，动态代理方法代理实现


总结:

1. 为什么用 ImportBeanDefinitionRegistrar ？

    BeanFactoryPostProcessor 也可以将对象直接添加到 beanFactory 中，但为什么选择了 ImportBeanDefinitionRegistrar 这种方式：
    
    - @Component 需要被 spring 扫描到，让业务代码扫描框架 jar 包不合理
    - 无法获取 @MyMapperScan 的扫描包进行多bean的注册


2. 为什么使用 MybatisFactoryBean ？

    因为接口是无法直接生成 bean，bean 只能为类，所以使用 MybatisFactoryBean ，在 MybatisFactoryBean 的 getObject() 方法中返回对于接口动态代理的实例
    在 getBean 时，会先判断 bean 是否继承自 FactoryBean  
      如果不继承自 FactoryBean ，则返回 bean 本身  
      如果继承自 FactoryBean ，则返回 bean.getObject() 方法返回值 (注意 getBean 加上 '&' 则返回 FactoryBean 本身)


3. ClassPathBeanDefinitionScanner 不能扫描接口 ，mybatis 是怎么做到的？

源码：
```java
protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
    AnnotationMetadata metadata = beanDefinition.getMetadata();
    return (metadata.isIndependent() && (metadata.isConcrete() ||
            (metadata.isAbstract() && metadata.hasAnnotatedMethods(Lookup.class.getName()))));
}
```

可见：ClassPathBeanDefinitionScanner 只会扫描类和带 @Lookup 注解的抽象类，如果想让 ClassPathBeanDefinitionScanner 扫描接口，则重写此方法即可：

```java
@Override
protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
    return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
}
```