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

	@RequestMapping(value = "/responseList/{responseAnswer}", method = RequestMethod.POST)
	public void setResponse(@PathVariable("responseAnswer") final int responseAnswer) {
		surveyResponseService.setResponse(responseAnswer);
	}

    @RequestMapping(value = "/responseList", method = RequestMethod.POST)
	public List<Integer> getResponses() {
		return surveyResponseService.getResponses();
	}

	@RequestMapping(value = "/response", method = RequestMethod.POST)
	public Integer getResponse() {
		return surveyResponseService.getResponse();
	}

	@RequestMapping(value = "/response/averageResponse", method = RequestMethod.GET)
	public double getSurveyResponseAverage() {
		return surveyResponseService.getSurveyResponseAverage();
	}

	@RequestMapping(value = "/response/standardDeviation", method = RequestMethod.GET)
	public double getSurveyResponseStandardDev() {
		return surveyResponseService.getSurveyResponseStandardDeviation();
	}

	@RequestMapping(value = "/response/minimumScore", method = RequestMethod.GET)
	public double getSurveyResponseMinimumScore() {
		return surveyResponseService.getSurveyResponseMinimumScore();
	}

	@RequestMapping(value = "/response/maximumScore", method = RequestMethod.GET)
	public double getSurveyResponseMaximumScore() {
		return surveyResponseService.getSurveyResponseMaximumScore();
	}

}
