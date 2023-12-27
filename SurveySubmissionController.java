package com.FeedbackSurvey.SpringBoot.project.Controller;
import com.FeedbackSurvey.SpringBoot.project.entity.ESurvey;
import com.FeedbackSurvey.SpringBoot.project.entity.EUser;
import com.FeedbackSurvey.SpringBoot.project.implementation.ESurveyAlreadySubmittedException;
import com.FeedbackSurvey.SpringBoot.project.implementation.SurveyImplementation;
import com.FeedbackSurvey.SpringBoot.project.implementation.SurveySubmissionImplementation;
import com.FeedbackSurvey.SpringBoot.project.implementation.UserImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/respondents")
public class SurveySubmissionController{
    @Autowired
    protected final SurveySubmissionImplementation surveySubmissionImplementation;
    @Autowired
    protected final UserImplementation userImplementation;
    @Autowired
    protected final SurveyImplementation surveyImplementation;


    public SurveySubmissionController(SurveySubmissionImplementation surveySubmissionImplementation, UserImplementation userImplementation, SurveyImplementation surveyImplementation) {
        this.surveySubmissionImplementation = surveySubmissionImplementation;
        this.userImplementation = userImplementation;
        this.surveyImplementation = surveyImplementation;
    }

    @PostMapping("/{respondentId}/surveys/{surveyId}/submit")
    public <SurveyAlreadySubmittedException extends Throwable> ResponseEntity<String> submitSurvey(@PathVariable UUID respondentId, @PathVariable UUID surveyId) {
        EUser respondent = userImplementation.getUserById(respondentId);
        ESurvey Esurvey = surveyImplementation.getSurveyById(surveyId);

        try {
            surveySubmissionImplementation.submitSurvey(respondent, Esurvey);
            return ResponseEntity.ok("Survey submitted successfully");
        } catch (ESurveyAlreadySubmittedException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        }
    }
