/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:52 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.base.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import animelabs.baseproject.ui.base.interfaces.IBaseActivity;


public class BaseActivity extends AppCompatActivity implements IBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(getLayout());
    }

    @Override
    public void logEvent(String data) {
        //
    }

    @Override
    public void showSnackBar(String data) {
        //
    }

    @Override
    public void showToast(String data) {
        //
    }

    @Override
    public View getLayout() {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }
}
