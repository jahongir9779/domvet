package com.sablab.domvetdoctor.remote

import com.sablab.domvetdoctor.cache.db.entries.ERegion
import com.sablab.domvetdoctor.domain.model.Filter
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.network.NCity
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.remote.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

/**
 * Defines the abstract methods used for interacting with the Bufferoo API
 */
interface ApiService {

    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("v1/site/register")
    suspend fun userLogin(@Body loginReq: LoginRequest): Response<Any>

    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("v1/site/activate")
    suspend fun smsConfirm(@Body user: UserCredentials): Response<NUser>

    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("v1/doctor/profile/city")
    suspend fun saveUserCity(@Body body: Map<String, String>): Response<NUser>

    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("v1/doctor/profile/update")
    suspend fun saveUser(@PartMap body: MutableMap<String, @JvmSuppressWildcards RequestBody>): Response<NUser>

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("v1/site/regions")
    suspend fun getAllRegions(): Response<List<ERegion>>

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("v1/site/cities")
    suspend fun getAllCities(): Response<MyResponse<List<NCity>>>


    @Headers("Content-Type:application/json", "Accept: application/json")
    @POST("driver_post/action/filter")
    suspend fun filterDriverPost(@Header("Authorization") token: String,
                                 @Header("Accept-Language") lang: String,
                                 @Body filter: Filter): DriverPostsResponse

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

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("region/action")
    suspend fun getPlacesFeed(@Header("Authorization") token: String,
                              @Header("Accept-Language") lang: String,
                              @Query("query") query: String): PlaceListResponse


    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("car_model/action")
    suspend fun getCarModels(@Header("Authorization") token: String,
                             @Header("Accept-Language") lang: String): CarModelsResponse

    @Headers("Content-Type:application/json", "Accept: application/json")
    @GET("car_color/action")
    suspend fun getCarColors(@Header("Authorization") token: String,
                             @Header("Accept-Language") lang: String): CarColorsResponse

    @Headers("Accept: application/json")
    @Multipart
    @POST("attach/image")
    suspend fun uploadPhoto(@Part file: MultipartBody.Part): PhotoUploadResponse


}

