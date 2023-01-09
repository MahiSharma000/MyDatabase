package com.example.mydatabase.ui

import android.content.ClipData
import android.icu.text.CaseMap.Title
import androidx.lifecycle.*
import com.example.mydatabase.data.Task
import com.example.mydatabase.data.TaskDao
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao:TaskDao) : ViewModel() {

    val taskList:LiveData<List<Task>> = taskDao.getAlltasks().asLiveData()

    private fun insert(task: Task){
        viewModelScope.launch { taskDao.insert(task) }
    }

    private fun update(task: Task){
        viewModelScope.launch { taskDao.update(task) }
    }


    private fun delete(task: Task){
        viewModelScope.launch { taskDao.delete(task) }
    }

    fun addTask(title:String,isComplete:Boolean,rank:Int=0):Boolean{
        val task=Task(title = title, isComplete = isComplete, rank = rank)
        if(isTaskValid(task)){
            insert(task)
            return true
        }
        return false
    }

    fun isTaskValid(task: Task):Boolean{
        return task.title.isNotBlank()
    }
}

class InventoryViewModelFactory(private val taskDao: TaskDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskViewModel::class.java)){
            @Suppress("UNCHCKED_CAST")
            return TaskViewModel(taskDao) as T
        }
        throw java.lang.IllegalArgumentException("unknown viewModel")
    }
}