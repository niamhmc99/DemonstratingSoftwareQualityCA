package com.example.survey;

import com.example.survey.java.com.example.survey.Survey.Survey;
import com.example.survey.java.com.example.survey.Survey.SurveyController;
import com.example.survey.java.com.example.survey.Survey.SurveyService;
import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponse;

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

    @Test
    public void deleteSurveyTest(){
        //GIVEN
        surveyController.createSurvey(new Survey(26, "Test 4"));
        surveyController.createSurvey(new Survey(27, "Test 5"));
         //WHEN
        surveyController.deleteSurvey(27);
        List<Survey> surveyList = surveyController.findAllSurveys();
        //THEN
        assertEquals(surveyList.size(), 1, "Survey is Deleted");
    }

    @Test
    public void addSurveyResponseTest() {
        //GIVEN
        List<SurveyResponse> surveyResponses;
        SurveyResponse surveyResponseTest;
        surveyController.createSurvey(new Survey(0, "Test 6"));
        surveyResponseTest = new SurveyResponse(28);
        //WHEN
        surveyController.addSurveyResponse(0, surveyResponseTest);
        surveyResponses = surveyController.getSurvey("Test 6").getResponses();
        //THEN
        assertEquals(surveyResponses.get(0), surveyResponseTest, "SurveyResponse");
    }

    @Test
    public void surveyResponseListTest(){
        //GIVEN 
        List<SurveyResponse> surveyResponses;
        SurveyResponse surveyResponse0, surveyResponse1, surveyResponse2, surveyResponse3, surveyResponse4, surveyResponse5, surveyResponse6, surveyResponse7, surveyResponse8, surveyResponse9;
        //WHEN
        surveyController.createSurvey(new Survey(0, "Test Survey Response"));
        surveyResponse0 = new SurveyResponse(0);
        surveyResponse1 = new SurveyResponse(1);
        surveyResponse2 = new SurveyResponse(2);
        surveyResponse3 = new SurveyResponse(3);
        surveyResponse4 = new SurveyResponse(4);
        surveyResponse5 = new SurveyResponse(5);
        surveyResponse6 = new SurveyResponse(6);
        surveyResponse7 = new SurveyResponse(7);
        surveyResponse8 = new SurveyResponse(8);
        surveyResponse9 = new SurveyResponse(9);
        surveyController.addSurveyResponse(0, surveyResponse0);
        surveyController.addSurveyResponse(0, surveyResponse1);
        surveyController.addSurveyResponse(0, surveyResponse2);
        surveyController.addSurveyResponse(0, surveyResponse3);
        surveyController.addSurveyResponse(0, surveyResponse4);
        surveyController.addSurveyResponse(0, surveyResponse5);
        surveyController.addSurveyResponse(0, surveyResponse6);
        surveyController.addSurveyResponse(0, surveyResponse7);
        surveyController.addSurveyResponse(0, surveyResponse8);
        surveyController.addSurveyResponse(0, surveyResponse9);

        surveyResponses = surveyController.getSurvey("Test Survey Response").getResponses();
        //THEN
        assertEquals(surveyResponses.size(), 10, "List should not contain more than 10 survey responses");
    }

    @Test
    public void getSurveyAverageTest(){
        //GIVEN
        SurveyResponse response1, response2, response3, response4;
        surveyController.createSurvey(new Survey(0, "Average Test"));
        //WHEN
        response1 = new SurveyResponse(0);
        response1.addResponses(1);
        response1.addResponses(2);
        response1.addResponses(3);
        response1.addResponses(4);
        response1.setResponseAnswer(3);
        surveyController.addSurveyResponse(0, response1);
        response2 = new SurveyResponse(2);
        response2.addResponses(2);
        response2.addResponses(4);
        response2.setResponseAnswer(2);
        surveyController.addSurveyResponse(0, response2);
        response3 = new SurveyResponse(2);
        response3.addResponses(2);
        response3.addResponses(4);
        response3.addResponses(2);
        response3.setResponseAnswer(4);
        surveyController.addSurveyResponse(0, response3);
        response4 = new SurveyResponse(2);
        response4.addResponses(1);
        response4.addResponses(3);
        response4.setResponseAnswer(3);
        surveyController.addSurveyResponse(0, response4);
       
        double surveyAverage = surveyController.getSurveyAverage(surveyController.getSurvey("Average Test").getSurveyName());
        //THEN
        assertEquals(3, surveyAverage);   
    }

    @Test
    public void getSurveyStandardDeviationTest() {
        //GIVEN
        SurveyResponse response1, response2, response3, response4;
        surveyController.createSurvey(new Survey(0, "Standard Dev Test"));
        //WHEN
        response1 = new SurveyResponse(0);
        response1.addResponses(1);
        response1.addResponses(2);
        response1.addResponses(3);
        response1.addResponses(4);
        response1.setResponseAnswer(3);
        surveyController.addSurveyResponse(0, response1);
        response2 = new SurveyResponse(2);
        response2.addResponses(2);
        response2.addResponses(4);
        response2.setResponseAnswer(2);
        surveyController.addSurveyResponse(0, response2);
        response3 = new SurveyResponse(2);
        response3.addResponses(2);
        response3.addResponses(4);
        response3.addResponses(2);
        response3.setResponseAnswer(4);
        surveyController.addSurveyResponse(0, response3);
        response4 = new SurveyResponse(2);
        response4.addResponses(1);
        response4.addResponses(3);
        response4.setResponseAnswer(3);
        surveyController.addSurveyResponse(0, response4);
        double surveyStandardDev = surveyController.getSurveyStandardDeviation(surveyController.getSurvey("Standard Dev Test").getSurveyName());
        //THEN
        assertEquals(0.7071067811865476, surveyStandardDev);   
    }
}