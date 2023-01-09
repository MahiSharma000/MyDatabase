package com.example.mydatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val title: String,


    @ColumnInfo(name = "isCompleted")
    val isComplete: Boolean=false,


    val rank:Int=0,

    @ColumnInfo(name="created_At")
    val created_At:Long=System.currentTimeMillis()

)