package com.example.survey;

import com.example.survey.java.com.example.survey.Survey.Survey;
import com.example.survey.java.com.example.survey.Survey.SurveyController;
import com.example.survey.java.com.example.survey.Survey.SurveyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SurveyTest {

    SurveyController surveyController = new SurveyController(new SurveyService());

    @Test
    public void createSurveyTest(){
        //GIVEN
        surveyController.createSurvey(new Survey(22, "Test to Create Survey"));
        //WHEN
		Survey surveyTest = surveyController.getSurvey("Test to Create Survey");
        //THEN
        assertEquals(surveyTest.getId(), 22, "Survey 22");
        assertEquals(surveyTest.getSurveyName(), "Test to Create Survey", "Survey 22");
    }

    @Test
    public void findSurveyByNameTest(){
        //GIVEN
        surveyController.createSurvey(new Survey(23, "Test to find Survey By Name"));
        //WHEN
        Survey surveyFindByNameTest = surveyController.getSurvey("Test to find Survey By Name");
        //THEN
        assertEquals((surveyFindByNameTest.getSurveyName()), "Test to find Survey By Name", "Found");
        assertNotEquals(surveyFindByNameTest.getSurveyName(), "Test", "Not Found - good");
    }

    @Test
    public void findAllSurveysTest(){
        //GIVEN
        surveyController.createSurvey(new Survey(24, "Test 1"));
        surveyController.createSurvey(new Survey(25, "Test 2"));
        surveyController.createSurvey(new Survey(26, "Test 3"));

        //WHEN
        List<Survey> surveyList = surveyController.findAllSurveys();
        
        //THEN
        assertEquals(surveyList.size(), 3, "All Surveys");
    }

    
}