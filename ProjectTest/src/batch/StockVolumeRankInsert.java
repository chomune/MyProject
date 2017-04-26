package batch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import controller.InsertStockVolumeRank;

public class StockVolumeRankInsert {

	public static void main(String args[]) throws IOException{
 
		kospiVolumeRankInsert();
		//kosdaqVolumeRankInsert();
	}

	public static void kospiVolumeRankInsert() throws IOException{
		
		Document doc = Jsoup.connect("http://finance.naver.com/sise/sise_quant.nhn?sosok=0").get();
		Elements elements = doc.select("div.box_type_l table tbody tr");
		
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));


		for(int i = 0; i <= elements.size(); i++){
			if(!elements.eq(i).select(".no").text().equals("")){
				System.out.println("───────────────────────────────────────");
				System.out.println("일시분초종목코드 : " + today + elements.eq(i).select("td").eq(1).select("a").attr("href").substring(21,26));//순위
				System.out.println("순위 : " + elements.eq(i).select("td").eq(0).text());//순위
				System.out.println("종목명 : " + elements.eq(i).select("td").eq(1).text());//종목명
				System.out.println("종목코드 : " + elements.eq(i).select("td").eq(1).select("a").attr("href").substring(21,26));
				System.out.println("현재가 : " + elements.eq(i).select("td").eq(2).text());//현재가
				System.out.println("전일비 : " + elements.eq(i).select("td").eq(3).text());//전일비
				System.out.println("등락률 : " + elements.eq(i).select("td").eq(4).text());//등락률
				System.out.println("거래량 : " + elements.eq(i).select("td").eq(5).text());//거래량
				System.out.println("거래대금 : " + elements.eq(i).select("td").eq(6).text());//거래대금
				System.out.println("매수호가 : " + elements.eq(i).select("td").eq(7).text());//매수호가
				System.out.println("매도호가 : " + elements.eq(i).select("td").eq(8).text());//매도호가
				System.out.println("시가총액 : " + elements.eq(i).select("td").eq(9).text());//시가총액	
				
				//InsertStockVolumeRank.insertKospiStockVolumeRnak();
			}
		}
	}
	
	public static void kosdaqVolumeRankInsert() throws IOException{
		
		Document doc = Jsoup.connect("http://finance.naver.com/sise/sise_quant.nhn?sosok=1").get();
		Elements elements = doc.select("div.box_type_l table tbody tr");
		
		for(int i = 0; i <= elements.size(); i++){
			if(!elements.eq(i).select(".no").text().equals("")){
				System.out.println("───────────────────────────────────────");
				
				System.out.println("순위 : " + elements.eq(i).select("td").eq(0).text());//순위
				System.out.println("종목명 : " + elements.eq(i).select("td").eq(1).text());//종목명
				System.out.println("현재가 : " + elements.eq(i).select("td").eq(2).text());//현재가
				System.out.println("전일비 : " + elements.eq(i).select("td").eq(3).text());//전일비
				System.out.println("등락률 : " + elements.eq(i).select("td").eq(4).text());//등락률
				System.out.println("거래량 : " + elements.eq(i).select("td").eq(5).text());//거래량
				System.out.println("거래대금 : " + elements.eq(i).select("td").eq(6).text());//거래대금
				System.out.println("매수호가 : " + elements.eq(i).select("td").eq(7).text());//매수호가
				System.out.println("매도호가 : " + elements.eq(i).select("td").eq(8).text());//매도호가
				System.out.println("시가총액 : " + elements.eq(i).select("td").eq(9).text());//시가총액
				
//				for(int j = 0; j <= elements.eq(i).select("td").size(); j++){
//					System.out.println(elements.eq(i).select("td").eq(j).text());
//				}
			}
		}
	}
}
