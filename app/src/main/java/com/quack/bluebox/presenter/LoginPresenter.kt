package com.quack.bluebox.presenter

import com.quack.bluebox.model.User
import com.quack.bluebox.model.sendUser
import com.quack.bluebox.model.toLang
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    fun pressRegister(langCode: String, username: String) {
        val newUser = User(toLang(langCode), username)
        sendUser(newUser)
    }
}