package model

import kotlinx.serialization.Serializable


@Serializable
data class Prediction(
    val count : Int,
    val name : String,
    val age : Int
)
