# spring-source-code

Spring事务是基于AOP环绕通知和异常通知实现的

    通知包括 前置通知、后置通知、异常通知、环绕通知、运行时通知

Spring事务传播行为
    
    注解：@Transactional(propagation = )设置传播行为
    PROPAGATION_REQUIRED        如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
    PROPAGATION_SUPPORTS        支持当前事务，如果当前没有事务，就以非事务方式执行。
    PROPAGATION_MANDATORY       使用当前的事务，如果当前没有事务，就抛出异常。
    PROPAGATION_REQUIRES_NEW	新建事务，如果当前存在事务，把当前事务挂起。(让已存在的事务在当前方法中失效，并重新一个针对当前方法的事务)
    PROPAGATION_NOT_SUPPORTED	以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。(让事务在当前方法中失效)
    PROPAGATION_NEVER	        以非事务方式执行，如果当前存在事务，则抛出异常。
    PROPAGATION_NESTED	        如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。（有事务就用同一个事务，没有就在当前方法中新一个事务）
    