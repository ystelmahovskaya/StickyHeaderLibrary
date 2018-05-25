package com.example.headerslibrary

import android.graphics.Canvas
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * Created by ystelmak on 2018-04-19.
 */


class HeaderDecorator : RecyclerView.ItemDecoration {
    private val TAG = this.javaClass.simpleName

    private val headerOffset: Int
    private val sticky: Boolean
    private var stickyOffset = 0
    private val sectionCallback: SectionCallback
    internal lateinit var stickedView: View
    private var stickedHeaderText: String = ""
    private var stickedHeaderSubText: String = ""

    private var headerView: View? = null
    private var headerTextView: TextView? = null
    private var headerSubTextView: TextView? = null
    internal lateinit var stickedHeaderTextView: TextView
    private var stickedHeaderSubTextView: TextView? = null
    private var isAutoheader = true

    private var headerLayoutid: Int = 0
    private var idHeaderTextView: Int = 0
    private var idHeaderSubTextView: Int? = 0
    private var headerHeight: Int = 0
    private var fontSize: Float = 0.0f


    constructor(headerHeight: Int, fontSize: Float, sticky: Boolean, sectionCallback: SectionCallback) {
        this.headerOffset = headerHeight
        this.fontSize = fontSize
        this.headerHeight = headerHeight
        this.sticky = sticky
        this.sectionCallback = sectionCallback
        idHeaderTextView = R.id.list_item_section_text
        idHeaderSubTextView = R.id.list_item_section_subtext
    }

    constructor(headerLayoutid: Int, idHeaderTextView: Int, idHeaderSubTextView: Int?, height: Int, sticky: Boolean, sectionCallback: SectionCallback) {
        isAutoheader = false
        this.headerLayoutid = headerLayoutid
        this.headerOffset = height
        this.idHeaderTextView = idHeaderTextView
        this.idHeaderSubTextView = idHeaderSubTextView
        this.sticky = sticky
        this.sectionCallback = sectionCallback
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val pos = parent.getChildAdapterPosition(view)
        if (sectionCallback.isSection(pos)) {
            outRect.top = headerOffset
        }
    }

    private fun inflateHeaderView(parent: RecyclerView): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.recycler_section_header, parent, false)
    }

    private fun inflateHeaderView(parent: RecyclerView, resource: Int): View {
        return LayoutInflater.from(parent.context).inflate(resource, parent, false)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)


        if (headerView == null) {
            if (isAutoheader) {
                configureAutoHeader(parent)
            } else {
                configureCustomHeader(parent)
            }
        }

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val index = parent.getChildAdapterPosition(child)
            val title = sectionCallback.getSectionHeader(index)
            val subTitle: String? = sectionCallback.getSectionSubHeader(index)
            val isSection = sectionCallback.isSection(index)


            if (stickedHeaderText != title && isSection) {
                try {
                    headerTextView?.text = title
                    headerSubTextView?.text = subTitle
                } catch (e: Exception) {
                    Log.d(TAG, e.localizedMessage)
                }
                if (i == 0 && sticky) {
                    stickedHeaderText = title
                    stickedHeaderSubText = subTitle ?: ""
                }
            }
            if (i == 0 && !isSection && !stickedHeaderText.equals(title)) {
                var reverseIndex = index
                do {
                    reverseIndex--
                } while (!sectionCallback.isSection(reverseIndex))
                headerTextView?.text = sectionCallback.getSectionHeader(reverseIndex)
                headerSubTextView?.text = sectionCallback.getSectionSubHeader(reverseIndex) ?: ""
                stickedHeaderText = sectionCallback.getSectionHeader(reverseIndex)
                stickedHeaderSubText = sectionCallback.getSectionSubHeader(reverseIndex) ?: ""
            }
            headerView?.let {
                adjustLayoutSize(it, parent)
                drawHeader(c, child, it, isSection, i)
            }

            if (sticky) {
                stickedView = headerView as View

                try {
                    stickedHeaderTextView = stickedView.findViewById<TextView>(idHeaderTextView)
                    stickedHeaderTextView.text = stickedHeaderText
                    idHeaderSubTextView?.let {
                        stickedHeaderSubTextView = stickedView.findViewById<TextView>(it)
                        stickedHeaderSubTextView?.text = stickedHeaderSubText
                    }
                } catch (e: Exception) {
                    Log.d(TAG, e.localizedMessage)
                }
                if (isSection && index >= 0 && child.top <= stickedView.height * 2) {
                    if (child.top - stickedView.height * 2 >= stickyOffset) {

                        if (stickedHeaderText == title) {
                            if (index > 0) {
                                var reverseIndex = index
                                do {
                                    reverseIndex--
                                } while (!sectionCallback.isSection(reverseIndex))
                                stickedHeaderText = sectionCallback.getSectionHeader(reverseIndex)
                                stickedHeaderSubText = sectionCallback.getSectionSubHeader(reverseIndex) ?: ""
                            } else {
                                stickedHeaderText = sectionCallback.getSectionHeader(index)
                                stickedHeaderSubText = sectionCallback.getSectionSubHeader(index) ?: ""
                            }
                        }
                    }

                    stickyOffset = child.top - stickedView.height * 2
                    adjustLayoutSize(stickedView, parent)
                    c.save()
                    c.translate(0f, stickyOffset.toFloat())
                    stickedView.draw(c)
                    c.restore()
                }
            }

        }
    }


    private fun configureAutoHeader(parent: RecyclerView) {
        headerView = inflateHeaderView(parent)
        val params = headerView?.layoutParams
        params?.height = headerHeight
        headerView?.layoutParams = params

        headerTextView = headerView?.findViewById<TextView>(idHeaderTextView)
        headerTextView?.textSize = fontSize

        idHeaderSubTextView?.let {
            headerSubTextView = headerView?.findViewById<TextView>(it)
            headerSubTextView?.text = stickedHeaderSubText
        }
    }


    private fun configureCustomHeader(parent: RecyclerView) {
        try {
            headerView = inflateHeaderView(parent, headerLayoutid)
            headerTextView = headerView?.findViewById<TextView>(idHeaderTextView)
            idHeaderSubTextView?.let {
                headerSubTextView = headerView?.findViewById<TextView>(it)
            }
        } catch (e: Exception) {
            Log.d(TAG, e.localizedMessage)
        }
    }


    private fun drawHeader(c: Canvas, child: View, headerView: View, isSection: Boolean, index: Int) {
        if (!isSection && index != 0)
            return

        val off = Math.max(0, child.top - headerView.height)
        c.save()
        if (sticky) {
            c.translate(0f, off.toFloat())
        } else {
            c.translate(0f, (child.top - headerView.height).toFloat())
        }
        headerView.draw(c)
        c.restore()
    }

    private fun adjustLayoutSize(view: View, parent: ViewGroup) {
        val widthSpec = View.MeasureSpec.makeMeasureSpec(parent.width,
                View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(parent.height,
                View.MeasureSpec.UNSPECIFIED)

        val childWidth = ViewGroup.getChildMeasureSpec(widthSpec,
                parent.paddingLeft + parent.paddingRight,
                view.layoutParams.width)
        val childHeight = ViewGroup.getChildMeasureSpec(heightSpec,
                parent.paddingTop + parent.paddingBottom,
                view.layoutParams.height)

        view.measure(childWidth, childHeight)

        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    }

}