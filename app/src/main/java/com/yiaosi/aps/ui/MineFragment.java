package com.yiaosi.aps.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chatuidemo.DemoHelper;
import com.hyphenate.chatuidemo.ui.LoginActivity;
import com.hyphenate.chatuidemo.ui.MainActivity;
import com.hyphenate.easeui.ui.EaseBaseFragment;
import com.yiaosi.aps.R;
import com.yiaosi.aps.widget.EditItem;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Administrator on 2017-06-05.
 */

public class MineFragment extends EaseBaseFragment implements View.OnClickListener {
    private View view;
    private EditItem personInfo, qrCodeDownLoad, qrCode, dataBundle, newMsg, checkUpdate, feedBack, helpCenter;
    private Button logoutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.em_fragment_mine, container, false);
        return view;
    }

    @Override
    protected void initView() {
        personInfo = (EditItem) view.findViewById(R.id.efm_personalInfo);
        qrCodeDownLoad = (EditItem) view.findViewById(R.id.efm_QRcodeDownload);
        qrCode = (EditItem) view.findViewById(R.id.efm_QRcode);
        dataBundle = (EditItem) view.findViewById(R.id.efm_DataBundle);
        newMsg = (EditItem) view.findViewById(R.id.efm_new_msg);
        checkUpdate = (EditItem) view.findViewById(R.id.efm_check_update);
        feedBack = (EditItem) view.findViewById(R.id.efm_feedback);
        helpCenter = (EditItem) view.findViewById(R.id.efm_help_center);

        logoutBtn = (Button) view.findViewById(R.id.btn_logout);
        if(!TextUtils.isEmpty(EMClient.getInstance().getCurrentUser())){
            logoutBtn.setText(getString(R.string.button_logout) + "(" + EMClient.getInstance().getCurrentUser() + ")");
        }

        personInfo.setOnClickListener(this);
        qrCodeDownLoad.setOnClickListener(this);
        qrCode.setOnClickListener(this);
        dataBundle.setOnClickListener(this);
        newMsg.setOnClickListener(this);
        checkUpdate.setOnClickListener(this);
        feedBack.setOnClickListener(this);
        helpCenter.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
    }

    @Override
    protected void setUpView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.efm_personalInfo:
                Intent it = new Intent(getActivity(), UserProfileActivity.class);
                it.putExtra("isChat", false);
                startActivity(it);
                break;
            case R.id.btn_logout:
                logout();
                break;
            case R.id.efm_QRcodeDownload:
                Intent itQRCodeDownload = new Intent(getActivity(), QRCodeDownloadActivity.class);
                startActivity(itQRCodeDownload);
                break;
            case R.id.efm_QRcode:
                Intent itQRCode = new Intent(getActivity(), QRCodeActivity.class);
                startActivity(itQRCode);
                break;
            case R.id.efm_DataBundle:
                Intent itBundle = new Intent(getActivity(), DataBundleActivity.class);
                startActivityForResult(itBundle, 1000);
                break;
            case R.id.efm_new_msg:
                Toast.makeText(getActivity(), "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.efm_check_update:
                Toast.makeText(getActivity(), "已经是最新版本", Toast.LENGTH_SHORT).show();
                break;
            case R.id.efm_feedback:
                Toast.makeText(getActivity(), "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.efm_help_center:
                Toast.makeText(getActivity(), "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            default:

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1000:
                if (resultCode == RESULT_OK) {
                    logout();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void logout() {
        final ProgressDialog pd = new ProgressDialog(getActivity());
        String st = getResources().getString(R.string.Are_logged_out);
        pd.setMessage(st);
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        DemoHelper.getInstance().logout(false,new EMCallBack() {

            @Override
            public void onSuccess() {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        pd.dismiss();
                        // show login screen
                        ((MainActivity) getActivity()).finish();
                        startActivity(new Intent(getActivity(), LoginActivity.class));

                    }
                });
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pd.dismiss();
                        Toast.makeText(getActivity(), "unbind devicetokens failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
