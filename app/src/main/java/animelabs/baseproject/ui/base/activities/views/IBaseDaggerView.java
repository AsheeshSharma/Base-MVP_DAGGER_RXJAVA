/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:52 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.base.activities.views;

import android.content.Context;
import android.view.View;

public interface IBaseDaggerView {
    void init(Context context, int layoutId);

    View getView();

    void initActions();
}
