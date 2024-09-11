package org.example.quiz.service;

import org.example.quiz.dao.QuizRepository;
import org.example.quiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(int id) {
        quizRepository.deleteById(id);
    }

    public Quiz getQuizById(int id) {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Quiz> getAllQuiz() {
        return (List<Quiz>) quizRepository.findAll();
    }

}
