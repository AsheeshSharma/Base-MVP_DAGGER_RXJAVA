/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:52 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.base.activities.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;


public class BaseDaggerView implements IBaseDaggerView{

    protected View mView;
    protected Context mContext;

    public BaseDaggerView(Context context, int layoutId) {
        init(context, layoutId);
        ButterKnife.bind(this, mView);
        initActions();
    }

    @Override
    public void init(Context context, int layoutId) {
        if(context != null) {
            FrameLayout parent = new FrameLayout(context);
            parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mView = LayoutInflater.from(context).inflate(layoutId, parent, true);
            mContext = context;
        }
    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void initActions() {

    }
}
