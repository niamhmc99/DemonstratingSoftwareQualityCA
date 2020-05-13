# Demonstrating Software Quality - Survey

## Team Version-Control 
The GitFlow process was followed throughout to ensure a smooth running process. 

**Master**

This branch is where the finalized project is located. This includes all the necessary documentation and code for the project. Pull requests from the survey_and_responses are only allowed here as this is the developing branch. This branch is familiar to every user. 


**Survey_and_responses**

This branch acts as the **develop branch** for my project. This defines the developing phase with the addition of feature branches created off it. TIt reflects the state of the latest developement delivered which is ready for the next release. This branch only accepts pull requests from feature branches. Once the code has reached a suitable state for it to be released to production it is merged back into the master branch. 

**Feature Branches**

These seperate branches branch of the survey_and_responses which is the develop branch for the project. Once the necessary code is implemented they are merged back into this develop branch. 

These branches are used for the addition of new features. 

These features include the following: 
- add_survey_response
- create_survey
- create_survey_response
- delete_survey
- find_all_surveys
- find_survey_by_name
- get_survey_average
- get_survey_max_score
- get_survey_min_score
- get_survey_response
- get_survey_response_average
- get_survey_response_maximum_score
- get_survey_response_minimum_score
- get_survey_response_standard_deviation
- get_survey_standard_deviation
- set_survey_response
- team_version_control

Each of these branches represent a new feature that follows a Test-Driven development approach which includes a test and the necessary code needed to develop the associated feature. 

**Hotfix Branches**

If a bug is encountered anywhere in piece of live production code a Hotfix branch can be created. The naming of this branch includes the version of where the bug occurs in the corresponding tag from the master branch. Overall, this allows other team members to continue developing off the develop branch while someone fixes the current bug. 
