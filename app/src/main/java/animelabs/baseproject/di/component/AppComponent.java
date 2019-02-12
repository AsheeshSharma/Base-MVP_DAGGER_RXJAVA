
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
import animelabs.baseproject.di.module.AppModule;
import dagger.BindsInstance;
import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
