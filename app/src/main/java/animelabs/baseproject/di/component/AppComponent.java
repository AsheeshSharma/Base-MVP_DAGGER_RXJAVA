
/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:35 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.di.component;

import android.app.Application;


import javax.inject.Singleton;

import animelabs.baseproject.app.App;
import animelabs.baseproject.di.module.ActivityBindingModule;
import animelabs.baseproject.di.module.AppModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {AppModule.class, ActivityBindingModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<App> {

    void inject(App app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
