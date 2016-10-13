package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.IpBO;
import com.cmpay.boss.entity.CMPAYIPBINDING;
import com.cmpay.boss.enums.InchannelEnum;
import com.cmpay.boss.mapper.CMPAYIPBINDINGMapper;
import com.cmpay.boss.service.ConfigService;
import com.cmpay.boss.service.MonitorRealm;
import com.cmpay.boss.util.DateUtil;
import com.cmpay.boss.util.Pagination;
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
    CMPAYIPBINDINGMapper    cMPAYIPBINDINGMapper;


	@Override
	public Pagination<IpBO> getAllIp(IpBO ipBO) {

		int count =cMPAYIPBINDINGMapper.getIpCounts();
        Pagination pagination = new Pagination(count, ipBO.getPageCurrent(),ipBO.getPageSize());
        PageHelper.startPage(ipBO.getPageCurrent(), ipBO.getPageSize());

        List<CMPAYIPBINDING> ips=cMPAYIPBINDINGMapper.getAllIp();
        List<IpBO> ipBOList = new ArrayList<>();
        for(CMPAYIPBINDING ipbinding:ips ){
        	IpBO ip=new IpBO();
            ip.setIp(ipbinding.getIp());
            ip.setInchannel(InchannelEnum.getInchannelByCode(ipbinding.getInchannel()).getName());
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
	public Map addNewIp(String ip, String inchannel, String remark) {
        Map resultMap = new HashMap();
        CMPAYIPBINDING _CMPAYIPBINDING=new CMPAYIPBINDING();
        _CMPAYIPBINDING.setIp(ip);
        _CMPAYIPBINDING.setInchannel(inchannel);
        _CMPAYIPBINDING.setStatus("OFF");
        _CMPAYIPBINDING.setRemark(remark);
        _CMPAYIPBINDING.setCreatetime(DateUtil.getCurrTime());

        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
                .getPrincipal();
        String loginName=shiroUser.getLoginName();
        _CMPAYIPBINDING.setOperator(loginName);
        logger.info("新增IP配置执行人[{}],参数[ip={},inchannel={},remark={}]",loginName,ip,inchannel,remark);

        int r=cMPAYIPBINDINGMapper.insert(_CMPAYIPBINDING);

        if (r != 0) {
            resultMap.put("statusCode", 200);
            resultMap.put("message", "操作成功!");
            resultMap.put("closeCurrent", true);
        } else {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");
            resultMap.put("closeCurrent", false);
        }

		return resultMap;
	}


	@Override
	public IpBO getById(String ip) {
		CMPAYIPBINDING _CMPAYIPBINDING=cMPAYIPBINDINGMapper.selectByPrimaryKey(ip);
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

	        int r=cMPAYIPBINDINGMapper.updateByPrimaryKeySelective(_CMPAYIPBINDING);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

			return resultMap;

	}


	@Override
	public Pagination<IpBO> getIpByPara(IpBO ipBO) {
		int count =cMPAYIPBINDINGMapper.getIpCounts();
        Pagination pagination = new Pagination(count, ipBO.getPageCurrent(),ipBO.getPageSize());
        PageHelper.startPage(ipBO.getPageCurrent(), ipBO.getPageSize());

        List<CMPAYIPBINDING> ips=cMPAYIPBINDINGMapper.getIpByPara(ipBO);
        List<IpBO> ipBOList = new ArrayList<>();
        for(CMPAYIPBINDING ipbinding:ips ){
        	IpBO ip=new IpBO();
            ip.setIp(ipbinding.getIp());
            ip.setInchannel(InchannelEnum.getInchannelByCode(ipbinding.getInchannel()).getName());
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




}
