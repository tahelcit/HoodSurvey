package api

import api.QuestionType.QuestionType

trait HTTPRequest

case class SurveyQuestion(questionID : String,
                          questionType : QuestionType,
                          featureFlag : Boolean,
                          order : Int)

case class SurveyAnswer(questionID : String,
                        answer : Option[String])

case class Survey(surveyID : String,
                  hoodID : String,
                  actionID : String,
                  questions : Set[SurveyQuestion])

case class GetSurveyRequest(hoodID : String,
                            actionID : String) extends HTTPRequest

case class GetSurveyResponse(status : Boolean,
                             questions : Set[SurveyQuestion])

case class SubmitSurveyRequest(userID : String,
                               answers : Set[SurveyAnswer]) extends HTTPRequest

case class SubmitSurveyResponse(status : Boolean)
