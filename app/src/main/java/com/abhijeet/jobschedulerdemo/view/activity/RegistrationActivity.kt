package com.abhijeet.jobschedulerdemo.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.abhijeet.jobschedulerdemo.R
import com.abhijeet.jobschedulerdemo.databinding.ActivityRegistrationBinding
import com.abhijeet.jobschedulerdemo.mvvm.viewmodel.RegistrationViewModel

import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    var viewModel: RegistrationViewModel? = null
    var binding: ActivityRegistrationBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registration)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);

        initView()
        initEvents()


    }

    private fun initView() {
        toolbar.title = "Registration"
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)


        viewModel = ViewModelProviders.of(this).get(RegistrationViewModel::class.java)
        viewModel?.init()
        binding?.model = viewModel
        // binding.setsetModel(viewModel);

    }

    private fun initEvents() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        viewModel?.buttonClick?.observe(this, Observer { registrationRecords ->
            Toast.makeText(applicationContext, "Email " + registrationRecords?.email + ", Password " + registrationRecords?.mobileNo,
                    Toast.LENGTH_SHORT).show()
        })

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
