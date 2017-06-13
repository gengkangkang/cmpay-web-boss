//package com.cmpay.boss.enums;
//
//import org.apache.commons.lang3.StringUtils;
//
///**
// * @author gengkangkang
// * @E-mail gengkangkang@cm-inv.com
// *
// * 2016年10月11日 下午5:18:56
// *
// */
//public enum InchannelEnum {
//
//	INCHANNEL_0000("0000","中民i投"),
//	INCHANNEL_0001("0001","核心柜面"),
//	INCHANNEL_0002("0002","O2O"),
//	INCHANNEL_0003("0003","云石"),
//	INCHANNEL_0004("0004","基金"),
//	INCHANNEL_0005("0005","保险客服"),
//	INCHANNEL_0006("0006","保险电销"),
//	INCHANNEL_0007("0007","大数据"),
//	INCHANNEL_0008("0008","OA"),
//	INCHANNEL_0009("0009","昱胜"),
//	INCHANNEL_0010("0010","三方支付"),
//	INCHANNEL_0012("0012","UMP"),
//
//
//
//	INCHANNEL_C9999("C9999","未知渠道");
//
//
//
//	private String code;
//	private String name;
//	private InchannelEnum(String code, String name) {
//		this.code = code;
//		this.name = name;
//	}
//
//	public static InchannelEnum getInchannelByCode(String code){
//		if(StringUtils.isBlank(code)){
//			return InchannelEnum.INCHANNEL_C9999;
//		}
//		code=code.trim();
//		for(InchannelEnum inchannelEnum:InchannelEnum.values()){
//			if(inchannelEnum.getCode().equalsIgnoreCase(code)){
//				return inchannelEnum;
//			}
//		}
//		return InchannelEnum.INCHANNEL_C9999;
//	}
//
//	public String getCode() {
//		return code;
//	}
//	public void setCode(String code) {
//		this.code = code;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//}
