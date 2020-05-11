package com.example.survey.java.com.example.survey.Survey;

import java.util.ArrayList;
import java.util.List;

import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponse;

import org.springframework.lang.NonNull;

public class Survey {

    @NonNull
    private int id;
    @NonNull
    private String surveyName;
   @NonNull
   private List<SurveyResponse> responses;

   public Survey(int id, String surveyName) {
        this.id = id;
        this.surveyName = surveyName;
        this.responses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurveyName() {
        return surveyName;
    }

 
    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public List<SurveyResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<SurveyResponse> responses) {
        this.responses = responses;
    }

	public void addSurveyResponse(String string) {
	}
}