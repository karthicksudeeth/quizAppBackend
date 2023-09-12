package com.quiz.quizApp.Controller

import com.quiz.quizApp.Service.QuizService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("quiz")
class QuizController(val quizService: QuizService) {

    @PostMapping("create")
    fun createQuiz(@RequestParam category:String ,@RequestParam num:Int, @RequestParam title:String):ResponseEntity<String> {
        return quizService.createQuiz(category,num,title)
    }
}