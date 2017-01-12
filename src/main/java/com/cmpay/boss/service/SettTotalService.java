package com.cmpay.boss.service;
import com.cmpay.boss.domain.SettDetailBO;
import com.cmpay.boss.domain.SettTotalBO;
import com.cmpay.boss.util.Pagination;

public interface SettTotalService {
	
	Pagination<SettTotalBO> getAllSettOrder(SettTotalBO settTotalBO);
    Pagination<SettTotalBO> getSettOrderByPara(SettTotalBO settTotalBO);
    
    Pagination<SettDetailBO> getSettDetailByPara(SettDetailBO settDetailBO);
	

}
