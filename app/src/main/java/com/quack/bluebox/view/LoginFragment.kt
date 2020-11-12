package com.quack.bluebox.view

import com.quack.bluebox.R
import com.quack.bluebox.presenter.LoginPresenter
import com.quack.bluebox.presenter.LoginView
import moxy.ktx.moxyPresenter

class LoginFragment : MvpFragmentX(R.layout.fragment_login), LoginView {

    private val presenter by moxyPresenter { LoginPresenter() }

    override fun setupLayout() {}
}