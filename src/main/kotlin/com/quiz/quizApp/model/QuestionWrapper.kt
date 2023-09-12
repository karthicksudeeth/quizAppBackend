package com.quiz.quizApp.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data

@Data
class QuestionWrapper(@Id
                      @GeneratedValue(strategy = GenerationType.SEQUENCE)
                      val id: Int =0,
                      val option1:String,
                      val option2:String,
                      val option3:String,
                      val option4:String,
                      val question:String)