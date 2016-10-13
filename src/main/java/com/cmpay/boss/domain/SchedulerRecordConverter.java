package com.cmpay.boss.domain;

import org.springframework.beans.BeanUtils;

import com.cmpay.boss.entity.SCRECORDDO;



public class SchedulerRecordConverter {

    public static SchedulerRecord convertSchedulerRecordDO(SCRECORDDO _SCRECORDDO) {
        if(_SCRECORDDO ==null){
            return null;
        }
        SchedulerRecord schedulerRecord = new SchedulerRecord();
        BeanUtils.copyProperties(_SCRECORDDO, schedulerRecord);
        return schedulerRecord;
    }

    public static SCRECORDDO convertSchedulerRecord(SchedulerRecord schedulerRecord) {
        if(schedulerRecord ==null){
            return null;
        }
        SCRECORDDO _SCRECORDDO = new SCRECORDDO();
        BeanUtils.copyProperties(schedulerRecord, _SCRECORDDO);
        return _SCRECORDDO;
    }

}
