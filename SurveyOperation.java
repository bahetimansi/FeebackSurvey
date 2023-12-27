package com.FeedbackSurvey.SpringBoot.project.operation;

import com.FeedbackSurvey.SpringBoot.project.entity.ESurvey;

import java.util.Optional;
import java.util.UUID;

public interface SurveyOperation {

    <Survey> String create(Survey survey);

    Optional<ESurvey> getById(String surveyId);

    <Survey> Optional<ESurvey> update(String id, Survey surveyDetails);

    ESurvey getSurveyById(UUID surveyId);
}

