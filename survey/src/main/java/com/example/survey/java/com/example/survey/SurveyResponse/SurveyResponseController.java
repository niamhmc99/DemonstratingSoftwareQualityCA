package com.example.survey.java.com.example.survey.SurveyResponse;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyResponseController {

    private final SurveyResponseService surveyResponseService;

    public SurveyResponseController(final SurveyResponseService surveyResponseService) {
		this.surveyResponseService = surveyResponseService;
	}

	@RequestMapping(value = "/responses", method = RequestMethod.POST)
	public void addResponse(@RequestParam final int response) {
		surveyResponseService.addResponse(response);
	}

	@RequestMapping(value = "/responseList/{responseAnswer}")
	public void setResponse(@PathVariable("responseAnswer") final int responseAnswer) {
		surveyResponseService.setResponse(responseAnswer);
	}

    @RequestMapping(value = "/responseList")
	public List<Integer> getResponses() {
		return surveyResponseService.getResponses();
	}

	@RequestMapping(value = "/response")
	public Integer getResponse() {
		return surveyResponseService.getResponse();
	}

	@RequestMapping(value = "/response/averageResponse")
	public double getSurveyResponseAverage() {
		return surveyResponseService.getSurveyResponseAverage();
	}

}
