package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

import util.LogUtil;
import util.ViewPrint;

/**
 * Created by taow on 2017/5/16.
 */

public class NavRadioButton extends RadioButton {
    private boolean isDown = false;
    public NavRadioButton(Context context) {
        this(context,null);
    }

    public NavRadioButton(Context context, AttributeSet attrs) {
        super(context,attrs);
        //TODO
        init();
    }

    private void init() {
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    NavRadioButton.this.setChecked(true);
                }
            }
        });
    }

   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_ENTER:
                LogUtil.i("NavRadioButton onkeydown isdown..");
                isDown = true;
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_ENTER:
                if(isDown){
                    LogUtil.i("NavRadioButton onkeyup ..");
                    View view = focusSearch(FOCUS_RIGHT);
                    if(view != null){
                        LogUtil.i("NavRadioButton onkeyup view: "+ ViewPrint.getViewClassAndId(view));
                        view.requestFocus();
                    }
                    isDown = false;
                }
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }*/
}
