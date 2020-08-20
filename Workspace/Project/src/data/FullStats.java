package data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FullStats{
	@JsonProperty("GamesPlayed")
	private Stat GamesPlayed;

	@JsonProperty("PassAttempts")
	private Stat PassAttempts;

	@JsonProperty("PassCompletions")
	private Stat PassCompletions;

	@JsonProperty("PassPct")
	private Stat PassPct;

	@JsonProperty("PassGrossYards")
	private Stat PassGrossYards;

	@JsonProperty("PassNetYards")
	private Stat PassNetYards;

	@JsonProperty("PassAvg")
	private Stat PassAvg;

	@JsonProperty("PassYardsPerAtt")
	private Stat PassYardsPerAtt;

	@JsonProperty("PassTD")
	private Stat PassTD;

	@JsonProperty("PassTDPct")
	private Stat PassTDPct;

	@JsonProperty("PassInt")
	private Stat PassInt;

	@JsonProperty("PassIntPct")
	private Stat PassIntPct;

	@JsonProperty("PassLng")
	private Stat PassLng;

	@JsonProperty("Pass20Plus")
	private Stat Pass20Plus;

	@JsonProperty("Pass40Plus")
	private Stat Pass40Plus;

	@JsonProperty("PassSacks")
	private Stat PassSacks;

	@JsonProperty("PassSackY")
	private Stat PassSackY;

	@JsonProperty("QBRating")
	private Stat QBRating;

	@JsonProperty("RushAttempts")
	private Stat RushAttempts;

	@JsonProperty("RushYards")
	private Stat RushYards;

	@JsonProperty("RushAverage")
	private Stat RushAverage;

	@JsonProperty("RushTD")
	private Stat RushTD;

	@JsonProperty("RushLng")
	private Stat RushLng;

	@JsonProperty("Rush20Plus")
	private Stat Rush20Plus;

	@JsonProperty("Rush40Plus")
	private Stat Rush40Plus;

	@JsonProperty("RushFumbles")
	private Stat RushFumbles;

	@JsonProperty("Receptions")
	private Stat Receptions;

	@JsonProperty("RecYards")
	private Stat RecYards;

	@JsonProperty("RecAverage")
	private Stat RecAverage;

	@JsonProperty("RecTD")
	private Stat RecTD;

	@JsonProperty("RecLng")
	private Stat RecLng;

	@JsonProperty("Rec20Plus")
	private Stat Rec20Plus;

	@JsonProperty("Rec40Plus")
	private Stat Rec40Plus;

	@JsonProperty("RecFumbles")
	private Stat RecFumbles;

	@JsonProperty("TackleSolo")
	private Stat TackleSolo;

	@JsonProperty("TackleTotal")
	private Stat TackleTotal;

	@JsonProperty("TackleAst")
	private Stat TackleAst;

	@JsonProperty("Sacks")
	private Stat Sacks;

	@JsonProperty("SackYds")
	private Stat SackYds;

	@JsonProperty("Safeties")
	private Stat Safeties;

	@JsonProperty("Interceptions")
	private Stat Interceptions;

	@JsonProperty("IntTD")
	private Stat IntTD;

	@JsonProperty("IntYds")
	private Stat IntYds;

	@JsonProperty("IntAverage")
	private Stat IntAverage;

	@JsonProperty("IntLng")
	private Stat IntLng;

	@JsonProperty("PassesDefended")
	private Stat PassesDefended;

	@JsonProperty("Stuffs")
	private Stat Stuffs;

	@JsonProperty("StuffYds")
	private Stat StuffYds;

	@JsonProperty("KB")
	private Stat KB;

	@JsonProperty("Fumbles")
	private Stat Fumbles;

	@JsonProperty("FumLost")
	private Stat FumLost;

	@JsonProperty("FumForced")
	private Stat FumForced;

	@JsonProperty("FumOwnRec")
	private Stat FumOwnRec;

	@JsonProperty("FumOppRec")
	private Stat FumOppRec;

	@JsonProperty("FumRecYds")
	private Stat FumRecYds;

	@JsonProperty("FumTotalRec")
	private Stat FumTotalRec;

	@JsonProperty("FumTD")
	private Stat FumTD;

	@JsonProperty("KrRet")
	private Stat KrRet;

	@JsonProperty("KrYds")
	private Stat KrYds;

	@JsonProperty("KrAvg")
	private Stat KrAvg;

	@JsonProperty("KrLng")
	private Stat KrLng;

	@JsonProperty("KrTD")
	private Stat KrTD;

	@JsonProperty("Kr20Plus")
	private Stat Kr20Plus;

	@JsonProperty("Kr40Plus")
	private Stat Kr40Plus;

	@JsonProperty("KrFC")
	private Stat KrFC;

	@JsonProperty("KrFum")
	private Stat KrFum;

	@JsonProperty("PrRet")
	private Stat PrRet;

	@JsonProperty("PrYds")
	private Stat PrYds;

	@JsonProperty("PrAvg")
	private Stat PrAvg;

	@JsonProperty("PrLng")
	private Stat PrLng;

	@JsonProperty("PrTD")
	private Stat PrTD;

	@JsonProperty("Pr20Plus")
	private Stat Pr20Plus;

	@JsonProperty("Pr40Plus")
	private Stat Pr40Plus;

	@JsonProperty("PrFC")
	private Stat PrFC;

	@JsonProperty("PrFum")
	private Stat PrFum;

	@JsonProperty("FgBlk")
	private Stat FgBlk;

	@JsonProperty("FgMade")
	private Stat FgMade;

	@JsonProperty("FgAtt")
	private Stat FgAtt;

	@JsonProperty("FgPct")
	private Stat FgPct;

	@JsonProperty("FgMade50Plus")
	private Stat FgMade50Plus;

	@JsonProperty("FgAtt50Plus")
	private Stat FgAtt50Plus;

	@JsonProperty("Fg50PlusPct")
	private Stat Fg50PlusPct;

	@JsonProperty("FgLng")
	private Stat FgLng;

	@JsonProperty("XpBlk")
	private Stat XpBlk;

	@JsonProperty("XpMade")
	private Stat XpMade;

	@JsonProperty("XpAtt")
	private Stat XpAtt;

	@JsonProperty("XpPct")
	private Stat XpPct;

	@JsonProperty("FgAndXpPts")
	private Stat FgAndXpPts;

	@JsonProperty("Kickoffs")
	private Stat Kickoffs;

	@JsonProperty("KoYds")
	private Stat KoYds;

	@JsonProperty("KoOOB")
	private Stat KoOOB;

	@JsonProperty("KoAvg")
	private Stat KoAvg;

	@JsonProperty("KoTB")
	private Stat KoTB;

	@JsonProperty("KoPct")
	private Stat KoPct;

	@JsonProperty("KoRet")
	private Stat KoRet;

	@JsonProperty("KoRetYds")
	private Stat KoRetYds;

	@JsonProperty("KoRetAvgYds")
	private Stat KoRetAvgYds;

	@JsonProperty("KoTD")
	private Stat KoTD;

	@JsonProperty("KoOS")
	private Stat KoOS;

	@JsonProperty("KoOSR")
	private Stat KoOSR;

	@JsonProperty("Punts")
	private Stat Punts;

	@JsonProperty("PuntYds")
	private Stat PuntYds;

	@JsonProperty("PuntNetYds")
	private Stat PuntNetYds;

	@JsonProperty("PuntLng")
	private Stat PuntLng;

	@JsonProperty("PuntAvg")
	private Stat PuntAvg;

	@JsonProperty("PuntNetAvg")
	private Stat PuntNetAvg;

	@JsonProperty("PuntBlk")
	private Stat PuntBlk;

	@JsonProperty("PuntOOB")
	private Stat PuntOOB;

	@JsonProperty("PuntDown")
	private Stat PuntDown;

	@JsonProperty("PuntIn20")
	private Stat PuntIn20;

	@JsonProperty("PuntIn20Pct")
	private Stat PuntIn20Pct;

	@JsonProperty("PuntTB")
	private Stat PuntTB;

	@JsonProperty("PuntTBPct")
	private Stat PuntTBPct;

	@JsonProperty("PuntFC")
	private Stat PuntFC;

	@JsonProperty("PuntRet")
	private Stat PuntRet;

	@JsonProperty("PuntRetYds")
	private Stat PuntRetYds;

	@JsonProperty("PuntRetAvg")
	private Stat PuntRetAvg;

	@JsonProperty("FirstDownsTotal")
	private Stat FirstDownsTotal;

	@JsonProperty("FirstDownsPass")
	private Stat FirstDownsPass;

	@JsonProperty("FirstDownsRush")
	private Stat FirstDownsRush;

	@JsonProperty("FirstDownsPenalty")
	private Stat FirstDownsPenalty;

	@JsonProperty("ThirdDowns")
	private Stat ThirdDowns;

	@JsonProperty("ThirdDownsAtt")
	private Stat ThirdDownsAtt;

	@JsonProperty("ThirdDownsPct")
	private Stat ThirdDownsPct;

	@JsonProperty("FourthDowns")
	private Stat FourthDowns;

	@JsonProperty("FourthDownsAtt")
	private Stat FourthDownsAtt;

	@JsonProperty("FourthDownsPct")
	private Stat FourthDownsPct;

	@JsonProperty("Penalties")
	private Stat Penalties;

	@JsonProperty("PenaltyYds")
	private Stat PenaltyYds;

	@JsonProperty("OffensePlays")
	private Stat OffensePlays;

	@JsonProperty("OffenseYds")
	private Stat OffenseYds;

	@JsonProperty("OffenseAvgYds")
	private Stat OffenseAvgYds;

	@JsonProperty("TotalTD")
	private Stat TotalTD;

	@JsonProperty("PointsFor")
	private Stat PointsFor;

	@JsonProperty("PointsAgainst")
	private Stat PointsAgainst;

	@JsonProperty("PointDifferential")
	private Stat PointDifferential;

	@JsonProperty("TwoPtAtt")
	private Stat TwoPtAtt;

	@JsonProperty("TwoPtMade")
	private Stat TwoPtMade;

	@JsonProperty("TwoPtPassAtt")
	private Stat TwoPtPassAtt;

	@JsonProperty("TwoPtPassMade")
	private Stat TwoPtPassMade;

	@JsonProperty("TwoPtRushAtt")
	private Stat TwoPtRushAtt;

	@JsonProperty("TwoPtRushMade")
	private Stat TwoPtRushMade;

	@JsonProperty("TacklesForLoss")
	private Stat TacklesForLoss;

	@JsonProperty("FgMade1_19")
	private Stat FgMade1_19;

	@JsonProperty("FgAtt1_19")
	private Stat FgAtt1_19;

	@JsonProperty("Fg1_19Pct")
	private Stat Fg1_19Pct;

	@JsonProperty("FgMade20_29")
	private Stat FgMade20_29;

	@JsonProperty("FgAtt20_29")
	private Stat FgAtt20_29;

	@JsonProperty("Fg20_29Pct")
	private Stat Fg20_29Pct;

	@JsonProperty("FgMade30_39")
	private Stat FgMade30_39;

	@JsonProperty("FgAtt30_39")
	private Stat FgAtt30_39;

	@JsonProperty("Fg30_39Pct")
	private Stat Fg30_39Pct;

	@JsonProperty("FgMade40_49")
	private Stat FgMade40_49;

	@JsonProperty("FgAtt40_49")
	private Stat FgAtt40_49;

	@JsonProperty("Fg40_49Pct")
	private Stat Fg40_49Pct;

	@JsonProperty("Wins")
	private Stat Wins;

	@JsonProperty("Losses")
	private Stat Losses;

	@JsonProperty("Ties")
	private Stat Ties;

	@JsonProperty("OTWins")
	private Stat OTWins;

	@JsonProperty("OTLosses")
	private Stat OTLosses;

	@JsonProperty("WinPct")
	private Stat WinPct;

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
		double[][] coefs = {{5.0543,-7.56632, 0},{3.96577, -0.628389, 0},{1.65717, -0.964088, 1},{2.37637, -0.508062, 0}, {-0.489881,0.188785, 0},{-1.66567,0.651066, 1},{-2.61024,0.248079, 1},{7.78729,-0.297944, 1},{9.62481,-2.37839, 0},{0.563469,-0.876024, 1},{2.60792,-0.0418199, 1},{1.66567,-0.651066, 1},{0.637217,-0.559201, 1},{-0.865994,0.0380353, 0},{1.872, -.313565, 1},{2.31006, -0.071767, 1}, {1.53569, -.172076, 1}, {2.90524, -.541637, 0}, {1.64785,-0.705528, 1}, {2.93293, -.12126, 1}, {-2.93293, .12126, 1}, {-.00705551, -.00792391, 1}, {1.98017, -.51137, 1}};
		for(int i = 0; i < ImportantStats.length; i++)
		{
			ImportantStats[i].setCoefs(coefs[i][0], coefs[i][1], coefs[i][2]);
		}
	}
	
	public String toString()
	{
		if(AllStats == null)
			combine();
		String str = "";
		for(Stat s : ImportantStats)
		{
			if(s != null && s.getText() != null)
				str += s.toString();
		}
	return str;
	}
	
	public Stat getWins() {
		return Wins;
	}
	public Stat getLosses() {
		return Losses;
	}
	public Stat getTies() {
		return Ties;
	}
	public Stat getGamesPlayed() {
		return GamesPlayed;
	}
}
