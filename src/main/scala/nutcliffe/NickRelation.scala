package nutcliffe

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.sources.{BaseRelation, Filter, PrunedFilteredScan}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Row, SQLContext}

//BaseRelation is basically a table but not enough!
//PrunedFilteredScan - go look at it, but basically lets you filter data at disk read without shipping it to other executors.
class NickRelation(
                    _sqlContext:SQLContext,
                   _schema:StructType
                  ) extends BaseRelation with PrunedFilteredScan {
  override def sqlContext: SQLContext = _sqlContext

  override def schema: StructType = _schema

  override def buildScan(requiredColumns:Array[String], filters: Array[Filter]) :RDD[Row] = {
    new NickRDD(sqlContext.sparkContext)
  }

  //Override unhandledFilters to do predicate pushdown
}

