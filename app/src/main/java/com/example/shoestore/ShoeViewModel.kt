package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe
import kotlin.collections.ArrayList

class ShoeViewModel : ViewModel() {
    val readAllShoes: LiveData<ArrayList<Shoe>>
    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDesc = MutableLiveData<String>()
    val shoeImages = MutableLiveData<List<Int>>()

    init {
        val shoes = ArrayList<Shoe>()
        shoes.add(Shoe("Mario's Shoes",40.0, "Super Mario", "The shoes Mario wears. They're worn out from all his adventures and have a familiar smell...", listOf(R.drawable.mario_shoes)))
        shoes.add(Shoe("Sand Boots",39.0, "The Legend of Zelda", "Gerudo artisans modified these boots for life in the desert. The special soles distribute your body weight evenly so you can maintain your normal movement speed on sand.", listOf(R.drawable.zelda_sand_boots)))
        shoes.add(Shoe("Black Dakroniks", 35.0, "Splatoon", "A 2-star item produced by Zink and come with the primary ability Main Power Up. Higher chances of rolling Quick Super Jump and lower chances of rolling Quick Respawn",listOf(R.drawable.splatoon_black_dakroniks)))
        shoes.add(Shoe("Turbo Trainers",24.0,"Banjo Kazooie", "Run like the wind and walk on water! Yes, it's true—this fabulous footwear gives a burst of incredible speed, even allowing you to run across the surface of water when at top speed", listOf(R.drawable.banjo_kazooie_turbo_trainers)))
        shoes.add(Shoe("Long Fall Boots",37.0,"Portal", "These boots were designed to prevent human Test Subjects from injuring themselves when falling from great heights at any speed, even terminal velocity.", listOf(R.drawable.portal_long_fall_boots)))
        readAllShoes = MutableLiveData<ArrayList<Shoe>>(shoes)
    }

    fun saveShoe(){
        if( !(
                    shoeName.value!!.isBlank() || shoeCompany.value!!.isBlank()
                    || shoeSize.value!!.isBlank() || shoeDesc.value!!.isBlank())){
            readAllShoes.value?.add(Shoe(shoeName.value!!, shoeSize.value!!.toDouble(), shoeCompany.value!!, shoeDesc.value!!, listOf()))
            resetShoeValues()
        }
    }

    fun resetShoeValues(){
        shoeName.value = ""
        shoeCompany.value = ""
        shoeSize.value = ""
        shoeDesc.value = ""
        shoeImages.value = listOf()
    }

    fun setShoeValues(shoe : Shoe){
        shoeName.value = shoe.name
        shoeCompany.value = shoe.company
        shoeSize.value = shoe.size.toString()
        shoeDesc.value = shoe.description
        shoeImages.value = shoe.images
    }
}