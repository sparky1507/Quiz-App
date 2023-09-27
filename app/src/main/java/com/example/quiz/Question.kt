package com.example.quiz

data class Question(
    val id: Int,
    val ques: String,
    val img: Int,
    val optionone : String,
    val optiontwo : String,
    val optithree : String,
    val optionfour : String,
    val correctoption : Int
)
