package org.skypro.exam_questions.interfaces;

import org.skypro.exam_questions.entities.Question;
import java.util.Collection;
public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
