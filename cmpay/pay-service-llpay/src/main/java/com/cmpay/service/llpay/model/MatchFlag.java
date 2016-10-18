package com.cmpay.service.llpay.model;

//import net.engining.pg.support.meta.EnumInfo;
//
//
//@EnumInfo({
//	"Y|已勾兑",
//	"N|未勾兑",
//	"W|延后勾兑",
//	"S|待补账",
//	"D|订单号重复",
//	"E|订单号为空",
//	"A|金额不一致"
//})
public enum MatchFlag {
	/**
	 * 已勾兑
	 */
	Y,
	
	/**
	 * 未勾兑
	 */
	N,
	
	/**
	 * 延后勾兑
	 */
	W,
	
	/**
	 * 待补账
	 */
	S,
	
	/**
	 * 订单号重复
	 */
	D,
	
	/**
	 * 订单号为空
	 */
	E,
	
	/**
	 * 金额不一致
	 */
	A
}
