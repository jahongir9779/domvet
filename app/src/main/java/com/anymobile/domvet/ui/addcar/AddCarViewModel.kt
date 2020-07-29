package com.anymobile.domvet.ui.addcar
//
//import androidx.lifecycle.viewModelScope
//import com.anymobile.domvet.util.Constants.TXT_CAR
//import com.anymobile.domvet.util.Constants.TXT_LANG
//import com.anymobile.domvet.util.Constants.TXT_TOKEN
//import com.anymobile.domvet.util.ErrorWrapper
//import com.anymobile.domvet.util.ResultWrapper
//import com.anymobile.domvet.domain.model.*
//import com.anymobile.domvet.domain.usecases.GetCarColors
//import com.anymobile.domvet.domain.usecases.GetCarModels
//import com.anymobile.domvet.domain.usecases.SaveCar
//import com.anymobile.domvet.domain.usecases.UploadPhoto
//import com.anymobile.domvet.App
//import com.anymobile.domvet.ui.BaseViewModel
//import com.anymobile.domvet.util.AppPreferences
//import com.anymobile.domvet.util.SingleLiveEvent
//import kotlinx.coroutines.*
//import kotlinx.coroutines.Dispatchers.IO
//import kotlinx.coroutines.Dispatchers.Main
//import splitties.experimental.ExperimentalSplittiesApi
//import splitties.init.appCtx
//import java.io.File
//import javax.inject.Inject
//
///**
// * Created by jahon on 28-Apr-20
// */
//class AddCarViewModel @Inject constructor(private val uploadPhoto: UploadPhoto,
//                                          private val saveCar: SaveCar,
//                                          private val getCarColors: GetCarColors,
//                                          private val getCarModels: GetCarModels) :
//    BaseViewModel() {
//
//    val carSaveReponse = SingleLiveEvent<ResultWrapper<String>>()
//    val colorsAndModels = SingleLiveEvent<ResultWrapper<ColorsAndModels>>()
//    val carAvatarResponse = SingleLiveEvent<ResultWrapper<PhotoBody>>()
//    val carImgResponse = SingleLiveEvent<ResultWrapper<PhotoBody>>()
//
////    fun getCarSaveReponse(): SingleLiveEvent<ResultWrapper<String>> = carSaveReponse
////    fun getColorsAndModels(): SingleLiveEvent<ResultWrapper<ColorsAndModels>> = colorsAndModels
////    fun getCarAvatarResponse(): SingleLiveEvent<ResultWrapper<PhotoBody>> = carAvatarResponse
////    fun getCarImgResponse(): SingleLiveEvent<ResultWrapper<PhotoBody>> = carImgResponse
//
//
//    @ExperimentalSplittiesApi
//    @InternalCoroutinesApi
//    fun getCarColorsAndModels() {
//        viewModelScope.launch(IO) {
//            withContext(Main) {
//                colorsAndModels.value = ResultWrapper.InProgress
//            }
//            withContext(IO) {
//                try {
//                    val colors = async { getCarColors.execute(hashMapOf(Pair(TXT_TOKEN, AppPreferences.token), Pair(
//                        TXT_LANG, AppPreferences.language))) }
//                    val models = async { getCarModels.execute(hashMapOf(Pair(TXT_TOKEN, AppPreferences.token), Pair(
//                        TXT_LANG, AppPreferences.language) ))}
//                    processResponses(colors.await(), models.await())
//                } catch (e: Exception) {
//                    withContext(Main) {
//                        colorsAndModels.value = ErrorWrapper.SystemError(e)
//                    }
//                }
//            }
//        }
//    }
//
//    private fun processResponses(colorsResp: ResultWrapper<List<CarColor>>,
//                                 modelsResp: ResultWrapper<List<CarModel>>) {
//        viewModelScope.launch(Main) {
//            if (colorsResp is ResultWrapper.Success && modelsResp is ResultWrapper.Success) {
//                colorsAndModels.value =
//                    ResultWrapper.Success(ColorsAndModels(colorsResp.value, modelsResp.value))
//            } else {
//                colorsAndModels.value =
//                    if (colorsResp is ErrorWrapper) colorsResp else modelsResp as ErrorWrapper
//            }
//        }
//    }
//
//
//    fun uploadCarPhoto(file: File, isAvatar: Boolean = false) {
//        val liveData = if (isAvatar) carAvatarResponse else carImgResponse
//        liveData.value = ResultWrapper.InProgress
//        viewModelScope.launch(IO) {
//            val response = uploadPhoto.execute(file)
//            withContext(Main) {
//                liveData.value = response
//            }
//        }
//
//
//    }
//
//
//    fun saveCar(token: String, car: Car) {
//        carSaveReponse.value = ResultWrapper.InProgress
//        viewModelScope.launch(IO) {
//            val response =
//                saveCar.execute(hashMapOf(Pair(TXT_TOKEN, token), Pair(TXT_CAR, car)))
//            withContext(Main) {
//                carSaveReponse.value = response
//            }
//
//        }
//    }
//
//
//    @ExperimentalCoroutinesApi
//    override fun onCleared() {
//        super.onCleared()
//        (appCtx as App).releaseAddCarComponent()
//    }
//}