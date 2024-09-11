package org.example.quiz.controller;

import org.example.quiz.entity.Question;
import org.example.quiz.entity.Quiz;
import org.example.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<Quiz>> index() {
        return ResponseEntity.ok(quizService.getAllQuiz());
    }

    @PostMapping("/new")
    public ResponseEntity<Quiz> newQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.createQuiz(quiz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") int id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Quiz> deleteQuiz(@PathVariable("id") int id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") int id, @RequestBody Quiz quiz) {
        quizService.updateQuiz(quiz);
        return ResponseEntity.ok(quiz);
    }



}
