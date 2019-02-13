/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 1:53 AM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.data.network.requestLayer;

/*
    Sample API requests of type GET, PUT and POST
    follow the same pattern to write your API calls.

    @GET("restaurants/{id}")
    Call<BaseResponse<ModelResponse>> getRestaurantDetails(@Path("id") int id);

    @POST("payments")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<BaseResponse<ModelResponse>> submitRazorPayResponse(@Body RequestBody updatedDAta);

    @PUT("orders/{id}")
    Call<BaseResponse<ModelResponse>>updateOrderAction(@Body RequestBody updatedDAta, @Path("id") String id);

*/

import animelabs.baseproject.data.network.models.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // Declare all APIs here
    @GET("movie/popular")
    Call<MovieResponse> getMovies(@Query("api_key") String mobileNumber, @Query("page") int page);

}
