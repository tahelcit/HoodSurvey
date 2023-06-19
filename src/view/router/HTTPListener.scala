package view.router

import api.{GetSurveyRequest, HTTPRequest, SubmitSurveyRequest}
import model.SurveyManager
import view.publisher.HTTPPublisher

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class HTTPListener
{
    val m_surveyManager = new SurveyManager()
    val m_httpPublisher = new HTTPPublisher()

    def router(request : HTTPRequest)
    {
        request match
        {
            case GetSurveyRequest(hoodID, actionID) =>
            {
                val questions = m_surveyManager.getSurvey(hoodID, actionID)
                m_httpPublisher.sendGetSurveyResponse(questions)
            }

            case SubmitSurveyRequest(userID, answers) =>
            {
                // We will not wait for an answer
                Future
                {
                    m_surveyManager.submitSurvey(userID, answers)
                }
                m_httpPublisher.sendSubmitSurveyResponse()
            }
        }
    }

}
