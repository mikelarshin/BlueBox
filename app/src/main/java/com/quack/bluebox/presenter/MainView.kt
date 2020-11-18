package com.quack.bluebox.presenter

import com.quack.bluebox.model.User
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface MainView : MvpView {
    fun showSearchResult(users: List<User>)
}