package tw.idv.hunterchen.lab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Connection.*;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.utility.properties.PropertiesUtility;

@Slf4j
public class ExJDBC {

	public static void main (String[] args) {
	/*
		log.info("1.載入DBMS驅動程式");
		log.info("2.準備 JdbcUrl, 以連線資料庫");
		log.info("3.建立(取得) connection, 與資料庫完成連線");
		log.info("4.對資料進行操作");
		log.info("5.取得執行結果");
	*/
		String jdbcDriverName = null;
		String jdbcUrl = null;
		
		String jdbcUsername = "developer";
		String jdbcPassword = "developer";
		
		String keyName = "app.user";
		Connection connection = null;
		try {
			log.info("1.載入DBMS驅動程式");
//			log.info("1.a.載入DBMS驅動程式.使用 Class.forName()");
//			jdbcDriverName = "com.mysql.cj.jdbc.Driver";			// MySql 8.x
//			jdbcDriverName = "com.mysql.jdbc.Driver";				// MySql 5.x
//			jdbcDriverName = "oracle.jdbc.driver.OracleDriver";
//			Class.forName(jdbcDriverName);

			log.info("2.準備 JdbcUrl, 以連線資料庫");
			// MySQL 
			jdbcUrl = "jdbc"			
					+ ":mysql"
					+ "://localhost"
					+ ":3306"
					+ "/lab_db"
					+ "?serverTimezone=UTC&useSSL=false"
					;

			log.info("3.建立(取得) connection, 與資料庫完成連線");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

			log.info("連線端資訊: {}", connection.getClientInfo().toString());
			PropertiesUtility.showAllProperties(connection.getClientInfo());
			connection.setSchema("newSchema");
			log.info("資料庫名稱: {}", connection.getSchema());

			log.info("4.對資料進行操作");
			String selectStr =  "SELECT key_value"
							 + " FROM app_config"
							 + " WHERE 1=1"
							 	+ " AND key_name = ?"
							 ;
			log.info("nativeSQL(): {}", connection.nativeSQL(selectStr));
			PreparedStatement prepareStatement = connection.prepareStatement(selectStr);
			prepareStatement.setString(1, keyName);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			log.info("5.取得執行結果");
			List<String> valueList = new ArrayList<>();
			while(resultSet.next()) {
				String keyValue =  resultSet.getString(1);
				valueList.add(keyValue);
			}
			resultSet.close();
			prepareStatement.close();

			int valueListIndex = 0;
			for(String keyValue : valueList) {
			valueListIndex++ ;
				log.info("第 {}/{} 筆 : {}", valueListIndex, valueList.size(), keyValue);
			}
//		} catch(ClassNotFoundException e){
//			log.info("連線失敗:{}/n帳號:{}/n密碼:{}", jdbcUrl, jdbcUsername, jdbcPassword);
//			e.printStackTrace();
		} catch(SQLException e) {
			log.info("sql問題：查詢、取值過程中...");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.info("連線未正常關閉...");
					e.printStackTrace();
				}
			}
		}// try-catch-finally
	/*	
		log.info("1.b.載入DBMS驅動程式");
		log.info("1.c.載入DBMS驅動程式.使用 System.setProperties()");
		System.setProperty("jdbc.driver", jdbcDriverName );
	*/
	}
}