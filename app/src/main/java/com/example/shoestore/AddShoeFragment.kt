package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentAddShoeBinding
import com.example.shoestore.models.Shoe

class AddShoeFragment : Fragment() {

    private lateinit var binding : FragmentAddShoeBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddShoeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = shoeViewModel
            saveButton.setOnClickListener {
                shoeViewModel.saveShoe()
                findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
            }
            cancelButton.setOnClickListener {
                findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
            }
        }

    }

}