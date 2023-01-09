package com.example.mydatabase.ui

import android.app.Application
import com.example.mydatabase.data.TaskDatabase

class TodoApplication : Application(){
    val database: TaskDatabase by lazy { TaskDatabase.getDatabase(this) }

}