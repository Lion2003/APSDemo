package com.yiaosi.aps.constant;

/**
 * Created by Administrator on 2017-11-16.
 */

public class Constant {
    public static String url = "http://192.168.11.22:8080";

    public static String checkUser = url + "/user/checkUser";  //验证用户名是否重复
    public static String register = url + "/register";  //注册
    public static String login = url + "/login";
    public static String user = url + "/user/";
    public static String companyMember = url + "/user/list?pn=";

    public static String QRCode = url + "/app/index.html?companyUuid=";  //生成二维码的URL  http://192.168.11.22:8080/app/index.html?companyUuid=;



}
