package com.tennoha.question_service.controller;


import com.tennoha.question_service.model.Question;
import com.tennoha.question_service.model.QuestionWrapper;
import com.tennoha.question_service.model.Response;
import com.tennoha.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category) {
        return questionService.getAllQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<UUID>> getQuestionsForQuiz(@RequestParam String category,
                                                          @RequestParam Integer numQ) {
        return questionService.getQuestionsForQuiz(category, numQ);
    }

    @PostMapping("get")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsfromIds(@RequestBody List<UUID> questionIds) {
        return questionService.getQuestionsfromIds(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }

}
