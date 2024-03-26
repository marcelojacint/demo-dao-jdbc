package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Properties;

public class DB {
	//interface usada para se connectar com banco relacional
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);//drivermanager gerenciador de drives jdbc, necessários para se comunicar com bnco de dados

			} catch (SQLException e) {
				throw new DbExpection(e.getMessage());
			}
		}

		return conn;

	}
	//fechar conexão com banco de dados
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbExpection(e.getMessage());
			}
		}
	}
	//carregar as propriedades que estão no arquivo db.properties
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbExpection(e.getMessage());
		}

	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbExpection(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				throw new DbExpection(e.getMessage());
			}
		}
	}
}
