package controllers

import javax.inject._

import play.api.mvc._
import services.{AgentService}

/**
 *
 * @author Eric on 2016/7/21 15:55
 */
@Singleton
class AgentController @Inject()(agentService: AgentService) extends Controller {

  def index = Action.async { implicit request =>
    agentService.listAllAgents map { grayConfigs =>
      Ok(views.html.verify_result.render())
    }
  }

}
