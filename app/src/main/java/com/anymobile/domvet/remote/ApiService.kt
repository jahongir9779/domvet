package com.anymobile.domvet.remote

import com.anymobile.domvet.domain.model.*
import com.anymobile.domvet.remote.model.*
import okhttp3.MultipartBody
import retrofit2.http.*

/**
 * Defines the abstract methods used for interacting with the Bufferoo API
 */
interface ApiService {

//    @GET("team.json")
//    suspend fun getBufferoos(): Flowable<BufferooResponse>

    //Passenger POST API

    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("driver_post/action/filter")
    suspend fun filterDriverPost(@Header("Authorization") token: String,
                                 @Header("Accept-Language") lang: String,
                                 @Body filter: Filter): DriverPostsResponse

    //END PASSENGER POST API


    //DRIVER POST API

    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("passenger_post/action")
    suspend fun createPost(@Header("Authorization") token: String,
                           @Body passengerPostBody: PassengerPost): PlainResponse

    @Headers("Content-Type:application/json", "Accept: application/json")
    @PUT("passenger_post/action/cancel/{identifier}")
    suspend fun deletePost(@Header("Authorization") token: String,
                           @Path(value = "identifier",
                                 encoded = true) identifier: String): PlainResponse

    @Headers("Content-Type:application/json", "Accept: application/json")
    @PUT("passenger_post/action/finish/{identifier}")
    suspend fun finishPost(@Header("Authorization") token: String,
                           @Path(value = "identifier",
                                 encoded = true) identifier: String): PlainResponse


    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("passenger_post/action/active")
    suspend fun getActivePosts(@Header("Authorization") token: String,
                               @Header("Accept-Language") lang: String): PassengerActivePostsResponse

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("passenger_post/action/history")
    suspend fun getHistoryPosts(@Header("Authorization") token: String,
                                @Header("Accept-Language") lang: String,
                                @Query("page") page: Int = 0,
                                @Query("size") size: Int = 10): PassengerHistoryPostsResponse

    //


    //Places Feed

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("region/action")
    suspend fun getPlacesFeed(@Header("Authorization") token: String,
                              @Header("Accept-Language") lang: String,
                              @Query("query") query: String): PlaceListResponse
    //PLACES END


    //AUTH API
    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("prof/mb/auth")
    suspend fun userLogin(@Body loginReq: LoginRequest): AuthResponse


    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("prof/mb/reg")
    suspend fun userRegister(@Body user: User): AuthResponse

    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("prof/mb/confirm")
    suspend fun smsConfirm(@Body user: UserCredentials): AuthSuccessResponse
    //END AUTH API

    ///CAR API


//    @Headers("Content-Type:application/json", "Accept: application/json")
//    @GET("car/action")
//    suspend fun getCars(/*@Header("Content-Language") lang: String,*/ @Header("Authorization") token: String): CarListResponse

//    @Headers("Content-Type:application/json", "Accept: application/json")
//    @POST("car/action")
//    suspend fun createCar(/*@Header("Content-Language") lang: String,*/
//        @Header("Authorization") token: String,
//        @Body car: Car): PlainResponse

//    @Headers("Content-Type:application/json", "Accept: application/json")
//    @PUT("car/action/{identifier}")
//    suspend fun updateCar(/*@Header("Content-Language") lang: String,*/
//        @Header("Authorization") token: String,
//        @Path(value = "identifier", encoded = true) identifier: Long,
//        @Body car: Car): PlainResponse

//    @Headers("Content-Type:application/json", "Accept: application/json")
//    @DELETE("car/action/{identifier}")
//    suspend fun deleteCar(/*@Header("Content-Language") lang: String,*/
//        @Header("Authorization") token: String,
//        @Path(value = "identifier", encoded = true) identifier: Long): PlainResponse

//    @Headers("Content-Type:application/json", "Accept: application/json")
//    @PUT("car/action/{identifier}/def")
//    suspend fun setDefaultCar(/*@Header("Content-Language") lang: String,*/
//        @Header("Authorization") token: String,
//        @Path(value = "identifier", encoded = true) identifier: Long,
//        @Body carDefault: CarDefaultBody = CarDefaultBody()): PlainResponse

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("car_model/action")
    suspend fun getCarModels(@Header("Authorization") token: String,
                             @Header("Accept-Language") lang: String): CarModelsResponse

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("car_color/action")
    suspend fun getCarColors(@Header("Authorization") token: String,
                             @Header("Accept-Language") lang: String): CarColorsResponse

    //END CAR API


    //FILE UPLOAD API

    @Headers("Accept: application/json")
    @Multipart
    @POST("attach/image")
    suspend fun uploadPhoto(@Part file: MultipartBody.Part): PhotoUploadResponse

    //END FILE UPLOAD API


//    class BufferooResponse {
//        lateinit var team: List<UserModel>
//    }

}

