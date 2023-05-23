package com.example.dp_infotech.data.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id") var id:String? = null,
    @SerializedName("name") var name:String? = null,
    var state:String? = null,
    var country:String? = null,
    val coord:Coord


)
