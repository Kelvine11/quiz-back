package org.example.quiz.dao;

import org.example.quiz.entity.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    //List<TodoApi> findByValidated(boolean validated);
}
