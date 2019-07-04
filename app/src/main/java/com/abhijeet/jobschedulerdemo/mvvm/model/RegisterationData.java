package com.abhijeet.jobschedulerdemo.mvvm.model;

import android.databinding.ObservableField;
import android.text.TextUtils;

import com.abhijeet.jobschedulerdemo.local_db.table.RegistrationRecords;

public class RegisterationData extends RegistrationRecords {
    public ObservableField<String> emailError = new ObservableField<>();
    public ObservableField<String> mobileNoError = new ObservableField<>();

    public boolean isEmailValid(boolean setMessage) {
        // Minimum a@b.c
        if (getEmail() != null && getEmail().length() > 5) {
            int indexOfAt = getEmail().indexOf("@");
            int indexOfDot = getEmail().lastIndexOf(".");
            if (indexOfAt > 0 && indexOfDot > indexOfAt && indexOfDot < getEmail().length() - 1) {
                emailError.set(null);
                return true;
            } else {
                if (setMessage)
                    emailError.set("error_format_invalid");
                return false;
            }
        }
        if (setMessage)
            emailError.set("error_too_short");
        return false;
    }

    public boolean isMobileNoValid(boolean setMessage) {
        if (TextUtils.isEmpty(getMobileNo())) {
            mobileNoError.set(null);
            return true;
        }if (!TextUtils.isEmpty(getMobileNo()) && getMobileNo().length() ==10) {
            mobileNoError.set(null);
            return true;
        }else if(TextUtils.isEmpty(getMobileNo())){
            return true;
        }
        if (setMessage)
            mobileNoError.set("error_too_short");
        return false;
    }


}
