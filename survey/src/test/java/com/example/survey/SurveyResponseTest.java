package com.example.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponseController;
import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponseService;

import org.junit.jupiter.api.Test;

public class SurveyResponseTest {

    SurveyResponseController surveyResponseController = new SurveyResponseController(new SurveyResponseService());

    @Test
    void createSurveyResponseTest(){
        //GIVEN
        surveyResponseController.addResponse(1);
        surveyResponseController.addResponse(3);
        surveyResponseController.addResponse(4);
        surveyResponseController.addResponse(2);
        //WHEN
        List<Integer> responses = surveyResponseController.getResponses();
        //THEN
        assertEquals(responses.size(), 4);
    }
}