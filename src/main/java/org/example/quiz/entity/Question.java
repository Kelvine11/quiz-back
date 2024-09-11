package org.example.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private int id;
    private String question;
    private String answer;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;

    @JsonIgnore
    public Quiz getQuiz() {
        return quiz;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", question=" + question + ", answer=" + answer + "]";
    }

}
