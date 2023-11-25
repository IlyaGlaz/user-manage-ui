package api

import User
import kotlinx.browser.window
import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun getUser(id: Int): User {
    val response = window
        .fetch("https://localhost:9500/users/$id")
        .await()
        .text()
        .await()
    return Json.decodeFromString(response)
}

suspend fun getAllUsers(): List<User> = coroutineScope {
    (1..25).map { id ->
        async {
            getUser(id)
        }
    }.awaitAll()
}
