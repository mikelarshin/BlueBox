package com.quack.bluebox.view

import android.os.Build
import androidx.annotation.RequiresApi
import com.quack.bluebox.R
import com.quack.bluebox.presenter.LoginPresenter
import com.quack.bluebox.presenter.LoginView
import kotlinx.android.synthetic.main.fragment_login.view.*
import moxy.ktx.moxyPresenter


@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
class LoginFragment : MvpFragmentX(R.layout.fragment_login), LoginView {

    private val presenter by moxyPresenter { LoginPresenter() }

    override fun setupLayout() {
        layout.register_button.setOnClickListener {
            val pos = layout.lang_spinner.selectedItemPosition
            val langCode = resources.getStringArray(R.array.lang_codes)[pos]

            presenter.pressRegister(langCode, layout.username.text.toString())
        }
    }
}