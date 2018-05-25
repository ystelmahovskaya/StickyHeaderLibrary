package com.example.yuliiastelmakhovska.stickyheaderlibrary.Fragments


import android.content.res.Resources
import android.os.Bundle

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.headerslibrary.HeaderDecorator
import com.example.headerslibrary.SectionCallback
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Models.Person
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Adapters.NameAdapter
import com.example.yuliiastelmakhovska.stickyheaderlibrary.R
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Helpers.*
import java.util.Collections

val Float.dp: Float
    get() = (this / Resources.getSystem().displayMetrics.density).toFloat()
class NamesCountListFragment : Fragment() {

    private val people: List<Person>
        get() {
            val personRepo = Repo()
            val people = personRepo.people
            Collections.sort(people)
            return people
        }

    private fun getSectionCallback(people: List<Person>): SectionCallback {

        return object : SectionCallback {

            override fun isSection(position: Int): Boolean {
                return position == 0 || people[position].lastName[0] != people[position - 1].lastName[0] || people[position].lastName[1] != people[position - 1].lastName[1]
            }

            override fun getSectionHeader(position: Int): String {
                return people[position].lastName.subSequence(0, 2).toString()
            }

            override fun getSectionSubHeader(position: Int): String? {

                var counter = 0

                if (isSection(position)) {
                    for (i in position until people.size) {
                        if (isSection(i) && i != position) {
                            return counter.toString() + ""
                        }
                        counter++
                    }
                }
                return counter.toString() + ""

            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val recyclerView = view.findViewById<View>(R.id.recycler_view) as RecyclerView
        val orientation = LinearLayoutManager.VERTICAL
        val layoutManager = LinearLayoutManager(this.context, orientation, false)
        recyclerView.layoutManager = layoutManager

        val people = people
        val sectionItemDecoration = HeaderDecorator(resources.getDimensionPixelSize(R.dimen.recycler_test),
                resources.getDimension(R.dimen.font_small).dp,
                true, getSectionCallback(people))
        recyclerView.addItemDecoration(sectionItemDecoration)

        recyclerView.adapter = NameAdapter(layoutInflater, people as MutableList<Person>, R.layout.recycler_row)
        return view
    }



}
