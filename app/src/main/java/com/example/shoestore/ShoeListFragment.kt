package com.example.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeViewModel: ShoeViewModel
    private val args : ShoeListFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        binding = FragmentShoeListBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        when(item.itemId){
            R.id.loginFragment ->
                navController.navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
            android.R.id.home ->
                navController.navigateUp()
        }
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoeViewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        if(args.shoe!=null){
            shoeViewModel.addShoe(args.shoe!!)
        }
        binding.shoeRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ShoeAdapter()
            shoeViewModel.readAllShoes.observe(viewLifecycleOwner, Observer {shoe ->
                (adapter as ShoeAdapter).setData(shoe)
            })
        }
        binding.addShoeFAB.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }
    }

}