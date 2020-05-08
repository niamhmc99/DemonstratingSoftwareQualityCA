package com.example.survey;

import com.example.survey.java.com.example.survey.Survey.Survey;
import com.example.survey.java.com.example.survey.Survey.SurveyController;
import com.example.survey.java.com.example.survey.Survey.SurveyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class SurveyTest {

    SurveyController surveyController = new SurveyController(new SurveyService());

    @Test
    public void createSurveyTest(){
        surveyController.createSurvey(new Survey(22, "Test to Create Survey"));
		Survey surveyTest = surveyController.getSurvey("Test to Create Survey");
        
        assertEquals(surveyTest.getId(), 22, "Survey 22");
        assertNotEquals(surveyTest.getId(), 86, "Survey 86 doesn't exist");
        assertEquals(surveyTest.getSurveyName(), "Test to Create Survey", "Survey 22");
        assertNotEquals(surveyTest.getSurveyName(), "Test", "Survey 86 doesn't exist");
    }

    @Test
    public void findSurveyByNameTest(){
        surveyController.createSurvey(new Survey(23, "Test to find Survey By Name"));
        Survey surveyFindByNameTest = surveyController.getSurvey("Test to find Survey By Name");

        assertEquals((surveyFindByNameTest.getSurveyName()), "Test to find Survey By Name", "Found");
        assertNotEquals(surveyFindByNameTest.getSurveyName(), "Test", "Not Found - good");
    }

    
}