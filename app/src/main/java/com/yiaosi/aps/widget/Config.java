package com.yiaosi.aps.widget;

import java.io.File;

import android.os.Environment;

/**
 * @Description: App所需的配置在此类定义实现sadfsdf
 * @author liaoxy
 * @date 2015-10-16 下午5:44:07
 * 
 */
public class Config {

	/**
	 * sdcard
	 */
	public static final String SDCARD_FOLDER = Environment.getExternalStorageDirectory().toString();

	/**
	 * 根目录
	 */
	public static final String ROOT_FOLDER = SDCARD_FOLDER + "/eshangle/";

	/**
	 * 缓存目录
	 */
	public static final String CACHE_FOLDER = ROOT_FOLDER + "cache/";

	/**
	 * 网页缓存目录
	 */
	public static final String WEB_CACHE_FOLDER = ROOT_FOLDER + "webCache/";

	/**
	 * 数据库缓存目录
	 */
	public static final String DB_CACHE_FOLDER = ROOT_FOLDER + "dbCache/";

	/**
	 * 相片目录
	 */
	public static final String PHOTO_FOLDER = ROOT_FOLDER + "photo/";

	/**
	 * 日志目录
	 */
	public static final String LOG_FOLDER = ROOT_FOLDER + "log/";

	/**
	 * 用户目录
	 */
	public static final String USER_FOLDER = ROOT_FOLDER + "user/";

	/**
	 * 城市的数据库地址
	 */
	public static final String ADDRESS_DB_CACHE_FILE = ROOT_FOLDER + "dbCache/address.db";
	
//	public static final String BI = "http://10.10.0.187:8080/esl-web/statics/h5report";
//	public static final String BI = "http://10.10.0.205:48080/statics/h5report";
//	public static final String BI = "http://10.10.0.187:8080/esl-web/";
//	public static final String BI = "http://10.10.0.205:48080/statics/h5report";
//	public static final String BI = "http://58.47.159.172:5050/statics/h5report";
//	public static final String BI = "http://erp02.zgps168.com/statics/h5report";
	
	/**
	 * 扫描二维码新建加盟信息
	 */

	// 腾讯云
	public static final String HTTP_URL = "http://erp02.zgps168.com/gateway.json";// http请求地址头
	public static final String GOODS_DETAIL_URL = "http://erp02.zgps168.com/statics/h5report/goods_detail.html?pkId=%s&goFrom=%s&userId=%s";
	public static final String LEAGUE_ENCONDING = "http://erp02.zgps168.com/dl-esl.html?";
	public static final String BI = "http://erp02.zgps168.com/statics/h5report";
	
	//http://erp02.zgps168.com/statics/h5report/bi_01_jygk.html?type=1&fkOrgId=1500023&token=2eba8b3f-c08a-419b-9c63-0ed8363499c0
	//http://erp02.zgps168.com/statics/h5reportstatics/h5report/bi_01_jygk.html?type=1&fkOrgId=1500023&token=2eba8b3f-c08a-419b-9c63-0ed8363499c0
	
	//外网
//	public static final String HTTP_URL = "http://58.47.159.172:5050/gateway.json";// http请求地址头
//	public static final String GOODS_DETAIL_URL = "http://www.zgps168.com/data/esl_new/goods_detail.html?pkId=%s&goFrom=%s&userId=%s";
//	public static final String LEAGUE_ENCONDING = "http://7xjas6.com2.z0.glb.qiniucdn.com/@/static/dl-esl.html?";
//	public static final String BI = "http://58.47.159.172:5050/statics/h5report";
	
	//205
//	public static final String HTTP_URL ="http://10.10.0.205:48080/gateway.json";//http请求地址头
//	public static final String GOODS_DETAIL_URL="http://10.10.0.205:48080/statics/h5report/goods_detail.html?pkId=%s&goFrom=%s&userId=%s";
//	public static final String LEAGUE_ENCONDING = "http://10.10.0.205:28080/download.html?";
//	public static final String BI = "http://10.10.0.205:48080/statics/h5report";

	
	//进洪
//	public static final String HTTP_URL ="http://10.10.0.70:8080/esl-web/gateway.json";//http请求地址头
	
	 // 内网测试接口+
//	 public static final String HTTP_URL ="http://10.10.0.234:8080/esl-web/gateway.json";//http请求地址头http://10.10.0.234:8080/esl-web/gateway
//	 public static final String HTTP_URL ="http://10.10.0.203/esl-web/gateway.json";//http请求地址头
//	 public static final String HTTP_URL ="http://10.10.0.205:48080/gateway.json";//http请求地址头
//	 public static final String HTTP_URL ="http://10.10.0.187:8080/esl-web/gateway.json";
//	 public static final String HTTP_URL ="http://10.10.0.203/esl-web/gateway.json";//http请求地址头
//	 public static final String HTTP_URL ="http://10.10.0.205:48080/gateway.json";//http请求地址头
//	 public static final String HTTP_URL ="http://10.10.0.253:8080/esl-web/gateway.json";//http请求地址头 文掌
//	 public static final String HTTP_URL ="http://10.10.0.70:8080/esl-web/gateway.json";//http请求地址头 进洪
//	 public static final String HTTP_URL ="http://10.10.0.225:8080/esl-web/gateway.json";//http请求地址头
//	 public static final String HTTP_URL ="http://10.10.0.188:8080/esl-web/gateway.json";//http请求地址头 钟武
//	 public static final String HTTP_URL ="http://10.10.0.210:8080/esl-web/gateway.json";//http请求地址头 刘德
//	 public static final String HTTP_URL ="http://10.10.0.49:8080/esl-web/gateway.json";//http请求地址头 卢玉婷
//	 public static final String HTTP_URL ="http://10.10.0.219:8080/esl-web/gateway.json";//http请求地址头 小龙
//   public static final String HTTP_URL ="http://10.10.0.132:8080/esl-web/gateway.json";//http请求地址头
//	 public static final String HTTP_URL ="http://10.10.0.186:8080/esl-web/gateway.json";//http请求地址头 欧阳
//	 public static final String GOODS_DETAIL_URL="http://10.10.0.205:48080/statics/h5report/goods_detail.html?pkId=%s&goFrom=%s&userId=%s";
//	 public static final String LEAGUE_ENCONDING = "http://10.10.0.205:28080/download.html?";

	// *************************************************************************
	/**
	 * 【】(sd卡初始化)
	 */
	// *************************************************************************
	public static void initSdcard() {
		if (!SDCardUtil.hasSDCard())
			return;

		File logFile = new File(LOG_FOLDER);
		if (!logFile.exists())
			logFile.mkdirs();

		File cacheFile = new File(CACHE_FOLDER);
		if (!cacheFile.exists())
			cacheFile.mkdirs();

		File photoFile = new File(PHOTO_FOLDER);
		if (!photoFile.exists())
			photoFile.mkdirs();

		File dbFile = new File(DB_CACHE_FOLDER);
		if (!dbFile.exists())
			dbFile.mkdirs();

		File userFile = new File(USER_FOLDER);
		if (!userFile.exists())
			userFile.mkdirs();
	}

}