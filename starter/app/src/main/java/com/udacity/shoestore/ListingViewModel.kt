package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Shoe(val name: String, val company: String, val size: String, val description: String)

class ListingViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun saveShoe(name: String?, company: String?, size: String?, description: String?) {
        _shoeList.value?.add(Shoe(name ?: "", company ?: "", size ?: "", description ?: "")
        )
    }

}