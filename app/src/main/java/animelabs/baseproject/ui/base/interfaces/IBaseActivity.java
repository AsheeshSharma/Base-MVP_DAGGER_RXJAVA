/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:52 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.base.interfaces;

import android.view.View;

public interface IBaseActivity {
    void logEvent(String data);
    void showSnackBar(String data);
    void showToast(String data);
    View getLayout();
    void init();
    void hideProgress();
    void showProgress();
}
