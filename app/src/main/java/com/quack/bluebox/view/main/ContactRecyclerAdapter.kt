package com.quack.bluebox.view.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quack.bluebox.R
import com.quack.bluebox.model.User
import com.quack.bluebox.view.inflate
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactRecyclerAdapter : RecyclerView.Adapter<ContactRecyclerAdapter.ContactHolder>() {

    private val list: MutableList<User> = mutableListOf()

    fun fill(addList: List<User>) {
        list.clear()
        list.addAll(addList)
        notifyDataSetChanged()
    }

    class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactHolder(parent.inflate(R.layout.item_contact))

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val itemView = holder.itemView
        val item = list[position]

        itemView.username_contact.text = item.username
        itemView.lang_contact.text = item.language.name
    }

    override fun getItemCount() = list.size
}