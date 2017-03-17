package frc.team1339.quals;

public class QualsMatch{
	
		private boolean red;
		private Object team1, team2, team3;
		private Object score;
		
		public QualsMatch(boolean red, Object team1, Object team2, Object team3, Object score){
			this.red = red;
			this.team1 = team1;
			this.team2 = team2;
			this.team3 = team3;
			this.score = score;
		}
		
		public boolean getColor(){
			return this.red;
		}
		
		public Object getTeamOne(){
			return this.team1;
		}
		public Object getTeamTwo(){
			return this.team2;
		}
		public Object getTeamThree(){
			return this.team3;
		}
		
		public Object getScore(){
			return this.score;
		}
		
		private String color(){
			if(red){
				return "Red";
			}
			return "Blue";
		}
		
		public String toString(){
			return color() + " " + team1.toString() + " " + team2.toString() + " " + team3.toString() + " " + score.toString();
		}
	}