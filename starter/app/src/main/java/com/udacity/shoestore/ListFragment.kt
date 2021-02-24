package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_instruction.view.*

class ListFragment : Fragment() {
    lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )
        binding.addShoeButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(
                R.id.action_listFragment_to_detailFragment
            )
        )

        return binding.root
    }

}