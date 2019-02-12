/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:53 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.data.network.middleware;

import android.support.annotation.NonNull;

import animelabs.baseproject.data.network.callbacks.INetworkCallbacks;
import animelabs.baseproject.data.network.models.base.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkLayer<T extends ApiResponse, Y> {
    private Call<T> mCall;
    private INetworkCallbacks<Y> mINetworkCallbacks;
    private String mType;

    public NetworkLayer(Call<T> call, INetworkCallbacks<Y> iNetworkCallbacks, String type) {
        this.mCall = call;
        this.mINetworkCallbacks = iNetworkCallbacks;
        this.mType = type;
    }

    public void callNetworkAPI() {
        mCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse  (@NonNull Call<T> call, @NonNull Response<T> response) {
                mINetworkCallbacks.onComplete();
                mINetworkCallbacks.onSuccess((Y) response.body(), mType);
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                mINetworkCallbacks.onComplete();
                mINetworkCallbacks.onError(t.getMessage(), mType);
            }
        });
    }
}
