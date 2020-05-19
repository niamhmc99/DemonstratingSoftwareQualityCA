package com.example.survey.java.com.example.survey.Survey;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private static final Logger logger = LoggerFactory.getLogger(SurveyService.class);

    private ArrayList<Survey> surveyList = new ArrayList<>();
    
    public void createSurvey(Survey survey) {
        for (Survey s : surveyList) {
            if(s.getSurveyName().equalsIgnoreCase(survey.getSurveyName())){
                logger.error("Survey with that name already exists, Please try again!");
                return;
            }
        }
        surveyList.add(survey);
    }


	public Survey getSurvey(String surveyName) {
        try{
            return surveyList.stream().filter(survey -> survey.getSurveyName().equals(surveyName)).findFirst().get();
        } catch(Exception e){
            logger.error("[ERROR] Survey not found in the list");
            throw new IllegalArgumentException("Survey not found");
        }
    }
    
	public Survey createEmptySurvey(Survey survey) {
		Survey s = new Survey();
		return s;
	}
}