## 1、java: 找不到符号 符号: 变量 CoroutinesUtils

    Error:(402, 51) java: 找不到符号 
    符号: 变量 CoroutinesUtils 
    位置: 类 org.springframework.core.ReactiveAdapterRegistry.CoroutinesRegistrar

### 解决方法：

> build整个项目报错后 -> 点击File -> Project Structure -> Libraries -> + -> Java，
> 然后选择spring-framework/spring-core/kotlin-coroutines/build/libs
> /kotlin-coroutines-5.2.4.BUILD-SNAPSHOT.jar，在弹出的对话框中选择spring-core.main，
> 在重新build 报错的模块即可。


## 2、java: 找不到符号 符号: 类 InstrumentationSavingAgent

    Error:(26, 38) java: 找不到符号
    符号:   类 InstrumentationSavingAgent
    位置: 程序包 org.springframework.instrument
    
### 解决方法：

> 1.首先找到报错的模块。我这里是：spring-context 
>
> 2.找到报错模块的gradle文件。我这里是：spring-context.gradle
>
> 3.找到引入InstrumentationSavingAgent所在模块的地方。
>
> 4.把optional修改为compile。再重新build报错模块，成功。修改如下：

```xml
    compile(project(":spring-aop"))
    compile(project(":spring-beans"))
    compile(project(":spring-core"))
    compile(project(":spring-expression"))
    optional(project(":spring-instrument"))  --->  compile(project(":spring-instrument"))
    optional("javax.annotation:javax.annotation-api")
    optional("javax.ejb:javax.ejb-api")
    optional("javax.enterprise.concurrent:javax.enterprise.concurrent-api")
    optional("javax.inject:javax.inject")
    optional("javax.interceptor:javax.interceptor-api")
    optional("javax.money:money-api")
    // Overriding 2.0.1.Final due to Bean Validation 1.1 compatibility in LocalValidatorFactoryBean
    ...
    ...
```