package com.quiz.quizApp.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import lombok.Data

@Entity
@Data
class Quiz(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id:Int,
           var title:String,
           @ManyToMany
           var question:List<Question>) {

}