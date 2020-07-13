package com.example.mylibrery

import Interfacess.Itoolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class toolbarActy : AppCompatActivity(),Itoolbar {

  protected   var  toolbar :Toolbar ?=null


    override fun ToLoadToolbar(toolbar: Toolbar?) {
        this.toolbar =toolbar
        toolbar.let {setSupportActionBar(toolbar)  }

    }

    override fun enableHomeDysplai(value: Boolean) {

        supportActionBar?.setDisplayHomeAsUpEnabled(value)


    }
}




