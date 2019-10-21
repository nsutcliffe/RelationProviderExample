package nutcliffe

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types.StructType


class NickRelationProvider extends DataSourceRegister with SchemaRelationProvider {

  override def shortName(): String = "nick"

  override def createRelation(
                               _sqlContext: SQLContext,
                               parameters: Map[String,String],
                               _schema: StructType
                             ) : BaseRelation = {

    new NickRelation(_sqlContext, _schema)
  }

  override def toString():String = "nick" // on explain plan makes a nice name for this
}