package view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by taow on 2017/4/24.
 */

public class MarqueeTextView extends TextView {
    public MarqueeTextView(Context context) {
        super(context);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isFocused() {
//        return super.isFocused();
        return true;
    }
}
