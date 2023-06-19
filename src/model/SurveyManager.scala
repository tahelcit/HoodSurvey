package model

import api.{Survey, SurveyAnswer, SurveyQuestion}
import scala.collection.mutable.ListBuffer

case class SurveyAnswerRow(questionID : String,
                           userID : String,
                           answer : Option[String])

class SurveyManager()
{
    // In real life each table will be implemented correctly and be managed and initialized in a separate class
    val m_surveyTable = new ListBuffer[Survey]
    val m_questionTable = new ListBuffer[SurveyQuestion]
    val m_answerTable = new ListBuffer[SurveyAnswerRow]

    def getSurvey(hoodID : String, actionID : String) : Set[SurveyQuestion] =
    {
        m_surveyTable.filter(survey => survey.hoodID == hoodID && survey.actionID == actionID).map(_.questions).headOption.getOrElse(Set.empty)
    }

    def submitSurvey(userID : String, answers : Set[SurveyAnswer])
    {
        answers.foreach
        {
            case SurveyAnswer(questionID, answer) =>
            {
                m_answerTable += SurveyAnswerRow(questionID, userID, answer)
            }
        }
    }
}
