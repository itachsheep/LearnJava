package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

import andorid.taow.bgctv_setting_demo.MainActivity;
import util.LogUtil;
import util.ViewPrint;

/**
 * Created by taow on 2017/5/16.
 */

public class NavRadioGroup extends RadioGroup {
    public NavRadioGroup(Context context) {
        this(context,null);
    }

    public NavRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        //TODO

    }

    @Override
    public View focusSearch(View focused, int direction) {
//        LogUtil.i("NavRadioGroup focusSearch focused, direction: "+direction);
//        if(direction == FOCUS_RIGHT && focused.getNextFocusRightId() == View.NO_ID){
//            LogUtil.i("NavRadioGroup focusSearch right..");
//            View v = ((MainActivity)getContext()).getFirstFocusView();
//            if(v != null){
//                LogUtil.i("NavRadioGroup focusSearch v:"+ ViewPrint.getViewClassAndId(v));
//                return v;
//            }
//        }
        return super.focusSearch(focused, direction);
    }
}
