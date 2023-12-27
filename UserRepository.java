package com.FeedbackSurvey.SpringBoot.project.repository;
import com.FeedbackSurvey.SpringBoot.project.entity.EUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<EUser, UUID> {
}