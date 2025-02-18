package com.BootTrack.Forum.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BootTrack.Forum.Entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
