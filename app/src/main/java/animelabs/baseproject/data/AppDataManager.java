/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:53 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import animelabs.baseproject.data.network.requestLayer.ApiService;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

/*
 *   This is a class which is just a
 *   wrapper over all network and
 *   db calls.
 *   To make the code better, you can
 *   write your calls here and get
 *   response accordingly.
 *
 */

public class AppDataManager implements DataManager {

    private final ApiService mApiService;

    private final Context mContext;

    private final Gson mGson;

    private String lat;

    private String lng;

    @Inject
    public AppDataManager(Context context, ApiService apiHelper, Gson gson) {
        mContext = context;
        mApiService = apiHelper;
        mGson = gson;
    }
}