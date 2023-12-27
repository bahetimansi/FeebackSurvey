package com.FeedbackSurvey.SpringBoot.project.operation;

import com.FeedbackSurvey.SpringBoot.project.entity.EUser;
import org.apache.catalina.User;

import java.util.Optional;
import java.util.UUID;

public interface UserOperation {

    String create(User user);

    Optional<EUser> getById(String userId);

    void update(String id, User userDetails);

    EUser getUserById(UUID respondentId);
}
