package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentAddShoeBinding
import com.example.shoestore.models.Shoe

class AddShoeFragment : Fragment() {

    private lateinit var binding : FragmentAddShoeBinding

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
        binding.saveButton.setOnClickListener {
            val shoe = Shoe(
                binding.shoeNameText.text.toString(),
                binding.sizeText.text.toString().toDouble(),
                binding.companyNameText.text.toString(),
                binding.descText.text.toString(),
                listOf<Int>()
            )
            findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment(shoe))
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment(null))
        }
    }

}