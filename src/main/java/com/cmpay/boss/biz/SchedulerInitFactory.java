package com.cmpay.boss.biz;
//package com.cmig.scheduler.biz;
//
//import org.apache.activemq.ConfigurationException;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.cmig.scheduler.domain.SchedulerRecord;
//import com.cmig.scheduler.service.SchedulerRecordRepository;
//
//import java.io.IOException;
//import java.util.List;
//
///**
// * 用来创建和初始化调度任务的工厂
// */
//public class SchedulerInitFactory {
//
//    protected static final Log        logger = LogFactory.getLog(SchedulerInitFactory.class);
//    @Autowired
//    private SchedulerManager          schedulerManager;
//    @Autowired
//    private SchedulerRecordRepository schedulerRecordRepository;
//
//    /**
//     */
//    public void init() throws ConfigurationException, IOException {
//        try {
//            List<SchedulerRecord> records = schedulerRecordRepository.listAllSchedulerRecords(null,
//                null, null);
//            for (SchedulerRecord record : records) {
//                if (SchedulerManager.STATUS_ON.equals(record.getStatus())) {
//                    schedulerManager.addScheduler(record.getSystemName(), record.getTaskName(),
//                        record.getCronExp(), record.getMessageType());
//                }
//
//            }
//            logger.info("初始化SchedulerInitFactory工厂成功...");
//        } catch (Exception e) {
//            logger.error("加载SchedulerInitFactory报错.", e);
//        }
//    }
//
//}
