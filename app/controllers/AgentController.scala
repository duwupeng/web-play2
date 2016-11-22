package controllers

import javax.inject._

import play.api.mvc._
import services.{AgentService}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 *
 * @author Eric on 2016/7/21 15:55
 */
@Singleton
class AgentController @Inject()(agentService: AgentService) extends Controller {

  def index = Action.async { implicit request =>
    agentService.listAllAgents map { agents =>
      Ok(views.html.verify_result.render())
    }
  }

    def verify =  Action { implicit request =>
      Ok(views.html.verify.render())
    }

    def verifyResultDetail=  Action { implicit request =>
      Ok(views.html.verify_result_detail.render())
    }


}
