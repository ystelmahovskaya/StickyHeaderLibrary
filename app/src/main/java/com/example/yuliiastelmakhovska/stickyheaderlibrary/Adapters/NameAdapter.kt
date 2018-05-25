
/**
 * Created by ystelmak on 2018-05-03.
 */
package com.example.yuliiastelmakhovska.stickyheaderlibrary.Adapters

import android.support.annotation .LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.yuliiastelmakhovska.stickyheaderlibrary.Models.Person
import com.example.yuliiastelmakhovska.stickyheaderlibrary.R


class NameAdapter(private val layoutInflater: LayoutInflater, private val people: MutableList<Person>, @param:LayoutRes private val rowLayout: Int) : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = layoutInflater.inflate(rowLayout,
                parent,
                false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people[position]
        holder.fullName.text = person.fullName
//        holder.itemView.setOnClickListener {
//
//                people.removeAt(position)
//                notifyDataSetChanged()
//
//        }
    }

    override fun getItemCount(): Int {
        return people.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal val fullName: TextView

        init {
            fullName = view.findViewById<View>(R.id.full_name_tv) as TextView
        }
    }
}
