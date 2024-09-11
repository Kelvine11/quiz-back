package org.example.quiz.controller;

import org.example.quiz.entity.Question;
import org.example.quiz.entity.Quiz;
import org.example.quiz.service.QuestionService;
import org.example.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;
    private final QuestionService questionService;

    public QuizController(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<Quiz>> index() {
        return ResponseEntity.ok(quizService.getAllQuiz());
    }

    @PostMapping(value = "/new", consumes = {"application/json"})
    public ResponseEntity<Quiz> newQuiz(@RequestBody Quiz quiz) {
        System.out.println(quiz);
        Quiz quizz = quizService.createQuiz(quiz);
        questionService.createManyQuestions(quiz.getQuestions().toArray(new Question[0]), quizz);
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

    @GetMapping("/connect")
    public Map<String, String> connect() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Connected to Quizz API");
        return response;

    }
}
