package org.skypro.exam_questions.interfaces;

import org.skypro.exam_questions.entities.Question;
import java.util.Collection;

public interface QuestionService {

    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(Question question);
    Question removeQuestion(String question, String answer);
    Collection<Question> getAllQuestions();
    Question getRandomQuestion();
    Question findQuestion(String question);

}
