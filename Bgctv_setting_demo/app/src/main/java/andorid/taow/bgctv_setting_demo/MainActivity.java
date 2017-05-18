package andorid.taow.bgctv_setting_demo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import fragment.AutoSearchFragment;
import fragment.ManuSearchFragment;
import fragment.ProgramEpgFragment;
import fragment.SignalTestFragment;
import util.LogUtil;
import view.NavRadioGroup;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {
    private NavRadioGroup mNavRadioGroup;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private String fragmentTag = MainActivity.class.getSimpleName();
    private Fragment mCurrentFragment;
    private ViewGroup mContentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = getFragmentManager().beginTransaction();
    }

    private void initListener() {
        mNavRadioGroup.setOnCheckedChangeListener(this);
    }

    private void initView() {
        mNavRadioGroup = (NavRadioGroup) findViewById(R.id.main_nav_radiogroup);
        mContentLayout = (ViewGroup)findViewById(R.id.main_content);
    }

    private AutoSearchFragment autoSearchFragment;
    private ManuSearchFragment manuSearchFragment;
    private ProgramEpgFragment programEpgFragment;
    private SignalTestFragment signalTestFragment;
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_nav_auto_search:
                if(autoSearchFragment == null){
                    autoSearchFragment = new AutoSearchFragment();
                }
                showFragment(autoSearchFragment,AutoSearchFragment.class.getSimpleName());
                break;
            case R.id.main_nav_manu_search:
                if(manuSearchFragment == null){
                    manuSearchFragment = new ManuSearchFragment();
                }
                showFragment(manuSearchFragment,ManuSearchFragment.class.getSimpleName());
                break;
            case R.id.main_nav_program_epg:
                if(programEpgFragment == null){
                    programEpgFragment = new ProgramEpgFragment();
                }
                showFragment(programEpgFragment,ProgramEpgFragment.class.getSimpleName());
                break;
            case R.id.main_nav_signal_test:
                if(signalTestFragment == null){
                    signalTestFragment = new SignalTestFragment();
                }
                showFragment(signalTestFragment,SignalTestFragment.class.getSimpleName());
                break;
            case R.id.main_nav_language_setting:
                break;
            case R.id.main_nav_image_ajust:
                break;
            case R.id.main_nav_email_see:
                break;
            case R.id.main_nav_shopping_info:
                break;
            case R.id.main_nav_output_setting:
                break;
            case R.id.main_nav_network_setting:
                break;
            case R.id.main_nav_ca_info:
                break;
            case R.id.main_nav_service_info:
                break;
            case R.id.main_nav_reset:
                break;
        }
    }

    /**
     * currentFramgent 记录当前显示的fragment，然后进行hide，再show其他的。
     * 这种方式 fragment tag已经没有多大意义了。
     * @param fragment
     */
    public void showFragment(Fragment fragment,String tag){
        if(null != fragment){
            mFragmentTransaction = getFragmentManager().beginTransaction();

            //如果没有加入fragment manager
            if(!fragment.isAdded()){
                LogUtil.i("switchFragment not add, add fragment tag: "+tag);
                mFragmentTransaction.add(R.id.main_content,fragment);
            }

            if(null != mCurrentFragment){
                LogUtil.i("switchFragment hide current fragment :"+mCurrentFragment.getClass().getSimpleName());
                mFragmentTransaction.hide(mCurrentFragment);
            }
            mFragmentTransaction.show(fragment);
            mFragmentTransaction.commit();
            mCurrentFragment = fragment;
        }
    }

    //activity 没有执行finish，进入后台时会执行该方法。
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public View getFirstFocusView(){
        int checkId = mNavRadioGroup.getCheckedRadioButtonId();
        View v = FocusFinder.getInstance().findNextFocus(mContentLayout,null,View.FOCUS_DOWN);
        LogUtil.i("MainActivity getFirstFocusView v:"+v.getId());
        return v;
    }
}
