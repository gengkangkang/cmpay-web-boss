package com.cmpay.boss.biz;
//package com.cmig.scheduler.biz;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//
//import com.cmig.saturn.activemq.sender.MessageSender;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class MessageSendJob implements Job {
//    private static final Log logger = LogFactory.getLog(MessageSendJob.class);
//
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//
//        MessageSender messageSender = (MessageSender) jobExecutionContext.getJobDetail().getJobDataMap().get("messageSender");
//        String messageType = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("messageType");
//        String name = jobExecutionContext.getJobDetail().getName();
//
//        sendMessage(messageSender, messageType, name);
//
//    }
//
//    public void sendMessage(MessageSender messageSender, String messageType, String name) {
//        if ("DATE".equals(messageType)) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            messageSender.send(name, sdf.format(new Date()));
//            logger.info(new Date() + "给topic=" + name + "发送时间调度消息...");
//            System.out.println("OUT:" + new Date() + "给topic="
//                    + name + "发送时间调度消息...");
//        } else {
//            messageSender.send(name, name);
//            logger.info(new Date() + "给topic=" + name + "发送调度消息...");
//            System.out.println("OUT:" + new Date() + "给topic=" + name + "发送调度消息...");
//        }
//    }
//}
