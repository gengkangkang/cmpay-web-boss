package com.cmpay.boss.biz;
//package com.cmig.scheduler.biz;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.TransactionCallback;
//import org.springframework.transaction.support.TransactionTemplate;
//
//import com.cmig.scheduler.domain.SchedulerRecord;
//import com.cmig.scheduler.service.SchedulerRecordRepository;
//
//
//@Service("schedulerManager")
//public class SchedulerManager {
//    private static final Log logger = LogFactory.getLog(SchedulerManager.class);
//
//    public static final String       STATUS_ON  = "on";
//    public static final String       STATUS_OFF = "off";
//    @Autowired
//    private SaturnSchedulerFactory    saturnSchedulerFactory;
//    @Autowired
//    private SchedulerRecordRepository schedulerRecordRepository;
//
//    @Autowired
//    TransactionTemplate               transactionTemplate;
//
//
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public void addScheduler(final String systemName, final String taskName, final String cronExp, final String messageType) {
//
//        transactionTemplate.execute(new TransactionCallback() {
//            public Object doInTransaction(TransactionStatus status) {
//                SchedulerRecord schedulerRecord  = new SchedulerRecord();
//                schedulerRecord.setCronExp(cronExp);
//                schedulerRecord.setStatus(STATUS_ON);
//                schedulerRecord.setSystemName(systemName);
//                schedulerRecord.setMessageType(messageType);
//                schedulerRecord.setTaskName(taskName);;
//                if (schedulerRecordRepository
//                        .getSchedulerRecordByIndex(systemName, taskName) == null) {
//                    schedulerRecordRepository.insert(schedulerRecord);
//                } else {
//                    schedulerRecordRepository.updateSchedulerStatusRecordByIndex(schedulerRecord);
//                }
//                saturnSchedulerFactory.addScheduler(SchedulerManager.constructSchedulerName(schedulerRecord.getSystemName(), schedulerRecord.getTaskName()),
//                        schedulerRecord.getCronExp(), schedulerRecord.getMessageType());
//                return null;
//            }
//        });
//
//    }
//
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public void passiveScheduler(final SchedulerRecord sr) {
//
//        transactionTemplate.execute(new TransactionCallback() {
//            public Object doInTransaction(TransactionStatus status) {
//                SchedulerRecord schedulerRecord = schedulerRecordRepository
//                    .getSchedulerRecordByIndex(sr.getSystemName(), sr.getTaskName());
//                if (schedulerRecord == null) {
//                    return null;
//                } else {
//                	SchedulerRecord record  = new SchedulerRecord();
//                	record.setSystemName(sr.getSystemName());
//                	record.setTaskName(sr.getTaskName());
//                	record.setStatus(STATUS_OFF);
//                	record.setMessageType(sr.getMessageType());
//                    schedulerRecordRepository.updateSchedulerStatusRecordByIndex(record);
//                }
//                saturnSchedulerFactory.delScheduler(SchedulerManager.constructSchedulerName(sr.getSystemName(), sr.getTaskName()));
//                return null;
//            }
//        });
//    }
//
//    public static String constructSchedulerName(String systemName, String taskName) {
//        //return "TP_SC_" + systemName + "_" + taskName;
//        return taskName;
//    }
//
//    /**
//     * Setter method for property <tt>saturnSchedulerFactory</tt>.
//     *
//     * @param saturnSchedulerFactory value to be assigned to property saturnSchedulerFactory
//     */
//    public void setSaturnSchedulerFactory(SaturnSchedulerFactory saturnSchedulerFactory) {
//        this.saturnSchedulerFactory = saturnSchedulerFactory;
//    }
//
//    /**
//     * Getter method for property <tt>saturnSchedulerFactory</tt>.
//     *
//     * @return property value of saturnSchedulerFactory
//     */
//    public SaturnSchedulerFactory getSaturnSchedulerFactory() {
//        return saturnSchedulerFactory;
//    }
//
//    /**
//     * Setter method for property <tt>schedulerRecordRepository</tt>.
//     *
//     * @param schedulerRecordRepository value to be assigned to property schedulerRecordRepository
//     */
//    public void setSchedulerRecordRepository(SchedulerRecordRepository schedulerRecordRepository) {
//        this.schedulerRecordRepository = schedulerRecordRepository;
//    }
//
//    /**
//     * Getter method for property <tt>schedulerRecordRepository</tt>.
//     *
//     * @return property value of schedulerRecordRepository
//     */
//    public SchedulerRecordRepository getSchedulerRecordRepository() {
//        return schedulerRecordRepository;
//    }
//
//}
