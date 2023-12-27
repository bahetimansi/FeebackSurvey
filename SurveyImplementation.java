package com.FeedbackSurvey.SpringBoot.project.implementation;
import com.FeedbackSurvey.SpringBoot.project.entity.ESurvey;
import com.FeedbackSurvey.SpringBoot.project.operation.SurveyOperation;
import com.FeedbackSurvey.SpringBoot.project.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SurveyImplementation implements SurveyOperation {

    @Autowired
    private SurveyRepository surveyRepository;


    @Override
    public <Survey> String create(Survey survey) {
        ESurvey eSurvey = (ESurvey) survey;
        ESurvey save = surveyRepository.save(eSurvey);
        return save.getIdAsString();
    }

    @Override
    public Optional<ESurvey> getById(String surveyId) {
        Optional<ESurvey> eSurvey = surveyRepository.findById(UUID.fromString(surveyId));
        return eSurvey;
    }


    @Override
    public <Survey> Optional<ESurvey> update(String id, Survey surveyDetails) {
        ESurvey eSurvey = surveyRepository.findById(UUID.fromString(id)).get();
        surveyRepository.save(eSurvey);
        return Optional.of(eSurvey);
    }

    @Override
    public ESurvey getSurveyById(UUID surveyId) {
        ESurvey eSurvey = surveyRepository.findById(UUID.fromString(String.valueOf(surveyId))).get();
        return eSurvey;
    }

}


