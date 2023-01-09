package com.yusufcancakmak.wallpaperapp.models


import com.google.gson.annotations.SerializedName

data class Paggination(
    @SerializedName("next")
    val next: Next
)