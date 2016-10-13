package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.SchedulerRecord;
import com.cmpay.boss.domain.SchedulerRecordConverter;
import com.cmpay.boss.entity.SCRECORDDO;
import com.cmpay.boss.entity.SCRECORDDOExample;
import com.cmpay.boss.mapper.SCRECORDDOMapper;
import com.cmpay.boss.service.SchedulerRecordRepository;


@Service("schedulerRecordRepository")
public class SchedulerRecordRepositoryImpl implements SchedulerRecordRepository {
    @Autowired
    private SCRECORDDOMapper _SCRECORDDOMapper;

    /**
     * @{inheritDoc}
     */
    @Override
    public void insert(SchedulerRecord schedulerRecord) {
    	_SCRECORDDOMapper.insertSelective(SchedulerRecordConverter
                .convertSchedulerRecord(schedulerRecord));
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public SchedulerRecord getSchedulerRecordByIndex(String systemName, String taskName) {
    	SCRECORDDOExample  _SCRECORDDOExample = new SCRECORDDOExample();
    	_SCRECORDDOExample.createCriteria().andSystemNameEqualTo(systemName).andTaskNameEqualTo(taskName);
       List<SCRECORDDO> list = _SCRECORDDOMapper.selectByExample(_SCRECORDDOExample);
       if(list!=null&&list.size()==1){
    	   SchedulerRecord  schedulerRecord = SchedulerRecordConverter.convertSchedulerRecordDO(list.get(0));
    	   return schedulerRecord;
       }else{
    	   return null;
       }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateSchedulerStatusRecordByIndex(SchedulerRecord schedulerRecord) {
        _SCRECORDDOMapper.updateByPrimaryKeySelective(SchedulerRecordConverter
                .convertSchedulerRecord(schedulerRecord));
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public List<SchedulerRecord> listAllSchedulerRecords(String systemName, String taskName, String status) {
    	SCRECORDDOExample  _SCRECORDDOExample = new SCRECORDDOExample();
    	SCRECORDDOExample.Criteria criteria = _SCRECORDDOExample.createCriteria();
    	if (StringUtils.isNotBlank(systemName)) {
    		criteria.andSystemNameLike("%" + systemName + "%");
        }
        if (StringUtils.isNotBlank(taskName)) {
        	criteria.andTaskNameLike("%" + taskName + "%");
        }
        if (StringUtils.isNotBlank(status)) {
        	criteria.andStatusEqualTo(status);
        }
        List<SCRECORDDO> list = _SCRECORDDOMapper.selectByExample(_SCRECORDDOExample);
        List<SchedulerRecord> targetList = new ArrayList<SchedulerRecord>();
        for (Object o : list) {
        	SCRECORDDO sr = (SCRECORDDO) o;
            targetList.add(SchedulerRecordConverter.convertSchedulerRecordDO(sr));
        }
        return targetList;
    }

	public SCRECORDDOMapper get_SCRECORDDOMapper() {
		return _SCRECORDDOMapper;
	}

	public void set_SCRECORDDOMapper(SCRECORDDOMapper _SCRECORDDOMapper) {
		this._SCRECORDDOMapper = _SCRECORDDOMapper;
	}
}
