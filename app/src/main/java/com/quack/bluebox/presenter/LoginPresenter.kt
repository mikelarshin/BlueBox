package com.quack.bluebox.presenter

import com.quack.bluebox.model.User
import com.quack.bluebox.model.isUserUnique
import com.quack.bluebox.model.postUser
import com.quack.bluebox.model.toLang
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    fun pressRegister(langCode: String, username: String) {
        val newUser = User(toLang(langCode), username)
        if (isUserUnique(newUser)) {
            postUser(newUser)
            viewState.finishRegister()
        } else {
            viewState.userNotUnique()
        }
    }
}