package org.skypro.exam_questions.services;

import org.skypro.exam_questions.entities.Question;
import org.skypro.exam_questions.interfaces.ExaminerService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private Collection<Question> questions;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
        questions = new ArrayList<>();
        fillTheCollection();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> result = new HashSet<>();
        Collection<Question> allQuestions = javaQuestionService.getAllQuestions();
        if (allQuestions.size() >= amount) {
            while (result.size() < amount) {
                result.add(javaQuestionService.getRandomQuestion());
            }
            return new ArrayList<>(result);
        } else {
            throw new RuntimeException("BAD_REQUEST");
        }
    }


    public void fillTheCollection() {
        Question question1 = new Question("What color is the apple?", "Green");
        Question question2 = new Question("Where does the bear live?", "In the forest");
        Question question3 = new Question("How many colors does a traffic light have?", "Three");
        Question question4 = new Question("How many wheels does a car have?", "4");
        javaQuestionService.addQuestion(question1);
        javaQuestionService.addQuestion(question2);
        javaQuestionService.addQuestion(question3);
        javaQuestionService.addQuestion(question4);
    }
}
