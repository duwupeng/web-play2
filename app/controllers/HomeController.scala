package controllers

import javax.inject._

import daos.NativeDao
import play.api.mvc._
import services.GrayServerService

import scala.concurrent.ExecutionContext.Implicits.global

/**
 *
 * @author Eric on 2016/7/21 15:55
 */
@Singleton
class HomeController @Inject()(graySystem: GrayServerService,nativeDao:NativeDao) extends Controller {

  def index = Action { implicit request =>
      Ok(views.html.index.render())
  }

  def sandie = Action { implicit request =>
    Ok(views.html.test.render())
  }

  def verify =  Action { implicit request =>
    Ok(views.html.verify.render())
  }

  def verifyResult=  Action { implicit request =>
    Ok(views.html.verify_result.render())
  }

  def verifyResultDetail=  Action { implicit request =>
    Ok(views.html.verify_result_detail.render())
  }
}
