package com.example.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.databinding.ASingleShoeItemBinding
import com.example.shoestore.models.Shoe

class ShoeAdapter(private val shoeViewModel: ShoeViewModel) : RecyclerView.Adapter<ShoeAdapter.ViewHolder>(){

    private var shoesList = emptyList<Shoe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ASingleShoeItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = shoesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shoesList[position], shoeViewModel)
    }

    class ViewHolder(private val binding: ASingleShoeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shoeItem: Shoe, shoeViewModel: ShoeViewModel) {
            binding.shoe = shoeItem
            binding.detailsButton.setOnClickListener{
                shoeViewModel.setShoeValues(shoeItem)
                itemView.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
            }
        }
    }

    fun setData(newShoes: List<Shoe>){
        shoesList = newShoes
        notifyDataSetChanged()
    }
}