package com.FeedbackSurvey.SpringBoot.project.entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class ESurveySubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private EUser respondent;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private ESurvey eSurvey;

    private LocalDateTime submissionTime;

    public ESurveySubmission() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EUser getRespondent() {
        return respondent;
    }

    public void setRespondent(EUser respondent) {
        this.respondent = respondent;
    }

    public ESurvey geteSurvey() {
        return eSurvey;
    }

    public void seteSurvey(ESurvey eSurvey) {
        this.eSurvey = eSurvey;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public ESurveySubmission(UUID id, EUser respondent, ESurvey eSurvey, LocalDateTime submissionTime) {
        this.id = id;
        this.respondent = respondent;
        this.eSurvey = eSurvey;
        this.submissionTime = submissionTime;
    }

    public void setESurvey(ESurvey eSurvey) {
    }

    public void setEsurvey(ESurvey eSurvey) {
    }
}
