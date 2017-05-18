package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import andorid.taow.bgctv_setting_demo.R;

/**
 * Created by taow on 2017/5/17.
 */

public class SignalTestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_signal_test, container,false);
        return view;
    }
}
