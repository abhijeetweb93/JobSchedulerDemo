package com.abhijeet.jobschedulerdemo.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.text.TextUtils
import android.view.View
import android.widget.EditText

import com.abhijeet.jobschedulerdemo.mvvm.model.RegisterationData
import com.abhijeet.jobschedulerdemo.local_db.table.RegistrationRecords

class RegistrationViewModel : ViewModel() {

    var login: RegisterationData? = null
    // private set
    var emailOnFocusChangeListener: View.OnFocusChangeListener? = null
        get() = field
        set(value) {
            field = value
        }



    var mobileOnFocusChangeListener: View.OnFocusChangeListener? = null
        get() = field
        set(value) {
            field = value
        }
    //  private set
    val buttonClick = MutableLiveData<RegistrationRecords>()


    fun init() {
        login = RegisterationData()
        login!!.email = "abhijeet@a.com"
        login!!.gender = "Male"
        login!!.name = "Abhijeet"

        emailOnFocusChangeListener = View.OnFocusChangeListener { view, focused ->
            val et = view as EditText
            if (et.text.length > 0 && !focused) {
                login!!.isEmailValid(true)
            }
        }

        mobileOnFocusChangeListener = View.OnFocusChangeListener { view, focused ->
            val et = view as EditText
            if (et.text.length > 0 && !focused) {
                login!!.isMobileNoValid(true)
            }
        }
    }

    fun onSaveButtonClick() {
        if (isValid(login)) {
            buttonClick.value = login
        }
    }

    fun isValid(registrationRecords: RegistrationRecords?): Boolean {
        if (TextUtils.isEmpty(registrationRecords!!.name)) {
            return false
        } else if (TextUtils.isEmpty(registrationRecords.gender)) {
            return false
        } else if (TextUtils.isEmpty(registrationRecords.city)) {
            return false

        }
        return true
    }


    @BindingAdapter("error")
    fun setError(editText: EditText, strOrResId: Any) {
        if (strOrResId is Int) {
            editText.error = editText.context.getString(strOrResId)
        } else {
            editText.error = strOrResId as String
        }

    }

    @BindingAdapter("bind:onFocus")
    // @BindingAdapter("onFocus")
    fun bindFocusChange(editText: EditText, onFocusChangeListener: View.OnFocusChangeListener) {
        if (editText.onFocusChangeListener == null) {
            editText.onFocusChangeListener = onFocusChangeListener
        }
    }



}

