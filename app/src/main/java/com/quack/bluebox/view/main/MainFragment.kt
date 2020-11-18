package com.quack.bluebox.view.main

import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.quack.bluebox.R
import com.quack.bluebox.model.User
import com.quack.bluebox.presenter.MainPresenter
import com.quack.bluebox.presenter.MainView
import com.quack.bluebox.view.MvpFragmentX
import kotlinx.android.synthetic.main.fragment_main.view.*
import moxy.ktx.moxyPresenter

class MainFragment : MvpFragmentX(R.layout.fragment_main), MainView {

    private val presenter by moxyPresenter { MainPresenter() }
    private val adapter = ContactRecyclerAdapter()

    override fun setupLayout() {
        setupRecycler()

        layout.searcher.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?) = true
            override fun onQueryTextChange(p0: String?): Boolean {
                p0?.let { presenter.searchLineChange(p0) }
                return true
            }
        })
    }

    override fun showSearchResult(users: List<User>) {
        adapter.fill(users)
    }

    private fun setupRecycler() {
        layout.contactRecycler.adapter = adapter
        layout.contactRecycler.layoutManager = LinearLayoutManager(activity)
    }
}