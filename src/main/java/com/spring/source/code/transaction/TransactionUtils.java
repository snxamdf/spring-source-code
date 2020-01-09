package com.spring.source.code.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

//编程事务（需要手动begin 手动回滚  手都提交）
@Component
@Scope("prototype")//设置为多例对象,目的解决多线程安全问题
public class TransactionUtils {
    private TransactionStatus transaction;
    // 获取事务源
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    // 开启事务
    public TransactionStatus begin() {
        transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transaction;
    }

    // 提交事务
    public void commit() {
        if (transaction != null) {
            dataSourceTransactionManager.commit(transaction);
        }
    }

    // 回滚事务
    public void rollback() {
        if (transaction != null) {
            dataSourceTransactionManager.rollback(transaction);
        }
    }

}
