package com.quack.bluebox.view.call

import com.quack.bluebox.R
import com.quack.bluebox.view.main.ContactRecyclerAdapter
import com.quack.bluebox.view.MvpFragmentX

class CallFragment : MvpFragmentX(R.layout.fragment_call) {

//    private val presenter by moxyPresenter { MainPresenter() }
    private val adapter = ContactRecyclerAdapter()

    override fun setupLayout() {}
}