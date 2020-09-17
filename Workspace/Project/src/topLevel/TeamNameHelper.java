package topLevel;

import java.awt.Color;

import teamStructure.Team;

public class TeamNameHelper {
	
	public static String getTeamName(String str) {
		switch(str) {
		case "New England Patriots": case "NE": case "Patriots": {
			return "New England Patriots";
		}
		case "New York Jets": case "NYJ": case "Jets": {
			return "New York Jets";
		}
		case "Buffalo Bills": case "BUF": case "Bills": {
			return "Buffalo Bills";
		}
		case "Miami Dolphins": case "MIA": case "Dolphins": {
			return "Miami Dolphins";
		}
		case "Houston Texans": case "HOU": case "Texans": {
			return "Houston Texans";
		}
		case "Indianapolis Colts": case "IND": case "Colts": {
			return "Indianapolis Colts";
		}
		case "Jacksonville Jaguars": case "JAX": case "Jaguars": {
			return "Jacksonville Jaguars";
		}
		case "Tennessee Titans": case "TEN": case "Titans": {
			return "Tennessee Titans";
		}
		case "Pittsburgh Steelers": case "PIT": case "Steelers": {
			return "Pittsburgh Steelers";
		}
		case "Cleveland Browns": case "CLE": case "Browns": {
			return "Cleveland Browns";
		}
		case "Baltimore Ravens": case "BAL": case "Ravens": {
			return "Baltimore Ravens";
		}
		case "Cincinnati Bengals": case "CIN": case "Bengals": {
			return "Cincinnati Bengals";
		}
		case "Los Angeles Chargers": case "LAC": case "Chargers": {
			return "Los Angeles Chargers";
		}
		case "Denver Broncos": case "DEN": case "Broncos": {
			return "Denver Broncos";
		}
		case "Las Vegas Raiders": case "LV": case "Raiders": {
			return "Las Vegas Raiders";
		}
		case "Kansas City Chiefs": case "KC": case "Chiefs": {
			return "Kansas City Chiefs";
		}
		case "Green Bay Packers": case "GB": case "Packers": {
			return "Green Bay Packers";
		}
		case "Detroit Lions": case "DET": case "Lions": {
			return "Detroit Lions";
		}
		case "Chicago Bears": case "CHI": case "Bears": {
			return "Chicago Bears";
		}
		case "Minnesota Vikings": case "MIN": case "Vikings": {
			return "Minnesota Vikings";
		}
		case "Washington Football Team": case "WAS": case "Football Team": {
			return "Washington Football Team";
		}
		case "Dallas Cowboys": case "DAL": case "Cowboys": {
			return "Dallas Cowboys";
		}
		case "New York Giants": case "NYG": case "Giants": {
			return "New York Giants";
		}
		case "Philadelphia Eagles": case "PHI": case "Eagles": {
			return "Philadelphia Eagles";
		}
		case "New Orleans Saints": case "NO": case "Saints": {
			return "New Orleans Saints";
		}
		case "Carolina Panthers": case "CAR": case "Panthers": {
			return "Carolina Panthers";
		}
		case "Atlanta Falcons": case "ATL": case "Falcons": {
			return "Atlanta Falcons";
		}
		case "Tampa Bay Buccaneers": case "TB": case "Buccaneers": {
			return "Tampa Bay Buccaneers";
		}
		case "Seattle Seahawks": case "SEA": case "Seahawks": {
			return "Seattle Seahawks";
		}
		case "San Francisco 49ers": case "SF": case "49ers": {
			return "San Francisco 49ers";
		}
		case "Arizona Cardinals": case "ARI": case "Cardinals": {
			return "Arizona Cardinals";
		}
		case "Los Angeles Rams": case "LAR": case "Rams": {
			return "Los Angeles Rams";
		}
		case "Oakland Raiders": case "OAK": {
			return getTeamName("Las Vegas Raiders");
		}
		case "Washington Redskins": case "Redskins": {
			return getTeamName("Washington Football Team");
		}
		case "San Diego Chargers": case "SD": {
			return getTeamName("Los Angeles Chargers");
		}
		case "St. Louis Rams": case "STL": {
			return getTeamName("Los Angeles Rams");
		}
		}
		return str;
	}

}
