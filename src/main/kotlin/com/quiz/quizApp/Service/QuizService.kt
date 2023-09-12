package com.quiz.quizApp.Service

import com.quiz.quizApp.dao.QuestionDao
import com.quiz.quizApp.dao.QuizDao
import com.quiz.quizApp.model.Question
import com.quiz.quizApp.model.QuestionWrapper
import com.quiz.quizApp.model.Quiz
import com.quiz.quizApp.model.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class QuizService(@Autowired val quizDao:QuizDao, @Autowired val questionDao:QuestionDao ){
    fun createQuiz(category: String, num: Int, title: String): ResponseEntity<String> {

        val questions:List<Question> = questionDao.findRandomQuestionsByCategory(category,num)
        var quiz: Quiz=Quiz(0,title,questions)
        quizDao.save(quiz)
        return ResponseEntity("Quiz created",HttpStatus.OK)
    }

    fun getQuizQuestions(id:Integer): ResponseEntity<List<QuestionWrapper>> {
        val quiz: Optional<Quiz> =quizDao.findById(id)
        val ques:List<Question> =  quiz.get().question
        val quesWrapper:MutableList<QuestionWrapper> = mutableListOf()

        for (q in ques){
            val temp:QuestionWrapper=QuestionWrapper(q.id,q.option1,q.option2,q.option3,q.option4,q.question)
            quesWrapper.add(temp)
        }
        return ResponseEntity(quesWrapper,HttpStatus.OK)
    }
    fun calculateResult(id: Integer, response: List<Response>): ResponseEntity<Int> {
        val quiz: Optional<Quiz> = quizDao.findById(id)
        val ques=quiz.get().question
        var ans=0
        var j=0;
        for(i in response){
            if(ques.get(j).answer.equals(i.response)){
                ans++
            }
            j++;
        }
        return ResponseEntity(ans,HttpStatus.OK)

    }
}