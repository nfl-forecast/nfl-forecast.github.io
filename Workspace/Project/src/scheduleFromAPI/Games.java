package scheduleFromAPI;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Games {
	private String id;
	private String date;
	private String time;
	private String location;
	private TeamSchedule awayTeam, homeTeam;
	private String week;
	private String ScheduleStatus;
	private boolean played;

	public void setScheduleStatus(String str) {
		ScheduleStatus = str;
	}

	public void setWeek(String str) {
		week = str;
	}

	public void setId(String str) {
		id = str;
	}

	public void setDate(String str) {
		date = str;
	}

	public void setTime(String str) {
		time = str;

		String[] split = date.split("-");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);

		split = time.split(":");
		int hour = Integer.parseInt(split[0]);
		int minute = Integer.parseInt(split[1].substring(0, 2));
		boolean am = (split[1].substring(2) == "AM");

		Calendar now = Calendar.getInstance();

		int thisYear = now.get(Calendar.YEAR);
		int thisMonth = now.get(Calendar.MONTH);
		int today = now.get(Calendar.DATE);

		int thisHour = now.get(Calendar.HOUR);
		int thisMinute = now.get(Calendar.MINUTE);
		boolean thisAm = (now.get(Calendar.AM_PM) == Calendar.AM);

		if (year > thisYear)
			played = false;
		else if (year < thisYear)
			played = true;
		else if (month > thisMonth)
			played = false;
		else if (year < thisMonth)
			played = true;
		else if (day > today)
			played = false;
		else if (day < today)
			played = true;
		else if (!thisAm && am)
			played = false;
		else if (thisAm && !am)
			played = true;
		else if (hour > thisHour)
			played = false;
		else if (hour < thisHour)
			played = true;
		else if (minute > thisMinute)
			played = false;
		else if (minute < thisMinute)
			played = true;
		else
			played = false;
	}

	public void setLocation(String str) {
		location = str;
	}

	public void setHomeTeam(TeamSchedule str) {
		homeTeam = str;
	}

	public void setAwayTeam(TeamSchedule str) {
		awayTeam = str;
	}
	
	public String getScheduleStatus() {
		return ScheduleStatus;
	}

	public String getWeek() {
		return week;
	}

	public String getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}
	
	public String getLocation() {
		return location;
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
