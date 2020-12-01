package com.thankrit

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
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
