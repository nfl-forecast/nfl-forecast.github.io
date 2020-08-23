package dataFromHTML;

public class FullStats {
	public String TeamName;
	
	public Stat PassAtt;

	public Stat PassCmpPCT;

	public Stat PassYdsPerAtt;

	public Stat PassTD;

	public Stat PassTDPct;

	public Stat PassINT;

	public Stat PassINTPct;

	public Stat PassSck;

	public Stat PassSckY;

	public Stat RushAtt;

	public Stat RushYPC;

	public Stat RushTD;

	
	public Stat Comb;

	public Stat Sck;

	public Stat INT;

	public Stat INTYds;

	public Stat IntAverage;

	public Stat PDef;

	public Stat ThirdMd;

	public Stat ThirdAtt;

	public Stat ThirdMdPct;

	/*
	 * @JsonProperty("Penalties") public Stat Penalties;
	 */

	public Stat OffenseAvgYds;

	public Stat TotalTD;

	public Stat PF;

	public Stat PA;

	public Stat NetPts;

	/*
	 * @JsonProperty("TacklesForLoss") public Stat TacklesForLoss;
	 */

	public Stat W;

	public Stat L;

	public Stat T;
	
	public String clinchCharacter;

	public Stat[] AllStats, ImportantStats;
	
	public void setClinchChar(String str) {
		clinchCharacter = str;
	}
	
	public void setName(String str) {
		TeamName = str;
	}

	public void setPassAtt(Stat str) {
		PassAtt = str;
	}

	public void setPassCmpPCT(Stat str) {
		PassCmpPCT = str;
	}

	public void setPassYdsPerAtt(Stat str) {
		PassYdsPerAtt = str;
	}

	public void setPassTD(Stat str) {
		PassTD = str;
	}

	public void setPassTDPct() {
		PassTDPct = new Stat();
		PassTDPct.setAbbreviation("Pass TD PCT");
		PassTDPct.setValue(""+Double.parseDouble(PassTD.getValue()) / Double.parseDouble(PassAtt.getValue()));
	}

	public void setPassINT(Stat str) {
		PassINT = str;
	}

	public void setPassINTPct() {
		PassINTPct = new Stat();
		PassINTPct.setAbbreviation("Pass INT PCT");
		PassINTPct.setValue(""+Double.parseDouble(PassINT.getValue()) / Double.parseDouble(PassAtt.getValue()));
	}

	public void setPassSck(Stat str) {
		PassSck = str;
	}

	public void setPassSckY(Stat str) {
		PassSckY = str;
	}

	public void setRushAtt(Stat str) {
		RushAtt = str;
	}

	public void setRushYPC(Stat str) {
		RushYPC = str;
	}

	public void setRushTD(Stat str) {
		RushTD = str;
	}

	public void setComb(Stat str) {
		Comb = str;
	}

	public void setSck(Stat str) {
		Sck = str;
	}

	public void setINT(Stat str) {
		INT = str;
	}

	public void setINTYds(Stat str) {
		INTYds = str;
	}

	public void setIntAverage() {
		IntAverage = new Stat();
		IntAverage.setAbbreviation("Int Avg");
		IntAverage.setValue(""+Double.parseDouble(INTYds.getValue())/Double.parseDouble(INT.getValue()));
	}

	public void setPDef(Stat str) {
		PDef = str;
	}

	public void setThirdMd(Stat str) {
		ThirdMd = str;
	}

	public void setThirdAtt(Stat str) {
		ThirdAtt = str;
	}

	public void setThirdMdPct() {
		ThirdMdPct = new Stat();
		ThirdMdPct.setValue(""+Double.parseDouble(ThirdMd.getValue())/Double.parseDouble(ThirdAtt.getValue()));
		ThirdMdPct.setAbbreviation("3rd PCT");
	}

	/*
	 * public void setPenalties(Stat str) { Penalties= str; }
	 */

	public void setOffenseAvgYds() {
		OffenseAvgYds = new Stat();
		OffenseAvgYds.setAbbreviation("Off Avg Yds");
		double RushAvg =Double.parseDouble(RushYPC.getValue());
		double RushAtmp =Double.parseDouble(RushAtt.getValue());
		double PassAvg =Double.parseDouble(PassYdsPerAtt.getValue());
		double PassAtmp =Double.parseDouble(PassAtt.getValue());
		double totalYds= (RushAvg) * (RushAtmp) + (PassAvg) * (PassAtmp);
		double totalPlays = RushAtmp + PassAtmp;
		OffenseAvgYds.setValue("" + totalYds/totalPlays);
	}

	public void setTotalTD() {
		TotalTD = new Stat();
		TotalTD.setAbbreviation("Total Off TD");
		TotalTD.setValue("" + (Integer.parseInt(PassTD.getValue()) + Integer.parseInt(RushTD.getValue())));
	}

	public void setPF(Stat str) {
		PF = str;
	}

	public void setPA(Stat str) {
		PA = str;
	}

	public void setNetPts(Stat str) {
		NetPts = str;
	}

	/*
	 * public void setTacklesForLoss(Stat str) { TacklesForLoss= str; }
	 */

	public void setW(Stat str) {
		W = str;
	}

	public void setL(Stat str) {
		L = str;
	}

	public void setT(Stat str) {
		T = str;
	}

	public void combine() {
		// Stat[] temp2 = {PassCmpPCT, PassYdsPerAtt, PassTD, PassTDPct, PassINTPct,
		// PassSck, PassSckY, QBRating, RushAtt, RushYPC, RushTD,
		// RecAverage, RecTD, FumLost, FumOwnRec, Comb, Sck, INT,
		// IntAverage, PDef, Stuffs, StuffYds, FumForced, FumOppRec,
		// FumRecYds, FumTotalRec, FumTD, KrAvg, PrAvg, FgPct, XpPct, KoAvg,
		// KoRetAvgYds, PuntNetAvg, PuntIn20Pct, PuntRetAvg, FirstDownsTotal,
		// FirstDownsPass, FirstDownsRush, ThirdMdPct, Penalties, PenaltyYds,
		// OffenseAvgYds, TotalTD, PF, PA, NetPts,
		// TacklesForLoss};
		
		if(getGamesPlayed() == 16)
		{
			W.setValue("0");
			L.setValue("0");
			T.setValue("0");
			clinchCharacter = "";
		}
		if(clinchCharacter == " ")
		{
			clinchCharacter = "";
		}
		
		setPassTDPct();
		setPassINTPct();
		setIntAverage();
		setThirdMdPct();
		setOffenseAvgYds();
		setTotalTD();
		

		Stat[] temp2 = { PassCmpPCT, PassYdsPerAtt, PassTD, PassTDPct, PassINTPct, PassSck, PassSckY, RushAtt,
				RushYPC, RushTD, Comb, Sck, INT, IntAverage, PDef, ThirdMdPct,
				OffenseAvgYds, TotalTD, PF, PA, NetPts };
		ImportantStats = temp2;
		double[][] coefs = { { 5.0543, -7.56632, 0 }, { 3.96577, -0.628389, 0 }, { 1.65717, -0.964088, 1 },
				{ 2.37637, -0.508062, 0 }, { -0.489881, 0.188785, 0 }, { -1.66567, 0.651066, 1 },
				{ -2.61024, 0.248079, 1 }, { 7.78729, -0.297944, 1 }, { 9.62481, -2.37839, 0 },
				{ 0.563469, -0.876024, 1 }, { 2.60792, -0.0418199, 1 }, { 1.66567, -0.651066, 1 },
				{ 0.637217, -0.559201, 1 }, { -0.865994, 0.0380353, 0 }, { 1.872, -.313565, 1 },
				{ 2.31006, -0.071767, 1 }, { 2.90524, -.541637, 0 }, { 1.64785, -0.705528, 1 }, { 2.93293, -.12126, 1 },
				{ -2.93293, .12126, 1 }, { -.00705551, -.00792391, 1 } };
		for (int i = 0; i < ImportantStats.length; i++) {
			ImportantStats[i].setCoefs(coefs[i][0], coefs[i][1], coefs[i][2]);
		}
	}

	public String toString() {
		if (AllStats == null)
			combine();
		String str = "";
		for (Stat s : ImportantStats) {
			if (s != null && s.getValue() != null)
				str += s.toString();
		}
		return str;
	}
	
	public String getTeamName() {
		return TeamName;
	}

	public Stat getW() {
		return W;
	}

	public Stat getL() {
		return L;
	}

	public Stat getT() {
		return T;
	}
	
	public String getClinchChar() {
		return clinchCharacter;
	}
	
	public int getGamesPlayed() {
		return Integer.parseInt(W.getValue()) + Integer.parseInt(L.getValue()) + Integer.parseInt(T.getValue());
	}
}
