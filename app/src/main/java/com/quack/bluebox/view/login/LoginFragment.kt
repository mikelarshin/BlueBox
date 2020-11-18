package com.quack.bluebox.view.login

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.quack.bluebox.R
import com.quack.bluebox.presenter.LoginPresenter
import com.quack.bluebox.presenter.LoginView
import com.quack.bluebox.view.MvpFragmentX
import kotlinx.android.synthetic.main.fragment_login.view.*
import moxy.ktx.moxyPresenter


@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
class LoginFragment : MvpFragmentX(R.layout.fragment_login), LoginView {

    private val presenter by moxyPresenter { LoginPresenter() }

    override fun setupLayout() {
        layout.register_button.setOnClickListener {
            hideKeyboard()
            val pos = layout.lang_spinner.selectedItemPosition
            val langCode = resources.getStringArray(R.array.lang_codes)[pos]

            presenter.pressRegister(langCode, layout.username_login.text.toString())
        }
    }

    override fun userNotUnique() {
        layout.username_login.hint = resources.getString(R.string.username_exists)
    }

    override fun finishRegister() {
        val action = LoginFragmentDirections.fromRegisterToMain()
        findNavController().navigate(action)
    }

    fun hideKeyboard() {
        val imm: InputMethodManager = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity?.currentFocus ?: View(activity)

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}