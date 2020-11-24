package com.example.demo11_3

data class CupcakeReview(var name:String="", var url:String="") {
    fun suggestCupcakePlace(position:Int){
        setName(position)
        setUrl(position)
    }

    private fun setName(position:Int){
        when(position) {
            0 -> name = "T&Cakes"
            else -> name="Boulder Baked"
        }
    }

    private fun setUrl(position: Int){
        when (position){
            0 -> url="https://www.teeandcakes.com"
            else -> url = "https://www.boulderbaked.com"
        }
    }

}