package com.example.survey;

import com.example.survey.java.com.example.survey.Survey.Survey;
import com.example.survey.java.com.example.survey.Survey.SurveyController;
import com.example.survey.java.com.example.survey.Survey.SurveyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SurveyTest {

    SurveyController surveyController = new SurveyController(new SurveyService());

    @Test
    void createSurveyTest(){
        surveyController.createSurvey(new Survey(22, "Test to Create Survey"));
		Survey surveyTest = surveyController.getSurvey("Test to Create Survey");
       assertEquals(surveyTest.getId(), 22, "Create Survey");
    }

    @Test
    void emptySurveyTest(){
        Survey s = surveyController.createEmptySurvey(new Survey());
        assertTrue(s instanceof Survey, "Should be an object of type survey");
    }
}