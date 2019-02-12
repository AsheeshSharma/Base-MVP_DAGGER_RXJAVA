/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:53 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.data.network.callbacks;

public interface INetworkCallbacks<T> {
    void onSuccess(T t, String type);
    void onError(String error, String type);
    void onComplete();
}
