package com.cmpay.web.cashier.gateway.service.impl;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cmpay.web.cashier.gateway.service.QRCodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月17日 下午2:39:19
 *
 */
@Service
public class QRCodeServiceImpl implements QRCodeService {

	private Logger logger=Logger.getLogger(QRCodeServiceImpl.class);


	@Override
	public BufferedImage createQRCode(String url) {

		BufferedImage image = null;
		try{
	        OutputStream out = null;
	        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
	        Map<EncodeHintType,String> hints = new HashMap<EncodeHintType,String>();
	     // 设置编码方式
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

	     // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
	        /*hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);*/
	        BitMatrix bitMatrix = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, 400, 400,hints);
	        bitMatrix = updateBit(bitMatrix,10);
	        image = MatrixToImageWriter.toBufferedImage(bitMatrix);


		}catch(Exception e){
			logger.error("生成二维码出现异常！！！");
			e.printStackTrace();
		}

		return image;
	}


	 /**
     * 自定义白边边框宽度
     *
     * @param matrix
     * @param margin
     * @return
     */
    private static BitMatrix updateBit(final BitMatrix matrix, final int margin) {
        int tempM = margin * 2;
        //获取二维码图案的属性
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + tempM;
        int resHeight = rec[3] + tempM;
        // 按照自定义边框生成新的BitMatrix
        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        //循环，将二维码图案绘制到新的bitMatrix中
        for (int i = margin; i < resWidth - margin; i++) {
            for (int j = margin; j < resHeight - margin; j++) {
                if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
                    resMatrix.set(i, j);
                }
            }
        }
        return resMatrix;
    }

}

