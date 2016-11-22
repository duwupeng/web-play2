package daos

/**
  * Created by eric on 16/11/22.
  */
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import models._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class AgentsTableDef(tag: Tag) extends Table[models.Agent](tag, "agents") {


  def id = column[Long]("id", O.PrimaryKey,O.AutoInc)
  def name = column[String]("name")
  def productName = column[String]("product_name")
  def level = column[String]("level")
  def status= column[Int]("status")

  override def * =
    (id, name, productName, level,status) <>(Agent.tupled, Agent.unapply)
}


class Agents @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {

  val agents = TableQuery[AgentsTableDef]


  def getAll(id: Long): Future[Seq[Agent]] = {
    db.run(agents.filter(_.id === id).result.headOption)
  }
}
