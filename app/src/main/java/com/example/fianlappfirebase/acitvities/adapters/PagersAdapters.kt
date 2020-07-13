package com.example.fianlappfirebase.acitvities.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagersAdapters (fm:FragmentManager) :FragmentPagerAdapter(fm) {
    private  val fragmenlist=ArrayList<Fragment>()


    override fun getItem(position: Int) =fragmenlist[position]


    override fun getCount()=fragmenlist.size


    fun ddFragment (fragment: Fragment)=fragmenlist.add(fragment)
}