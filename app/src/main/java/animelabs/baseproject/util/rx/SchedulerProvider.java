/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:03 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.util.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
