/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:56 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.listingSample;

import android.view.View;

import javax.inject.Inject;

import animelabs.baseproject.ui.base.activities.BaseActivityDagger;
import animelabs.baseproject.ui.base.listeners.EndlessRecyclerViewScrollListener;
import animelabs.baseproject.ui.listingSample.mvp.ListingPresenter;
import animelabs.baseproject.ui.listingSample.mvp.ListingView;
import butterknife.ButterKnife;

public class PaginatedListSampleActivity extends BaseActivityDagger {
    @Inject
    ListingView listingView;

    @Inject
    ListingPresenter listingPresenter;

    @Override
    public View getLayout() {
        return listingView.getView();
    }

    @Override
    public void init() {
        super.init();
        listingPresenter.initPresenter();
    }
}
