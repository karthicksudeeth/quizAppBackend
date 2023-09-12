package com.quiz.quizApp.Service

import com.quiz.quizApp.dao.QuestionDao
import com.quiz.quizApp.dao.QuizDao
import com.quiz.quizApp.model.Question
import com.quiz.quizApp.model.Quiz
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class QuizService(@Autowired val quizDao:QuizDao, @Autowired val questionDao:QuestionDao ){
    fun createQuiz(category: String, num: Int, title: String): ResponseEntity<String> {

        val questions:List<Question> = questionDao.findRandomQuestionsByCategory(category,num)
        var quiz: Quiz=Quiz(0,title,questions)
        quizDao.save(quiz)
        return ResponseEntity("Quiz created",HttpStatus.OK)
    }
}