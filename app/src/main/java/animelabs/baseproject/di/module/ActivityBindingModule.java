/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 4:33 PM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.di.module;

import animelabs.baseproject.di.ActivityScoped;
import animelabs.baseproject.ui.listingSample.PaginatedListSampleActivity;
import animelabs.baseproject.ui.listingSample.core.ListingSampleModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = ListingSampleModule.class)
    abstract PaginatedListSampleActivity containerActivity();

}
