package frc.team1339.master;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	static ArrayList arr = new ArrayList<String>();
	static ArrayList quals = new ArrayList<QualsMatch>();
	static Elements temp;
	static Document doc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			doc = Jsoup.connect("https://www.thebluealliance.com/event/2017utwv").userAgent("chrome/56.0.2924.87").get();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		getTeamOne();
		for(int i = 0; i < arr.size(); i++){
			System.out.println(arr.get(i));
			//System.out.println("Red Quals " + (i+1) + " " + arr.get(i));
		}
	}
	public static void getTeamNames(){
		temp = doc.select("div.team-name");
		for(Element teamList:temp){
			arr.add(teamList.getElementsByTag("a").first().text());
		}
	}
	
	public static void getTeamOne(){
		temp = doc.select("td.red");
		int i = 0;
		int j = 0;
		boolean bool = true;
		for(Element teamList:temp){
			if(i % 3 == 0) bool = !bool;
			if(bool) {
				if(j % 3 == 0){ //==1 for second, ==2 for third
					arr.add(teamList.getElementsByTag("a").first().text());
				}
			}
			j++;
			i++;
		}
	}
	public static void getTeamTwo(){
		temp = doc.select("td.red");
		int i = 0;
		int j = 0;
		boolean bool = true;
		for(Element teamList:temp){
			if(i % 3 == 0) bool = !bool;
			if(bool) {
				if(j % 3 == 1){
					arr.add(teamList.getElementsByTag("a").first().text());
				}
			}
			j++;
			i++;
		}
	}
	public static void getTeamThree(){
		temp = doc.select("td.red");
		int i = 0;
		int j = 0;
		boolean bool = true;
		for(Element teamList:temp){
			if(i % 3 == 0) bool = !bool;
			if(bool) {
				if(j % 3 == 2){
					arr.add(teamList.getElementsByTag("a").first().text());
				}
			}
			j++;
			i++;
		}
	}
	
	public static void getRedScore(){
		temp = doc.select("td.redScore");
		int i = 0;
		for(Element teamList:temp){
			if(i % 2 == 1){
				arr.add(teamList.getElementsByTag("span").first().text());
			}
			i++;
		}
	}
	
	public static class QualsMatch{
		boolean red;
		int team1, team2, team3;
		int score;
		
		public QualsMatch(boolean red, int team1, int team2, int team3, int score){
			this.red = red;
			this.team1 = team1;
			this.team2 = team2;
			this.team3 = team3;
			this.score = score;
		}
	}
}