package com.example.headerslibrary

/**
 * Created by ystelmak on 2018-05-03.
 */

interface SectionCallback {
    fun isSection(position: Int): Boolean
    fun getSectionHeader(position: Int): String
    fun getSectionSubHeader(position: Int): String?
}
