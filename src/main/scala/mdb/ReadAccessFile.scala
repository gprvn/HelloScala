package mdb

import java.sql.{Connection, DriverManager, ResultSet, ResultSetMetaData}

object ReadAccessFile {
    def main(args: Array[String]): Unit = {
      val dbFilePath = "/Users/praveenrao/Downloads/sample.mdb" // Replace with the actual path to your MDB file

      // Register the UCanAccess driver class
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver")

      // JDBC URL to connect to the MDB file
      val jdbcUrl = s"jdbc:ucanaccess://$dbFilePath"

      // Establish a connection
      val connection: Connection = DriverManager.getConnection(jdbcUrl)

      try {
        // Get the metadata for the database
        val databaseMetaData = connection.getMetaData()

        // Get all table names
        val tableNames = databaseMetaData.getTables(null, null, null, Array("TABLE"))

        var tableName: String = null;
        // Print the table names
        while (tableNames.next()) {
          tableName = tableNames.getString("TABLE_NAME")
          println(tableName)
        }


        val query = s"SELECT TOP 0 * FROM $tableName"

        // Execute the query and retrieve the ResultSetMetaData
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery(query)
        val metaData: ResultSetMetaData = resultSet.getMetaData()

        // Get the number of columns in the table
        val numColumns = metaData.getColumnCount()

        // Print the column names
        for (i <- 1 to numColumns) {
          val columnName = metaData.getColumnName(i)
          println(s"Column $i: $columnName")
        }

        // Prepare the SQL query to select all data from the table
        val queryToGetData = s"SELECT * FROM $tableName"

        // Execute the query and process the results
        val statement1 = connection.createStatement()
        val resultSet1 = statement1.executeQuery(queryToGetData)

        while (resultSet1.next()) {
          // Process the data, e.g., retrieve column values
          val columnValue1 = resultSet1.getString("ID")
          val columnValue2 = resultSet1.getString("Email_Address")
          val columnValue3 = resultSet1.getString("First_Name")
          val columnValue4 = resultSet1.getString("Last_Name")
          val columnValue5 = resultSet1.getString("Address")
          // Add more column retrievals as needed
          println(s"Column1: $columnValue1, Column2: $columnValue2, Column3: $columnValue3, Column4: $columnValue4, Column5: $columnValue5")
        }

      } catch {
        case ex: Exception =>
          println(s"Error while getting table names: ${ex.getMessage}")
      } finally {
        // Close the connection when done
        connection.close()
      }
    }
}
