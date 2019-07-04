package com.abhijeet.jobschedulerdemo.local_db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.abhijeet.jobschedulerdemo.local_db.table.RegistrationRecords;

@Database(entities = {RegistrationRecords.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RegistrationRecordsDao registrationRecordsDao();
}

