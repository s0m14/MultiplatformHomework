package model

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.JsonConfiguration

class ModelView() {

    var age = 0
    var name : String? = null
    var count = 0

    val httpClient : HttpClient = HttpClient(OkHttp){
        install(ContentNegotiation){
            json()
        }
    }

    suspend fun request(names : String){
        age = 0
        name = null
        count = 0
        val response = httpClient.get("https://api.agify.io/?name=$names").body<Prediction>()
        name = response.name
        age = response.age
        count = response.count
        }

    fun showAge() : Int{
        return age
    }

    fun showName() : String? {
        return name
    }
}