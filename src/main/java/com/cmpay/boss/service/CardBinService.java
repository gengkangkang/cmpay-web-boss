package com.cmpay.boss.service;

import java.math.BigDecimal;
import java.util.Map;

import com.cmpay.boss.domain.CardBinBO;
import com.cmpay.boss.domain.MerchantBO;
import com.cmpay.boss.util.Pagination;

public interface CardBinService {
	
	    Pagination<CardBinBO> getAllCardbin(CardBinBO cardBinBO);
	    Pagination<CardBinBO> getCardbinByPara(CardBinBO cardBinBO);
	    Map addNewCardbin(CardBinBO cardBinBO);
	    Map updateCardbinInfo(CardBinBO cardBinBO);
	    CardBinBO getCardByKey(String cardBin,String cardLenght);

}