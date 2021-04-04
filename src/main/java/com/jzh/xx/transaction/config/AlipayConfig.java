package com.jzh.xx.transaction.config;

import org.springframework.context.annotation.Configuration;

/**
 * 支付宝沙箱支付配置类
 */

@Configuration
public class AlipayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id = "x";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "x";

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj9IWiMYOdtTrywQiq1EWT0f/oHDVlW2IIkgfIFsDZmBWyMOVj+LRAWQphmSAf0J59IaRmt/hai9XJpVJnijRS9SyMujlLc0IC+caTrMLy5BFq/biQmPVSs9qFiWS6YkRKbVvkTZY63MUlfaoyWi+uRplFKskJZs4Zv3iC9Bg3flClf265vRzVuKfEeyWgY+b3bgL4Fser9eSN+/ecUd2V4qM9gpBzPnfh/DsCm50kfiVMKe2H2OV0/8R48eV3kxLvCP3FYQXtfwej+fF5zEgDCUjjW2+Pm7vNmS4c6ht2NyhvZ1T27Ap3mlSuc0Y7dTJf2qy0Pm4Y3qjbUbtzR4ITQIDAQAB";

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    //public static String notify_url = "http://z2o7626444.qicp.vip/checkout/returnUrl";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "http://ppji7j.natappfree.cc/checkout/returnUrl";

    /**
     * 签名方式
     */
    public static String sign_type = "RSA2";

    /**
     * 字符编码格式
     */
    public static String charset = "utf-8";

    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}

