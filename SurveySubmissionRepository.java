package com.FeedbackSurvey.SpringBoot.project.repository;

import com.FeedbackSurvey.SpringBoot.project.entity.ESurvey;
import com.FeedbackSurvey.SpringBoot.project.entity.ESurveySubmission;
import com.FeedbackSurvey.SpringBoot.project.entity.EUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SurveySubmissionRepository extends JpaRepository<ESurvey, UUID>  {
    static void save(ESurveySubmission submission) {
    }

    boolean existsByRespondentAndSurvey(EUser respondent, ESurvey eSurvey);

    List<ESurveySubmission> findBySurveyCoordinatorId(Long coordinatorId);

    ESurveySubmission findByIdAndSurveyCoordinatorId(Long submissionId, Long coordinatorId);
}
