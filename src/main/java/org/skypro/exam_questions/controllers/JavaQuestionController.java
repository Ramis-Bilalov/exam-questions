package org.skypro.exam_questions.controllers;

import org.skypro.exam_questions.entities.Question;
import org.skypro.exam_questions.services.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java")
    public Collection<Question> getAllQuestions() {
        return javaQuestionService.getAllQuestions();
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return javaQuestionService.addQuestion(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return javaQuestionService.removeQuestion(question, answer);
    }
}
