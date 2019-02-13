/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 4:27 PM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.listingSample.mvp;

import android.graphics.Movie;
import android.util.Log;

import animelabs.baseproject.data.network.callbacks.INetworkCallbacks;
import animelabs.baseproject.data.network.models.MovieResponse;

public class ListingPresenter implements INetworkCallbacks<MovieResponse> {


    private ListingView mListingView;
    private ListingModel mListingModel;

    public ListingPresenter(ListingModel listingModel, ListingView listingView) {
        this.mListingModel = listingModel;
        this.mListingView = listingView;
        this.mListingModel.setiNetworkCallbacks(this);
        this.mListingView.setPresenter(this);
    }

    public void initPresenter() {
        mListingModel.getOrders("b57baa9d26924c96cde3bceb30d1fb7b", 1);
    }

    @Override
    public void onSuccess(MovieResponse baseCollectionResponse, String type) {
        Log.d("res", baseCollectionResponse + "");
    }

    @Override
    public void onError(String error, String type) {
    }

    @Override
    public void onComplete() {
    }
}
