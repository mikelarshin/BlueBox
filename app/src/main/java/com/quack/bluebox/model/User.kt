package com.quack.bluebox.model

data class User(val language: Language, val username: String)

enum class Language(val langCode: String) {
    Russian("ru"),
    English("en")
}

fun toLang(langCode: String) = Language.values().find { it.langCode == langCode }!!