package com.spring.source.code.aop;

import com.spring.source.code.annotation.ExtTransactional;
import com.spring.source.code.transaction.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//切面类  基于手手动事务封装
@Component
@Aspect
public class AopTransaction {
    @Autowired
    private TransactionUtils transactionUtils;

    // TransactionUtils 不要实现为单例子： 如果为单例子的话可能会发生线程安全问题
    // // 异常通知
    @AfterThrowing("execution(* com.spring.source.code.service.*.*(..))")
    public void afterThrowing() {
        System.out.println("回滚事务");
        // 获取当前事务 直接回滚
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        transactionUtils.rollback();
    }

    // 环绕通知 在方法之前和之后处理事情
    @Around("execution(* com.spring.source.code.service.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        Class<?> clasz = AopUtils.getTargetClass(proceedingJoinPoint.getTarget());
        Method targetMethod = clasz.getMethod(signature.getName(), ((MethodSignature) signature).getParameterTypes());
        ExtTransactional extTransactional = targetMethod.getDeclaredAnnotation(ExtTransactional.class);
        if (extTransactional != null) {
            // 调用方法之前执行
            System.out.println("开启事务");
            transactionUtils.begin();
            proceedingJoinPoint.proceed();
            // 调用方法之后执行
            System.out.println("提交事务");
            transactionUtils.commit();
        } else {
            proceedingJoinPoint.proceed();
        }
    }
}
