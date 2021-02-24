package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel: ViewModel() {
    private var _listOfShoes = MutableLiveData<Shoe>()

    var name = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var size = MutableLiveData<String>()
    var description = MutableLiveData<String>()
    var onUpdate = MutableLiveData<Boolean>()

    // called from the ListFragment after the UI is updated
    fun afterUIUpdate() {
        Log.i("afterUIUpdate", "Save button was pressed!")
        onUpdate.value = true
    }

}