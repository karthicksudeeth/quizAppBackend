package com.quiz.quizApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuizAppApplication

fun main(args: Array<String>) {
	runApplication<QuizAppApplication>(*args)
}
