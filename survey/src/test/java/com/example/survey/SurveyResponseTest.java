package com.example.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponseController;
import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponseService;

import org.junit.jupiter.api.Test;

public class SurveyResponseTest {
    private final SurveyResponseController surveyResponseController = new SurveyResponseController(
            new SurveyResponseService());

    @Test
    public void createSurveyResponseTest() {
        // GIVEN
        surveyResponseController.addResponse(1);
        surveyResponseController.addResponse(3);
        surveyResponseController.addResponse(4);
        surveyResponseController.addResponse(2);
        // WHEN
        final List<Integer> responses = surveyResponseController.getResponses();
        //THEN
        assertEquals(responses.size(), 4);
    }

    @Test
    public void setSurveyResponseTest(){
        //GIVEN
        surveyResponseController.addResponse(1);
        surveyResponseController.addResponse(2);
        surveyResponseController.addResponse(3);
        surveyResponseController.addResponse(4);
        List<Integer> responses;
        //WHEN
        surveyResponseController.setResponse(2);
        responses = surveyResponseController.getResponses();
        //THEN
        assertTrue(responses.contains(2));
    }
}