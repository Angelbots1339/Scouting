package frc.team1339.master;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import frc.team1339.quals.QualsMatch;

public class Main {

	static ArrayList<Object> teamNames = new ArrayList<Object>();
	static ArrayList<Object> redOne = new ArrayList<Object>();
	static ArrayList<Object> redTwo = new ArrayList<Object>();
	static ArrayList<Object> redThree = new ArrayList<Object>();
	static ArrayList<Object> blueOne = new ArrayList<Object>();
	static ArrayList<Object> blueTwo = new ArrayList<Object>();
	static ArrayList<Object> blueThree = new ArrayList<Object>();
	static ArrayList<Object> redScore = new ArrayList<Object>();
	static ArrayList<Object> blueScore = new ArrayList<Object>();
	static ArrayList<QualsMatch> quals = new ArrayList<QualsMatch>();
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
		generateQual();
		for(int i = 0; i < 160; i++){
			if(i % 2 == 0){
				System.out.println("Quals Match " + ((i/2) + 1));
			}
			System.out.println(quals.get(i).toString());
			if(i % 2 == 1){
				System.out.println();
			}
		}
	}
	
	public static void generateQual(){
		getTeamNames();
		getTeamOne();
		getTeamTwo();
		getTeamThree();
		getTeamFour();
		getTeamFive();
		getTeamSix();
		getRedScore();
		getBlueScore();
		for(int i = 0; i < 80; i++){
			quals.add(new QualsMatch(true, redOne.get(i), redTwo.get(i), redThree.get(i), redScore.get(i)));
			quals.add(new QualsMatch(false, blueOne.get(i), blueTwo.get(i), blueThree.get(i), blueScore.get(i)));
		}
	}
	
	public static void getTeamNames(){
		temp = doc.select("div.team-name");
		for(Element teamList:temp){
			teamNames.add(teamList.getElementsByTag("a").first().text());
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
					redOne.add(teamList.getElementsByTag("a").first().text());
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
					redTwo.add(teamList.getElementsByTag("a").first().text());
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
					redThree.add(teamList.getElementsByTag("a").first().text());
				}
			}
			j++;
			i++;
		}
	}
	
	public static void getTeamFour(){
		temp = doc.select("td.blue");
		int i = 0;
		int j = 0;
		boolean bool = true;
		for(Element teamList:temp){
			if(i % 3 == 0) bool = !bool;
			if(bool) {
				if(j % 3 == 0){ //==1 for second, ==2 for third
					blueOne.add(teamList.getElementsByTag("a").first().text());
				}
			}
			j++;
			i++;
		}
	}
	
	public static void getTeamFive(){
		temp = doc.select("td.blue");
		int i = 0;
		int j = 0;
		boolean bool = true;
		for(Element teamList:temp){
			if(i % 3 == 0) bool = !bool;
			if(bool) {
				if(j % 3 == 1){ //==1 for second, ==2 for third
					blueTwo.add(teamList.getElementsByTag("a").first().text());
				}
			}
			j++;
			i++;
		}
	}
	
	public static void getTeamSix(){
		temp = doc.select("td.blue");
		int i = 0;
		int j = 0;
		boolean bool = true;
		for(Element teamList:temp){
			if(i % 3 == 0) bool = !bool;
			if(bool) {
				if(j % 3 == 2){ //==1 for second, ==2 for third
					blueThree.add(teamList.getElementsByTag("a").first().text());
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
				redScore.add(teamList.getElementsByTag("span").first().text());
			}
			i++;
		}
	}
	
	public static void getBlueScore(){
		temp = doc.select("td.blueScore");
		int i = 0;
		for(Element teamList:temp){
			if(i % 2 == 1){
				blueScore.add(teamList.getElementsByTag("span").first().text());
			}
			i++;
		}
	}
}