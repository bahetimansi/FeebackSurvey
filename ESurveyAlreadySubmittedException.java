package com.FeedbackSurvey.SpringBoot.project.implementation;

public class ESurveyAlreadySubmittedException extends Throwable {
    public ESurveyAlreadySubmittedException(String message) {
        super(message);
    }
}
