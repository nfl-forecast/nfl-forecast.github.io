package scheduleFromHTML;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Games {
	public String date;
	public String time;
	public TeamSchedule awayTeam, homeTeam;
	public String week;
	private boolean played;

	public void setWeek(String str) {
		week = str;
	}

	public void setDate(String str) {
		date = str;
	}

	public void setTime(String str) {
		time = str;

		if(time == "final") {
			played = true;
		}
		else {
			played = false;
		}
	}

	public void setHomeTeam(TeamSchedule str) {
		homeTeam = str;
	}

	public void setAwayTeam(TeamSchedule str) {
		awayTeam = str;
	}
	
	public String getWeek() {
		return week;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public TeamSchedule getHomeTeam() {
		return homeTeam;
	}

	public TeamSchedule getAwayTeam() {
		return awayTeam;
	}
	
	public boolean getPlayed() {
		return played;
	}

	public String toString() {
		return awayTeam + " @ " + homeTeam;
	}
}
