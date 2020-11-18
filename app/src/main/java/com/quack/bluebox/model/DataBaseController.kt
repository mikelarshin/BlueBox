package com.quack.bluebox.model

fun postUser(user: User) {} // TODO()
fun isUserUnique(user: User): Boolean = true // TODO()
fun getSimilarUsers(name: String): List<User> =
    listOf(
        User(Language.English, "Миша"),
        User(Language.Russian, "Александр Чайковский")) // TODO()