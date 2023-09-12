package com.quiz.quizApp.Controller

import com.quiz.quizApp.model.Question
import com.quiz.quizApp.Service.QuestionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("question")
class QuestionController(private val service:QuestionService) {

    @GetMapping("allQuestions")
    fun getAllQuestions():ResponseEntity<List<Question>> {
        return service.getAllQuestions()
    }

    @GetMapping("category/{category}")
    fun getCategoryQuestions(@PathVariable category:String):ResponseEntity<List<Question>> =service.getCategoryQuestions(category)

    @PostMapping("add")
    fun addQuestion(@RequestBody question: Question):ResponseEntity<String> = service.addQuestion(question)

    @DeleteMapping("delete")
    fun deleteQuestion(@RequestBody question:Question):ResponseEntity<String> =service.deleteQuestion(question)

    @DeleteMapping("deleteById")
    fun deleteById(@RequestBody id:Int):ResponseEntity<String> = service.deleteById(id)

    @PutMapping("update")
    fun updateQuestion(@RequestBody question:Question):ResponseEntity<String> = service.updateQuestion(question)

}