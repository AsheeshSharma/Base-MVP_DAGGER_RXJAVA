/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 4:26 PM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.listingSample.core;

import javax.inject.Named;

import animelabs.baseproject.R;
import animelabs.baseproject.data.network.requestLayer.ApiService;
import animelabs.baseproject.di.ActivityScoped;
import animelabs.baseproject.ui.listingSample.PaginatedListSampleActivity;
import animelabs.baseproject.ui.listingSample.mvp.ListingModel;
import animelabs.baseproject.ui.listingSample.mvp.ListingPresenter;
import animelabs.baseproject.ui.listingSample.mvp.ListingView;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ListingSampleModule {
    @Provides
    @ActivityScoped
    static ListingView getContainerView(PaginatedListSampleActivity paginatedListSampleActivity, int layoutId) {
        return new ListingView(paginatedListSampleActivity, layoutId);
    }

    @Provides
    @ActivityScoped
    static int getLayoutId() {
        return R.layout.list_sample;
    }

    @Provides
    @ActivityScoped
    static ListingPresenter getPresenter(ListingModel restaurantsListModel, ListingView restaurantsListView) {
        return new ListingPresenter(restaurantsListModel, restaurantsListView);
    }

    @Provides
    @ActivityScoped
    static ListingModel getPastOrdersListModel(ApiService apiService) {
        return new ListingModel(apiService);
    }
}
