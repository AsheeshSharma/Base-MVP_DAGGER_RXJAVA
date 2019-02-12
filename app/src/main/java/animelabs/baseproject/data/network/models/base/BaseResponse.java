/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:53 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.data.network.models.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import animelabs.baseproject.data.network.models.common.Status;

public class BaseResponse<T> extends ApiResponse{
    @SerializedName("data")
    @Expose
    private T t;
    @SerializedName("status")
    @Expose
    private Status status;

    public T getPayload() {
        return t;
    }

    public void setPayload(T payload) {
        this.t = payload;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
