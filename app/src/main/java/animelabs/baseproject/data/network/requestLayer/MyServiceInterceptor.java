/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:53 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.data.network.requestLayer;

import android.content.Context;

import java.io.IOException;

import javax.inject.Singleton;

import animelabs.baseproject.util.NetworkUtils;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*
  Set the authorization token
  when it is available.
 */

@Singleton
public class MyServiceInterceptor implements Interceptor {
    private String sessionToken;
    private Context context;

    public MyServiceInterceptor(Context context) {
        this.context = context;
    }

    @Override public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (NetworkUtils.isNetworkConnected(context)) {
            int maxAge = 60; // read from cache for 1 minute
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    }
}