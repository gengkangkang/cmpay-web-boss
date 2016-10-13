package com.cmpay.boss.biz;
//package com.cmig.scheduler.biz;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cmig.saturn.activemq.sender.MessageSender;
//import com.cmig.scheduler.domain.SchedulerRecord;
//
//@Service("schedulerMessageSender")
//public class SchedulerMessageSender {
//
//    public static final String SCHEDULER_TOPIC = "TP_SC_SCHEDULER_1.0";
//
//    @Autowired
//    private MessageSender messageSender;
//
//    public void sendSchedulerMessage(SchedulerRecord schedulerRecord) {
//        System.out.println("schedulerRecord.getMessageType() = " + schedulerRecord.getMessageType());
//        messageSender.send(SCHEDULER_TOPIC, schedulerRecord);
//    }
//
//}
