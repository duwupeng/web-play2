package daos

/**
  * Created by eric on 16/11/22.
  */
import java.util.Date
import javax.inject.Inject

import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import models._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class AgentsTableDef(tag: Tag) extends Table[models.Agent](tag, "agents") {

  implicit val JavaUtilDateMapper =
    MappedColumnType.base[java.util.Date, java.sql.Timestamp] (
      d => new java.sql.Timestamp(d.getTime),
      d => new java.util.Date(d.getTime))

  def id = column[Long]("id", O.PrimaryKey,O.AutoInc)
  def name = column[String]("name")
  def productName = column[String]("product_name")
  def authorizeCode = column[String]("authorize_code")
  def level = column[String]("level")
  def status= column[String]("status")
  def createdAt= column[Date]("created_at")
  def updatedAt= column[Date]("updated_at")

  override def * =
    (id, name, productName,authorizeCode,level,status,createdAt,updatedAt) <>(Agent.tupled, Agent.unapply)
}


class Agents @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {

  val agents = TableQuery[AgentsTableDef]


  def getAll(id: Long): Future[Seq[Agent]] = {
    db.run(agents.filter(_.id === id).result)
  }
}
