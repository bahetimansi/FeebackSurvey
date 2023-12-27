package com.FeedbackSurvey.SpringBoot.project.implementation;
import com.FeedbackSurvey.SpringBoot.project.entity.ESurvey;
import com.FeedbackSurvey.SpringBoot.project.entity.ESurveySubmission;
import com.FeedbackSurvey.SpringBoot.project.entity.EUser;
import com.FeedbackSurvey.SpringBoot.project.repository.SurveySubmissionRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SurveySubmissionImplementation {

    private final SurveySubmissionRepository surveySubmissionRepository;

    public SurveySubmissionImplementation(SurveySubmissionRepository surveySubmissionRepository) {
        this.surveySubmissionRepository = surveySubmissionRepository;
    }
    public List<ESurveySubmission> getSubmissionsForCoordinator(Long coordinatorId) {
        return surveySubmissionRepository.findBySurveyCoordinatorId(coordinatorId);
    }

    public ESurveySubmission getSubmissionByIdForCoordinator(Long submissionId, Long coordinatorId) throws NotFoundException {
        ESurveySubmission submission = surveySubmissionRepository.findByIdAndSurveyCoordinatorId(submissionId, coordinatorId);
        if (submission == null) {

            throw new NotFoundException("Submission not found for this coordinator");
        }
        return submission;
    }

    public void editSubmissionForCoordinator(Long submissionId, Long coordinatorId, ESurveySubmission updatedSubmission) throws NotFoundException {
        ESurveySubmission submission = getSubmissionByIdForCoordinator(submissionId, coordinatorId);
        submission.setRespondent(updatedSubmission.getRespondent());
        submission.seteSurvey(updatedSubmission.geteSurvey());


        SurveySubmissionRepository.save(submission);
    }
    public boolean hasRespondentAlreadySubmitted(EUser respondent, ESurvey eSurvey){
        return surveySubmissionRepository.existsByRespondentAndSurvey(respondent, eSurvey);


    }

    public void submitSurvey(EUser respondent, ESurvey eSurvey) throws ESurveyAlreadySubmittedException {
        if (!hasRespondentAlreadySubmitted(respondent, eSurvey)) {
            ESurveySubmission submission = new ESurveySubmission();
            submission.setRespondent(respondent);
            submission.setEsurvey(eSurvey);
            submission.setSubmissionTime(LocalDateTime.now());
            SurveySubmissionRepository.save(submission);
        } else {
            throw new ESurveyAlreadySubmittedException("Respondent has already submitted this survey.");
        }
    }
}
