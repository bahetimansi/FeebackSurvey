package com.FeedbackSurvey.SpringBoot.project.implementation;
import com.FeedbackSurvey.SpringBoot.project.entity.EUser;
import com.FeedbackSurvey.SpringBoot.project.operation.UserOperation;
import com.FeedbackSurvey.SpringBoot.project.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserImplementation implements UserOperation {

    @Autowired
    private UserRepository userRepository;


@Override
    public String create(User user) {
        EUser eUser = (EUser) user;
        EUser save = userRepository.save(eUser);
        return save.getIdAsString();
        }

    @Override
    public Optional<EUser> getById(String userId) {

        Optional<EUser> eUser = userRepository.findById(UUID.fromString(userId));
        return eUser ;
    }

    @Override
    public void update(String id, User userDetails) {
            EUser eUser = userRepository.findById(UUID.fromString(id)).get();
            userRepository.save(eUser);
        }

    @Override
    public EUser getUserById(UUID respondentId) {
        EUser eUser = userRepository.findById(UUID.fromString(String.valueOf(respondentId))).get();
        return eUser ;
    }


}








