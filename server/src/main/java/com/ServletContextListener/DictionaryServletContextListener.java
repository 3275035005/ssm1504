package com.ServletContextListener;

import com.thread.MyThreadMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 字典初始化监视器  用的是服务器监听,每次项目启动,都会调用这个类
 */
public class DictionaryServletContextListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryServletContextListener.class);
    private MyThreadMethod myThreadMethod;
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("----------服务器停止----------");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        logger.info("----------线程执行开始----------");
        if (myThreadMethod == null) {
            myThreadMethod = new MyThreadMethod();
            myThreadMethod.start(); // servlet 上下文初始化时启动线程myThreadMethod
        }
        logger.info("----------线程执行结束----------");
    }

}
