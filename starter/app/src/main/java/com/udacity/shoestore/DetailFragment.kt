package com.udacity.shoestore

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val viewModel: ListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentDetailBinding =  DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )

        // cancel button - go back to shoe list
        binding.cancelButton.setOnClickListener {
                view: View -> view.findNavController().navigateUp()
        }

        binding.listingViewModel = viewModel

        return binding.root

    }
}