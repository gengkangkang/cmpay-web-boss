package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.BankBaseBO;
import com.cmpay.boss.domain.ChannelBaseBO;
import com.cmpay.boss.domain.ChannelConfigBO;
import com.cmpay.boss.domain.IpBO;
import com.cmpay.boss.domain.MerchantBO;
import com.cmpay.boss.domain.PayChannelBO;
import com.cmpay.boss.domain.SuppBankBO;
import com.cmpay.boss.entity.CMPAYIPBINDING;
import com.cmpay.boss.entity.CmpayBankBase;
import com.cmpay.boss.entity.CmpayBankBaseExample;
import com.cmpay.boss.entity.CmpayChannel;
import com.cmpay.boss.entity.CmpayChannelBase;
import com.cmpay.boss.entity.CmpayChannelBaseExample;
import com.cmpay.boss.entity.CmpayChannelConfig;
import com.cmpay.boss.entity.CmpayChannelConfigExample;
import com.cmpay.boss.entity.CmpayChannelExample;
import com.cmpay.boss.entity.CmpayMerchant;
import com.cmpay.boss.entity.CmpayMerchantExample;
import com.cmpay.boss.entity.CmpaySuppBankMap;
import com.cmpay.boss.entity.CmpaySuppBankMapExample;
import com.cmpay.boss.mapper.CMPAYIPBINDINGMapper;
import com.cmpay.boss.mapper.CmpayBankBaseMapper;
import com.cmpay.boss.mapper.CmpayChannelBaseMapper;
import com.cmpay.boss.mapper.CmpayChannelConfigMapper;
import com.cmpay.boss.mapper.CmpayChannelMapper;
import com.cmpay.boss.mapper.CmpayMerchantMapper;
import com.cmpay.boss.mapper.CmpaySuppBankMapMapper;
import com.cmpay.boss.service.ConfigService;
import com.cmpay.boss.service.MonitorRealm;
import com.cmpay.boss.util.Constant;
import com.cmpay.boss.util.DateUtil;
import com.cmpay.boss.util.Pagination;
import com.cmpay.boss.util.UUIDGenerator;
import com.cmpay.common.enums.InChannelEnum;
import com.cmpay.common.util.Constants;
import com.cmpay.common.util.RedisConstants;
import com.cmpay.common.util.RedisUtil;
import com.github.pagehelper.PageHelper;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月11日 下午2:47:33
 *
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Autowired
    CMPAYIPBINDINGMapper    cmpayIpBindingMapper;
    @Autowired
    CmpayMerchantMapper cmpayMerchantMapper;
    @Autowired
    CmpayChannelMapper cmpayChannelMapper;
    @Autowired
    CmpayChannelBaseMapper cmpayChannelBaseMapper;
    @Autowired
    CmpayBankBaseMapper cmpayBankBaseMapper;
    @Autowired
    CmpaySuppBankMapMapper cmpaySuppBankMapMapper;
    @Autowired
    CmpayChannelConfigMapper cmpayChannelConfigMapper;
    @Autowired
    private RedisUtil redisUtil;


	@Override
	public Pagination<IpBO> getAllIp(IpBO ipBO) {

		int count =cmpayIpBindingMapper.getIpCounts();
        Pagination pagination = new Pagination(count, ipBO.getPageCurrent(),ipBO.getPageSize());
        PageHelper.startPage(ipBO.getPageCurrent(), ipBO.getPageSize());

        List<CMPAYIPBINDING> ips=cmpayIpBindingMapper.getAllIp();
        List<IpBO> ipBOList = new ArrayList<>();
        for(CMPAYIPBINDING ipbinding:ips ){
        	IpBO ip=new IpBO();
            ip.setIp(ipbinding.getIp());
            ip.setInchannel(InChannelEnum.getInchannelByCode(ipbinding.getInchannel()));
            ip.setStatus(ipbinding.getStatus());
            ip.setCreatetime(ipbinding.getCreatetime());
            ip.setUpdatetime(ipbinding.getUpdatetime());
            ip.setOperator(ipbinding.getOperator());
            ip.setRemark(ipbinding.getRemark());
            ipBOList.add(ip);
        }
        pagination.addResult(ipBOList);

		return pagination;
	}

	@Override
	public Pagination<MerchantBO> getAllMer(MerchantBO merchantBO) {

		CmpayMerchantExample cmpayMerchantExample=new CmpayMerchantExample();
        int count=cmpayMerchantMapper.countByExample(cmpayMerchantExample);

        Pagination pagination = new Pagination(count, merchantBO.getPageCurrent(),merchantBO.getPageSize());
        PageHelper.startPage(merchantBO.getPageCurrent(), merchantBO.getPageSize());
        List<CmpayMerchant> mers=cmpayMerchantMapper.selectByExample(cmpayMerchantExample);
        List<MerchantBO> merchantBOList=new ArrayList<MerchantBO>();
        for(CmpayMerchant cmpayMerchant:mers){
        	MerchantBO merBO=new MerchantBO();
        	try {
				BeanUtils.copyProperties(merBO, cmpayMerchant);
			} catch (Exception e) {
				logger.error("cope cmpayMerchant异常！！！！！！");
				e.printStackTrace();
			}
        	merchantBOList.add(merBO);

        }
        pagination.addResult(merchantBOList);

		return pagination;
	}

	@Override
	public Pagination<ChannelBaseBO> getAllChannelBase(ChannelBaseBO channelBaseBO) {
		CmpayChannelBaseExample cmpayChannelBaseExample=new CmpayChannelBaseExample();
		int count=cmpayChannelBaseMapper.countByExample(cmpayChannelBaseExample);

        Pagination pagination = new Pagination(count, channelBaseBO.getPageCurrent(),channelBaseBO.getPageSize());
        PageHelper.startPage(channelBaseBO.getPageCurrent(), channelBaseBO.getPageSize());

        List<CmpayChannelBase> channels=cmpayChannelBaseMapper.selectByExample(cmpayChannelBaseExample);
        List<ChannelBaseBO> channelBaseBOList=new ArrayList<ChannelBaseBO>();
        for(CmpayChannelBase cmpayChannelBase:channels){
        	ChannelBaseBO channelBO=new ChannelBaseBO();
        	try {
				BeanUtils.copyProperties(channelBO, cmpayChannelBase);
			} catch (Exception e) {
				logger.error("cope cmpayChannelBase异常！！！！！！");
				e.printStackTrace();
			}
        	channelBaseBOList.add(channelBO);

        }
        pagination.addResult(channelBaseBOList);

		return pagination;
	}

	@Override
	public Map addNewIp(String ip, String inchannel, String remark) {
        Map resultMap = new HashMap();
        CMPAYIPBINDING cmpayIpBinding = new CMPAYIPBINDING();
        cmpayIpBinding.setIp(ip);
        cmpayIpBinding.setInchannel(inchannel);
        cmpayIpBinding.setStatus("OFF");
        cmpayIpBinding.setRemark(remark);
        cmpayIpBinding.setCreatetime(DateUtil.getCurrTime());

        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
                .getPrincipal();
        String loginName=shiroUser.getLoginName();
        cmpayIpBinding.setOperator(loginName);
        logger.info("新增IP配置执行人[{}],参数[ip={},inchannel={},remark={}]",loginName,ip,inchannel,remark);

        int r=cmpayIpBindingMapper.insert(cmpayIpBinding);

        if (r != 0) {
            resultMap.put("statusCode", 200);
            resultMap.put("message", "操作成功!");
            resultMap.put("closeCurrent", true);

            //操作成功，更新缓存
//            try{
//            	logger.info("更新IP[{}]到缓存中",_CMPAYIPBINDING.getIp());
//            	redisUtil.set(RedisConstants.CMPAY_IPCONTROL_+_CMPAYIPBINDING.getIp(),_CMPAYIPBINDING.getIp());
//            }catch(Exception e){
//            	logger.error("新增IP更新到缓存异常！",e);
//            }

        } else {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");
            resultMap.put("closeCurrent", false);
        }

		return resultMap;
	}


	@Override
	public Map addNewMer(MerchantBO merchantBO) {

        Map resultMap = new HashMap();
		try{
			CmpayMerchant cmpayMerchant=new CmpayMerchant();
			BeanUtils.copyProperties(cmpayMerchant, merchantBO);
			cmpayMerchant.setId(UUIDGenerator.getUUID());
			cmpayMerchant.setStatus("OFF");
			cmpayMerchant.setCreatetime(DateUtil.getCurrTime());
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpayMerchant.setOperator(loginName);
	        logger.info("新增商户参数："+cmpayMerchant.toString());

	        int r=cmpayMerchantMapper.insert(cmpayMerchant);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	            if(StringUtils.isNotBlank(cmpayMerchant.getPartnerKey())){
                    try{
                		logger.info("更新商户key到缓存");
		            	redisUtil.set(RedisConstants.CMPAY_MD5KEY_+cmpayMerchant.getMerchantid(),cmpayMerchant.getPartnerKey());
                 }catch(Exception e){
                	logger.info("更新商户key到缓存失败",e);
                 }

	            }

	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

		}catch(Exception e){
			logger.error("新增商户出现异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map addNewChannel(PayChannelBO payChannelBO) {
        Map resultMap = new HashMap();
		try{
			CmpayChannel cmpayChannel=new CmpayChannel();
			BeanUtils.copyProperties(cmpayChannel, payChannelBO);
			cmpayChannel.setId(UUIDGenerator.getUUID());
			cmpayChannel.setOpenStatus(Constant.OFF);
			cmpayChannel.setCreateTime(new Date());
			cmpayChannel.setVersion(0);
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpayChannel.setCreator(loginName);
	        logger.info("新增渠道参数："+cmpayChannel.toString());

	        int r=cmpayChannelMapper.insert(cmpayChannel);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

		}catch(Exception e){
			logger.error("新增支付渠道出现异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map addNewCB(ChannelBaseBO channelBaseBO) {
		Map resultMap = new HashMap();
		try{
			CmpayChannelBase cmpayChannelBase=new CmpayChannelBase();
			BeanUtils.copyProperties(cmpayChannelBase, channelBaseBO);
			cmpayChannelBase.setId(UUIDGenerator.getUUID());
			cmpayChannelBase.setCreateTime(new Date());
			cmpayChannelBase.setVersion(0);
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpayChannelBase.setCreator(loginName);
	        logger.info("新增基础渠道信息参数："+cmpayChannelBase.toString());

	        int r=cmpayChannelBaseMapper.insert(cmpayChannelBase);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

		}catch(Exception e){
			logger.error("新增基础渠道信息出现异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public IpBO getById(String ip) {
		CMPAYIPBINDING _CMPAYIPBINDING=cmpayIpBindingMapper.selectByPrimaryKey(ip);
		return convertCMPAYIPBINDINGToIpBO(_CMPAYIPBINDING);
	}

	private IpBO convertCMPAYIPBINDINGToIpBO(CMPAYIPBINDING _CMPAYIPBINDING){
		IpBO ipBO=new IpBO();
		ipBO.setIp(_CMPAYIPBINDING.getIp());
		ipBO.setInchannel(_CMPAYIPBINDING.getInchannel());
		ipBO.setStatus(_CMPAYIPBINDING.getStatus());
		ipBO.setCreatetime(_CMPAYIPBINDING.getCreatetime());
		ipBO.setOperator(_CMPAYIPBINDING.getOperator());
		return ipBO;

	}

	@Override
	public Map updateIpInfo(IpBO ipBO) {
		 Map resultMap = new HashMap();
		 CMPAYIPBINDING _CMPAYIPBINDING=new CMPAYIPBINDING();
	        _CMPAYIPBINDING.setIp(ipBO.getIp());
	        _CMPAYIPBINDING.setInchannel(ipBO.getInchannel());
	        _CMPAYIPBINDING.setStatus(ipBO.getStatus());
	        _CMPAYIPBINDING.setRemark(ipBO.getRemark());
	        _CMPAYIPBINDING.setUpdatetime(DateUtil.getCurrTime());

	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        _CMPAYIPBINDING.setOperator(loginName);
	        logger.info("修改IP配置执行人[{}],参数[ip={},inchannel={},remark={}]",loginName,ipBO.getIp(),ipBO.getInchannel(),ipBO.getRemark());

	        int r=cmpayIpBindingMapper.updateByPrimaryKeySelective(_CMPAYIPBINDING);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	            //操作成功，更新缓存
	            try{
	            	logger.info("根据IP【{}】状态[{}]操作缓存",ipBO.getIp(),ipBO.getStatus());
	            	if(StringUtils.equals(Constants.ON, ipBO.getStatus())){
	            		logger.info("启用ip地址，添加到缓存中");
		            	redisUtil.set(RedisConstants.CMPAY_IPCONTROL_+ipBO.getIp(),ipBO.getIp());
	            	}else if(StringUtils.equals(Constants.OFF, ipBO.getStatus())){
	            		logger.info("禁用ip地址，从缓存中删除");
	            		redisUtil.del(RedisConstants.CMPAY_IPCONTROL_+ipBO.getIp());
	            	}else{
	            		logger.info("状态未知");

	            	}

	            }catch(Exception e){
	            	logger.error("修改IP更新到缓存异常！",e);
	            }


	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

			return resultMap;

	}

	@Override
	public MerchantBO getMerById(String id) {
		CmpayMerchant cmpayMerchant=cmpayMerchantMapper.selectByPrimaryKey(id);
		MerchantBO merchantBO=new MerchantBO();
		try {
			BeanUtils.copyProperties(merchantBO, cmpayMerchant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchantBO;
	}


	@Override
	public PayChannelBO getChannelById(String id) {
		CmpayChannel cmpayChannel=cmpayChannelMapper.selectByPrimaryKey(id);
		PayChannelBO payChannelBO=new PayChannelBO();
		try {
			BeanUtils.copyProperties(payChannelBO, cmpayChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payChannelBO;
	}

	@Override
	public ChannelBaseBO getChannelBaseById(String id) {
		CmpayChannelBase cmpayChannelBase=cmpayChannelBaseMapper.selectByPrimaryKey(id);
		ChannelBaseBO channelBaseBO=new ChannelBaseBO();
		try {
			BeanUtils.copyProperties(channelBaseBO, cmpayChannelBase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return channelBaseBO;
	}

	@Override
	public Map updateMerInfo(MerchantBO merchantBO) {
		 Map resultMap = new HashMap();
		try{
			CmpayMerchant cmpayMerchant=new CmpayMerchant();
			BeanUtils.copyProperties(cmpayMerchant, merchantBO);
			 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
		                .getPrincipal();
		        String loginName=shiroUser.getLoginName();
		        cmpayMerchant.setOperator(loginName);
		        cmpayMerchant.setUpdatetime(DateUtil.getCurrTime());
		        logger.info("更新商户信息参数为："+cmpayMerchant.toString());
		        int r=cmpayMerchantMapper.updateByPrimaryKeySelective(cmpayMerchant);
		        if (r != 0) {
		            resultMap.put("statusCode", 200);
		            resultMap.put("message", "操作成功!");
		            resultMap.put("closeCurrent", true);
		            //更新商户KEY
		            if(StringUtils.isNotBlank(cmpayMerchant.getPartnerKey())){
                     try{
                    		logger.info("更新商户key到缓存");
    		            	redisUtil.set(RedisConstants.CMPAY_MD5KEY_+cmpayMerchant.getMerchantid(),cmpayMerchant.getPartnerKey());
                     }catch(Exception e){
                    	logger.info("更新商户key到缓存失败",e);
                     }
		            }

		        } else {
		            resultMap.put("statusCode", 300);
		            resultMap.put("message", "操作失败!");
		            resultMap.put("closeCurrent", false);
		        }

		}catch(Exception e){
			logger.error("更新商户信息异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map updateChannelInfo(PayChannelBO payChannelBO) {
		 Map resultMap = new HashMap();
			try{
				CmpayChannel cmpayChannel=new CmpayChannel();
				BeanUtils.copyProperties(cmpayChannel, payChannelBO);
				 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
			                .getPrincipal();
			        String loginName=shiroUser.getLoginName();
			        cmpayChannel.setModifier(loginName);
			        cmpayChannel.setModifyTime(new Date());
			        logger.info("更新渠道信息参数为："+cmpayChannel.toString());
			        int r=cmpayChannelMapper.updateByPrimaryKeySelective(cmpayChannel);
			        if (r != 0) {
			            resultMap.put("statusCode", 200);
			            resultMap.put("message", "操作成功!");
			            resultMap.put("closeCurrent", true);
			        } else {
			            resultMap.put("statusCode", 300);
			            resultMap.put("message", "操作失败!");
			            resultMap.put("closeCurrent", false);
			        }

			}catch(Exception e){
				logger.error("更新渠道信息异常！！！");
				e.printStackTrace();
			}
			return resultMap;
	}

	@Override
	public Map updateCBInfo(ChannelBaseBO channelBaseBO) {
		 Map resultMap = new HashMap();
			try{
				CmpayChannelBase cmpayChannelBase=new CmpayChannelBase();
				BeanUtils.copyProperties(cmpayChannelBase, channelBaseBO);
				 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
			                .getPrincipal();
			        String loginName=shiroUser.getLoginName();
			        cmpayChannelBase.setModifier(loginName);
			        cmpayChannelBase.setModifyTime(new Date());
			        logger.info("更新基础渠道信息参数为："+cmpayChannelBase.toString());
			        int r=cmpayChannelBaseMapper.updateByPrimaryKeySelective(cmpayChannelBase);
			        if (r != 0) {
			            resultMap.put("statusCode", 200);
			            resultMap.put("message", "操作成功!");
			            resultMap.put("closeCurrent", true);
			        } else {
			            resultMap.put("statusCode", 300);
			            resultMap.put("message", "操作失败!");
			            resultMap.put("closeCurrent", false);
			        }

			}catch(Exception e){
				logger.error("更新渠道信息异常！！！");
				e.printStackTrace();
			}
			return resultMap;
	}

	@Override
	public Pagination<IpBO> getIpByPara(IpBO ipBO) {
		int count =cmpayIpBindingMapper.getIpCounts();
        Pagination pagination = new Pagination(count, ipBO.getPageCurrent(),ipBO.getPageSize());
        PageHelper.startPage(ipBO.getPageCurrent(), ipBO.getPageSize());

        List<CMPAYIPBINDING> ips=cmpayIpBindingMapper.getIpByPara(ipBO);
        List<IpBO> ipBOList = new ArrayList<>();
        for(CMPAYIPBINDING ipbinding:ips ){
        	IpBO ip=new IpBO();
            ip.setIp(ipbinding.getIp());
            ip.setInchannel(InChannelEnum.getInchannelByCode(ipbinding.getInchannel()));
            ip.setStatus(ipbinding.getStatus());
            ip.setCreatetime(ipbinding.getCreatetime());
            ip.setUpdatetime(ipbinding.getUpdatetime());
            ip.setOperator(ipbinding.getOperator());
            ip.setRemark(ipbinding.getRemark());
            ipBOList.add(ip);
        }
        pagination.addResult(ipBOList);

		return pagination;
	}

	@Override
	public Pagination<MerchantBO> getMerByPara(MerchantBO merchantBO) {
		CmpayMerchantExample cmpayMerchantExample=new CmpayMerchantExample();
		if(StringUtils.isNotBlank(merchantBO.getMerchantid())){
			cmpayMerchantExample.createCriteria().andMerchantidEqualTo(merchantBO.getMerchantid());
		}
		if(StringUtils.isNotBlank(merchantBO.getMerchantName())){
			cmpayMerchantExample.createCriteria().andMerchantNameEqualTo(merchantBO.getMerchantName());
		}
        int count=cmpayMerchantMapper.countByExample(cmpayMerchantExample);

        Pagination pagination = new Pagination(count, merchantBO.getPageCurrent(),merchantBO.getPageSize());
        PageHelper.startPage(merchantBO.getPageCurrent(), merchantBO.getPageSize());
        List<CmpayMerchant> mers=cmpayMerchantMapper.selectByExample(cmpayMerchantExample);
        List<MerchantBO> merchantBOList=new ArrayList<MerchantBO>();
        for(CmpayMerchant cmpayMerchant:mers){
        	MerchantBO merBO=new MerchantBO();
        	try {
        		BeanUtils.copyProperties(merBO, cmpayMerchant);
			} catch (Exception e) {
				logger.error("cope cmpayMerchant异常！！！！！！");
				e.printStackTrace();
			}
        	merchantBOList.add(merBO);

        }
        pagination.addResult(merchantBOList);

		return pagination;
	}

	@Override
	public Pagination<PayChannelBO> getPayChannelByPara(PayChannelBO payChannelBO) {
        List<PayChannelBO> payChannelBOList=new ArrayList<PayChannelBO>();

		CmpayChannelExample cmpayChannelExample=new CmpayChannelExample();
		cmpayChannelExample.createCriteria().andMerchNoEqualTo(payChannelBO.getMerchNo());
		int count=cmpayChannelMapper.countByExample(cmpayChannelExample);
        Pagination pagination = new Pagination(count, payChannelBO.getPageCurrent(),payChannelBO.getPageSize());
        PageHelper.startPage(payChannelBO.getPageCurrent(), payChannelBO.getPageSize());
        List<CmpayChannel> channels=cmpayChannelMapper.selectByExample(cmpayChannelExample);

        for(CmpayChannel cmpayChannel:channels){
        	PayChannelBO payBO=new PayChannelBO();
        	try {
				BeanUtils.copyProperties(payBO, cmpayChannel);
			} catch (Exception e) {
				logger.error("cope CmpayChannel异常！！！！！！");
				e.printStackTrace();
			}
        	payChannelBOList.add(payBO);

        }
        pagination.addResult(payChannelBOList);

		return pagination;
	}

	@Override
	public Pagination<BankBaseBO> getAllBankBase(BankBaseBO bankBaseBO) {
		CmpayBankBaseExample cmpayBankBaseExample=new CmpayBankBaseExample();
		int count=cmpayBankBaseMapper.countByExample(cmpayBankBaseExample);

        Pagination pagination = new Pagination(count, bankBaseBO.getPageCurrent(),bankBaseBO.getPageSize());
        PageHelper.startPage(bankBaseBO.getPageCurrent(), bankBaseBO.getPageSize());

        List<CmpayBankBase> banks=cmpayBankBaseMapper.selectByExample(cmpayBankBaseExample);
        List<BankBaseBO> bankBaseBOList=new ArrayList<BankBaseBO>();
        for(CmpayBankBase cmpayBankBase:banks){
        	BankBaseBO bankBO=new BankBaseBO();
        	try {
				BeanUtils.copyProperties(bankBO, cmpayBankBase);
			} catch (Exception e) {
				logger.error("cope cmpayBankBase异常！！！！！！");
				e.printStackTrace();
			}
        	bankBaseBOList.add(bankBO);

        }
        pagination.addResult(bankBaseBOList);

		return pagination;
	}

	@Override
	public Map addNewBB(BankBaseBO bankBaseBO) {
		Map resultMap = new HashMap();
		try{
			CmpayBankBase cmpayBankBase=new CmpayBankBase();
			BeanUtils.copyProperties(cmpayBankBase, bankBaseBO);
			cmpayBankBase.setId(UUIDGenerator.getUUID());
			cmpayBankBase.setCreateTime(new Date());
			cmpayBankBase.setVersion(0);
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpayBankBase.setCreator(loginName);
	        logger.info("新增银行渠道信息参数："+cmpayBankBase.toString());

	        int r=cmpayBankBaseMapper.insert(cmpayBankBase);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

		}catch(Exception e){
			logger.error("新增基础银行信息出现异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public BankBaseBO getBankBaseById(String id) {
		CmpayBankBase cmpayBankBase=cmpayBankBaseMapper.selectByPrimaryKey(id);
		BankBaseBO bankBaseBO=new BankBaseBO();
		try {
			BeanUtils.copyProperties(bankBaseBO, cmpayBankBase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankBaseBO;
	}

	@Override
	public Map updateBBInfo(BankBaseBO bankBaseBO) {
		 Map resultMap = new HashMap();
			try{
				CmpayBankBase cmpayBankBase=new CmpayBankBase();
				BeanUtils.copyProperties(cmpayBankBase, bankBaseBO);
				 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
			                .getPrincipal();
			        String loginName=shiroUser.getLoginName();
			        cmpayBankBase.setModifier(loginName);
			        cmpayBankBase.setModifyTime(new Date());
			        logger.info("更新基础银行信息参数为："+cmpayBankBase.toString());
			        int r=cmpayBankBaseMapper.updateByPrimaryKeySelective(cmpayBankBase);
			        if (r != 0) {
			            resultMap.put("statusCode", 200);
			            resultMap.put("message", "操作成功!");
			            resultMap.put("closeCurrent", true);
			        } else {
			            resultMap.put("statusCode", 300);
			            resultMap.put("message", "操作失败!");
			            resultMap.put("closeCurrent", false);
			        }

			}catch(Exception e){
				logger.error("更新银行基础信息异常！！！");
				e.printStackTrace();
			}
			return resultMap;
	}

	@Override
	public Pagination<SuppBankBO> getSuppBankByPara(SuppBankBO suppBankBO) {
		 List<SuppBankBO> suppBankBOList=new ArrayList<SuppBankBO>();

			CmpaySuppBankMapExample cmpaySuppBankMapExample=new CmpaySuppBankMapExample();
			cmpaySuppBankMapExample.createCriteria().andPayChannelCodeEqualTo(suppBankBO.getPayChannelCode());
			int count=cmpaySuppBankMapMapper.countByExample(cmpaySuppBankMapExample);
	        Pagination pagination = new Pagination(count, suppBankBO.getPageCurrent(),suppBankBO.getPageSize());
	        PageHelper.startPage(suppBankBO.getPageCurrent(), suppBankBO.getPageSize());
	        List<CmpaySuppBankMap> banks=cmpaySuppBankMapMapper.selectByExample(cmpaySuppBankMapExample);

	        for(CmpaySuppBankMap cmpaySuppBankMap:banks){
	        	SuppBankBO SuppBankBO=new SuppBankBO();
	        	try {
					BeanUtils.copyProperties(SuppBankBO, cmpaySuppBankMap);
				} catch (Exception e) {
					logger.error("cope cmpaySuppBankMap异常！！！！！！");
					e.printStackTrace();
				}
	        	suppBankBOList.add(SuppBankBO);

	        }
	        pagination.addResult(suppBankBOList);

			return pagination;
	}

	@Override
	public Map addNewSuppBank(SuppBankBO suppBankBO) {
		Map resultMap = new HashMap();
		try{
			CmpaySuppBankMap cmpaySuppBankMap=new CmpaySuppBankMap();
			BeanUtils.copyProperties(cmpaySuppBankMap, suppBankBO);
			cmpaySuppBankMap.setId(UUIDGenerator.getUUID());
			cmpaySuppBankMap.setCreateTime(new Date());
			cmpaySuppBankMap.setVersion(0);
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpaySuppBankMap.setCreator(loginName);
	        logger.info("新增银行参数："+cmpaySuppBankMap.toString());

	        int r=cmpaySuppBankMapMapper.insert(cmpaySuppBankMap);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

		}catch(Exception e){
			logger.error("新增银行出现异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public SuppBankBO getSuppBankById(String id) {
		CmpaySuppBankMap cmpaySuppBankMap=cmpaySuppBankMapMapper.selectByPrimaryKey(id);
		SuppBankBO suppBankBO=new SuppBankBO();
		try {
			BeanUtils.copyProperties(suppBankBO, cmpaySuppBankMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suppBankBO;
	}

	@Override
	public Map updateSuppBankInfo(SuppBankBO suppBankBO) {
		 Map resultMap = new HashMap();
			try{
				CmpaySuppBankMap cmpaySuppBankMap=new CmpaySuppBankMap();
				BeanUtils.copyProperties(cmpaySuppBankMap, suppBankBO);
				 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
			                .getPrincipal();
			        String loginName=shiroUser.getLoginName();
			        cmpaySuppBankMap.setModifier(loginName);
			        cmpaySuppBankMap.setModifyTime(new Date());
			        logger.info("更新支持银行信息参数为："+cmpaySuppBankMap.toString());
			        int r=cmpaySuppBankMapMapper.updateByPrimaryKeySelective(cmpaySuppBankMap);
			        if (r != 0) {
			            resultMap.put("statusCode", 200);
			            resultMap.put("message", "操作成功!");
			            resultMap.put("closeCurrent", true);
			        } else {
			            resultMap.put("statusCode", 300);
			            resultMap.put("message", "操作失败!");
			            resultMap.put("closeCurrent", false);
			        }

			}catch(Exception e){
				logger.error("更新支持银行信息异常！！！");
				e.printStackTrace();
			}
			return resultMap;
	}

	@Override
	public Pagination<ChannelBaseBO> getChannelByPara(ChannelBaseBO channelBaseBO) {
		CmpayChannelBaseExample cmpayChannelBaseExample=new CmpayChannelBaseExample();
		if(StringUtils.isNotBlank(channelBaseBO.getCode())){
			cmpayChannelBaseExample.createCriteria().andCodeEqualTo(channelBaseBO.getCode());
		}
		if(StringUtils.isNotBlank(channelBaseBO.getName())){
			cmpayChannelBaseExample.createCriteria().andNameEqualTo(channelBaseBO.getName());
		}
        int count=cmpayChannelBaseMapper.countByExample(cmpayChannelBaseExample);

        Pagination pagination = new Pagination(count, channelBaseBO.getPageCurrent(),channelBaseBO.getPageSize());
        PageHelper.startPage(channelBaseBO.getPageCurrent(), channelBaseBO.getPageSize());
        List<CmpayChannelBase> chas=cmpayChannelBaseMapper.selectByExample(cmpayChannelBaseExample);
        List<ChannelBaseBO> chasBOList=new ArrayList<ChannelBaseBO>();
        for(CmpayChannelBase cmpayChannelBase:chas){
        	ChannelBaseBO chasBO=new ChannelBaseBO();
        	try {
        		BeanUtils.copyProperties(chasBO, cmpayChannelBase);
			} catch (Exception e) {
				logger.error("cope CmpayChannelBase异常！！！！！！");
				e.printStackTrace();
			}
        	chasBOList.add(chasBO);

        }
        pagination.addResult(chasBOList);

		return pagination;

	}

	@Override
	public Pagination<BankBaseBO> getBankByPara(BankBaseBO bankBaseBO) {
		CmpayBankBaseExample cmpayBankBaseExample=new CmpayBankBaseExample();
		if(StringUtils.isNotBlank(bankBaseBO.getCode())){
			cmpayBankBaseExample.createCriteria().andCodeEqualTo(bankBaseBO.getCode());
		}
		if(StringUtils.isNotBlank(bankBaseBO.getName())){
			cmpayBankBaseExample.createCriteria().andNameEqualTo(bankBaseBO.getName());
		}
        int count=cmpayBankBaseMapper.countByExample(cmpayBankBaseExample);

        Pagination pagination = new Pagination(count, bankBaseBO.getPageCurrent(),bankBaseBO.getPageSize());
        PageHelper.startPage(bankBaseBO.getPageCurrent(), bankBaseBO.getPageSize());
        List<CmpayBankBase> banks=cmpayBankBaseMapper.selectByExample(cmpayBankBaseExample);
        List<BankBaseBO> bankBOList=new ArrayList<BankBaseBO>();
        for(CmpayBankBase cmpayBankBase:banks){
        	BankBaseBO bankBO=new BankBaseBO();
        	try {
        		BeanUtils.copyProperties(bankBO, cmpayBankBase);
			} catch (Exception e) {
				logger.error("cope cmpayBankBase异常！！！！！！");
				e.printStackTrace();
			}
        	bankBOList.add(bankBO);

        }
        pagination.addResult(bankBOList);

		return pagination;

	}

	@Override
	public Map addNewChannelConfig(ChannelConfigBO channelConfigBO) {
		Map resultMap = new HashMap();
		try{
			CmpayChannelConfig cmpayChannelConfig=new CmpayChannelConfig();
			BeanUtils.copyProperties(cmpayChannelConfig, channelConfigBO);
			cmpayChannelConfig.setId(UUIDGenerator.getUUID());
			cmpayChannelConfig.setCreateTime(new Date());
			cmpayChannelConfig.setVersion(0);
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpayChannelConfig.setCreator(loginName);
	        logger.info("新增银行渠道信息参数："+cmpayChannelConfig.toString());

	        int r=cmpayChannelConfigMapper.insert(cmpayChannelConfig);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

		}catch(Exception e){
			logger.error("新增支付渠道配置信息出现异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Pagination<ChannelConfigBO> getAllChannelConfig(ChannelConfigBO channelConfigBO) {
		CmpayChannelConfigExample cmpayChannelConfigExample=new CmpayChannelConfigExample();
		int count=cmpayChannelConfigMapper.countByExample(cmpayChannelConfigExample);
        Pagination pagination = new Pagination(count, channelConfigBO.getPageCurrent(),channelConfigBO.getPageSize());
        PageHelper.startPage(channelConfigBO.getPageCurrent(), channelConfigBO.getPageSize());

        List<CmpayChannelConfig> channelconfigs=cmpayChannelConfigMapper.selectByExample(cmpayChannelConfigExample);
        List<ChannelConfigBO> channelconfigBOList=new ArrayList<ChannelConfigBO>();
        for(CmpayChannelConfig Channelconfig:channelconfigs){
        	ChannelConfigBO channelCfg=new ChannelConfigBO();
        	try {
				BeanUtils.copyProperties(channelCfg, Channelconfig);
			} catch (Exception e) {
				logger.error("cope cmpayChannelBase异常！！！！！！");
				e.printStackTrace();
			}
        	channelconfigBOList.add(channelCfg);

        }
        pagination.addResult(channelconfigBOList);

		return pagination;
	}

	@Override
	public Pagination<ChannelConfigBO> getChannelConfigByPara(ChannelConfigBO channelConfigBO) {
		CmpayChannelConfigExample cmpayChannelConfigExample=new CmpayChannelConfigExample();

		if(StringUtils.isNotBlank(channelConfigBO.getMerNo())){
			cmpayChannelConfigExample.createCriteria().andMerNoEqualTo(channelConfigBO.getMerNo());
		}
		if(StringUtils.isNotBlank(channelConfigBO.getPaychannelNo())){
			cmpayChannelConfigExample.createCriteria().andPaychannelNoEqualTo(channelConfigBO.getPaychannelNo());
		}
		if(StringUtils.isNotBlank(channelConfigBO.getPaychannelName())){
			cmpayChannelConfigExample.createCriteria().andPaychannelNameEqualTo(channelConfigBO.getPaychannelName());
		}
		int count=cmpayChannelConfigMapper.countByExample(cmpayChannelConfigExample);

        Pagination pagination = new Pagination(count, channelConfigBO.getPageCurrent(),channelConfigBO.getPageSize());
        PageHelper.startPage(channelConfigBO.getPageCurrent(), channelConfigBO.getPageSize());

        List<CmpayChannelConfig> channelconfigs=cmpayChannelConfigMapper.selectByExample(cmpayChannelConfigExample);
        List<ChannelConfigBO> channelconfigBOList=new ArrayList<ChannelConfigBO>();
        for(CmpayChannelConfig Channelconfig:channelconfigs){
        	ChannelConfigBO channelCfg=new ChannelConfigBO();
        	try {
				BeanUtils.copyProperties(channelCfg, Channelconfig);
			} catch (Exception e) {
				logger.error("cope cmpayChannelBase异常！！！！！！");
				e.printStackTrace();
			}
        	channelconfigBOList.add(channelCfg);

        }
        pagination.addResult(channelconfigBOList);

		return pagination;
	}

	@Override
	public ChannelConfigBO getChannelConfigById(String id) {
		CmpayChannelConfig cmpayChannelConfig=cmpayChannelConfigMapper.selectByPrimaryKey(id);
		ChannelConfigBO channelConfigBO=new ChannelConfigBO();
		try {
			BeanUtils.copyProperties(channelConfigBO, cmpayChannelConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return channelConfigBO;
	}

	@Override
	public Map updateChannelConfigInfo(ChannelConfigBO channelConfigBO) {
		 Map resultMap = new HashMap();
			try{
				CmpayChannelConfig cmpayChannelConfig=new CmpayChannelConfig();
				BeanUtils.copyProperties(cmpayChannelConfig, channelConfigBO);
				 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
			                .getPrincipal();
			        String loginName=shiroUser.getLoginName();
			        cmpayChannelConfig.setModifier(loginName);
			        cmpayChannelConfig.setModifyTime(new Date());
			        logger.info("更新支持银行信息参数为："+cmpayChannelConfig.toString());
			        int r=cmpayChannelConfigMapper.updateByPrimaryKeySelective(cmpayChannelConfig);
			        if (r != 0) {
			            resultMap.put("statusCode", 200);
			            resultMap.put("message", "操作成功!");
			            resultMap.put("closeCurrent", true);
			        } else {
			            resultMap.put("statusCode", 300);
			            resultMap.put("message", "操作失败!");
			            resultMap.put("closeCurrent", false);
			        }

			}catch(Exception e){
				logger.error("更新支持银行信息异常！！！");
				e.printStackTrace();
			}
			return resultMap;
	}


}
