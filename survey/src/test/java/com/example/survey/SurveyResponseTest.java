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

    @Test 
    public void getSurveyResponseTest(){
        //GIVEN
        surveyResponseController.addResponse(3);
        //WHEN
        surveyResponseController.setResponse(3);
        //THEN
        assertEquals(3, surveyResponseController.getResponse(), "Survey Response");
    }

    @Test
    public void getSurveyResponseAverageTest(){
        //GIVEN
        surveyResponseController.addResponse(2);
        surveyResponseController.addResponse(4);
        surveyResponseController.addResponse(3);
        //WHEN
        double average = surveyResponseController.getSurveyResponseAverage();
        //THEN
        assertEquals(3, average, "Average Survey Response");
    }

    @Test
    public void getSurveyResponseStandardDeviationTest(){
        //GIVEN 
        surveyResponseController.addResponse(1);
        surveyResponseController.addResponse(2);
        surveyResponseController.addResponse(3);
        //WHEN
        double standardDev = surveyResponseController.getSurveyResponseStandardDev();
        //THEN
        assertEquals(0.816496580927726, standardDev, "Standard Deviation of Response");
    }
    @Test
    public void getSurveyResponseMinimumScoreTest(){
        //GIVEN 
        surveyResponseController.addResponse(1);
        surveyResponseController.addResponse(2);
        surveyResponseController.addResponse(3);
        //WHEN
        double minimum = surveyResponseController.getSurveyResponseMinimumScore();
        //THEN
        assertEquals(1, minimum, "Minimum Score for Response");
    }

    @Test
    public void getSurveyResponseMaximumScoreTest(){
        //GIVEN 
        surveyResponseController.addResponse(4);
        surveyResponseController.addResponse(2);
        surveyResponseController.addResponse(5);
        //WHEN
        double maximum = surveyResponseController.getSurveyResponseMaximumScore();
        //THEN
        assertEquals(5, maximum, "Maximum Score for Response");
    }

    
}