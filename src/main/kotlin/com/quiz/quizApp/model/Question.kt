package com.quiz.quizApp.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="questions")
class Question(@Id
               @GeneratedValue(strategy = GenerationType.SEQUENCE)
               val id: Int =0,
               val category:String,
               val difficulty:String,
               val option1:String,
               val option2:String,
               val option3:String,
               val option4:String,
               val question:String,
               val answer:String


)



