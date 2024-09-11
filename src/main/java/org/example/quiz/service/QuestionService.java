package org.example.quiz.service;

import org.example.quiz.dao.QuestionRepository;
import org.example.quiz.entity.Question;
import org.example.quiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createManyQuestions(Question[] questions, Quiz quiz) {
        for (Question question : questions) {
            question.setQuiz(quiz);
            questionRepository.save(question);
        }
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question UpdateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void DeleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    public Question getQuestionById(int id) {
        return questionRepository.findById(id).orElse(null);
    }

}
