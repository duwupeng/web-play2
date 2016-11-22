package services

import java.sql.Date
import javax.inject.Inject

import daos._
import models._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 *
 * @author Eric on 2016/7/21 15:55
 */
class AgentService @Inject()(agents: Agents)  {

  def listAllAgents: Future[Seq[Agent]] = {
    agents.getAll(1)
  }
}