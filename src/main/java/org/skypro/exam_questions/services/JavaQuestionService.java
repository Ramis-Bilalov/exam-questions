package org.skypro.exam_questions.services;

import org.skypro.exam_questions.entities.Question;
import org.skypro.exam_questions.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (questions.add(newQuestion)) {
            return newQuestion;
        }
        return null;
    }

    @Override
    public Question addQuestion(Question question) {
        if (questions.add(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Question removeQuestion(Question question) {
        if(null != question) {
            questions.remove(question);
            return question;
        }
        return null;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.remove(question1);
        return question1;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return questions.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        ArrayList<Question> collect = getAllQuestions().stream().collect(Collectors.toCollection(ArrayList::new));
        if(questions == null || questions.isEmpty()) {
            return null;
        }
        int index = random.nextInt(questions.size());
        return collect.get(index);
    }

    @Override
    public Question findQuestion(String question) {
        ArrayList<Question> questionList = questions.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("questionList = " + questionList);
        return questionList.stream().filter(questionObj -> questionObj.getQuestion().equals(question)).findAny().orElseThrow();
    }
}
