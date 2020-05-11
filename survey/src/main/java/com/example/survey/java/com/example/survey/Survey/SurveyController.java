package com.example.survey.java.com.example.survey.Survey;

import java.util.List;

import com.example.survey.java.com.example.survey.SurveyResponse.SurveyResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Survey getSurvey(@PathVariable("surveyName") String surveyName) {
        return surveyService.getSurvey(surveyName);
	}

    @RequestMapping("/surveys")
	public List<Survey> findAllSurveys() {
        return surveyService.findAllSurveys();
	}

    @RequestMapping( value = "/surveys/{id}", method = RequestMethod.DELETE)
	public void deleteSurvey(int id) {
        surveyService.deleteSurvey(id);
    }

    @RequestMapping( value = "/survey/answer", method = RequestMethod.POST)
	public void addSurveyResponse(@RequestParam("surveyId") int surveyId, @RequestBody SurveyResponse surveyResponse) {
        surveyService.addSurveyResponse(surveyId, surveyResponse);
	}

    @RequestMapping(value = "/survey/average/{surveyName}", method =RequestMethod.GET)
	public double getSurveyAverage(@PathVariable("surveyName") String surveyName) {
		return surveyService.getSurveyAverage(surveyName);
	}

    @RequestMapping(value = "/survey/standardDev/{surveyName}", method =RequestMethod.GET)
	public double getSurveyStandardDeviation(@PathVariable("surveyName") String surveyName) {
		return surveyService.getSurveyStandardDeviation(surveyName);
	}    
    
}