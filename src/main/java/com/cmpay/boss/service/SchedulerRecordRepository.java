
package com.cmpay.boss.service;


import java.util.List;

import com.cmpay.boss.domain.SchedulerRecord;

public interface SchedulerRecordRepository {

    public void insert(SchedulerRecord schedulerRecord);

    public SchedulerRecord getSchedulerRecordByIndex(String systemName,String taskName);

    public void updateSchedulerStatusRecordByIndex(SchedulerRecord schedulerRecord) ;
    
    public List<SchedulerRecord> listAllSchedulerRecords(String systemName,String taskName, String status);
}
