package com.cmpay.web.cashier.gateway.service;

import java.awt.image.BufferedImage;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月17日 下午2:37:26
 *
 */
public interface QRCodeService {
	public BufferedImage createQRCode(String url);
}
