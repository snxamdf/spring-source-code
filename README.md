# spring-source-code
spring-source-code

Spring事务是基于AOP环绕通知和异常通知实现的

    通知包括 前置通知、后置通知、异常通知、环绕通知、运行时通知

Spring事务编程式事务和声明式事务
    
    编程式事务：手动开启事务 begin rollback
    声明式事务：扫包或者使用注解

Spring事务底层是编程式事务+AOP实现包装=声明式事务

Spring核心 IOC 和 AOP
    
    AOP：面向切面编程 解决代码复用问题
    AOP：低层实现原理代理设计模式（静态代理、动态代理）
        静态代理 生成代理对象
        动态代理 不生成代理对象（CGLIB）
    AOP：在方法之前或之后做一些事情
    AOP
        关注点 重复代码
        切入点 按关注点找到适合的切入点