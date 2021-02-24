package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var listingViewModel: ListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listingViewModel = ViewModelProvider(this).get(ListingViewModel::class.java)

        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )

        // cancel button - go back to shoe list
        binding.cancelButton.setOnClickListener {
                view: View -> view.findNavController().navigateUp()
        }

        // save button - add a new shoe and go back to shoe list
        binding.saveButton.setOnClickListener {
            listingViewModel.name.value = binding.editTextTextPersonName.text.toString()
            listingViewModel.company.value = binding.editTextTextPersonName2.text.toString()
            listingViewModel.size.value = binding.editTextNumberDecimal.text.toString()
            listingViewModel.description.value = binding.editTextTextPersonName3.text.toString()
            listingViewModel.afterUIUpdate()
        }

        listingViewModel.onUpdate.observe(viewLifecycleOwner, Observer {
            updated -> if (updated) {
                binding.cancelButton.performClick()
            }
        })

        return binding.root
    }

}