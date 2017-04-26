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

	public static void  insertKospiStockVolumeRnak(String dateData, String stockDiv, String rank, String stockName, String stockCode, int price, double changeRate, int volume, int tradePrice, int buyPrice, int sellPrice, int marketCapitalization) throws SQLException{
		
		con =  DriverManager.getConnection("jdbc:mysql://192.168.3.130?useUnicode=yes&amp;characterEncoding=UTF-8&amp;autoReconnect=true","root", "1234");
		String sql = "INSERT INTO "
					 + "mysql.STOCK_VOLUME_RANK VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1,dateData);
		pstmt.setString(2,stockDiv);
		pstmt.setString(3,rank);
		pstmt.setString(4,stockName);
		System.out.println("stockName : " + stockName);
		pstmt.setString(5,stockCode);
		pstmt.setDouble(6,changeRate);
		System.out.println("changeRate : " + changeRate);
		pstmt.setInt(7,volume);
		pstmt.setInt(8,tradePrice);
		pstmt.setInt(9,tradePrice);
		pstmt.setInt(10,buyPrice);
		pstmt.setInt(11,sellPrice);
		pstmt.setInt(12,marketCapitalization);
		
//		dateData = today;
//		stockDiv
//		rank = elements.eq(i).select("td").eq(0).text();	
//		stockName = elements.eq(i).select("td").eq(1).text();
//		stockCode = elements.eq(i).select("td").eq(1).select("a").attr("href").substring(21,26);
//		price = Integer.parseInt(elements.eq(i).select("td").eq(2).text().replace(",", ""));	
//		changeRate = Double.parseDouble(elements.eq(i).select("td").eq(4).text().replace("%","")) ;	
//		volume = Integer.parseInt(elements.eq(i).select("td").eq(5).text().replace(",", ""));
//		tradePrice = Integer.parseInt(elements.eq(i).select("td").eq(6).text().replace(",", ""));
//		buyPrice = Integer.parseInt(elements.eq(i).select("td").eq(7).text().replace(",", ""));
//		sellPrice =  Integer.parseInt(elements.eq(i).select("td").eq(8).text().replace(",", ""));
//		marketCapitalization = Integer.parseInt(elements.eq(i).select("td").eq(9).text().replace(",", ""));
		
		pstmt.executeUpdate(); 

	}
	
}
