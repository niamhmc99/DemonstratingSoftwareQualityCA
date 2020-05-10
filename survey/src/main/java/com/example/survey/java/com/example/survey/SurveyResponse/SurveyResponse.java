package com.example.survey.java.com.example.survey.SurveyResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

public class SurveyResponse {

    @NonNull
    private int surveyResponseId;
    @NonNull //answer is between 1-5
    private int responseAnswer;
    @NonNull
    private List<Integer> responses;

    public SurveyResponse(){
        
    }

    public SurveyResponse(int surveyResponseId){
        this.surveyResponseId =surveyResponseId;
        this.responseAnswer = -1;
        this.responses = new ArrayList<>();
    }
    public int getSurveyResponseId() {
        return surveyResponseId;
    }

    public void setSurveyResponseId(int surveyResponseId) {
        this.surveyResponseId = surveyResponseId;
    }

    public int getResponseAnswer() {
        return responseAnswer;
    }

    public void setResponseAnswer(int responseAnswer) {
        this.responseAnswer = responseAnswer;
    }

    public List<Integer> getResponses() {
        return responses;
    }

    public void setResponses(List<Integer> responses) {
        this.responses = responses;
    }

    public void addResponses (int responseAnswer){
        this.responses.add(responseAnswer);
    }
}