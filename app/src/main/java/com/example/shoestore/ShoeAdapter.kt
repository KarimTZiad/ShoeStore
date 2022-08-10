package com.example.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.databinding.ASingleShoeItemBinding
import com.example.shoestore.models.Shoe

class ShoeAdapter() : RecyclerView.Adapter<ShoeAdapter.ViewHolder>(){

    private var shoesList = emptyList<Shoe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ASingleShoeItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = shoesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shoesList[position])
    }

    class ViewHolder(private val binding: ASingleShoeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shoeItem: Shoe) {
            binding.shoe = shoeItem
            binding.detailsButton.setOnClickListener{
                itemView.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(shoeItem))
            }
        }
    }

    fun setData(newShoes: List<Shoe>){
        shoesList = newShoes
        notifyDataSetChanged()
    }
}