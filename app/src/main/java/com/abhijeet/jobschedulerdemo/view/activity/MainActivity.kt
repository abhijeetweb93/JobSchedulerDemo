package com.abhijeet.jobschedulerdemo.view.activity

import android.content.Intent
import com.abhijeet.jobschedulerdemo.databinding.ActivityMainBinding
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.abhijeet.jobschedulerdemo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var activity: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        activity = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        eventListionar()

    }


    fun initView() {

    }

    fun eventListionar() {
        fab?.setOnClickListener { _ ->
            intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }


}
