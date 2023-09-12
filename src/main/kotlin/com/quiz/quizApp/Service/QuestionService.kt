package com.quiz.quizApp.Service

import com.quiz.quizApp.model.Question
import com.quiz.quizApp.dao.QuestionDao
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class QuestionService(private val dao:QuestionDao){

        fun getAllQuestions(): ResponseEntity<List<Question>> {
                try {
                        return ResponseEntity(dao.findAll(), HttpStatus.OK)
                }
                catch (e:Exception){
                        e.printStackTrace()
                }
                return  ResponseEntity(ArrayList<Question>(),HttpStatus.BAD_REQUEST)
                }

        fun getCategoryQuestions(category: String): ResponseEntity<List<Question>> {
                try {
                        ResponseEntity(dao.findByCategory(category),HttpStatus.OK)
                }
                catch (e:Exception){
                        e.printStackTrace()
                }
                return ResponseEntity(ArrayList<Question>(),HttpStatus.BAD_REQUEST)
        }

        fun addQuestion(question: Question):ResponseEntity<String>{
                dao.save(question)
                return ResponseEntity("success",HttpStatus.CREATED)
        }

        fun deleteQuestion(question: Question): ResponseEntity<String> {
                dao.delete(question)
                return ResponseEntity("deleted successfully",HttpStatus.OK)
        }

        fun deleteById(id:Int):ResponseEntity<String>{
                dao.deleteById(id)
                return ResponseEntity("deleted successfully",HttpStatus.OK)
        }

        fun updateQuestion(question: Question):ResponseEntity<String>{
                if(dao.findById(question.id).isPresent){
                        dao.deleteById(question.id)
                }
                dao.save(question)
                return ResponseEntity("Updated successfully",HttpStatus.OK)
        }

}