package com.quiz.quizApp.dao

import com.quiz.quizApp.model.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface QuestionDao:JpaRepository<Question,Int> {

   fun findByCategory(category:String):List<Question>

   @Query("SELECT *FROM QUESTIONS Q WHERE CATEGORY=:category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
   fun findRandomQuestionsByCategory(category: String, num: Int): List<Question>

}