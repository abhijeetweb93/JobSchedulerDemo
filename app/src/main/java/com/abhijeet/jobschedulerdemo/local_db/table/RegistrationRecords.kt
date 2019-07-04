package com.abhijeet.jobschedulerdemo.local_db.table

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BaseObservable

import java.io.Serializable


@Entity(tableName = "registration_records")
open class RegistrationRecords : BaseObservable, Serializable {

    /*
     * Getters and Setters
     * */

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "gender")
    var gender: String? = null

    @ColumnInfo(name = "date_of_birth")
    var dateOfBirth: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null

    @ColumnInfo(name = "mobile_no")
    var mobileNo: String? = null

    @ColumnInfo(name = "address")
    var address: String? = null

    @ColumnInfo(name = "city")
    var city: String? = null

    @ColumnInfo(name = "state")
    var state: String? = null

    @ColumnInfo(name = "pin")
    var pin: String? = null

    @ColumnInfo(name = "finished")
    var isFinished: Boolean = false

    constructor() {}

    constructor(id: Int, name: String, gender: String, dateOfBirth: String, email: String, mobileNo: String, address: String, city: String, state: String, pin: String, finished: Boolean) {
        this.id = id
        this.name = name
        this.gender = gender
        this.dateOfBirth = dateOfBirth
        this.email = email
        this.mobileNo = mobileNo
        this.address = address
        this.city = city
        this.state = state
        this.pin = pin
        this.isFinished = finished
    }
}