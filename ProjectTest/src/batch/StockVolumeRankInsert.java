package batch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import controller.InsertStockVolumeRank;

public class StockVolumeRankInsert {

	static Calendar calendar = Calendar.getInstance();
    static java.util.Date date = calendar.getTime();
    static String today = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));
	
    static String dateData = "";
    static String stockDiv = "";
    static String rank = "";
    static String stockName = "";
    static String stockCode = "";
    static int price = 0;
    static double changeRate = 0.0;
    static int volume = 0;
    static int tradePrice = 0;
    static int buyPrice = 0;
    static int sellPrice = 0;
    static int marketCapitalization = 0;
	
	public static void main(String args[]) throws IOException, SQLException{
 
		kospiVolumeRankInsert();
		kosdaqVolumeRankInsert();
	}

	public static void kospiVolumeRankInsert() throws IOException, SQLException{
		
		Document doc = Jsoup.connect("http://finance.naver.com/sise/sise_quant.nhn?sosok=0").get();
		Elements elements = doc.select("div.box_type_l table tbody tr");
		
        stockDiv = "P";
        
        for(int i = 0; i <= elements.size(); i++){
			if(!elements.eq(i).select(".no").text().equals("")){
				dateData = today;
				rank = elements.eq(i).select("td").eq(0).text();
				stockName = elements.eq(i).select("td").eq(1).text();
				stockCode = elements.eq(i).select("td").eq(1).select("a").attr("href").substring(21,26);
				price = Integer.parseInt(elements.eq(i).select("td").eq(2).text().replace(",", ""));
				changeRate = Double.parseDouble(elements.eq(i).select("td").eq(4).text().replace("%","")) ;
				volume = Integer.parseInt(elements.eq(i).select("td").eq(5).text().replace(",", ""));
				tradePrice = Integer.parseInt(elements.eq(i).select("td").eq(6).text().replace(",", ""));
				buyPrice = Integer.parseInt(elements.eq(i).select("td").eq(7).text().replace(",", ""));
				sellPrice =  Integer.parseInt(elements.eq(i).select("td").eq(8).text().replace(",", ""));
				marketCapitalization = Integer.parseInt(elements.eq(i).select("td").eq(9).text().replace(",", ""));
	
				InsertStockVolumeRank.insertStockVolumeRnak(dateData, stockDiv, rank, stockName, stockCode, price, changeRate, volume, tradePrice, buyPrice, sellPrice, marketCapitalization);
			}
		}
	}
	
	public static void kosdaqVolumeRankInsert() throws IOException, SQLException{
		
		Document doc = Jsoup.connect("http://finance.naver.com/sise/sise_quant.nhn?sosok=1").get();
		Elements elements = doc.select("div.box_type_l table tbody tr");
		
        stockDiv = "D";
        
        for(int i = 0; i <= elements.size(); i++){
			if(!elements.eq(i).select(".no").text().equals("")){
				dateData = today;
				rank = elements.eq(i).select("td").eq(0).text();
				stockName = elements.eq(i).select("td").eq(1).text();
				stockCode = elements.eq(i).select("td").eq(1).select("a").attr("href").substring(21,26);
				price = Integer.parseInt(elements.eq(i).select("td").eq(2).text().replace(",", ""));
				changeRate = Double.parseDouble(elements.eq(i).select("td").eq(4).text().replace("%","")) ;
				volume = Integer.parseInt(elements.eq(i).select("td").eq(5).text().replace(",", ""));
				tradePrice = Integer.parseInt(elements.eq(i).select("td").eq(6).text().replace(",", ""));
				buyPrice = Integer.parseInt(elements.eq(i).select("td").eq(7).text().replace(",", ""));
				sellPrice =  Integer.parseInt(elements.eq(i).select("td").eq(8).text().replace(",", ""));
				marketCapitalization = Integer.parseInt(elements.eq(i).select("td").eq(9).text().replace(",", ""));
	
				InsertStockVolumeRank.insertStockVolumeRnak(dateData, stockDiv, rank, stockName, stockCode, price, changeRate, volume, tradePrice, buyPrice, sellPrice, marketCapitalization);
			}
		}
	}
}
