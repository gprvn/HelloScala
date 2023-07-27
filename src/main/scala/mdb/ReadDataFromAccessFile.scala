package mdb
import java.sql.{Connection, DriverManager, ResultSet, ResultSetMetaData}

object ReadDataFromAccessFile {
  def main(args: Array[String]): Unit = {
    val dbFilePath = "/Users/praveenrao/Downloads/Campaign_Template.mdb"

    //register the ucanaccess driver
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver")
    // JDBC URL to connect to the MS Access database
    val jdbcUrl = s"jdbc:ucanaccess://$dbFilePath"

    // Establish a connection
    val connection: Connection = DriverManager.getConnection(jdbcUrl)

    try {
      // Specify the table name to read data from
      val tableName = "Campaign_Table" // Replace with the actual table name

      // Prepare the SQL query to select all data from the table
      val query = s"SELECT * FROM $tableName"

      // Execute the query and retrieve the result set
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery(query)

      println("resultset is executed")

      // Get the metadata of the result set
      val metaData = resultSet.getMetaData
      val numColumns = metaData.getColumnCount

      // Process each row in the result set
      while (resultSet.next()) {
        // Process each column in the row
        for (i <- 1 to numColumns) {
          // Get the column value as an Object
          val columnValue: AnyRef = resultSet.getObject(i)

          // Check the data type of the column
          if (columnValue.isInstanceOf[String]) {
            println(s"Column $i (String): ${columnValue.asInstanceOf[String]}")
          } else if (columnValue.isInstanceOf[Int]) {
            println(s"Column $i (Int): ${columnValue.asInstanceOf[Int]}")
          } else {
            // Handle other data types as needed
            println(s"Column $i (Unknown Type): $columnValue")
          }
        }
      }
    } catch {
      case ex: Exception =>
        println(s"Error while reading data: ${ex.getMessage}")
    } finally {
      // Close the connection when done
      connection.close()
    }
  }
}
