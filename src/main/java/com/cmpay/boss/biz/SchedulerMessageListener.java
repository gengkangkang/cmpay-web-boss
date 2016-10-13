package com.cmpay.boss.biz;
//package com.cmig.scheduler.biz;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.cmig.saturn.listener.SaturnMessageListener;
//import com.cmig.scheduler.domain.SchedulerRecord;
//
//public class SchedulerMessageListener extends SaturnMessageListener {
//    @Autowired
//    private SchedulerManager schedulerManager;
//
//    @Override
//    protected void handleMessage(Object obj) {
//        SchedulerRecord sr = (SchedulerRecord) obj;
//        System.out.println(">>>>>>>>>>>>>>>>> 开始保存 sr = " + sr);
//        if (SchedulerManager.STATUS_ON.equals(sr.getStatus())) {
//            //FIXME: 消息类型
//            schedulerManager.addScheduler(sr.getSystemName(), sr.getTaskName(), sr.getCronExp(), sr.getMessageType());
//        } else {
//            if (SchedulerManager.STATUS_OFF.equals(sr.getStatus())) {
//                schedulerManager.passiveScheduler(sr);
//            }
//        }
//
//    }
//
//    /**
//     * Setter method for property <tt>schedulerManager</tt>.
//     *
//     * @param schedulerManager value to be assigned to property schedulerManager
//     */
//    public void setSchedulerManager(SchedulerManager schedulerManager) {
//        this.schedulerManager = schedulerManager;
//    }
//
//    /**
//     * Getter method for property <tt>schedulerManager</tt>.
//     *
//     * @return property value of schedulerManager
//     */
//    public SchedulerManager getSchedulerManager() {
//        return schedulerManager;
//    }
//
//}
