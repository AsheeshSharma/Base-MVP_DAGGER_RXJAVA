/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:03 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.util.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class AppSchedulerProvider implements SchedulerProvider {

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
