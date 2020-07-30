package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import com.sablab.domvetdoctor.models.Doctor

/*{
    "result": [
        {
            "animal": {
                "id": 6,
                "name": "gerda",
                "photo": "http://domvet.sab-lab.com/uploads/animal/images/1585978783.png",
                "age": "1.5",
                "weight": "2",
                "status": "Активный",
                "gender": 2,
                "type_animal_id": 1,
                "animal_breed_id": 1,
                "consumer_id": 1,
                "created_at": "2020-04-04 10:39:43",
                "gender_name": "Самка",
                "type_animal_name": "Собака",
                "animal_breed_name": "buldok1"
            },
            "disease_id": 3,
            "consumerFullName": "1 1 1",
            "created_at": "2020-04-29 10:31:15",
            "status_name": "Doctor search",
            "status": 5,
            "come_at": null,
            "info": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": null,
                "summary": 1000.5,
                "services": "Выезд в переделая города, Ukol, Pricheska, Yuvintrish"
            },
            "detail": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": null,
                "summary": 1000.5,
                "defaultService": {
                    "name": "Выезд в переделая города",
                    "price": "100"
                },
                "services": [
                    {
                        "price": "200",
                        "service_id": 1,
                        "service": {
                            "id": 1,
                            "name": "Ukol"
                        }
                    },
                    {
                        "price": "100.5",
                        "service_id": 2,
                        "service": {
                            "id": 2,
                            "name": "Pricheska"
                        }
                    },
                    {
                        "price": "600",
                        "service_id": 4,
                        "service": {
                            "id": 4,
                            "name": "Yuvintrish"
                        }
                    }
                ]
            },
            "photos": [],
            "_links": []
        },
        {
            "animal": {
                "id": 6,
                "name": "gerda",
                "photo": "http://domvet.sab-lab.com/uploads/animal/images/1585978783.png",
                "age": "1.5",
                "weight": "2",
                "status": "Активный",
                "gender": 2,
                "type_animal_id": 1,
                "animal_breed_id": 1,
                "consumer_id": 1,
                "created_at": "2020-04-04 10:39:43",
                "gender_name": "Самка",
                "type_animal_name": "Собака",
                "animal_breed_name": "buldok1"
            },
            "disease_id": 4,
            "consumerFullName": "1 1 1",
            "created_at": "2020-04-30 09:17:00",
            "status_name": "Doctor search",
            "status": 5,
            "come_at": null,
            "info": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": null,
                "summary": 1000.5,
                "services": "Выезд в переделая города, Ukol, Pricheska, Yuvintrish"
            },
            "detail": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": null,
                "summary": 1000.5,
                "defaultService": {
                    "name": "Выезд в переделая города",
                    "price": "100"
                },
                "services": [
                    {
                        "price": "200",
                        "service_id": 1,
                        "service": {
                            "id": 1,
                            "name": "Ukol"
                        }
                    },
                    {
                        "price": "100.5",
                        "service_id": 2,
                        "service": {
                            "id": 2,
                            "name": "Pricheska"
                        }
                    },
                    {
                        "price": "600",
                        "service_id": 4,
                        "service": {
                            "id": 4,
                            "name": "Yuvintrish"
                        }
                    }
                ]
            },
            "photos": [],
            "_links": []
        },
        {
            "animal": {
                "id": 6,
                "name": "gerda",
                "photo": "http://domvet.sab-lab.com/uploads/animal/images/1585978783.png",
                "age": "1.5",
                "weight": "2",
                "status": "Активный",
                "gender": 2,
                "type_animal_id": 1,
                "animal_breed_id": 1,
                "consumer_id": 1,
                "created_at": "2020-04-04 10:39:43",
                "gender_name": "Самка",
                "type_animal_name": "Собака",
                "animal_breed_name": "buldok1"
            },
            "disease_id": 6,
            "consumerFullName": "1 1 1",
            "created_at": "2020-05-23 04:48:13",
            "status_name": "Doctor search",
            "status": 5,
            "come_at": null,
            "info": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": null,
                "summary": 1000.5,
                "services": "Выезд в переделая города, Ukol, Pricheska, Yuvintrish"
            },
            "detail": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": null,
                "summary": 1000.5,
                "defaultService": {
                    "name": "Выезд в переделая города",
                    "price": "100"
                },
                "services": [
                    {
                        "price": "200",
                        "service_id": 1,
                        "service": {
                            "id": 1,
                            "name": "Ukol"
                        }
                    },
                    {
                        "price": "100.5",
                        "service_id": 2,
                        "service": {
                            "id": 2,
                            "name": "Pricheska"
                        }
                    },
                    {
                        "price": "600",
                        "service_id": 4,
                        "service": {
                            "id": 4,
                            "name": "Yuvintrish"
                        }
                    }
                ]
            },
            "photos": [],
            "_links": []
        },
        {
            "animal": {
                "id": 6,
                "name": "gerda",
                "photo": "http://domvet.sab-lab.com/uploads/animal/images/1585978783.png",
                "age": "1.5",
                "weight": "2",
                "status": "Активный",
                "gender": 2,
                "type_animal_id": 1,
                "animal_breed_id": 1,
                "consumer_id": 1,
                "created_at": "2020-04-04 10:39:43",
                "gender_name": "Самка",
                "type_animal_name": "Собака",
                "animal_breed_name": "buldok1"
            },
            "disease_id": 5,
            "consumerFullName": "1 1 1",
            "created_at": "2020-04-30 09:17:09",
            "status_name": "Doctor reject",
            "status": 4,
            "come_at": "Mon, 11 May 20:00",
            "info": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": {
                    "name": null,
                    "address": "",
                    "latitude": "55.675555",
                    "longitude": "37.599696",
                    "landmark": "land",
                    "address_refinement_id": 2,
                    "addressRefinement": {
                        "apartment": "123123",
                        "porch": "123123",
                        "floor": null,
                        "intercom": null,
                        "comment": null
                    }
                },
                "summary": 1000.5,
                "services": "Выезд в переделая города, Ukol, Pricheska, Yuvintrish"
            },
            "detail": {
                "reason": {
                    "selected": "Нужен плановый осмотр",
                    "comment": "12312"
                },
                "address": {
                    "name": null,
                    "address": "",
                    "latitude": "55.675555",
                    "longitude": "37.599696",
                    "landmark": "land",
                    "address_refinement_id": 2,
                    "addressRefinement": {
                        "apartment": "123123",
                        "porch": "123123",
                        "floor": null,
                        "intercom": null,
                        "comment": null
                    }
                },
                "summary": 1000.5,
                "defaultService": {
                    "name": "Выезд в переделая города",
                    "price": "100"
                },
                "services": [
                    {
                        "price": "200",
                        "service_id": 1,
                        "service": {
                            "id": 1,
                            "name": "Ukol"
                        }
                    },
                    {
                        "price": "100.5",
                        "service_id": 2,
                        "service": {
                            "id": 2,
                            "name": "Pricheska"
                        }
                    },
                    {
                        "price": "600",
                        "service_id": 4,
                        "service": {
                            "id": 4,
                            "name": "Yuvintrish"
                        }
                    }
                ]
            },
            "photos": [
                {
                    "file": "http://domvet.sab-lab.com/uploads/animal/images/disease/1589378244.143.png"
                },
                {
                    "file": "http://domvet.sab-lab.com/uploads/animal/images/disease/1589378244.2408.png"
                },
                {
                    "file": "http://domvet.sab-lab.com/uploads/animal/images/disease/1589378244.2507.png"
                },
                {
                    "file": "http://domvet.sab-lab.com/uploads/animal/images/disease/1589378334.8469.png"
                },
                {
                    "file": "http://domvet.sab-lab.com/uploads/animal/images/disease/1589378334.8686.png"
                },
                {
                    "file": "http://domvet.sab-lab.com/uploads/animal/images/disease/1589378334.8777.png"
                }
            ],
            "_links": []
        }
    ]
}*/
@Parcelize
data class NDisease(
    @SerializedName("animal") val animal: NAnimal? = null,
    @SerializedName("disease_id") val diseaseId: String? = "",
    @SerializedName("consumerFullName") val consumerFullName: String? = "",
    @SerializedName("created_at") val created_at: String? = "",
    @SerializedName("status") val status: Int? = 0,
    @SerializedName("come_at") val come_at: String? = "",
    @SerializedName("comment") val comment: String? = "",
    @SerializedName("info") val info: NDiseaseInfo? = null,
    @SerializedName("detail") val detail: NDiseaseDetail? = null,
    @SerializedName("doctor") val diseaseDoctor: NDiseaseDoctor? = null,
    @SerializedName("photos") val photos: List<NPhoto>? = emptyList()
) : Parcelable {
    companion object {
        val DIFF_UTILL = object : DiffUtil.ItemCallback<NDisease>() {
            override fun areItemsTheSame(oldItem: NDisease, newItem: NDisease) = oldItem == newItem

            override fun areContentsTheSame(oldItem: NDisease, newItem: NDisease) =
                oldItem.diseaseId == newItem.diseaseId

        }
    }
}