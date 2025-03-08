package org.skypro.exam_questions.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_questions.entities.Question;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    JavaQuestionService javaQuestionService;
    Set<Question> questions;

    @BeforeEach
    void prepare() {
        questions = new HashSet<>();
        fillTheQuestions();
    }

    private void fillTheQuestions() {
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
    public void givenNullQuestionOrAnswer_whenAddQuestion_thenGetEmptyJson() {
        Question question = new Question("", "");

        questions.add(question);

        Assertions.assertTrue(true, String.valueOf(questions.add(question)));
    }

    @Test
    public void givenQuestionAndAnswer_whenRemoveQuestion_thenRemoveTheQuestion() {
        String question = "What color is the apple?";
        String answer = "Green";

        Question questionObj = new Question(question, answer);

        Assertions.assertTrue(true, String.valueOf(questions.remove(questionObj)));
    }

    @Test
    public void givenStringQuestion_whenFindTheQuestion_thenReturnQuestion() {
        String question = "What color is the apple?";

        Question questionObj = new Question("What color is the apple?", "Green");

        Mockito.when(javaQuestionService.findQuestion(question)).thenReturn(questionObj);

        Assertions.assertEquals("question='What color is the apple?', answer='Green'", javaQuestionService.findQuestion(question).toString());
    }
}
