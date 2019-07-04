package com.abhijeet.jobschedulerdemo.local_db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.abhijeet.jobschedulerdemo.local_db.table.RegistrationRecords;

import java.util.List;

@Dao
interface RegistrationRecordsDao {

    @Query("SELECT * FROM registration_records")
    List<RegistrationRecords> getAllRecords();

    @Insert
    void insert(RegistrationRecords registrationRecords);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert1(RegistrationRecords registrationRecords);

    @Delete
    void delete(RegistrationRecords registrationRecords);

    @Update
    void update(RegistrationRecords registrationRecords);

    @Query("SELECT * FROM registration_records WHERE 'id' = :id ")
    List<RegistrationRecords> getRecord(int id);
}
