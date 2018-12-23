package data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FullStats{
	@JsonProperty("GamesPlayed")
	Stat GamesPlayed;

	@JsonProperty("PassAttempts")
	Stat PassAttempts;

	@JsonProperty("PassCompletions")
	Stat PassCompletions;

	@JsonProperty("PassPct")
	Stat PassPct;

	@JsonProperty("PassGrossYards")
	Stat PassGrossYards;

	@JsonProperty("PassNetYards")
	Stat PassNetYards;

	@JsonProperty("PassAvg")
	Stat PassAvg;

	@JsonProperty("PassYardsPerAtt")
	Stat PassYardsPerAtt;

	@JsonProperty("PassTD")
	Stat PassTD;

	@JsonProperty("PassTDPct")
	Stat PassTDPct;

	@JsonProperty("PassInt")
	Stat PassInt;

	@JsonProperty("PassIntPct")
	Stat PassIntPct;

	@JsonProperty("PassLng")
	Stat PassLng;

	@JsonProperty("Pass20Plus")
	Stat Pass20Plus;

	@JsonProperty("Pass40Plus")
	Stat Pass40Plus;

	@JsonProperty("PassSacks")
	Stat PassSacks;

	@JsonProperty("PassSackY")
	Stat PassSackY;

	@JsonProperty("QBRating")
	Stat QBRating;

	@JsonProperty("RushAttempts")
	Stat RushAttempts;

	@JsonProperty("RushYards")
	Stat RushYards;

	@JsonProperty("RushAverage")
	Stat RushAverage;

	@JsonProperty("RushTD")
	Stat RushTD;

	@JsonProperty("RushLng")
	Stat RushLng;

	@JsonProperty("Rush20Plus")
	Stat Rush20Plus;

	@JsonProperty("Rush40Plus")
	Stat Rush40Plus;

	@JsonProperty("RushFumbles")
	Stat RushFumbles;

	@JsonProperty("Receptions")
	Stat Receptions;

	@JsonProperty("RecYards")
	Stat RecYards;

	@JsonProperty("RecAverage")
	Stat RecAverage;

	@JsonProperty("RecTD")
	Stat RecTD;

	@JsonProperty("RecLng")
	Stat RecLng;

	@JsonProperty("Rec20Plus")
	Stat Rec20Plus;

	@JsonProperty("Rec40Plus")
	Stat Rec40Plus;

	@JsonProperty("RecFumbles")
	Stat RecFumbles;

	@JsonProperty("TackleSolo")
	Stat TackleSolo;

	@JsonProperty("TackleTotal")
	Stat TackleTotal;

	@JsonProperty("TackleAst")
	Stat TackleAst;

	@JsonProperty("Sacks")
	Stat Sacks;

	@JsonProperty("SackYds")
	Stat SackYds;

	@JsonProperty("Safeties")
	Stat Safeties;

	@JsonProperty("Interceptions")
	Stat Interceptions;

	@JsonProperty("IntTD")
	Stat IntTD;

	@JsonProperty("IntYds")
	Stat IntYds;

	@JsonProperty("IntAverage")
	Stat IntAverage;

	@JsonProperty("IntLng")
	Stat IntLng;

	@JsonProperty("PassesDefended")
	Stat PassesDefended;

	@JsonProperty("Stuffs")
	Stat Stuffs;

	@JsonProperty("StuffYds")
	Stat StuffYds;

	@JsonProperty("KB")
	Stat KB;

	@JsonProperty("Fumbles")
	Stat Fumbles;

	@JsonProperty("FumLost")
	Stat FumLost;

	@JsonProperty("FumForced")
	Stat FumForced;

	@JsonProperty("FumOwnRec")
	Stat FumOwnRec;

	@JsonProperty("FumOppRec")
	Stat FumOppRec;

	@JsonProperty("FumRecYds")
	Stat FumRecYds;

	@JsonProperty("FumTotalRec")
	Stat FumTotalRec;

	@JsonProperty("FumTD")
	Stat FumTD;

	@JsonProperty("KrRet")
	Stat KrRet;

	@JsonProperty("KrYds")
	Stat KrYds;

	@JsonProperty("KrAvg")
	Stat KrAvg;

	@JsonProperty("KrLng")
	Stat KrLng;

	@JsonProperty("KrTD")
	Stat KrTD;

	@JsonProperty("Kr20Plus")
	Stat Kr20Plus;

	@JsonProperty("Kr40Plus")
	Stat Kr40Plus;

	@JsonProperty("KrFC")
	Stat KrFC;

	@JsonProperty("KrFum")
	Stat KrFum;

	@JsonProperty("PrRet")
	Stat PrRet;

	@JsonProperty("PrYds")
	Stat PrYds;

	@JsonProperty("PrAvg")
	Stat PrAvg;

	@JsonProperty("PrLng")
	Stat PrLng;

	@JsonProperty("PrTD")
	Stat PrTD;

	@JsonProperty("Pr20Plus")
	Stat Pr20Plus;

	@JsonProperty("Pr40Plus")
	Stat Pr40Plus;

	@JsonProperty("PrFC")
	Stat PrFC;

	@JsonProperty("PrFum")
	Stat PrFum;

	@JsonProperty("FgBlk")
	Stat FgBlk;

	@JsonProperty("FgMade")
	Stat FgMade;

	@JsonProperty("FgAtt")
	Stat FgAtt;

	@JsonProperty("FgPct")
	Stat FgPct;

	@JsonProperty("FgMade50Plus")
	Stat FgMade50Plus;

	@JsonProperty("FgAtt50Plus")
	Stat FgAtt50Plus;

	@JsonProperty("Fg50PlusPct")
	Stat Fg50PlusPct;

	@JsonProperty("FgLng")
	Stat FgLng;

	@JsonProperty("XpBlk")
	Stat XpBlk;

	@JsonProperty("XpMade")
	Stat XpMade;

	@JsonProperty("XpAtt")
	Stat XpAtt;

	@JsonProperty("XpPct")
	Stat XpPct;

	@JsonProperty("FgAndXpPts")
	Stat FgAndXpPts;

	@JsonProperty("Kickoffs")
	Stat Kickoffs;

	@JsonProperty("KoYds")
	Stat KoYds;

	@JsonProperty("KoOOB")
	Stat KoOOB;

	@JsonProperty("KoAvg")
	Stat KoAvg;

	@JsonProperty("KoTB")
	Stat KoTB;

	@JsonProperty("KoPct")
	Stat KoPct;

	@JsonProperty("KoRet")
	Stat KoRet;

	@JsonProperty("KoRetYds")
	Stat KoRetYds;

	@JsonProperty("KoRetAvgYds")
	Stat KoRetAvgYds;

	@JsonProperty("KoTD")
	Stat KoTD;

	@JsonProperty("KoOS")
	Stat KoOS;

	@JsonProperty("KoOSR")
	Stat KoOSR;

	@JsonProperty("Punts")
	Stat Punts;

	@JsonProperty("PuntYds")
	Stat PuntYds;

	@JsonProperty("PuntNetYds")
	Stat PuntNetYds;

	@JsonProperty("PuntLng")
	Stat PuntLng;

	@JsonProperty("PuntAvg")
	Stat PuntAvg;

	@JsonProperty("PuntNetAvg")
	Stat PuntNetAvg;

	@JsonProperty("PuntBlk")
	Stat PuntBlk;

	@JsonProperty("PuntOOB")
	Stat PuntOOB;

	@JsonProperty("PuntDown")
	Stat PuntDown;

	@JsonProperty("PuntIn20")
	Stat PuntIn20;

	@JsonProperty("PuntIn20Pct")
	Stat PuntIn20Pct;

	@JsonProperty("PuntTB")
	Stat PuntTB;

	@JsonProperty("PuntTBPct")
	Stat PuntTBPct;

	@JsonProperty("PuntFC")
	Stat PuntFC;

	@JsonProperty("PuntRet")
	Stat PuntRet;

	@JsonProperty("PuntRetYds")
	Stat PuntRetYds;

	@JsonProperty("PuntRetAvg")
	Stat PuntRetAvg;

	@JsonProperty("FirstDownsTotal")
	Stat FirstDownsTotal;

	@JsonProperty("FirstDownsPass")
	Stat FirstDownsPass;

	@JsonProperty("FirstDownsRush")
	Stat FirstDownsRush;

	@JsonProperty("FirstDownsPenalty")
	Stat FirstDownsPenalty;

	@JsonProperty("ThirdDowns")
	Stat ThirdDowns;

	@JsonProperty("ThirdDownsAtt")
	Stat ThirdDownsAtt;

	@JsonProperty("ThirdDownsPct")
	Stat ThirdDownsPct;

	@JsonProperty("FourthDowns")
	Stat FourthDowns;

	@JsonProperty("FourthDownsAtt")
	Stat FourthDownsAtt;

	@JsonProperty("FourthDownsPct")
	Stat FourthDownsPct;

	@JsonProperty("Penalties")
	Stat Penalties;

	@JsonProperty("PenaltyYds")
	Stat PenaltyYds;

	@JsonProperty("OffensePlays")
	Stat OffensePlays;

	@JsonProperty("OffenseYds")
	Stat OffenseYds;

	@JsonProperty("OffenseAvgYds")
	Stat OffenseAvgYds;

	@JsonProperty("TotalTD")
	Stat TotalTD;

	@JsonProperty("PointsFor")
	Stat PointsFor;

	@JsonProperty("PointsAgainst")
	Stat PointsAgainst;

	@JsonProperty("PointDifferential")
	Stat PointDifferential;

	@JsonProperty("TwoPtAtt")
	Stat TwoPtAtt;

	@JsonProperty("TwoPtMade")
	Stat TwoPtMade;

	@JsonProperty("TwoPtPassAtt")
	Stat TwoPtPassAtt;

	@JsonProperty("TwoPtPassMade")
	Stat TwoPtPassMade;

	@JsonProperty("TwoPtRushAtt")
	Stat TwoPtRushAtt;

	@JsonProperty("TwoPtRushMade")
	Stat TwoPtRushMade;

	@JsonProperty("TacklesForLoss")
	Stat TacklesForLoss;

	@JsonProperty("FgMade1_19")
	Stat FgMade1_19;

	@JsonProperty("FgAtt1_19")
	Stat FgAtt1_19;

	@JsonProperty("Fg1_19Pct")
	Stat Fg1_19Pct;

	@JsonProperty("FgMade20_29")
	Stat FgMade20_29;

	@JsonProperty("FgAtt20_29")
	Stat FgAtt20_29;

	@JsonProperty("Fg20_29Pct")
	Stat Fg20_29Pct;

	@JsonProperty("FgMade30_39")
	Stat FgMade30_39;

	@JsonProperty("FgAtt30_39")
	Stat FgAtt30_39;

	@JsonProperty("Fg30_39Pct")
	Stat Fg30_39Pct;

	@JsonProperty("FgMade40_49")
	Stat FgMade40_49;

	@JsonProperty("FgAtt40_49")
	Stat FgAtt40_49;

	@JsonProperty("Fg40_49Pct")
	Stat Fg40_49Pct;

	@JsonProperty("Wins")
	Stat Wins;

	@JsonProperty("Losses")
	Stat Losses;

	@JsonProperty("Ties")
	Stat Ties;

	@JsonProperty("OTWins")
	Stat OTWins;

	@JsonProperty("OTLosses")
	Stat OTLosses;

	@JsonProperty("WinPct")
	Stat WinPct;

	Stat[] AllStats;

	public void setGamesPlayed(Stat str)
	{
		GamesPlayed= str;
	}

	public void setPassAttempts(Stat str)
	{
		PassAttempts= str;
	}

	public void setPassCompletions(Stat str)
	{
		PassCompletions= str;
	}

	public void setPassPct(Stat str)
	{
		PassPct= str;
	}

	public void setPassGrossYards(Stat str)
	{
		PassGrossYards= str;
	}

	public void setPassNetYards(Stat str)
	{
		PassNetYards= str;
	}

	public void setPassAvg(Stat str)
	{
		PassAvg= str;
	}

	public void setPassYardsPerAtt(Stat str)
	{
		PassYardsPerAtt= str;
	}

	public void setPassTD(Stat str)
	{
		PassTD= str;
	}

	public void setPassTDPct(Stat str)
	{
		PassTDPct= str;
	}

	public void setPassInt(Stat str)
	{
		PassInt= str;
	}

	public void setPassIntPct(Stat str)
	{
		PassIntPct= str;
	}

	public void setPassLng(Stat str)
	{
		PassLng= str;
	}

	public void setPass20Plus(Stat str)
	{
		Pass20Plus= str;
	}

	public void setPass40Plus(Stat str)
	{
		Pass40Plus= str;
	}

	public void setPassSacks(Stat str)
	{
		PassSacks= str;
	}

	public void setPassSackY(Stat str)
	{
		PassSackY= str;
	}

	public void setQBRating(Stat str)
	{
		QBRating= str;
	}

	public void setRushAttempts(Stat str)
	{
		RushAttempts= str;
	}

	public void setRushYards(Stat str)
	{
		RushYards= str;
	}

	public void setRushAverage(Stat str)
	{
		RushAverage= str;
	}

	public void setRushTD(Stat str)
	{
		RushTD= str;
	}

	public void setRushLng(Stat str)
	{
		RushLng= str;
	}

	public void setRush20Plus(Stat str)
	{
		Rush20Plus= str;
	}

	public void setRush40Plus(Stat str)
	{
		Rush40Plus= str;
	}

	public void setRushFumbles(Stat str)
	{
		RushFumbles= str;
	}

	public void setReceptions(Stat str)
	{
		Receptions= str;
	}

	public void setRecYards(Stat str)
	{
		RecYards= str;
	}

	public void setRecAverage(Stat str)
	{
		RecAverage= str;
	}

	public void setRecTD(Stat str)
	{
		RecTD= str;
	}

	public void setRecLng(Stat str)
	{
		RecLng= str;
	}

	public void setRec20Plus(Stat str)
	{
		Rec20Plus= str;
	}

	public void setRec40Plus(Stat str)
	{
		Rec40Plus= str;
	}

	public void setRecFumbles(Stat str)
	{
		RecFumbles= str;
	}

	public void setTackleSolo(Stat str)
	{
		TackleSolo= str;
	}

	public void setTackleTotal(Stat str)
	{
		TackleTotal= str;
	}

	public void setTackleAst(Stat str)
	{
		TackleAst= str;
	}

	public void setSacks(Stat str)
	{
		Sacks= str;
	}

	public void setSackYds(Stat str)
	{
		SackYds= str;
	}

	public void setSafeties(Stat str)
	{
		Safeties= str;
	}

	public void setInterceptions(Stat str)
	{
		Interceptions= str;
	}

	public void setIntTD(Stat str)
	{
		IntTD= str;
	}

	public void setIntYds(Stat str)
	{
		IntYds= str;
	}

	public void setIntAverage(Stat str)
	{
		IntAverage= str;
	}

	public void setIntLng(Stat str)
	{
		IntLng= str;
	}

	public void setPassesDefended(Stat str)
	{
		PassesDefended= str;
	}

	public void setStuffs(Stat str)
	{
		Stuffs= str;
	}

	public void setStuffYds(Stat str)
	{
		StuffYds= str;
	}

	public void setKB(Stat str)
	{
		KB= str;
	}

	public void setFumbles(Stat str)
	{
		Fumbles= str;
	}

	public void setFumLost(Stat str)
	{
		FumLost= str;
	}

	public void setFumForced(Stat str)
	{
		FumForced= str;
	}

	public void setFumOwnRec(Stat str)
	{
		FumOwnRec= str;
	}

	public void setFumOppRec(Stat str)
	{
		FumOppRec= str;
	}

	public void setFumRecYds(Stat str)
	{
		FumRecYds= str;
	}

	public void setFumTotalRec(Stat str)
	{
		FumTotalRec= str;
	}

	public void setFumTD(Stat str)
	{
		FumTD= str;
	}

	public void setKrRet(Stat str)
	{
		KrRet= str;
	}

	public void setKrYds(Stat str)
	{
		KrYds= str;
	}

	public void setKrAvg(Stat str)
	{
		KrAvg= str;
	}

	public void setKrLng(Stat str)
	{
		KrLng= str;
	}

	public void setKrTD(Stat str)
	{
		KrTD= str;
	}

	public void setKr20Plus(Stat str)
	{
		Kr20Plus= str;
	}

	public void setKr40Plus(Stat str)
	{
		Kr40Plus= str;
	}

	public void setKrFC(Stat str)
	{
		KrFC= str;
	}

	public void setKrFum(Stat str)
	{
		KrFum= str;
	}

	public void setPrRet(Stat str)
	{
		PrRet= str;
	}

	public void setPrYds(Stat str)
	{
		PrYds= str;
	}

	public void setPrAvg(Stat str)
	{
		PrAvg= str;
	}

	public void setPrLng(Stat str)
	{
		PrLng= str;
	}

	public void setPrTD(Stat str)
	{
		PrTD= str;
	}

	public void setPr20Plus(Stat str)
	{
		Pr20Plus= str;
	}

	public void setPr40Plus(Stat str)
	{
		Pr40Plus= str;
	}

	public void setPrFC(Stat str)
	{
		PrFC= str;
	}

	public void setPrFum(Stat str)
	{
		PrFum= str;
	}

	public void setFgBlk(Stat str)
	{
		FgBlk= str;
	}

	public void setFgMade(Stat str)
	{
		FgMade= str;
	}

	public void setFgAtt(Stat str)
	{
		FgAtt= str;
	}

	public void setFgPct(Stat str)
	{
		FgPct= str;
	}

	public void setFgMade50Plus(Stat str)
	{
		FgMade50Plus= str;
	}

	public void setFgAtt50Plus(Stat str)
	{
		FgAtt50Plus= str;
	}

	public void setFg50PlusPct(Stat str)
	{
		Fg50PlusPct= str;
	}

	public void setFgLng(Stat str)
	{
		FgLng= str;
	}

	public void setXpBlk(Stat str)
	{
		XpBlk= str;
	}

	public void setXpMade(Stat str)
	{
		XpMade= str;
	}

	public void setXpAtt(Stat str)
	{
		XpAtt= str;
	}

	public void setXpPct(Stat str)
	{
		XpPct= str;
	}

	public void setFgAndXpPts(Stat str)
	{
		FgAndXpPts= str;
	}

	public void setKickoffs(Stat str)
	{
		Kickoffs= str;
	}

	public void setKoYds(Stat str)
	{
		KoYds= str;
	}

	public void setKoOOB(Stat str)
	{
		KoOOB= str;
	}

	public void setKoAvg(Stat str)
	{
		KoAvg= str;
	}

	public void setKoTB(Stat str)
	{
		KoTB= str;
	}

	public void setKoPct(Stat str)
	{
		KoPct= str;
	}

	public void setKoRet(Stat str)
	{
		KoRet= str;
	}

	public void setKoRetYds(Stat str)
	{
		KoRetYds= str;
	}

	public void setKoRetAvgYds(Stat str)
	{
		KoRetAvgYds= str;
	}

	public void setKoTD(Stat str)
	{
		KoTD= str;
	}

	public void setKoOS(Stat str)
	{
		KoOS= str;
	}

	public void setKoOSR(Stat str)
	{
		KoOSR= str;
	}

	public void setPunts(Stat str)
	{
		Punts= str;
	}

	public void setPuntYds(Stat str)
	{
		PuntYds= str;
	}

	public void setPuntNetYds(Stat str)
	{
		PuntNetYds= str;
	}

	public void setPuntLng(Stat str)
	{
		PuntLng= str;
	}

	public void setPuntAvg(Stat str)
	{
		PuntAvg= str;
	}

	public void setPuntNetAvg(Stat str)
	{
		PuntNetAvg= str;
	}

	public void setPuntBlk(Stat str)
	{
		PuntBlk= str;
	}

	public void setPuntOOB(Stat str)
	{
		PuntOOB= str;
	}

	public void setPuntDown(Stat str)
	{
		PuntDown= str;
	}

	public void setPuntIn20(Stat str)
	{
		PuntIn20= str;
	}

	public void setPuntIn20Pct(Stat str)
	{
		PuntIn20Pct= str;
	}

	public void setPuntTB(Stat str)
	{
		PuntTB= str;
	}

	public void setPuntTBPct(Stat str)
	{
		PuntTBPct= str;
	}

	public void setPuntFC(Stat str)
	{
		PuntFC= str;
	}

	public void setPuntRet(Stat str)
	{
		PuntRet= str;
	}

	public void setPuntRetYds(Stat str)
	{
		PuntRetYds= str;
	}

	public void setPuntRetAvg(Stat str)
	{
		PuntRetAvg= str;
	}

	public void setFirstDownsTotal(Stat str)
	{
		FirstDownsTotal= str;
	}

	public void setFirstDownsPass(Stat str)
	{
		FirstDownsPass= str;
	}

	public void setFirstDownsRush(Stat str)
	{
		FirstDownsRush= str;
	}

	public void setFirstDownsPenalty(Stat str)
	{
		FirstDownsPenalty= str;
	}

	public void setThirdDowns(Stat str)
	{
		ThirdDowns= str;
	}

	public void setThirdDownsAtt(Stat str)
	{
		ThirdDownsAtt= str;
	}

	public void setThirdDownsPct(Stat str)
	{
		ThirdDownsPct= str;
	}

	public void setFourthDowns(Stat str)
	{
		FourthDowns= str;
	}

	public void setFourthDownsAtt(Stat str)
	{
		FourthDownsAtt= str;
	}

	public void setFourthDownsPct(Stat str)
	{
		FourthDownsPct= str;
	}

	public void setPenalties(Stat str)
	{
		Penalties= str;
	}

	public void setPenaltyYds(Stat str)
	{
		PenaltyYds= str;
	}

	public void setOffensePlays(Stat str)
	{
		OffensePlays= str;
	}

	public void setOffenseYds(Stat str)
	{
		OffenseYds= str;
	}

	public void setOffenseAvgYds(Stat str)
	{
		OffenseAvgYds= str;
	}

	public void setTotalTD(Stat str)
	{
		TotalTD= str;
	}

	public void setPointsFor(Stat str)
	{
		PointsFor= str;
	}

	public void setPointsAgainst(Stat str)
	{
		PointsAgainst= str;
	}

	public void setPointDifferential(Stat str)
	{
		PointDifferential= str;
	}

	public void setTwoPtAtt(Stat str)
	{
		TwoPtAtt= str;
	}

	public void setTwoPtMade(Stat str)
	{
		TwoPtMade= str;
	}

	public void setTwoPtPassAtt(Stat str)
	{
		TwoPtPassAtt= str;
	}

	public void setTwoPtPassMade(Stat str)
	{
		TwoPtPassMade= str;
	}

	public void setTwoPtRushAtt(Stat str)
	{
		TwoPtRushAtt= str;
	}

	public void setTwoPtRushMade(Stat str)
	{
		TwoPtRushMade= str;
	}

	public void setTacklesForLoss(Stat str)
	{
		TacklesForLoss= str;
	}

	public void setFgMade1_19(Stat str)
	{
		FgMade1_19= str;
	}

	public void setFgAtt1_19(Stat str)
	{
		FgAtt1_19= str;
	}

	public void setFg1_19Pct(Stat str)
	{
		Fg1_19Pct= str;
	}

	public void setFgMade20_29(Stat str)
	{
		FgMade20_29= str;
	}

	public void setFgAtt20_29(Stat str)
	{
		FgAtt20_29= str;
	}

	public void setFg20_29Pct(Stat str)
	{
		Fg20_29Pct= str;
	}

	public void setFgMade30_39(Stat str)
	{
		FgMade30_39= str;
	}

	public void setFgAtt30_39(Stat str)
	{
		FgAtt30_39= str;
	}

	public void setFg30_39Pct(Stat str)
	{
		Fg30_39Pct= str;
	}

	public void setFgMade40_49(Stat str)
	{
		FgMade40_49= str;
	}

	public void setFgAtt40_49(Stat str)
	{
		FgAtt40_49= str;
	}

	public void setFg40_49Pct(Stat str)
	{
		Fg40_49Pct= str;
	}

	public void setWins(Stat str)
	{
		Wins= str;
	}

	public void setLosses(Stat str)
	{
		Losses= str;
	}

	public void setTies(Stat str)
	{
		Ties= str;
	}

	public void setOTWins(Stat str)
	{
		OTWins= str;
	}

	public void setOTLosses(Stat str)
	{
		OTLosses= str;
	}

	public void setWinPct(Stat str)
	{
		WinPct= str;
	}

	public void combine()
	{
		Stat[] temp = {GamesPlayed, PassAttempts, PassCompletions, PassPct, PassGrossYards, PassNetYards, PassAvg, PassYardsPerAtt, PassTD, PassTDPct, PassInt, PassIntPct, PassLng, Pass20Plus, Pass40Plus, PassSacks, PassSackY, QBRating, RushAttempts, RushYards, RushAverage, RushTD, RushLng, Rush20Plus, Rush40Plus, RushFumbles, Receptions, RecYards, RecAverage, RecTD, RecLng, Rec20Plus, Rec40Plus, RecFumbles, TackleSolo, TackleTotal, TackleAst, Sacks, SackYds, Safeties, Interceptions, IntTD, IntYds, IntAverage, IntLng, PassesDefended, Stuffs, StuffYds, KB, Fumbles, FumLost, FumForced, FumOwnRec, FumOppRec, FumRecYds, FumTotalRec, FumTD, KrRet, KrYds, KrAvg, KrLng, KrTD, Kr20Plus, Kr40Plus, KrFC, KrFum, PrRet, PrYds, PrAvg, PrLng, PrTD, Pr20Plus, Pr40Plus, PrFC, PrFum, FgBlk, FgMade, FgAtt, FgPct, FgMade50Plus, FgAtt50Plus, Fg50PlusPct, FgLng, XpBlk, XpMade, XpAtt, XpPct, FgAndXpPts, Kickoffs, KoYds, KoOOB, KoAvg, KoTB, KoPct, KoRet, KoRetYds, KoRetAvgYds, KoTD, KoOS, KoOSR, Punts, PuntYds, PuntNetYds, PuntLng, PuntAvg, PuntNetAvg, PuntBlk, PuntOOB, PuntDown, PuntIn20, PuntIn20Pct, PuntTB, PuntTBPct, PuntFC, PuntRet, PuntRetYds, PuntRetAvg, FirstDownsTotal, FirstDownsPass, FirstDownsRush, FirstDownsPenalty, ThirdDowns, ThirdDownsAtt, ThirdDownsPct, FourthDowns, FourthDownsAtt, FourthDownsPct, Penalties, PenaltyYds, OffensePlays, OffenseYds, OffenseAvgYds, TotalTD, PointsFor, PointsAgainst, PointDifferential, TwoPtAtt, TwoPtMade, TwoPtPassAtt, TwoPtPassMade, TwoPtRushAtt, TwoPtRushMade, TacklesForLoss, FgMade1_19, FgAtt1_19, Fg1_19Pct, FgMade20_29, FgAtt20_29, Fg20_29Pct, FgMade30_39, FgAtt30_39, Fg30_39Pct, FgMade40_49, FgAtt40_49, Fg40_49Pct, Wins, Losses, Ties, OTWins, OTLosses, WinPct};
		AllStats = temp;
	}

	public String toString()
	{
		if(AllStats == null)
			combine();
		String str = "";
		for(Stat s : AllStats)
		{
			if(s != null && s.text != null)
				str += s.toString();
		}
	return str;
	}
}