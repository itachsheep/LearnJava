package view;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import util.LogUtil;

public class AutoTextView extends TextView {

	public static final String TAG = "AutoTextView";

	/** 字幕滚动的速度 快，普通，慢 */
	public static final int SCROLL_SLOW = 0;
	public static final int SCROLL_NORM = 1;
	public static final int SCROLL_FAST = 2;

	/** 字幕内容 */
	private String mText;

	/** 字幕字体颜色 */
	private int mTextColor;

	/** 字幕字体大小 */
	private float mTextSize;

	private float offX = 0f;

	private float mStep = 2.0f;

	private Rect mRect = new Rect();
	private Rect mBackgroundRect;

	private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Paint mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


	private static final int REFRESH_TIME = 30;  // ms

	public AutoTextView(Context context) {
		super(context);
		setSingleLine(true);
		init();
	}

	public AutoTextView(Context context, AttributeSet attr) {
		super(context, attr);
		setSingleLine(true);
		init();
	}

	private void init() {
		mBackgroundPaint.setColor(0xff000011);
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		LogUtil.i("[AutoTexttView.onWindowFocusChanged] hasWindowFocus:" + hasWindowFocus + ", visibility:" + getVisibility());
		super.onWindowFocusChanged(hasWindowFocus);
	}

	@Override
	public void setVisibility(int visibility) {
		if (visibility == View.VISIBLE) {
			offX = 0;
		} else {
			removeCallbacks(refreshRunnable);
		}

		super.setVisibility(visibility);

		if (visibility == View.VISIBLE) {
			postDelayed(refreshRunnable, REFRESH_TIME);
		}
	}

	private Runnable refreshRunnable = new Runnable() {
		@Override
		public void run() {
			LogUtil.i("AutoTexttView set invalidate. currentThreadTimeMillis:" + SystemClock.currentThreadTimeMillis());
			invalidate();
			postDelayed(refreshRunnable, REFRESH_TIME);
		}
	};

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mText = getText().toString();
		mTextColor = getCurrentTextColor();
//		mTextColor = Color.WHITE;
		mTextSize = getTextSize();
		mPaint.setColor(mTextColor);
		mPaint.setTextSize(mTextSize);
		mPaint.getTextBounds(mText, 0, mText.length(), mRect);

	};

	@Override
	protected void onDraw(Canvas canvas) {
		float x, y;

		x = getMeasuredWidth() - offX;

		//y = (getMeasuredHeight() >> 1) + ((int)(mPaint.descent() - mPaint.ascent()) >> 1);
		//CLog.d("pd:" + mPaint.descent() + ", pa:" + mPaint.ascent() + ", y:" + y);
		//CLog.d("mh:" + getMeasuredHeight());

		y = ((getHeight() - mRect.height()) >> 1 ) + mRect.height() - 10;

		if (null == mBackgroundRect) {
			mBackgroundRect = new Rect(0, 0, getWidth(), getHeight());
		}

		//CLog.d("vh:" + getHeight() + ", rh:" + mRect.height() + ", y:" + y);

		canvas.drawRect(mBackgroundRect, mBackgroundPaint);
		canvas.drawText(mText, x, y, mPaint);

		offX += mStep;
		if (offX >= getMeasuredWidth() + mRect.width()) {
			offX = 0f;
		}

		//invalidate();
	}

	/**
	 * 设置字幕滚动的速度
	 */
	public void setScrollMode(int scrollMod) {
		if (scrollMod == SCROLL_SLOW) {
			mStep = 0.5f;
		} else if (scrollMod == SCROLL_NORM) {
			mStep = 1f;
		} else {
			mStep = 1.5f;
		}
	}

}
