package activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import andorid.taow.selfview.R;
import view.AutoTextView;

/**
 * Created by taow on 2017/5/31.
 */

public class TextViewActivity extends Activity implements View.OnClickListener {
    private Button bt;
    private AutoTextView autoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        bt = (Button) findViewById(R.id.textact_bt);
        autoTextView = (AutoTextView) findViewById(R.id.atv_tv);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.textact_bt){
//            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) autoTextView
//                    .getLayoutParams();
//            autoTextView.setLayoutParams(lp);
            autoTextView.setText("dlsjfslkjflsd的数量大幅减少的法律类似的疯狂举动是否建立世界十大");
//            autoTextView.setHeight(getResources().getDimensionPixelSize(R.dimen.text_size));
            autoTextView.setVisibility(View.VISIBLE);
        }
    }
}
