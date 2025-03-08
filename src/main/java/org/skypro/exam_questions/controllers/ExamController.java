package org.skypro.exam_questions.controllers;

import org.skypro.exam_questions.entities.Question;
import org.skypro.exam_questions.services.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/questions/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") Integer amount) {
        return examinerServiceImpl.getQuestions(amount);
    }
}
