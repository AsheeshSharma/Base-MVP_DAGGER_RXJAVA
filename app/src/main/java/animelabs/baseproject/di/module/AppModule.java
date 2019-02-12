
/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:35 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.di.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import animelabs.baseproject.BuildConfig;
import animelabs.baseproject.data.AppDataManager;
import animelabs.baseproject.data.DataManager;
import animelabs.baseproject.data.network.requestLayer.ApiService;
import animelabs.baseproject.data.network.requestLayer.MyServiceInterceptor;
import animelabs.baseproject.di.DatabaseInfo;
import animelabs.baseproject.di.PreferenceInfo;
import animelabs.baseproject.util.AppConstants;
import animelabs.baseproject.util.rx.AppSchedulerProvider;
import animelabs.baseproject.util.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

    @Singleton
    @Provides
    static ApiService provideApiService(OkHttpClient okHttpClient, Gson gson) {
        Retrofit.Builder retrofitBuilder;
        retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());
        return retrofitBuilder.build().create(ApiService.class);
    }


    @Provides
    @Singleton
    static OkHttpClient provideOkhttp(MyServiceInterceptor interceptor, HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache)
                .addInterceptor(interceptor)
                .addInterceptor(httpLoggingInterceptor);
        return builder.build();
    }


    @Provides
    @Singleton
    static Cache provideCache(Context context) {
        File cacheFile = new File(context.getCacheDir(), "HttpCache");
        cacheFile.mkdirs();
        return new Cache(cacheFile, 10 * 1000 * 1000); //10 MB
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("API_LOGS", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    static MyServiceInterceptor getServiceInterceptor(Context context) {
        return new MyServiceInterceptor(context);
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
