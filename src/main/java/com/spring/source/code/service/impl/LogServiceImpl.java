package com.spring.source.code.service.impl;import com.spring.source.code.dao.LogDao;import com.spring.source.code.service.LogService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Propagation;import org.springframework.transaction.annotation.Transactional;import java.util.Date;/** * @author * @description * @date 2020/1/9 */@Servicepublic class LogServiceImpl implements LogService {    @Autowired    private LogDao logDao;    @Override    @Transactional(propagation = Propagation.NOT_SUPPORTED)    public void add() {        logDao.add("add log" + new Date().toString());        int i = 1 / 0;    }}