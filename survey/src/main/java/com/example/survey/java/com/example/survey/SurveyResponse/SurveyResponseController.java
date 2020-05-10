package com.example.survey.java.com.example.survey.SurveyResponse;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyResponseController {

    private final SurveyResponseService surveyResponseService;

    public SurveyResponseController(SurveyResponseService surveyResponseService) {
        this.surveyResponseService = surveyResponseService;
    }

    @RequestMapping(value = "/responses", method = RequestMethod.POST)
	public void addResponse(@RequestParam final int response) {
        surveyResponseService.addResponse(response);
	}

    @RequestMapping(value = "/responseList")
	public List<Integer> getResponses() {
		return surveyResponseService.getResponses();
	}

}
