package com.FeedbackSurvey.SpringBoot.project.entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SURVEY")
public class ESurvey {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "Questions", length = 100)
    private String questions;

    @Column(name = "target_age", length = 100)
    private int targetAge;

    @Column(name = "target_gender", length = 100)
    private int targetGender;

    private Long coordinatorId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public int getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(int targetAge) {
        this.targetAge = targetAge;
    }

    public int getTargetGender() {
        return targetGender;
    }

    public void setTargetGender(int targetGender) {
        this.targetGender = targetGender;
    }


    public String getIdAsString() {
        return this.id == null ? null : this.id.toString();
    }

    public Long getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Long coordinatorId) {
        this.coordinatorId = coordinatorId;
    }
}

