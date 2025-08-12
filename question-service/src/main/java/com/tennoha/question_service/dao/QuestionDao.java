package com.tennoha.question_service.dao;

import com.tennoha.question_service.model.QuestionWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tennoha.question_service.model.Question;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionDao extends JpaRepository<Question, UUID> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<UUID> findRandomQuestionsByCategory(String category, Integer numQ);

}
