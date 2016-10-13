package com.cmpay.boss.biz;
//package com.cmig.scheduler.biz;
//
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.quartz.CronTrigger;
//import org.quartz.JobDataMap;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Service;
//
//import com.cmig.saturn.activemq.sender.MessageSender;
//import com.cmig.saturn.activemq.sender.impl.MessageSenderImpl;
//
//import java.text.ParseException;
//
///**
// * 调度框架工厂类
// */
//@Service("saturnSchedulerFactory")
//public class SaturnSchedulerFactory {
//    private static final Log logger = LogFactory.getLog(SaturnSchedulerFactory.class);
//
//    private static Scheduler scheduler;
//
//    @Autowired
//    private MessageSender messageSender;
//
//    private Scheduler getScheduler() {
//        if (scheduler == null) {
//            SchedulerFactory sf = new StdSchedulerFactory();
//            try {
//                scheduler = sf.getScheduler();
//                scheduler.start();
//                logger.info("调度框架启动成功！");
//            } catch (SchedulerException e) {
//                logger.error("调度框架启动失败", e);
//            }
//        }
//
//        return scheduler;
//    }
//
//    public void addScheduler(String schedulerName, String cronExp, String messageType) {
//        try {
//            getScheduler().deleteJob(schedulerName, schedulerName);
//
////        	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
////    				new String[] { "classpath*:applicationContext.xml" });
////        	messageSender = (MessageSenderImpl) applicationContext.getBean("messageSender");
//
//            JobDetail jobDetail = new JobDetail();
//            jobDetail.setJobClass(MessageSendJob.class);
//            jobDetail.setName(schedulerName);
//            jobDetail.setGroup(schedulerName);
//
//            JobDataMap jobDataMap = new JobDataMap();
//            jobDataMap.put("messageSender", messageSender);
//            jobDataMap.put("messageType", messageType);
//            jobDetail.setJobDataMap(jobDataMap);
//
//            CronTrigger cronTrigger = null;
//            try {
//                cronTrigger = new CronTrigger(schedulerName, schedulerName, cronExp);
//                scheduler.scheduleJob(jobDetail, cronTrigger);
//                scheduler.start();
//            } catch (ParseException e) {
//                logger.error(schedulerName + "表达式错误", e);
//            }
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            logger.error("添加调度任务出错", e);
//        }
//        logger.info("添加调度任务"+schedulerName+"成功，cron="+cronExp);
//    }
//
//    public void delScheduler(String schedulerName) {
//        try {
//            getScheduler().deleteJob(schedulerName, schedulerName);
//
//        } catch (SchedulerException e) {
//            logger.error("删除调度任务出错", e);
//        }
//    }
//
//
//}
