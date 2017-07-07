package com.inspur.qinporting;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;


import com.inspur.cyberinterface.CyberJSPlayer;
import com.inspur.jsf.JsonUtils;
import com.inspur.qin.QinPlayer;
import com.xin.util.XLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicBoolean;

public class QINPlayer implements CyberJSPlayer {
	
	public  final static int LAST_FRAME_STATIC_MODE    =   1; 
	public  final static int LAST_FRAME_BLACK_MODE     =   2; 
	public  final static int LAST_FRAME_AUTO_MODE      =   3;
	
	private static String TAG = XLog.TAG;
	private static Handler uiHandler;
	
	private Context mContext;
	private String playerType = "dvbc";
	private AtomicBoolean isCreated = new AtomicBoolean(false);
	private int mHandlerId;
	/**
	 * Instantiate the interface and set the context
	 */
	public static void setHandler(Handler _uiHandler) {
		uiHandler = _uiHandler;
	}
	
	public QINPlayer(Context c) {
		mContext = c;
	}
	
	public int getPlayerHandle() {
		/*if (mHandlerId < 0) {  // player handle 灏忎簬0锛屽繀闇�鍒涘缓鏂版挱鏀惧櫒
			XLog.i("[QINPlayer.getPlayerHandle] player handle < 0 , try create player!");
			isCreated.set(false);
			mHandlerId = create(null);
		}*/
		
		XLog.i("[QINPlayer.getPlayerHandle] player handle:" + mHandlerId);
		
		if (mHandlerId < 0) {
			XLog.w("[QINPlayer.getPlayerHandle] player handle < 0 !!!!!");
		}
		
		return mHandlerId;
	}
	
	// FIXME
	public void keepLastFrame(int handleId){
		JSONObject obj=new JSONObject();
		try {
			obj.put("lastFrame", "static");
		} catch (JSONException e) {
			XLog.e("keepLastFrame", e);
		}
		String json=obj.toString();
		XLog.i("keepLastFrame,handle="+handleId+",json="+json);
		QinPlayer.set(handleId, obj.toString());
	}
	
	public void clearLastFrame(int handleId){
		JSONObject obj=new JSONObject();
		try {
			obj.put("clearLastFrame", "");
			obj.put("lastFrame", "black");
		} catch (JSONException e) {
			XLog.e("clearLastFrame", e);
		}
		String json=obj.toString();
		XLog.i("clearLastFrame,handle="+handleId+",json="+json);
		QinPlayer.set(handleId, obj.toString());
	}
	
	public String getSingleParameter(int handleId, String key){
		JSONArray array=new JSONArray();
		array.put(key);
		String json=array.toString();
		String result=QinPlayer.get(handleId, json);
		String value= JsonUtils.getStringFromJson(result, key);
		XLog.i("getSingleParameter "+key+"="+value);
		return value;
	}
	
	public String getCreateJson(){
		XLog.e("QINPlayer,use default create-json");
		JSONObject json=new JSONObject();
		try {
			json.put("wx", 0);
			json.put("wy", 0);
			json.put("wz", 0);
			DisplayMetrics dm = new DisplayMetrics();
			WindowManager wm=(WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
			wm.getDefaultDisplay().getMetrics(dm);
			
			XLog.i("[QINPlayer.getCreateJson] widthPixels:" + dm.widthPixels + ", heightPixels:" + dm.heightPixels);
			
			json.put("ww", 1920);
			json.put("wh", 1080);

			json.put("audioEnable", 1);
		} catch (JSONException e) {
			XLog.e("getCreateJson", e);
		}
		return json.toString();
	}
	
	@JavascriptInterface
	public int create(String jsonParam) {
		XLog.i("[QINPlayer.create] <... jsonParam:" + jsonParam);
		
		if(isCreated.compareAndSet(false, true)){
			if(jsonParam == null){
				jsonParam = getCreateJson();
				XLog.i("[QINPlayer.create] local  param:" + jsonParam);
			} else {
				XLog.i("[QINPlayer.create] js formal param:" + jsonParam);
			}
		}else{
			XLog.i("[QINPlayer.create] player already created, return handle directly mHandlerId=" + mHandlerId + ", param=" + jsonParam);
			return mHandlerId;
		}
		
		mHandlerId = QinPlayer.create(jsonParam);
		XLog.i("[QINPlayer.create] player handle:" + mHandlerId);
		
		return mHandlerId;
	}

	@JavascriptInterface
	public int destroy(int handle) {
		XLog.i("[QINPlayer.destroy] <... param player handle:" + handle);
		
		int result = -1;
		
		if (handle > 0) {
			result =  QinPlayer.destroy(handle);
		}
		
		isCreated.set(false);
		mHandlerId = -1;
		
		return result;
	}
	
	/**
	 * 瑙嗗崥浜戣姹傜殑浼犲叆鍙傛暟鏄繖鏍风殑锛屼絾鎴戜滑鐨勬帴鍙ｄ笉鏄繖鏍风殑锛屾殏缂�
	 * 瑙嗛鐐规挱淇℃伅
	 * 瑙嗛鎾斁
	 */
	@JavascriptInterface
	public int start(int handle, String parameter) {
		XLog.i("[QINPlayer.start] <... handle:" + handle + ", parameter:" + parameter);

		Message msg = uiHandler.obtainMessage();
		msg.what = 2;
		msg.sendToTarget();

		int result = 0;
		boolean is4K = false;
		
		if (is4K) {
			try {
				JSONObject object = new JSONObject(parameter);
				String type = object.getString("type");
				if (playerType.equals(type)) {
					JSONArray array = object.getJSONArray("url");
					for (int a = 0; a < array.length(); a++) {
						JSONObject obj = (JSONObject) array.get(a);
						obj.put("frequency", obj.optInt("frequency"));
						obj.put("symbolRate", obj.optInt("symbolRate"));
						obj.put("serviceId", obj.optInt("serviceId"));
						obj.put("tsId", obj.optInt("tsId"));
						obj.put("audioPID", obj.optInt("audioPID"));
						obj.put("videoPID", obj.optInt("videoPID"));
						obj.put("videoDecodeType", obj.optInt("videoDecodeType"));
						obj.put("audioDecodeType", obj.optInt("audioDecodeType"));
						obj.put("pcrPID", obj.optInt("pcrPID"));
						obj.put("programType", obj.optInt("programType"));
					}
					result = QinPlayer.start(handle, object.toString());
					Log.d(TAG, "[QINPlayer.start] is4K 1 result:" + result);
				} else {
					result = QinPlayer.start(handle, parameter);
					Log.d(TAG, "[QINPlayer.start] is4K 2 result:" + result);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = QinPlayer.start(handle, parameter);
			Log.d(TAG, "[QINPlayer.start] result:" + result);
		}

		return result;
	}
	
	public boolean setLastFrameMode(int playerHandle, int type) {
		boolean result = false;
		JSONObject objParam = new JSONObject();
		
		try {
			switch (type) {
			case LAST_FRAME_STATIC_MODE:
				objParam.put("lastFrame", "static");
				break;
			case LAST_FRAME_BLACK_MODE:
				objParam.put("lastFrame", "black");
				break;
			case LAST_FRAME_AUTO_MODE:
				objParam.put("lastFrame", "auto");
				break;
			default:
				objParam.put("lastFrame", "static");
				break;
			}
			
			// 0 success / other failed
			result = (0 == set(playerHandle, objParam.toString()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@JavascriptInterface
	public int stop(int handle) {
		XLog.i("[QINPlayer.stop] <... handle:" + handle);
		return QinPlayer.stop(handle);
	}

	@JavascriptInterface
	public int pause(int handle) {
		XLog.i("[QINPlayer.pause] <... handle:" + handle);
		return QinPlayer.pause(handle);
	}

	@JavascriptInterface
	public int resume(int handle) {
		XLog.i("[QINPlayer.resume] <... handle:" + handle);
		return QinPlayer.resume(handle);
	}

	@JavascriptInterface
	public int forward(int handle, int scale) {
		XLog.i("[QINPlayer.forward] <... handle:" + handle + ", scale:" + scale);
		return QinPlayer.forward(handle, scale);
	}

	@JavascriptInterface
	public int backward(int handle, int scale) {
		XLog.i("[QINPlayer.backward] <... handle:" + handle + ", scale:" + scale);
		return QinPlayer.backward(handle, scale);
	}

	@JavascriptInterface
	public int seek(int handle, int seconds) {
		XLog.i("[QINPlayer.seek] <... handle:" + handle + ", seconds:" + seconds);
		return QinPlayer.seek(handle, seconds);
	}

	@JavascriptInterface
	public int mute(int handle) {
		XLog.i("[QINPlayer.mute] <... handle:" + handle);
		return QinPlayer.mute(handle);
	}

	@JavascriptInterface
	public int unmute(int handle) {
		XLog.i("[QINPlayer.unmute] <... handle:" + handle);
		return QinPlayer.unmute(handle);
	}

	@JavascriptInterface
	public int enableSubtitle(int handle) {
		XLog.i("[QINPlayer.enableSubtitle] <... handle:" + handle);
		return QinPlayer.enableSubtitle(handle);
	}

	@JavascriptInterface
	public int disableSubtitle(int handle) {
		XLog.i("[QINPlayer.disableSubtitle] <... handle:" + handle);
		return QinPlayer.disableSubtitle(handle);
	}

	@JavascriptInterface
	public int getSubtitleStatus(int handle) {
		XLog.i("[QINPlayer.getSubtitleStatus] <... handle:" + handle);
		return QinPlayer.getSubtitleStatus(handle);
	}

	@JavascriptInterface
	public int set(int handle, String parmeter) {
		XLog.i("[QINPlayer.set] <... handle:" + handle + ", parmeter:" + parmeter);
		return QinPlayer.set(handle, parmeter);
	}

	@JavascriptInterface
	public String get(int handle, String parameter) {
		XLog.i("[QINPlayer.get] <... handle:" + handle + ", parameter:" + parameter);
		return QinPlayer.get(handle, parameter);
	}
	
	

}
