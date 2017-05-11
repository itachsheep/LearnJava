package view;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tao.asjava.R;

public class CaTipsDialog extends Dialog {

	protected Handler mHandler = new Handler();
	private TextView mMsgView;
	private final int mBookDialogLongTimeout =3*1000;
	@SuppressWarnings("unused")
	private Context context;
	
	private final Runnable mDismissDialogRunnable = new Runnable() {
		public void run() {
			Log.i("CaTipsDialog","mDismissDialogRunnable showing: "+
					CaTipsDialog.this.isShowing());

			if (CaTipsDialog.this.isShowing()) {
				Log.i("CaTipsDialog","mDismissDialogRunnable dismiss..");
				//CaTipsDialog.this.dismiss();
				CaTipsDialog.this.dismiss();
			}
		};
	};
	
	public CaTipsDialog(Context context) {
		super(context, R.style.dialog_theme2);
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Window window = getWindow();
		window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		window.requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_ca_warning);
		mMsgView = (TextView) findViewById(R.id.dialog_ca_tip_txt);
		setCanceledOnTouchOutside(true);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("CaTipsDialog"," onStart..");
	}

	@Override
	protected void onStop() {
		super.onStop();
		removeAllBookDialogCallbacks();
		Log.i("CaTipsDialog"," onStop..");

	}

	public void show(int content, Boolean hide){
		super.show();
		Log.i("CaTipsDialog"," show..");
		mMsgView.setText(content);
		if (hide){
			Log.i("CaTipsDialog","show..1 ");
			resetBookDialogLongTimeout();
//			SystemProperty.set("sys.prevent.keyevent.power","false");
		}
		else{
			Log.i("CaTipsDialog","show..2 ");
			//SystemPropertiesProxy.set(context,"inspur.prevent.keyevent","true");
//			SystemProperty.set("sys.prevent.keyevent.power","true");
			mHandler.removeCallbacks(mDismissDialogRunnable);
		}

	}
	
	public void resetBookDialogLongTimeout() {
		Log.i("CaTipsDialog","resetBookDialogLongTimeout ...");
		dismissBookDialog(mBookDialogLongTimeout);
	}

	private void dismissBookDialog(int timeout) {
		Log.i("CaTipsDialog","dismissBookDialog ...");
		removeAllBookDialogCallbacks();
		mHandler.postDelayed(mDismissDialogRunnable, timeout);
	}
	
	private void removeAllBookDialogCallbacks() {
		Log.i("CaTipsDialog","removeAllBookDialogCallbacks ...");
		mHandler.removeCallbacks(mDismissDialogRunnable);
	}
	
}
