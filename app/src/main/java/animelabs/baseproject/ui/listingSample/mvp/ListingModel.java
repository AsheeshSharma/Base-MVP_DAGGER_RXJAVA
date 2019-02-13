/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 4:27 PM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.listingSample.mvp;

import android.graphics.Movie;

import animelabs.baseproject.data.network.callbacks.INetworkCallbacks;
import animelabs.baseproject.data.network.middleware.NetworkLayer;
import animelabs.baseproject.data.network.models.MovieResponse;
import animelabs.baseproject.data.network.requestLayer.ApiService;
import animelabs.baseproject.util.AppConstants;
import retrofit2.Call;

public class ListingModel {
    private ApiService mApiService;
    private INetworkCallbacks<MovieResponse> iNetworkCallbacks;

    public ListingModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    public void setiNetworkCallbacks(ListingPresenter listingPresenter) {
        this.iNetworkCallbacks = listingPresenter;
    }

    public void getOrders(String apiId, int page) {
        retrofit2.Call<MovieResponse> call = mApiService.getMovies(apiId, page);
        NetworkLayer<MovieResponse, MovieResponse> networkLayer = new NetworkLayer<MovieResponse, MovieResponse>(call, iNetworkCallbacks, AppConstants.GET_MOVIES);
        networkLayer.callNetworkAPI();
    }

}