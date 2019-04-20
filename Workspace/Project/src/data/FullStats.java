package data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FullStats{
	@JsonProperty("GamesPlayed")
	public Stat GamesPlayed;

	@JsonProperty("PassAttempts")
	public Stat PassAttempts;

	@JsonProperty("PassCompletions")
	public Stat PassCompletions;

	@JsonProperty("PassPct")
	public Stat PassPct;

	@JsonProperty("PassGrossYards")
	public Stat PassGrossYards;

	@JsonProperty("PassNetYards")
	public Stat PassNetYards;

	@JsonProperty("PassAvg")
	public Stat PassAvg;

	@JsonProperty("PassYardsPerAtt")
	public Stat PassYardsPerAtt;

	@JsonProperty("PassTD")
	public Stat PassTD;

	@JsonProperty("PassTDPct")
	public Stat PassTDPct;

	@JsonProperty("PassInt")
	public Stat PassInt;

	@JsonProperty("PassIntPct")
	public Stat PassIntPct;

	@JsonProperty("PassLng")
	public Stat PassLng;

	@JsonProperty("Pass20Plus")
	public Stat Pass20Plus;

	@JsonProperty("Pass40Plus")
	public Stat Pass40Plus;

	@JsonProperty("PassSacks")
	public Stat PassSacks;

	@JsonProperty("PassSackY")
	public Stat PassSackY;

	@JsonProperty("QBRating")
	public Stat QBRating;

	@JsonProperty("RushAttempts")
	public Stat RushAttempts;

	@JsonProperty("RushYards")
	public Stat RushYards;

	@JsonProperty("RushAverage")
	public Stat RushAverage;

	@JsonProperty("RushTD")
	public Stat RushTD;

	@JsonProperty("RushLng")
	public Stat RushLng;

	@JsonProperty("Rush20Plus")
	public Stat Rush20Plus;

	@JsonProperty("Rush40Plus")
	public Stat Rush40Plus;

	@JsonProperty("RushFumbles")
	public Stat RushFumbles;

	@JsonProperty("Receptions")
	public Stat Receptions;

	@JsonProperty("RecYards")
	public Stat RecYards;

	@JsonProperty("RecAverage")
	public Stat RecAverage;

	@JsonProperty("RecTD")
	public Stat RecTD;

	@JsonProperty("RecLng")
	public Stat RecLng;

	@JsonProperty("Rec20Plus")
	public Stat Rec20Plus;

	@JsonProperty("Rec40Plus")
	public Stat Rec40Plus;

	@JsonProperty("RecFumbles")
	public Stat RecFumbles;

	@JsonProperty("TackleSolo")
	public Stat TackleSolo;

	@JsonProperty("TackleTotal")
	public Stat TackleTotal;

	@JsonProperty("TackleAst")
	public Stat TackleAst;

	@JsonProperty("Sacks")
	public Stat Sacks;

	@JsonProperty("SackYds")
	public Stat SackYds;

	@JsonProperty("Safeties")
	public Stat Safeties;

	@JsonProperty("Interceptions")
	public Stat Interceptions;

	@JsonProperty("IntTD")
	public Stat IntTD;

	@JsonProperty("IntYds")
	public Stat IntYds;

	@JsonProperty("IntAverage")
	public Stat IntAverage;

	@JsonProperty("IntLng")
	public Stat IntLng;

	@JsonProperty("PassesDefended")
	public Stat PassesDefended;

	@JsonProperty("Stuffs")
	public Stat Stuffs;

	@JsonProperty("StuffYds")
	public Stat StuffYds;

	@JsonProperty("KB")
	public Stat KB;

	@JsonProperty("Fumbles")
	public Stat Fumbles;

	@JsonProperty("FumLost")
	public Stat FumLost;

	@JsonProperty("FumForced")
	public Stat FumForced;

	@JsonProperty("FumOwnRec")
	public Stat FumOwnRec;

	@JsonProperty("FumOppRec")
	public Stat FumOppRec;

	@JsonProperty("FumRecYds")
	public Stat FumRecYds;

	@JsonProperty("FumTotalRec")
	public Stat FumTotalRec;

	@JsonProperty("FumTD")
	public Stat FumTD;

	@JsonProperty("KrRet")
	public Stat KrRet;

	@JsonProperty("KrYds")
	public Stat KrYds;

	@JsonProperty("KrAvg")
	public Stat KrAvg;

	@JsonProperty("KrLng")
	public Stat KrLng;

	@JsonProperty("KrTD")
	public Stat KrTD;

	@JsonProperty("Kr20Plus")
	public Stat Kr20Plus;

	@JsonProperty("Kr40Plus")
	public Stat Kr40Plus;

	@JsonProperty("KrFC")
	public Stat KrFC;

	@JsonProperty("KrFum")
	public Stat KrFum;

	@JsonProperty("PrRet")
	public Stat PrRet;

	@JsonProperty("PrYds")
	public Stat PrYds;

	@JsonProperty("PrAvg")
	public Stat PrAvg;

	@JsonProperty("PrLng")
	public Stat PrLng;

	@JsonProperty("PrTD")
	public Stat PrTD;

	@JsonProperty("Pr20Plus")
	public Stat Pr20Plus;

	@JsonProperty("Pr40Plus")
	public Stat Pr40Plus;

	@JsonProperty("PrFC")
	public Stat PrFC;

	@JsonProperty("PrFum")
	public Stat PrFum;

	@JsonProperty("FgBlk")
	public Stat FgBlk;

	@JsonProperty("FgMade")
	public Stat FgMade;

	@JsonProperty("FgAtt")
	public Stat FgAtt;

	@JsonProperty("FgPct")
	public Stat FgPct;

	@JsonProperty("FgMade50Plus")
	public Stat FgMade50Plus;

	@JsonProperty("FgAtt50Plus")
	public Stat FgAtt50Plus;

	@JsonProperty("Fg50PlusPct")
	public Stat Fg50PlusPct;

	@JsonProperty("FgLng")
	public Stat FgLng;

	@JsonProperty("XpBlk")
	public Stat XpBlk;

	@JsonProperty("XpMade")
	public Stat XpMade;

	@JsonProperty("XpAtt")
	public Stat XpAtt;

	@JsonProperty("XpPct")
	public Stat XpPct;

	@JsonProperty("FgAndXpPts")
	public Stat FgAndXpPts;

	@JsonProperty("Kickoffs")
	public Stat Kickoffs;

	@JsonProperty("KoYds")
	public Stat KoYds;

	@JsonProperty("KoOOB")
	public Stat KoOOB;

	@JsonProperty("KoAvg")
	public Stat KoAvg;

	@JsonProperty("KoTB")
	public Stat KoTB;

	@JsonProperty("KoPct")
	public Stat KoPct;

	@JsonProperty("KoRet")
	public Stat KoRet;

	@JsonProperty("KoRetYds")
	public Stat KoRetYds;

	@JsonProperty("KoRetAvgYds")
	public Stat KoRetAvgYds;

	@JsonProperty("KoTD")
	public Stat KoTD;

	@JsonProperty("KoOS")
	public Stat KoOS;

	@JsonProperty("KoOSR")
	public Stat KoOSR;

	@JsonProperty("Punts")
	public Stat Punts;

	@JsonProperty("PuntYds")
	public Stat PuntYds;

	@JsonProperty("PuntNetYds")
	public Stat PuntNetYds;

	@JsonProperty("PuntLng")
	public Stat PuntLng;

	@JsonProperty("PuntAvg")
	public Stat PuntAvg;

	@JsonProperty("PuntNetAvg")
	public Stat PuntNetAvg;

	@JsonProperty("PuntBlk")
	public Stat PuntBlk;

	@JsonProperty("PuntOOB")
	public Stat PuntOOB;

	@JsonProperty("PuntDown")
	public Stat PuntDown;

	@JsonProperty("PuntIn20")
	public Stat PuntIn20;

	@JsonProperty("PuntIn20Pct")
	public Stat PuntIn20Pct;

	@JsonProperty("PuntTB")
	public Stat PuntTB;

	@JsonProperty("PuntTBPct")
	public Stat PuntTBPct;

	@JsonProperty("PuntFC")
	public Stat PuntFC;

	@JsonProperty("PuntRet")
	public Stat PuntRet;

	@JsonProperty("PuntRetYds")
	public Stat PuntRetYds;

	@JsonProperty("PuntRetAvg")
	public Stat PuntRetAvg;

	@JsonProperty("FirstDownsTotal")
	public Stat FirstDownsTotal;

	@JsonProperty("FirstDownsPass")
	public Stat FirstDownsPass;

	@JsonProperty("FirstDownsRush")
	public Stat FirstDownsRush;

	@JsonProperty("FirstDownsPenalty")
	public Stat FirstDownsPenalty;

	@JsonProperty("ThirdDowns")
	public Stat ThirdDowns;

	@JsonProperty("ThirdDownsAtt")
	public Stat ThirdDownsAtt;

	@JsonProperty("ThirdDownsPct")
	public Stat ThirdDownsPct;

	@JsonProperty("FourthDowns")
	public Stat FourthDowns;

	@JsonProperty("FourthDownsAtt")
	public Stat FourthDownsAtt;

	@JsonProperty("FourthDownsPct")
	public Stat FourthDownsPct;

	@JsonProperty("Penalties")
	public Stat Penalties;

	@JsonProperty("PenaltyYds")
	public Stat PenaltyYds;

	@JsonProperty("OffensePlays")
	public Stat OffensePlays;

	@JsonProperty("OffenseYds")
	public Stat OffenseYds;

	@JsonProperty("OffenseAvgYds")
	public Stat OffenseAvgYds;

	@JsonProperty("TotalTD")
	public Stat TotalTD;

	@JsonProperty("PointsFor")
	public Stat PointsFor;

	@JsonProperty("PointsAgainst")
	public Stat PointsAgainst;

	@JsonProperty("PointDifferential")
	public Stat PointDifferential;

	@JsonProperty("TwoPtAtt")
	public Stat TwoPtAtt;

	@JsonProperty("TwoPtMade")
	public Stat TwoPtMade;

	@JsonProperty("TwoPtPassAtt")
	public Stat TwoPtPassAtt;

	@JsonProperty("TwoPtPassMade")
	public Stat TwoPtPassMade;

	@JsonProperty("TwoPtRushAtt")
	public Stat TwoPtRushAtt;

	@JsonProperty("TwoPtRushMade")
	public Stat TwoPtRushMade;

	@JsonProperty("TacklesForLoss")
	public Stat TacklesForLoss;

	@JsonProperty("FgMade1_19")
	public Stat FgMade1_19;

	@JsonProperty("FgAtt1_19")
	public Stat FgAtt1_19;

	@JsonProperty("Fg1_19Pct")
	public Stat Fg1_19Pct;

	@JsonProperty("FgMade20_29")
	public Stat FgMade20_29;

	@JsonProperty("FgAtt20_29")
	public Stat FgAtt20_29;

	@JsonProperty("Fg20_29Pct")
	public Stat Fg20_29Pct;

	@JsonProperty("FgMade30_39")
	public Stat FgMade30_39;

	@JsonProperty("FgAtt30_39")
	public Stat FgAtt30_39;

	@JsonProperty("Fg30_39Pct")
	public Stat Fg30_39Pct;

	@JsonProperty("FgMade40_49")
	public Stat FgMade40_49;

	@JsonProperty("FgAtt40_49")
	public Stat FgAtt40_49;

	@JsonProperty("Fg40_49Pct")
	public Stat Fg40_49Pct;

	@JsonProperty("Wins")
	public Stat Wins;

	@JsonProperty("Losses")
	public Stat Losses;

	@JsonProperty("Ties")
	public Stat Ties;

	@JsonProperty("OTWins")
	public Stat OTWins;

	@JsonProperty("OTLosses")
	public Stat OTLosses;

	@JsonProperty("WinPct")
	public Stat WinPct;

	public Stat[] AllStats, ImportantStats;

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
		
		//Stat[] temp2 = {PassPct, PassYardsPerAtt, PassTD, PassTDPct, PassIntPct, PassSacks, PassSackY, QBRating, RushAttempts, RushAverage, RushTD, RecAverage, RecTD, FumLost, FumOwnRec, TackleTotal, Sacks, Interceptions, IntAverage, PassesDefended, Stuffs, StuffYds,  FumForced, FumOppRec, FumRecYds, FumTotalRec, FumTD, KrAvg, PrAvg, FgPct, XpPct, KoAvg, KoRetAvgYds, PuntNetAvg, PuntIn20Pct, PuntRetAvg, FirstDownsTotal, FirstDownsPass, FirstDownsRush, ThirdDownsPct, Penalties, PenaltyYds, OffenseAvgYds, TotalTD, PointsFor, PointsAgainst, PointDifferential, TacklesForLoss};
		
		Stat[] temp2 = {PassPct, PassYardsPerAtt, PassTD, PassTDPct, PassIntPct, PassSacks, PassSackY, RushAttempts, RushAverage, RushTD, TackleTotal, Sacks, Interceptions, IntAverage, PassesDefended, ThirdDownsPct, Penalties, OffenseAvgYds, TotalTD, PointsFor, PointsAgainst, PointDifferential, TacklesForLoss};
		ImportantStats = temp2;
		double[][] coefs = {{5.0543,-7.56632},{3.96577, -0.628389},{1.65717, -0.964088},{2.37637, -0.508062}, {-0.489881,0.188785},{-1.66567,0.651066},{-2.61024,0.248079},{7.78729,-0.297944},{9.62481,-2.37839},{0.563469,-0.876024},{2.60792,-0.0418199},{1.66567,-0.651066},{0.637217,-0.559201},{-0.865994,0.0380353},{1.872, -.313565},{2.31006, -0.071767}, {1.53569, -.172076}, {2.90524, -.541637}, {1.64785,-0.705528}, {2.93293, -.12126}, {-2.93293, .12126}, {-.00705551, -.00792391}, {1.98017, -.51137}};
		for(int i = 0; i < ImportantStats.length; i++)
		{
			ImportantStats[i].setCoefs(coefs[i][0], coefs[i][1]);
		}
	}
	
	public String toString()
	{
		if(AllStats == null)
			combine();
		String str = "";
		for(Stat s : ImportantStats)
		{
			if(s != null && s.text != null)
				str += s.toString();
		}
	return str;
	}
}
