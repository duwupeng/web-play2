package controllers

import javax.inject._

import daos.NativeDao
import play.api.mvc._
import services.GrayServerService

/**
 *
 * @author Eric on 2016/7/21 15:55
 */
@Singleton
class AgentController @Inject()(graySystem: GrayServerService) extends Controller {

  def index = Action { implicit request =>
      Ok(views.html.index.render())
  }
}
