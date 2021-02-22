package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel: ViewModel() {
    private var _listOfShoes = MutableLiveData<Shoe>()


}