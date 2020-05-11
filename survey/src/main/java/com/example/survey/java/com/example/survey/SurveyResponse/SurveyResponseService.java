package com.example.survey.java.com.example.survey.SurveyResponse;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SurveyResponseService {

    private SurveyResponse surveyResponse = new SurveyResponse(1);

	public void addResponse(int response) {
        //check if response is between numbers 1-5 
        if(response>=1 && response<=5){
            surveyResponse.addResponses(response);
        }else{
            System.out.println("Answer has to be between number 1-5");
        }
	}

	public List<Integer> getResponses() {
		return surveyResponse.getResponses();
	}

	public void setResponse(int responseAnswer) {
        if(surveyResponse.getResponses().contains(responseAnswer)){
            surveyResponse.setResponseAnswer(responseAnswer);
        }else{
            System.out.println("Response has to between numbers 1-5");
        }
    }

    //single response answer
	public Integer getResponse() {
		return surveyResponse.getResponseAnswer();
	}

	public double getSurveyResponseAverage() {
        double total=0;
        List<Integer> responses = getResponses();
        for(int responseAnswer: responses){
            total += responseAnswer;
        }
		return total/ responses.size();
	}

}