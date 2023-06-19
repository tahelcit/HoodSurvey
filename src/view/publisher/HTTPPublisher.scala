package view.publisher

import api.{GetSurveyResponse, SubmitSurveyResponse, SurveyQuestion}

class HTTPPublisher
{
    def sendGetSurveyResponse(question : Set[SurveyQuestion]) : GetSurveyResponse =
    {
        // Will send the response back here I will just return the response
        GetSurveyResponse(true, question)
    }

    def sendSubmitSurveyResponse() : SubmitSurveyResponse =
    {
        // Will send the response back here I will just return the response
        SubmitSurveyResponse(true)
    }
}
