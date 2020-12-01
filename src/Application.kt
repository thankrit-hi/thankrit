package com.thankrit

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.cio.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

// ipconfig
fun Application.module() {

    install(DefaultHeaders)
    install(CallLogging)

    install(ContentNegotiation) {
        gson {
        }
    }

    install(Routing) {
        get("/api/krit/test") {
            val dru = "dru sp"
            call.respond(dru)
        }

        post("/api/krit/testtest") {
            val ok = "OK success"
            call.respond(ok)
        }

        get("/api/krit/json-basic") {
            val response = """{"name": "Kate", "pet": {"dog": "Corgi", "cat": "Persian"}}"""
            call.respond(response)
        }

        get("/api/krit/user") {
            val user = User(name = "krit", age = 21)
            val response = UserResponse(success = true, message = "User success", user = user)
            call.respond(response)
        }

        get(path = "/api/krit/covid") {
            val covild = Covid(
                Confirmed = 4008,
                Recovered = 3811,
                Hospitalized = 137,
                Deaths = 60,
                NewConfirmed = 10,
                NewRecovered = 8,
                NewHospitalized = 2,
                NewDeaths = 0,
                UpdateDate = "01/12/2020 17:22",
                Source = "https://covid19.th-stat.com/",
                DevBy = "https://www.kidkarnmai.com/",
                SeverBy = "https://smilehost.asia/")
            call.respond(covild)
        }
    }
}

data class UserResponse(
    val success: Boolean = false,
    val message: String? = null,
    val user: User? = null,
)

data class User(
    val name: String? = null,
    val age: Int? = null,
)

data class Covid(
    val Confirmed: Int? = null,
    val Recovered: Int? = null,
    val Hospitalized: Int? = null,
    val Deaths: Int? = null,
    val NewConfirmed: Int? = null,
    val NewRecovered: Int? = null,
    val NewHospitalized: Int? = null,
    val NewDeaths: Int? = null,
    val UpdateDate: String? = null,
    val Source: String? = null,
    val DevBy: String? = null,
    val SeverBy: String? = null,


    )
