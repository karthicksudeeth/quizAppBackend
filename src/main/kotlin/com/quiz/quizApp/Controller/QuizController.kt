package com.quiz.quizApp.Controller

import com.quiz.quizApp.Service.QuizService
import com.quiz.quizApp.model.Question
import com.quiz.quizApp.model.QuestionWrapper
import com.quiz.quizApp.model.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("quiz")
class QuizController(val quizService: QuizService) {

    @PostMapping("create")
    fun createQuiz(@RequestParam category:String ,@RequestParam num:Int, @RequestParam title:String):ResponseEntity<String> {
        return quizService.createQuiz(category,num,title)
    }

    @GetMapping("get/{id}")
    fun getQuizQuestions(@PathVariable id:Integer):ResponseEntity<List<QuestionWrapper>>{
        return quizService.getQuizQuestions(id)
    }

    @PostMapping("submit/{id}")
    fun submitQuiz(@PathVariable id:Integer, @RequestBody response:List<Response>):ResponseEntity<Int>{
        return quizService.calculateResult(id,response)
    }
}