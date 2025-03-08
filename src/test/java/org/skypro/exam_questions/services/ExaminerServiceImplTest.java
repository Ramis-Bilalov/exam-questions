package org.skypro.exam_questions.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_questions.entities.Question;

import java.util.ArrayList;
import java.util.Collection;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    Collection<Question> questions;

    @BeforeEach
    public void prepare() {
        questions = new ArrayList<>();
        fillTheCollection();
    }

    private void fillTheCollection() {
        Question question1 = new Question("What color is the apple?", "Green");
        Question question2 = new Question("Where does the bear live?", "In the forest");
        Question question3 = new Question("How many colors does a traffic light have?", "Three");
        Question question4 = new Question("How many wheels does a car have?", "4");
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
    }

    @Test
    public void givenAmountOfQuestions_whenGetQuestions_thenReturnQuestions() {
        int amount = 2;

        Question question1 = new Question("What color is the apple?", "Green");
        Question question2 = new Question("Where does the bear live?", "In the forest");

        Mockito.when(javaQuestionService.getAllQuestions()).thenReturn(questions);

        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(1);

        Collection<Question> collection = new ArrayList<>();
        collection.add(question1);
        collection.add(question2);

        Assertions.assertEquals("[question='What color is the apple?', answer='Green', " +
                "question='Where does the bear live?', answer='In the forest']",
                examinerService.getQuestions(amount).toString());
    }
}
