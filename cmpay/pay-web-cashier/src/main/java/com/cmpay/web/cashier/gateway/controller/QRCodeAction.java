package com.cmpay.web.cashier.gateway.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmpay.web.cashier.gateway.service.QRCodeService;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月17日 下午2:49:57
 *
 */
@Controller
@RequestMapping("/qrcode")
public class QRCodeAction {

	private Logger logger=Logger.getLogger(QRCodeAction.class);

	 @Autowired
	 private QRCodeService qRCodeService;

	 /**
	  * 测试地址 http://127.0.0.1:8888/pay-web-cashier/qrcode/getQRCode.do
	  * @param model
	  * @param request
	  * @param response
	  */
	   @RequestMapping("/getQRCode")
	    public void getQRCode(ModelMap model,HttpServletRequest request,
	                          HttpServletResponse response){
	        String shopURL = "二维码生成测试";
	        //二维码图片输出流
	        OutputStream out = null;
	        try{
	            response.setContentType("image/jpeg;charset=UTF-8");
	            BufferedImage image = qRCodeService.createQRCode(shopURL);
	            //实例化输出流对象
	            out = response.getOutputStream();
	            //画图
	            ImageIO.write(image, "png", response.getOutputStream());
	            out.flush();
	            out.close();
	        }catch (Exception e){
	            logger.error("生成二维码出现异常"+e.getMessage());
	            e.printStackTrace();
	        }finally {
	            try{
	                if (null != response.getOutputStream()) {
	                    response.getOutputStream().close();
	                }
	                if (null != out) {
	                    out.close();
	                }
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	        }

	    }


}
