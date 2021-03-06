package com.cmpay.boss.service;
import java.util.Map;

import com.cmpay.boss.domain.OrderRecordBO;
import com.cmpay.boss.util.Pagination;

public interface OrderRecordService {
    Pagination<OrderRecordBO> getAllOrderRecord(OrderRecordBO orderRecordBO);
    Pagination<OrderRecordBO> getOrderRecordByPara(OrderRecordBO orderRecordBO);
    OrderRecordBO getOrderRecordById(String id);
    Map updateOrderRecordInfo(OrderRecordBO orderRecordBO);
}
