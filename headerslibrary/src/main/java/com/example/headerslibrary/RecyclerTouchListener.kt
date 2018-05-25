package com.example.headerslibrary


import android.support.v7.widget.RecyclerView
import android.view.MotionEvent

/**
 * Created by ystelmak on 2018-05-15.
 */
class RecyclerTouchListener : RecyclerView.OnItemTouchListener {
    private var clickListener: ClickListener? = null
    internal var headerheight: Int = 0

    constructor (headerHeight: Int, clickListener: ClickListener?) {
        this.clickListener = clickListener
        this.headerheight = headerHeight
    }


    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        var intercept = false;
        if (e.getAction() == MotionEvent.ACTION_UP) {
            val child = rv.findChildViewUnder(e.x, e.y)

            if (e.y < headerheight && child != null) {
                clickListener!!.onStickedHeaderClicked(rv.getChildPosition(child))
                intercept = true
            }
            if (child != null && e.y > headerheight) {
                intercept = false
            }
            if (child == null) {
                val childUnder = rv.findChildViewUnder(e.x, e.y + headerheight)
                if (childUnder != null) {
                    clickListener!!.onHeaderClick(rv.getChildPosition(childUnder))
                    intercept = true
                }
            }
        }
        return intercept

    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }


    interface ClickListener {

        fun onStickedHeaderClicked(position: Int)

        fun onHeaderClick(position: Int)

    }
}