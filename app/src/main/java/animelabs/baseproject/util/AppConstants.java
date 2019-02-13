/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 2:01 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.util;

public final class AppConstants {

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "YOUR_APP_DB_NAME";

    public static final long NULL_INDEX = -1L;

    public static final String PREF_NAME = "YOUR_APP_SHARED_PREF_NAME";

    public static final int STATUS_CODE_FAILED = 500;

    public static final int STATUS_CODE_SUCCESS = 200;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    //Request Header Constants
    public static final String DEVICE_ID = "Device-id";
    public static final String AUTHORIZATION = "Authorization";
    public static final String VERSION_NAME = "Version-name";
    public static final String VERSION_CODE = "Version-code";
    public static final String CLIENT_ID = "Client-id";
    public static final String CONNECTION_QUALITY = "Connection-quality";
    public static final String CLIENT_SECRET = "Client-secret";
    public static final String GET_MOVIES = "GET_MOVIES";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
