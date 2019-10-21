package nutcliffe

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.{Partition, SparkContext, TaskContext}


class NickRDD(sparkContext: SparkContext) extends RDD[Row](sparkContext, Nil) {
  override def compute(split: Partition, context: TaskContext): Iterator[Row] = Iterator (
    Row(1L, "Spark+AI Summit")
  )

  override protected def getPartitions: Array[Partition] = Array(
    new NickPartition
  )
}

class NickPartition extends Partition {
  override def index: Int = 0
}
