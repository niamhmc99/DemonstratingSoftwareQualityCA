package com.example.survey.java.com.example.survey.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SurveyController {
    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping(value="/survey", method=RequestMethod.POST)
    public void createSurvey(@RequestParam Survey survey) {
            surveyService.createSurvey(survey);
        }

    @RequestMapping("/surveys/{surveyName}")
	public Survey getSurvey(@PathVariable("name") String surveyName) {
        return surveyService.getSurvey(surveyName);
	}

    @RequestMapping("/empty_survey")
	public Survey createEmptySurvey(@RequestParam Survey survey) {
        return surveyService.createEmptySurvey(survey);
	}

}