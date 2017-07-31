package apsdemo.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017-06-07.
 */

public class FragmentOne extends Fragment implements View.OnClickListener {
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragament_layout,null);
        rootView.findViewById(R.id.btnAnotherFragment).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction()
//                .setCustomAnimations(R.animator.animator_enter,R.animator.animator_exit,R.animator.animator_enter,R.animator.animator_exit)
                .addToBackStack("OtherFragment")
                .replace(R.id.fragment, new OtherFragment())
                .commit();
    }
}
