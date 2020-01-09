# spring-source-code

Spring事务是基于AOP环绕通知和异常通知实现的

    通知包括 前置通知、后置通知、异常通知、环绕通知、运行时通知

Spring自定义事务
    
    1.定义事务注解
    2.定义事务AOP扫包
    3.实现AOP开启事务和提交、回滚事务
    4.实现事务工具类为多实例@Scope("prototype")解决多线程安全问题
    5.判断方法是否有事务注解
           //获取方法或类的注解
           Signature signature = proceedingJoinPoint.getSignature();
           Class<?> clasz = AopUtils.getTargetClass(proceedingJoinPoint.getTarget());
           Method targetMethod = clasz.getMethod(signature.getName(), ((MethodSignature) signature).getParameterTypes());
           ExtTransactional extTransactional = targetMethod.getDeclaredAnnotation(ExtTransactional.class);
           if (extTransactional != null) {
            //有事务注解
           }
    6.开启事务
    7.提交事务或回滚事务
    
    AopTransaction.java AOP实现类
    TransactionUtils.java 事务获取类
    ExtTransactional.java 自定义注解类