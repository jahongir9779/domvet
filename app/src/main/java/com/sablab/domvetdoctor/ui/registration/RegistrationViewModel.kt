package com.sablab.domvetdoctor.ui.registration

import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.ui.BaseViewModel
import com.sablab.domvetdoctor.util.*
import javax.inject.Inject

//enum class PhotoType {
//    AVATAR, PASSPORT1, PASSPORT2, ADDITIONAL
//}

class RegistrationViewModel @Inject constructor() : BaseViewModel() {


    private val _avatarBitmap = MutableLiveData<Bitmap?>()
    val avatarBitmap: LiveData<Bitmap?> get() = _avatarBitmap


    private val _passportBitmap1 = MutableLiveData<Bitmap?>()
    val passportBitmap1: LiveData<Bitmap?> get() = _passportBitmap1

    private val _passportBitmap2 = MutableLiveData<Bitmap?>()
    val passportBitmap2: LiveData<Bitmap?> get() = _passportBitmap2

    private val _additionalImages = MutableLiveData<ArrayList<Bitmap>>(arrayListOf())
    val additionalImages: LiveData<ArrayList<Bitmap>> get() = _additionalImages

    fun removeDocAtPos(pos : Int){
            _additionalImages.value = _additionalImages.value!!.let {
            it.removeAt(pos)
            it
        }
    }

    fun setImageUri(imageUri: Uri?, photoType: Int) {
        try {
            if (imageUri != null) {
                val bitmap = MediaStore.Images.Media.getBitmap(
                    App.getAppContext()?.contentResolver, imageUri)

                when (photoType) {
                    AVATAR -> {
                        _avatarBitmap.value = bitmap
                    }
                    PASSPORT1 -> {
                        _passportBitmap1.value = bitmap
                    }
                    PASSPORT2 -> {
                        _passportBitmap2.value = bitmap
                    }
                    ADDITIONAL0 -> {
                        val pos = ADDITIONAL0.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }

                        }
                    }
                    ADDITIONAL1 -> {
                        val pos = ADDITIONAL1.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    ADDITIONAL2 -> {
                        val pos = ADDITIONAL2.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    ADDITIONAL3 -> {
                        val pos = ADDITIONAL3.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    ADDITIONAL4 -> {
                        val pos = ADDITIONAL4.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    ADDITIONAL5 -> {
                        val pos = ADDITIONAL5.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    ADDITIONAL6 -> {
                        val pos = ADDITIONAL6.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    ADDITIONAL7 -> {
                        val pos = ADDITIONAL7.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    ADDITIONAL8 -> {
                        val pos = ADDITIONAL8.toString().substring(1, 2).toInt()
                        if (pos < additionalImages.value!!.size) {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it[pos] = bitmap
                                it
                            }
                        } else {
                            _additionalImages.value = _additionalImages.value!!.let {
                                it.add(pos, bitmap)
                                it
                            }
                        }
                    }
                    else -> {

                    }
                }

            }
        } catch (e: Exception) {
        }
    }


    fun setImageBitmap(bitmap: Bitmap?,
                       photoType: Int) {
        when (photoType) {
            AVATAR -> {
                _avatarBitmap.value = bitmap
            }
            PASSPORT1 -> {
                _passportBitmap1.value = bitmap
            }
            PASSPORT2 -> {
                _passportBitmap2.value = bitmap
            }
            ADDITIONAL0 -> {
                val pos = ADDITIONAL0.toString().substring(1, 2).toInt()
                if (pos < _additionalImages.value!!.size) {
                    _additionalImages.value!![pos] = bitmap!!
                } else {
                    _additionalImages.value!!.add(pos, bitmap!!)
                }
            }
            ADDITIONAL1 -> {
                val pos = ADDITIONAL1.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            ADDITIONAL2 -> {
                val pos = ADDITIONAL2.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            ADDITIONAL3 -> {
                val pos = ADDITIONAL3.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            ADDITIONAL4 -> {
                val pos = ADDITIONAL4.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            ADDITIONAL5 -> {
                val pos = ADDITIONAL5.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            ADDITIONAL6 -> {
                val pos = ADDITIONAL6.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            ADDITIONAL7 -> {
                val pos = ADDITIONAL7.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            ADDITIONAL8 -> {
                val pos = ADDITIONAL8.toString().substring(1, 2).toInt()
                if (pos < additionalImages.value!!.size) {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it[pos] = bitmap!!
                        it
                    }
                } else {
                    _additionalImages.value = _additionalImages.value!!.let {
                        it.add(pos, bitmap!!)
                        it
                    }
                }
            }
            else -> {

            }
        }

    }

}