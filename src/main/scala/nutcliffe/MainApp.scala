package nutcliffe

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}

object MainApp extends App {
  override def main(args:Array[String]):Unit = {

    val spark = SparkSession.builder.master("local[*]").getOrCreate()

    val schema = StructType(StructField("id", LongType)
      :: StructField("name", StringType)
      :: Nil)
    println(spark.version)
    val df = spark.read.format("nick").schema(schema).load
    df.show
  }

}
