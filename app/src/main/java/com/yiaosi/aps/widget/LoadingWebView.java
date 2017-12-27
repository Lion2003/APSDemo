package com.yiaosi.aps.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.yiaosi.aps.R;

//*****************************************************************************
/**
 * Title:LoadingWebView Description:(带加载条的webview) Copyright: Copyright (c) 2015
 * Company: 中国品尚
 * 
 * @author 曹景浪 - cjl
 * @version v1.0 2015年3月12日
 */
// *****************************************************************************
public class LoadingWebView extends WebView {

	private ProgressBar mProgressBar;
	public ScrollInterface mScrollInterface;// 监听滚动的接口

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public LoadingWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initContext(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public LoadingWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initContext(context);
	}

	/**
	 * @param context
	 */
	public LoadingWebView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initContext(context);
	}

	/**
	 * @Title: initContext
	 * @Description: 初始化context
	 * @param context
	 * @return void
	 */
	@SuppressLint("NewApi")
	private void initContext(Context context) {
		requestFocus();
		setInitialScale(39);
		getSettings().setJavaScriptEnabled(true);
		getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		getSettings().setUseWideViewPort(true);
		getSettings().setLoadWithOverviewMode(true);
		getSettings().setDomStorageEnabled(true);
		getSettings().setDatabaseEnabled(true);
		// 只有17及以上才可以
		if (android.os.Build.VERSION.SDK_INT >= 17)
			getSettings().setMediaPlaybackRequiresUserGesture(false);
		String cacheDirPath = Config.CACHE_FOLDER;
		getSettings().setDatabasePath(cacheDirPath);
		getSettings().setAppCachePath(cacheDirPath);
		getSettings().setAppCacheEnabled(true);
		getSettings().setUserAgentString(getSettings().getUserAgentString() + "  Flygift/android");

	}

	/**
	 * @Title: loadMessageUrl
	 * @Description: 加载网页url
	 * @param url
	 * @return void
	 */
	public void loadMessageUrl(String url) {
		super.loadUrl(url);
		setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) { // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
				loadUrl(url);
				return true;
			}
		});
	}

	/**
	 * @Title: addProgressBar
	 * @Description: 添加进度条
	 * @return void
	 */
	public void addProgressBar() {
		mProgressBar = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
		mProgressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 2, 0, 0));
		mProgressBar.setProgressDrawable(getContext().getResources().getDrawable(R.drawable.com_webview_loading));
		addView(mProgressBar);

		setWebChromeClient(new WebChromeClient() {
			@Override
			public boolean onJsConfirm(WebView view, String url, String message, final android.webkit.JsResult result) {
				return true;
			}

			@Override
			public boolean onJsAlert(WebView view, String url, String message, final android.webkit.JsResult result) {
				return false;
			}

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				if (newProgress == 100) {
					mProgressBar.setVisibility(GONE);
				} else {
					if (mProgressBar.getVisibility() == GONE)
						mProgressBar.setVisibility(VISIBLE);
					mProgressBar.setProgress(newProgress);
				}
				super.onProgressChanged(view, newProgress);
			}
		});
	}

	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		super.computeScroll();
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		try {
			mScrollInterface.onSChanged(l, t, oldl, oldt);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void setOnCustomScroolChangeListener(ScrollInterface scrollInterface) {
		this.mScrollInterface = scrollInterface;
	}

	public interface ScrollInterface {
		public void onSChanged(int l, int t, int oldl, int oldt);
	}

	/**
	 * @Title: destroyWebView
	 * @Description: 回收webview
	 * @return void
	 */
	public void destroyWebView() {
		clearCache(true);
		clearHistory();
	}

}
