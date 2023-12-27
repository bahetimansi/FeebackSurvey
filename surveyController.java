package com.FeedbackSurvey.SpringBoot.project.Controller;
import com.FeedbackSurvey.SpringBoot.project.entity.ESurvey;
import com.FeedbackSurvey.SpringBoot.project.operation.SurveyOperation;
import com.FeedbackSurvey.SpringBoot.project.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/survey")
public class surveyController {


    @Autowired
    private SurveyOperation surveyOperation;

    public surveyController(SurveyRepository surveyRepository) {
        this.surveyOperation = surveyOperation;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public <Survey> ResponseEntity<Void> create(@RequestBody Survey survey) {
        String id = surveyOperation.create(survey);
        return ResponseEntity.created(URI.create(id)).build();
    }

    @RequestMapping(value = "/{surveyId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<ESurvey> getSurveyById(@PathVariable("surveyId") String surveyId) {
        return surveyOperation.getById(surveyId);
    }

    @RequestMapping(value = "/{surveyId}", method = RequestMethod.PUT)
    public <Survey> ResponseEntity<Void> updateSurvey(@PathVariable String id, @RequestBody Survey surveyDetails) {
        surveyOperation.update(id, surveyDetails);
        return ResponseEntity.noContent().build();
    }
}



