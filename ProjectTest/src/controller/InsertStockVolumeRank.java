package controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DBConnection;

public class InsertStockVolumeRank {

	static Connection con = null;
	static PreparedStatement pstmt = null;

	public static void  insertStockVolumeRnak(String dateData, String stockDiv, String rank, String stockName, String stockCode, int price, double changeRate, int volume, int tradePrice, int buyPrice, int sellPrice, int marketCapitalization) throws SQLException{

																						    	//useUnicode=true&characterEncoding=utf8   &amp;
		con =  DriverManager.getConnection("jdbc:mysql://192.168.3.130?useUnicode=true&characterEncoding=utf8","root", "1234");
		String sql = "INSERT INTO "
					 + "mysql.STOCK_VOLUME_RANK VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1,dateData);
		System.out.println("dateData : " + dateData);
		pstmt.setString(2,stockDiv);
		pstmt.setString(3,rank);
		pstmt.setString(4,stockName);
		pstmt.setString(5,stockCode);
		pstmt.setInt(6,price);
		pstmt.setDouble(7,changeRate);
		System.out.println("changeRate : " + changeRate);
		pstmt.setInt(8,volume);
		pstmt.setInt(9,tradePrice);
		pstmt.setInt(10,buyPrice);
		pstmt.setInt(11,sellPrice);
		pstmt.setInt(12,marketCapitalization);
	
		pstmt.executeUpdate(); 
		
		con.close();

	}
	
}
