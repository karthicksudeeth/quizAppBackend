package com.quiz.quizApp.dao

import com.quiz.quizApp.model.Quiz
import org.springframework.data.jpa.repository.JpaRepository

interface QuizDao:JpaRepository<Quiz,Integer> {
}