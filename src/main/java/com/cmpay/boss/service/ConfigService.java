package com.cmpay.boss.service;

import java.util.Map;

import com.cmpay.boss.domain.IpBO;
import com.cmpay.boss.domain.MerchantBO;
import com.cmpay.boss.domain.PayChannelBO;
import com.cmpay.boss.util.Pagination;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月11日 下午2:46:42
 *
 */
public interface ConfigService {

	//IP相关
    Pagination<IpBO> getAllIp(IpBO ipBO);
    Map addNewIp(String ip,String inchannel,String remark);
    IpBO getById(String ip);
    Map updateIpInfo(IpBO ipBO);
    Pagination<IpBO> getIpByPara(IpBO ipBO);

    //商户相关sql
    Pagination<MerchantBO> getAllMer(MerchantBO merchantBO);
    Pagination<MerchantBO> getMerByPara(MerchantBO merchantBO);
    Map addNewMer(MerchantBO merchantBO);
    MerchantBO getMerById(String id);
    Map updateMerInfo(MerchantBO merchantBO);

    //支付渠道相关
    Pagination<PayChannelBO> getPayChannelByPara(PayChannelBO payChannelBO);
    Map addNewChannel(PayChannelBO payChannelBO);
    PayChannelBO getChannelById(String id);
    Map updateChannelInfo(PayChannelBO payChannelBO);




}
