# Demonstrating Software Quality - Survey

## Introduction
This project provides a  list of guidelines for the best practices to refer to during the development of a Software Project. The steps involved within the standard development 
Before starting to code any standard software development project there are numerous components that need to be considered first. 


## Scrum Sprint Backlog and Task Estimation
Sprint Backlog contains a list of tasks that a team targets to deliver during a sprint in order to reach the sprint needed to be completed within the sprint. Ideally, the Sprint Backlog items are taken directly from the product backlog. The Sprint Backlog identifies a set of tasks and to-do items for the developers to complete in the upcoming sprint. A sprint has generally a fixed time period of 2 weeks. The tasks in a sprint are identified before the initial sprint start date. The Sprint Backlog is a highly-visibible, real-time picture of the work that the development team plans to complete throughout the Sprint block.

### Sprint Backlog

1. **Set up the Development Environment**
    - Create Workspace in Visual Studio Code.
    - Link GitHub to project in Visual Studio Code: enable git flow process.
    - **Story Point =** 1

2. **Create Survey Model** 
    - Survey model contains an id, name and a list of Survey Responses.
    - Each variable has a corresponding getter method.
    - **Story Point =** 1

3. **Create Survey Service Class**
    - Use @Service annotation.
    - Includes: 
        - getAllSurveys() -> retruns Survey list.
        - getSurveyByName() -> returns specific Survey.
        - addSurvey() -> add a new Survey to the list of Surveys. 
        - deleteSurvey() -> deletes and removes a Survey from the list of Surveys.
        - addSurveyResponse() -> add a Survey Response to the list. 
    - **Story Point =** 5

4. **Create Survey Controller Class**
    - Use @Controller annotation.
    - Includes: 
        - getAllSurveys() -> get all Surveys.
        - getSurveyByName() -> get Survey with specific name. 
        - addSurvey() -> creates new Survey.
        - deleteSurvey() -> delete a Survey.
        - addSurveyResponse() -> add Survey Response to the list. 
     - **Story Point =** 5

5. **Create Survey Response Model**
    - Survey Response model contains an id, response and a list of Survey Responses.
    - Each variable has a corresponding getter method.
    - Method to add a response
    - **Story Point =** 1

6. **Create Survey Response Service Class**
    - Use @Service annotation.
    - Includes: 
        - setResponse() -> submits response for a Survey Response.
        - getSurveyResponses() -> returns all responses of a Survey Response.
        - addSurveyResponse() -> submits new response to a Survey Response. 
    - **Story Point =** 3

7. **Create Survey Response Controller Class**
    - Use @Controller annotation.
    - Includes: 
        - getAllSurveys() -> get all Surveys.
        - getSurveyByName() -> get Survey with specific name. 
        - addSurvey() -> creates new Survey.
        - deleteSurvey() -> delete a Survey.
        - addSurveyResponse() -> add Survey Response to the list. 
     - **Story Point =** 3

8. **Add Summary Calculation to Survey**
- Survey Service and Survey Controller contains the following:
    - getSurveyAverage() -> returns average result of a Survey. 
    - getSurveyStandardDeviation() -> return the standard deviation result of a Survey. 
    - getSurveyMinimumScore() -> returns minimum score for a Survey.
    - getSurveyMaximumScore() -> returns maximum score for a Survey.
- **Story Point =** 5

9. **Add Summary Calculation to Survey Response**
- Survey Response Service and Survey Response Controller contains the following:
    - getSurveyResponseAverage() -> returns average result of a Survey Response. 
    - getSurveyStandardDeviation() -> return the standard deviation result of responses for a Survey Response. 
    - getSurveyMinimumScore() -> returns minimum score for a Survey Response.
    - getSurveyMaximumScore() -> returns maximum score for a Survey Response.
 - **Story Point =** 5

## Unit Testing and Test-Driven Development
Test Driven Development is the process of software development where you first write a test thats fails before writing the implementation code.

![TDD Process](TDD_Diagram.png)

## Test Coverage Metric

## Team Version-Control 

## Code-Review Checklist