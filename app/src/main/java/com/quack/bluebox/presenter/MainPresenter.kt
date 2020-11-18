package com.quack.bluebox.presenter

import com.quack.bluebox.model.User
import com.quack.bluebox.model.getSimilarUsers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    fun searchLineChange(searchText: String) {
        val responseList: List<User> =
            if (searchText.isBlank())
                emptyList()
            else
                getSimilarUsers(searchText)

        viewState.showSearchResult(responseList)
    }
}