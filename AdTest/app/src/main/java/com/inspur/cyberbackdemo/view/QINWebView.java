package com.inspur.cyberbackdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inspur.qinporting.QINPlayer;
import com.xin.util.XLog;

public class QINWebView extends WebView {
	private static String TAG = XLog.TAG;
	private QINPlayer mPlayer;

	public QINWebView(Context context) {
		super(context);
		common(context);
	}

	public QINWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		common(context);
	}

	public QINWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		common(context);
	}

	public QINPlayer getPlayer() {
		return mPlayer;
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void common(Context context) {
		if (isInEditMode()) {
			return;
		}

		// Handling Page Navigation
		setWebViewClient(new QINWebViewClient());
		
		WebSettings websettings = getSettings();
		
		if (null != websettings) {
			XLog.d("[QINWebView.common] init WebSettings.");
			
			websettings.setCacheMode(WebSettings.LOAD_DEFAULT);

			websettings.setDomStorageEnabled(true);
			
			websettings.setAllowUniversalAccessFromFileURLs(true);
			
			websettings.setJavaScriptEnabled(true);
		}
		
		setWebChromeClient(new WebChromeClient() {
			@Override
			public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
				return super.onJsAlert(view, url, message, result);
			}

		});

		mPlayer = new QINPlayer(context);


		//addJavascriptInterface(new WebAppInterface(context), "android");

		/* 扩充JS接口 */
		/*Log.d(TAG, "========>addJavascriptInterface");

		addJavascriptInterface(new GOLIVE(context), "goto");
		addJavascriptInterface(mPlayer, "player");
		addJavascriptInterface(new QINEnv(context), "evt");*/

		/* start tiny */
		/*addJavascriptInterface(new QINBooking(), "booking");
		addJavascriptInterface(new QINCa(), "ca");
		addJavascriptInterface(new QINData(), "data");
		addJavascriptInterface(new QINEpg(), "epg");
		addJavascriptInterface(new QINOc(), "oc");
		addJavascriptInterface(new QINScan(), "scan");
		addJavascriptInterface(new QINSettings(), "settings");
		addJavascriptInterface(new QINTuner(), "tuner");
		addJavascriptInterface(new QINBrowser(context), "browser");*/
		/* end tiny */

		/* start NGB-H */

		Log.d(TAG, "addJavascriptInterface NGBJSCaManager");

		/* end NGB-H */

		setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);


		android.os.Process.setThreadPriority(
				android.os.Process.THREAD_PRIORITY_URGENT_DISPLAY
						+ android.os.Process.THREAD_PRIORITY_FOREGROUND
						+ android.os.Process.THREAD_PRIORITY_MORE_FAVORABLE);



		// FIXME 此处会造成JS页面不能隐藏DIV
		int color = getResources().getColor(android.R.color.transparent);
		setBackgroundColor(color); // 设置背景色


	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		Log.v(TAG, "[QINWebView.dispatchKeyEvent] " + event);
		int keyCode = event.getKeyCode();
		if(event.getAction() == KeyEvent.ACTION_DOWN){
			Log.v(TAG, "[QINWebView.dispatchKeyEvent] keyCode:" + keyCode);
			switch (keyCode){
				case KeyEvent.KEYCODE_PROG_RED:
				case KeyEvent.KEYCODE_PROG_GREEN:
				case KeyEvent.KEYCODE_PROG_YELLOW:
				case KeyEvent.KEYCODE_PROG_BLUE:
				case KeyEvent.KEYCODE_MENU: // 菜单
				case KeyEvent.KEYCODE_HOME:
				case KeyEvent.KEYCODE_CHANNEL_UP:
				case KeyEvent.KEYCODE_CHANNEL_DOWN:
					sendKey(event.getAction(), keyValueToBgctv(keyCode));
					return true;
				default:
					break;
			}
		}
		return super.dispatchKeyEvent(event);
	}

	private int keyValueToBgctv(final int androidKeyvalue) {
		int bgctvKeyValue = androidKeyvalue;

		switch (androidKeyvalue) {
		case KeyEvent.KEYCODE_PROG_RED:
			bgctvKeyValue = 180;
			break;
		case KeyEvent.KEYCODE_PROG_GREEN:
			bgctvKeyValue = 152;
			break;
		case KeyEvent.KEYCODE_PROG_YELLOW:
			bgctvKeyValue = 153;
			break;
		case KeyEvent.KEYCODE_PROG_BLUE:
			bgctvKeyValue = 154;
			break;
		case KeyEvent.KEYCODE_MENU: // 菜单
			bgctvKeyValue = 136;
			break;
		case KeyEvent.KEYCODE_HOME:
			bgctvKeyValue = 172;
			break;
		case KeyEvent.KEYCODE_CHANNEL_UP:
			bgctvKeyValue = 176;
			break;
		case KeyEvent.KEYCODE_CHANNEL_DOWN:
			bgctvKeyValue = 177;
			break;
		case KeyEvent.KEYCODE_VOLUME_UP:
			bgctvKeyValue = 175;
			break;
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			bgctvKeyValue = 174;
			break;
		case KeyEvent.KEYCODE_VOLUME_MUTE: // 静音
			bgctvKeyValue = 173;
			break;
		default:
			break;
		}



		return bgctvKeyValue;
	}

	private void sendKey(int eventType, int keyCode) {
		if (eventType == KeyEvent.ACTION_DOWN) {
			String str = "javascript:(function() {var evt = document.createEvent('Event');evt.initEvent('keydown',true,true);evt.keyCode = "
					+ keyCode + ";document.dispatchEvent(evt);})();";
			loadUrl(str);
		} else if (eventType == KeyEvent.ACTION_UP) {
			String str = "javascript:(function() {var evt = document.createEvent('Event');evt.initEvent('keyup',true,true);evt.keyCode = "
					+ keyCode + ";document.dispatchEvent(evt);})();";
			loadUrl(str);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.v(TAG, "[QINWebView.onKeyDown] keyCode:" + keyCode);
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * 
	 * JS通信部分
	 *
	 */
	private class QINWebViewClient extends WebViewClient {
		/**
		 * 在点击请求的是链接是才会调用，重写此方法返回true表明 点击网页里面的链接还是在当前的web view里跳转，不跳到浏览器那边。
		 */
		/*
		 * @Override public boolean shouldOverrideUrlLoading(WebView webView,
		 * String url) { webView.loadUrl(url); XLog.d(
		 * "[QINWebView.shouldOverrideUrlLoading] url:" + url); return true; }
		 */

		@Override
		public void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {

			Context ctx = getContext();


			XLog.e("[QINWebView.onReceivedError] when parsing url:" + failingUrl + ", error:" + errorCode + ", desc:"
					+ description);
			webView.reload();

		}

		@Override
		public void onPageStarted(WebView webView, String url, Bitmap favicon) {
			super.onPageStarted(webView, url, favicon);
			XLog.d("[QINWebView.onPageStarted] qinwebview load start, url:" + url);
		}

		@Override
		public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
			super.onUnhandledKeyEvent(view, event);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			XLog.d("[QINWebView.onPageFinished] qinwebview load finish, url:" + url);

		}

	}

}
