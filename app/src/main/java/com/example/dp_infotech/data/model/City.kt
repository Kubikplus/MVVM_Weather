package com.example.dp_infotech.data.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id")@Expose var id:String? = null,
    @SerializedName("name")@Expose var name:String? = null,
    @SerializedName("state")@Expose var state:String? = null,
    @SerializedName("country")@Expose var country:String? = null,
    // add coords
)
