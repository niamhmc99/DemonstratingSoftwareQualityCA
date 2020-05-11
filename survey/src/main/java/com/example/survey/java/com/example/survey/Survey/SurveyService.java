package com.example.survey.java.com.example.survey.Survey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponse;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private ArrayList<Survey> surveyList = new ArrayList<>();
    
    public void createSurvey(Survey survey) {
        for (Survey s : surveyList) {
            if(s.getSurveyName().equalsIgnoreCase(survey.getSurveyName())){
                return;
            }
        }
        surveyList.add(survey);
    }

	public Survey getSurvey(String surveyName) {
        try{
            return surveyList.stream()
            .filter(survey -> survey.getSurveyName()
            .equals(surveyName))
            .findFirst()
            .get();
        } catch(Exception e){
            throw new IllegalArgumentException("Survey not found");
        }
	}

	public List<Survey> findAllSurveys() {
		return surveyList;
	}

	public void deleteSurvey(int id) {
        //if survey with this id exists remove it
        surveyList.removeIf(survey -> survey.getId()==(id));
    }

	public void addSurveyResponse(int surveyId, SurveyResponse surveyResponse) {
        List<SurveyResponse> surveyResponses = new ArrayList<SurveyResponse>();
        for(Survey s : surveyList) {
            if(s.getId() == surveyId){
                surveyResponses = surveyList.get(surveyId).getResponses();
            }
        }
        if (surveyResponses.size() < 10 && surveyResponses!=null){
            surveyResponses.add(surveyResponse);
        }else{
            System.out.println("Survey Response has to be between 1-5.");
        }
    
    }

	public double getSurveyAverage(String surveyName) {
        double totalOfResponses =0;
        Survey averageSurvey = getSurvey(surveyName);
        List<SurveyResponse> responses = averageSurvey.getResponses();

        for(SurveyResponse sr: responses){ //for each survey question add each reponse to the total sum 
            totalOfResponses += sr.getResponseAnswer();
        }
        return totalOfResponses/responses.size();
	}

	public double getSurveyStandardDeviation(String surveyName) {
        double standardDeviation = 0.0;
        double average = getSurveyAverage(surveyName);
        List<Integer> responses = new ArrayList<>();
        for(SurveyResponse sr: getSurvey(surveyName).getResponses()){ 
           responses.add(sr.getResponseAnswer());
        }
        for(int response: responses) {
            standardDeviation += Math.pow(response - average, 2); //pow = power
        }
        return Math.sqrt(standardDeviation/responses.size()); //sqrt = square root
	}

	public int getSurveyMinimumScore(String surveyName) {
        List<Integer> responses = new ArrayList<>();
        for (SurveyResponse response : getSurvey(surveyName).getResponses()) {
            responses.add(response.getResponseAnswer());
        }
        return Collections.min(responses); 
    	}

	public int getSurveyMaximumScore(String surveyName) {
        List<Integer> responses = new ArrayList<>();
        for (SurveyResponse response : getSurvey(surveyName).getResponses()) {
            responses.add(response.getResponseAnswer());
        }
        return Collections.max(responses);
    	}

}