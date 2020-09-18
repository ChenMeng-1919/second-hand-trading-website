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
    public static String app_id = "2016101700708519";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqwHLNspF3XMHb12/G923IEYSXUO2RcPlrMo5unTWRX74CwtCyBynRow+YWoRqX9FxRCPhc9xq41WSlhvyo1ylNwH2khYtfZCSy/ImdR1leBuR2LfQCVX5iU1WYcAiOBxB5FwmyoBTlpv/rr0s10tJOVJn0P8Q0LObp/jDnfTI4KK+zuFmKW8QLjokPZbLPodQHtzIY6sBTVFRYmAFuMFGYwdefZwYLOlR60Y/CP1FbHSgWdIFzh5mgOql6+UeyosgNXriloN9SuvQqX+6D0byvmbBt3gaJ9whINQYcZ6X+Gi1Az4u+iAf2jFJrWzn8pAAR0SnSoQFhQAMYUgdVsWPAgMBAAECggEAIX7PBnrY/kk73hxM2QMAjhaho+1ELRu0UcsBFcHRGEtnwrLkrYeqNG2ASaq3/wX81/M99qP7wRwHVVIM+XQCYIaB5BSUNShEjAdl4RVoRtdg0SNqK20paGH+wcs7HXtUT7i0OwfOVJde0rE8eudg5WRRPfxJjMrj8Mzqh7Ucp6rXILJy+HOxq5u02hV+A7SEN/lvyPXr4SQSgMF0Ql5JzucoY1pMjPSsmNpVbn1/hj6zl5TXlMrrSHjv2S05bJaAVvyqd+oLB87cOPglbyGSyQXWcpc/jwUgI873i14FdawGwnAuVosqpZxQKp4CrAU0jvUN0F9sFhs4fk8G3PulAQKBgQDbz+yJ4edz1Hp9TKpMgNGVVz74jQS0niCuldQpaJx14P6gfQQEjzRZqwoPVTZdHElqJ9N0nGcfQMsi85z8AZnbJ1exBRbPZGsgqIMxqB0IAKR0JKiw1nwq4PM3Lu59+kYz8t3+lMHkgWNT++nMWYTxpKozvs4QNb7NKS08k8ObXwKBgQDG3Nn8LZ+b+9+yNnkpnBj+d7n7cULUJ+oiPP13X7pmNwQJo3Pb5BFhqZvzq8un5FpxGJ2jyocD295lXUx4Ic+7prnBzxJc6+m/2Ya3ELENgpOqcNE+neb4SAB2ogibXXenU+3Lp7r/OkiNMhTs+zwQVgF9w2xu7CTaSNkjq+8z0QKBgQCTlIEqfeqo4RKwR6XbIW4Vh3M2628qWTR2IxBEEQFjP4GVfPoSmZc7UNO7QanzT8eWp1CYbV3rJNR+DfPrWqPS+RIuPs12xuQKFDmpQEbllZDUjbxYpljNbSS+exsSp9M0k64qe/PGGHz46Ryq37ubhcPkZAnz5jHJiwjdMBRXnwKBgCxmEqUi6ofA7Gi1kMehelMWGAfzeaA0aSnLxCtqzAsWLWiZfbySZu8PFyqIKKgLa8XkYQ24ofxSkoy/D9uicObMipyixs7IPSAASPuGVoFVrfJXzd/VEURNjwztkE5fx98r9eOKR03EjX44uENQtFBRY3PYtdTuFCxIJ3K3aGiBAoGBALS++i0/prRwk2YdmIggoXYSYTfm+AQmPQ1IcMeQAdxWkGAsAUSOag1HWkDVjq1jBylD6ER16SNZYwYyk4wDTUnV/idnc4DkXXpCSE6dzGP8o/0wWMmuDUKIsR/IJKBOZ7+mQGzSYmasJmAjxe3jb415DKwg0cfoZv45jCJ/PTVP";

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
    public static String return_url = "http://458bwe.natappfree.cc/checkout/returnUrl";

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

