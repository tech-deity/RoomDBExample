package com.example.roomdbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database :ContactDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext,
            ContactDB::class.java,
            "contactdb").build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(1,"vishal","12345671233"))
        }

    }
}