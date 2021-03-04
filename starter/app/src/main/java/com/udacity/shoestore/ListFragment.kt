package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private val viewModel: ListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )

        binding.addShoeButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList: MutableList<Shoe> ->
            for (shoe in shoeList) {
                val textView = View.inflate(requireContext(), R.layout.textview_layout, null) as TextView
                textView.text = "Name: ${shoe.name}\nCompany: ${shoe.company}\nSize: ${shoe.size}\nDescription: ${shoe.description} "
                binding.shoeListHost.addView(textView)
            }
        })

        return binding.root
    }


}