package com.example.yuliiastelmakhovska.stickyheaderlibrary.Fragments


import android.os.Build
import android.os.Bundle

import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.headerslibrary.HeaderDecorator


import com.example.headerslibrary.SectionCallback
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Adapters.TripAdapter
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Models.Trip
import com.example.yuliiastelmakhovska.stickyheaderlibrary.R
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Helpers.*
import java.util.Collections
import java.util.Comparator

/**
 * Created by ystelmak on 2018-04-25.
 */

class DateAmountListFragment : Fragment() {
    private val trips: List<Trip>
        @RequiresApi(api = Build.VERSION_CODES.O)
        get() {
            val repo = Repo()
            val trips = repo.trips
            Collections.sort(trips) { o1, o2 -> o1.date.compareTo(o2.date) }
            return trips
        }

    private fun getSectionCallback(trips: List<Trip>): SectionCallback {

        return object : SectionCallback {

            override fun isSection(position: Int): Boolean {
                return position == 0 || trips[position].date != trips[position - 1].date
            }

            override fun getSectionHeader(position: Int): String {
                return trips[position].date.toString()
            }

            override fun getSectionSubHeader(position: Int): String {

                var counter = 0.0

                if (isSection(position)) {
                    for (i in position until trips.size) {
                        if (isSection(i) && i != position) {
                            return counter.toString() + ""
                        }
                        counter += trips[i].expenses
                    }
                }
                return counter.toString() + ""
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val recyclerView = view.findViewById<View>(R.id.recycler_view) as RecyclerView
        val orientation = LinearLayoutManager.VERTICAL
        val layoutManager = LinearLayoutManager(activity?.getBaseContext(), orientation, false)
        recyclerView.layoutManager = layoutManager

        val trips = trips

        val sectionItemDecoration = HeaderDecorator(resources.getDimensionPixelSize(R.dimen.recycler_test), 20f, true, getSectionCallback(trips))
        recyclerView.addItemDecoration(sectionItemDecoration)


        recyclerView.adapter = TripAdapter(layoutInflater, trips, R.layout.recycler_row)
        return view
    }


}
