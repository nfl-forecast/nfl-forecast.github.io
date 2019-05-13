angular.module('nflforecast').component('createView', {
  controller: ["logoService", "teamService", CVController],
  bindings: {
    names: "<",
    percents: "<",
    actualplayoffteams: "<"
  },
  templateUrl: "htmlTemplates/createView.html"

});

function CVController(logoService, teamService) {
  this.namesOfSeeds = ["AFC 1st Seed", "AFC 2nd Seed", "AFC 3rd Seed", "AFC 4th Seed", "AFC 5th Seed", "AFC 6th Seed", "NFC 1st Seed",
    "NFC 2nd Seed", "NFC 3rd Seed", "NFC 4th Seed", "NFC 5th Seed", "NFC 6th Seed"];

  this.changed = false;

  this.SEED = 0;
  this.NAME = 1;
  this.WC = 2;
  this.DIV = 3;
  this.CONF = 4;
  this.SB = 5;
  this.FPI = 6;
  this.currSorted = this.SEED;
  this.DESCENDING = false;
  this.ASCENDING = true;
  this.sortedState = this.ASCENDING;

  this.natFinal =[]; this.natFinal[0] = 0.0; this.natFinal[1] = 0.0; this.natFinal[2] = 0.0; this.natFinal[3] = 0; this.natFinal[4] = 0;
    this.natFinal[5] = 0;
  this.amerFinal =[]; this.amerFinal[0] = 0.0; this.amerFinal[1] = 0.0; this.amerFinal[2] = 0.0; this.amerFinal[3] = 0; this.amerFinal[4] = 0;
    this.amerFinal[5] = 0;
  this.natConf =[]; this.natConf[0] = 0.0; this.natConf[1] = 0.0; this.natConf[2] = 0.0; this.natConf[3] = 0; this.natConf[4] = 0;
    this.natConf[5] = 0;
  this.amerConf =[]; this.amerConf[0] = 0.0; this.amerConf[1] = 0.0; this.amerConf[2] = 0.0; this.amerConf[3] = 0; this.amerConf[4] = 0;
    this.amerConf[5] = 0;
  this.natWildCard = []; this.natWildCard[0] = []; this.natWildCard[0][0] = 0.0; this.natWildCard[0][1] = 0.0; this.natWildCard[0][2] = 0.0;
    this.natWildCard[0][3] = 0; this.natWildCard[0][4] = 0; this.natWildCard[0][5] = 0; this.natWildCard[1] = []; this.natWildCard[1][0] = 0.0;
    this.natWildCard[1][1] = 0.0; this.natWildCard[1][2] = 0.0; this.natWildCard[1][3] = 0; this.natWildCard[1][4] = 0; this.natWildCard[1][5] = 0;
  this.natDivisional = []; this.natDivisional[0] = []; this.natDivisional[0][0] = 0.0; this.natDivisional[0][1] = 0.0; this.natDivisional[0][2] = 0.0;
    this.natDivisional[0][3] = 0; this.natDivisional[0][4] = 0; this.natDivisional[0][5] = 0; this.natDivisional[1] = [];
    this.natDivisional[1][0] = 0.0; this.natDivisional[1][1] = 0.0; this.natDivisional[1][2] = 0.0; this.natDivisional[1][3] = 0;
    this.natDivisional[1][4] = 0; this.natDivisional[1][5] = 0;
  this.amerWildCard = []; this.amerWildCard[0] = []; this.amerWildCard[0][0] = 0.0; this.amerWildCard[0][1] = 0.0; this.amerWildCard[0][2] = 0.0;
    this.amerWildCard[0][3] = 0; this.amerWildCard[0][4] = 0; this.amerWildCard[0][5] = 0; this.amerWildCard[1] = []; this.amerWildCard[1][0] = 0.0;
    this.amerWildCard[1][1] = 0.0; this.amerWildCard[1][2] = 0.0; this.amerWildCard[1][3] = 0; this.amerWildCard[1][4] = 0;
    this.amerWildCard[1][5] = 0;
  this.amerDivisional = []; this.amerDivisional[0] = []; this.amerDivisional[0][0] = 0.0; this.amerDivisional[0][1] = 0.0;
    this.amerDivisional[0][2] = 0.0; this.amerDivisional[0][3] = 0; this.amerDivisional[0][4] = 0; this.amerDivisional[0][5] = 0;
    this.amerDivisional[1] = []; this.amerDivisional[1][0] = 0.0; this.amerDivisional[1][1] = 0.0; this.amerDivisional[1][2] = 0.0;
    this.amerDivisional[1][3] = 0; this.amerDivisional[1][4] = 0; this.amerDivisional[1][5] = 0;

  this.percent = []; this.percent[0] = []; this.percent[1] = []; this.percent[2] = []; this.percent[3] = []; this.percent[4] = [];
    this.percent[5] = []; this.percent[6] = []; this.percent[7] = []; this.percent[8] = []; this.percent[9] = []; this.percent[10] = [];
    this.percent[11] = [];




  this.$onInit = function() {
    this.afcTeams = this.names.slice(0, 16);
    this.nfcTeams = this.names.slice(16);
    this.seeds = angular.copy(this.actualplayoffteams);
    this.fun = false;
  };

  this.makePercents = function() {
    for (var i = 0; i < 6; i++) {
      this.percent[i][i] = 0;
      for (var j = i + 1; j < 6; j++) {
        this.percent[i][j] = this.calculate(this.seeds[i], this.seeds[j]);
        this.percent[j][i] = 1.0 - this.percent[i][j];
      }
    }
    for (var i = 6; i < 12; i++) {
      this.percent[i][i] = 0;
      for (var j = i + 1; j < 12; j++) {
        this.percent[i][j] = this.calculate(this.seeds[i], this.seeds[j]);
        this.percent[j][i] = 1.0 - this.percent[i][j];
      }
    }
    for (var i = 0; i < 6; i++) {
      for (var j = 6; j < 12; j++) {
        this.percent[i][j] = this.superbowlCalc(this.seeds[i], this.seeds[j]);
        this.percent[j][i] = 1.0 - this.percent[i][j];
      }
    }
  };

  this.getConfernceTeams = function(index) {
    if(index < 6)
      return this.afcTeams;
    else
      return this.nfcTeams;
  };

  this.calculate = function(homeTeam, awayTeam) {
    var hF = this.getFPI(homeTeam)/100;
    var aF = this.getFPI(awayTeam)/100;

    var fpiDiff = -(hF-aF)-.15;

    var exponent = (fpiDiff)/3.5;
    var power = Math.pow(10.0, exponent);


    return 1.0/(power+1);
  };

  this.superbowlCalc = function(homeTeam, awayTeam) {
    var hF = this.getFPI(homeTeam)/100;
    var aF = this.getFPI(awayTeam)/100;

    var fpiDiff = -(hF-aF);

    var exponent = (fpiDiff)/3.5;
    var power = Math.pow(10.0, exponent);


    return 1.0/(power+1);
  };

  this.makeCalculations = function() {

    this.makePercents();

    // first game of playoffs
    this.natWildCard[0][0] = 1;
    this.natWildCard[1][1] = 1;
    this.natWildCard[0][3] = this.percent[3][4] * this.percent[2][5];
    this.natWildCard[0][4] = this.percent[4][3] * this.percent[2][5];
    this.natWildCard[0][5] = this.percent[5][2];
    this.natWildCard[1][3] = this.percent[3][4] * this.percent[5][2];
    this.natWildCard[1][4] = this.percent[4][3] * this.percent[5][2];
    this.natWildCard[1][2] = this.percent[2][5];


    // second game
    var sum1 = 0, sum2 = 0;
    for (var j = 2; j < 6; j++) {
      // System.out.println(percent[0][j] * left[j]);
      sum1 += this.percent[0][j] * this.natWildCard[0][j];
      sum2 += this.percent[1][j] * this.natWildCard[1][j];
    }

    this.natDivisional[0][0] = sum1;//team 1
    this.natDivisional[0][3] = this.percent[3][0] * this.natWildCard[0][3];//team 4
    this.natDivisional[0][4] = this.percent[4][0] * this.natWildCard[0][4];//team 5
    this.natDivisional[0][5] = this.percent[5][0] * this.natWildCard[0][5];//team 6
    this.natDivisional[1][1] = sum2;//team 2
    this.natDivisional[1][2] = this.percent[2][1] * this.natWildCard[1][2];//team 3
    this.natDivisional[1][3] = this.percent[3][1] * this.natWildCard[1][3];//team 4
    this.natDivisional[1][4] = this.percent[4][1] * this.natWildCard[1][4];//team 5


    // third game
    this.natConf[0] =
      (this.natWildCard[0][3] * this.percent[0][3] *
        ((this.percent[1][2]    * this.percent[0][1])+
          (this.percent[2][1]    * this.percent[0][2])))+
      (this.natWildCard[0][4] * this.percent[0][4] *
        ((this.percent[1][2]    * this.percent[0][1])+
          (this.percent[2][1]    * this.percent[0][2])))+
      (this.natWildCard[1][3] * this.percent[0][5] *
        ((this.percent[1][3]    * this.percent[0][1])+
          (this.percent[3][1]    * this.percent[0][3])))+
      (this.natWildCard[1][4] * this.percent[0][5]*
        ((this.percent[1][4]    * this.percent[0][1])+
          (this.percent[4][1]    * this.percent[0][4])));
    this.natConf[1] =
      (this.natWildCard[0][3] * this.percent[1][2]*
        ((this.percent[0][3]    * this.percent[1][0])+
          (this.percent[3][0]    * this.percent[1][3])))+
      (this.natWildCard[0][4] * this.percent[1][2]*
        ((this.percent[0][4]    * this.percent[1][0])+
          (this.percent[4][0]    * this.percent[1][4])))+
      (this.natWildCard[1][3] * this.percent[1][3]*
        ((this.percent[0][5]    * this.percent[1][0])+
          (this.percent[5][0]    * this.percent[1][5])))+
      (this.natWildCard[1][4] * this.percent[1][4]*
        ((this.percent[0][5]    * this.percent[1][0])+
          (this.percent[5][0]    * this.percent[1][5])));
    this.natConf[2] =
      (this.natWildCard[0][3] * this.percent[2][1]*
        ((this.percent[0][3]    * this.percent[2][0])+
          (this.percent[3][0]    * this.percent[2][3])))+
      (this.natWildCard[0][4] * this.percent[2][1]*
        ((this.percent[0][4]    * this.percent[2][0])+
          (this.percent[4][0]    * this.percent[2][4])));
    this.natConf[3] =
      (this.natWildCard[0][3] * this.percent[3][0]*
        ((this.percent[1][2]    * this.percent[3][1])+
          (this.percent[2][1]    * this.percent[3][2])))+
      (this.natWildCard[1][3] * this.percent[3][1]*
        ((this.percent[0][5]    * this.percent[3][0])+
          (this.percent[5][0]    * this.percent[3][5])));
    this.natConf[4] =
      (this.natWildCard[0][4] * this.percent[4][0]*
        ((this.percent[1][2]    * this.percent[4][1])+
          (this.percent[2][1]    * this.percent[4][2])))+
      (this.natWildCard[1][4] * this.percent[4][1]*
        ((this.percent[0][5]    * this.percent[4][0])+
          (this.percent[5][0]    * this.percent[4][5])));
    this.natConf[5] =
      (this.natWildCard[1][3] * this.percent[5][0]*
        ((this.percent[1][3]    * this.percent[5][1])+
          (this.percent[3][1]    * this.percent[5][3])))+
      (this.natWildCard[1][4] * this.percent[5][0]*
        ((this.percent[1][4]    * this.percent[5][1])+
          (this.percent[4][1]    * this.percent[5][4])));
    ////////////////////////////////////////////////////////


    // AMERICAN//


    // set up arrays for after wild card round
    this.amerPerc = [];
    this.amerPerc[0] = [];
    this.amerPerc[1] = [];
    this.amerPerc[2] = [];
    this.amerPerc[3] = [];
    this.amerPerc[4] = [];
    this.amerPerc[5] = [];

    for(var i = 0; i < 6; i++)
    for(var j = 0; j < 6; j++)
      this.amerPerc[i][j] = this.percent[i+6][j+6];

    // first game of playoffs
    this.amerWildCard[0][0] = 1;
    this.amerWildCard[1][1] = 1;
    this.amerWildCard[0][3] = this.amerPerc[3][4] * this.amerPerc[2][5];
    this.amerWildCard[0][4] = this.amerPerc[4][3] * this.amerPerc[2][5];
    this.amerWildCard[0][5] = this.amerPerc[5][2];
    this.amerWildCard[1][3] = this.amerPerc[3][4] * this.amerPerc[5][2];
    this.amerWildCard[1][4] = this.amerPerc[4][3] * this.amerPerc[5][2];
    this.amerWildCard[1][2] = this.amerPerc[2][5];


    // second game
    sum1 = 0;
    sum2 = 0;
    for (var j = 2; j < 6; j++) {
      sum1 += this.amerPerc[0][j] * this.amerWildCard[0][j];
      sum2 += this.amerPerc[1][j] * this.amerWildCard[1][j];
    }

    this.amerDivisional[0][0] = sum1;
    this.amerDivisional[0][3] = this.amerPerc[3][0] * this.amerWildCard[0][3];
    this.amerDivisional[0][4] = this.amerPerc[4][0] * this.amerWildCard[0][4];
    this.amerDivisional[0][5] = this.amerPerc[5][0] * this.amerWildCard[0][5];
    this.amerDivisional[1][1] = sum2;
    this.amerDivisional[1][2] = this.amerPerc[2][1] * this.amerWildCard[1][2];
    this.amerDivisional[1][3] = this.amerPerc[3][1] * this.amerWildCard[1][3];
    this.amerDivisional[1][4] = this.amerPerc[4][1] * this.amerWildCard[1][4];


    // third game
    this.amerConf[0] =
      (this.amerWildCard[0][3] * this.amerPerc[0][3] *
        ((this.amerPerc[1][2]    * this.amerPerc[0][1])+
          (this.amerPerc[2][1]    * this.amerPerc[0][2])))+
      (this.amerWildCard[0][4] * this.amerPerc[0][4] *
        ((this.amerPerc[1][2]    * this.amerPerc[0][1])+
          (this.amerPerc[2][1]    * this.amerPerc[0][2])))+
      (this.amerWildCard[1][3] * this.amerPerc[0][5] *
        ((this.amerPerc[1][3]    * this.amerPerc[0][1])+
          (this.amerPerc[3][1]    * this.amerPerc[0][3])))+
      (this.amerWildCard[1][4] * this.amerPerc[0][5]*
        ((this.amerPerc[1][4]    * this.amerPerc[0][1])+
          (this.amerPerc[4][1]    * this.amerPerc[0][4])));
    this.amerConf[1] =
      (this.amerWildCard[0][3] * this.amerPerc[1][2]*
        ((this.amerPerc[0][3]    * this.amerPerc[1][0])+
          (this.amerPerc[3][0]    * this.amerPerc[1][3])))+
      (this.amerWildCard[0][4] * this.amerPerc[1][2]*
        ((this.amerPerc[0][4]    * this.amerPerc[1][0])+
          (this.amerPerc[4][0]    * this.amerPerc[1][4])))+
      (this.amerWildCard[1][3] * this.amerPerc[1][3]*
        ((this.amerPerc[0][5]    * this.amerPerc[1][0])+
          (this.amerPerc[5][0]    * this.amerPerc[1][5])))+
      (this.amerWildCard[1][4] * this.amerPerc[1][4]*
        ((this.amerPerc[0][5]    * this.amerPerc[1][0])+
          (this.amerPerc[5][0]    * this.amerPerc[1][5])));
    this.amerConf[2] =
      (this.amerWildCard[0][3] * this.amerPerc[2][1]*
        ((this.amerPerc[0][3]    * this.amerPerc[2][0])+
          (this.amerPerc[3][0]    * this.amerPerc[2][3])))+
      (this.amerWildCard[0][4] * this.amerPerc[2][1]*
        ((this.amerPerc[0][4]    * this.amerPerc[2][0])+
          (this.amerPerc[4][0]    * this.amerPerc[2][4])));
    this.amerConf[3] =
      (this.amerWildCard[0][3] * this.amerPerc[3][0]*
        ((this.amerPerc[1][2]    * this.amerPerc[3][1])+
          (this.amerPerc[2][1]    * this.amerPerc[3][2])))+
      (this.amerWildCard[1][3] * this.amerPerc[3][1]*
        ((this.amerPerc[0][5]    * this.amerPerc[3][0])+
          (this.amerPerc[5][0]    * this.amerPerc[3][5])));
    this.amerConf[4] =
      (this.amerWildCard[0][4] * this.amerPerc[4][0]*
        ((this.amerPerc[1][2]    * this.amerPerc[4][1])+
          (this.amerPerc[2][1]    * this.amerPerc[4][2])))+
      (this.amerWildCard[1][4] * this.amerPerc[4][1]*
        ((this.amerPerc[0][5]    * this.amerPerc[4][0])+
          (this.amerPerc[5][0]    * this.amerPerc[4][5])));
    this.amerConf[5] =
      (this.amerWildCard[1][3] * this.amerPerc[5][0]*
        ((this.amerPerc[1][3]    * this.amerPerc[5][1])+
          (this.amerPerc[3][1]    * this.amerPerc[5][3])))+
      (this.amerWildCard[1][4] * this.amerPerc[5][0]*
        ((this.amerPerc[1][4]    * this.amerPerc[5][1])+
          (this.amerPerc[4][1]    * this.amerPerc[5][4])));
    ////////////////////////////////////////////////////////


    // SUPERBOWL//

    for (var i = 0; i < this.natFinal.length; i++) {
      var sumNat = 0, sumAmer = 0;
      // for nat comparing to amer
      for (var j = 0; j < this.natFinal.length; j++) {
        sumNat += this  .amerConf[j] * this.percent[i][j + 6];
      }
      this.natFinal[i] = sumNat * this.natConf[i];

      // for amer comparing to nat
      for (var j = 0; j < this.natFinal.length; j++) {
        sumAmer += this.natConf[j] * this.percent[i + 6][j];
      }
      this.amerFinal[i] = sumAmer * this.amerConf[i];
    }
    this.teamPercents =[];
    for(var i = 0; i < 6; i++)
      this.teamPercents[i] = {seed: i+1, teamName:this.seeds[i], fpi:this.getFPI(this.seeds[i]), wildcard:((this.natWildCard[0][i]+this.natWildCard[1][i])*100).toFixed(2), divisional:((this.natDivisional[0][i]+this.natDivisional[1][i])*100).toFixed(2), conference:((this.natConf[i])*100).toFixed(2), superbowl:(100*this.natFinal[i]).toFixed(2)};
    for(var i = 6; i < 12; i++)
      this.teamPercents[i] = {seed: i-5, teamName:this.seeds[i], fpi:this.getFPI(this.seeds[i]), wildcard:((this.amerWildCard[0][i-6]+this.amerWildCard[1][i-6])*100).toFixed(2), divisional:((this.amerDivisional[0][i-6]+this.amerDivisional[1][i-6])*100).toFixed(2), conference: ((this.amerConf[i-6])*100).toFixed(2), superbowl:((this.amerFinal[i-6])*100).toFixed(2)};
    this.originalOrder = angular.copy(this.teamPercents);
  };

  this.getIndex = function(teamName) {
    for(var i = 0; i < 12; i++) {
      if (this.teamPercents[i].teamName === teamName)
        return i;
    }
    return -1;
  }

  this.sortSeed = function(){
    this.currSorted = this.SEED;
    this.teamPercents = angular.copy(this.originalOrder);
  };

  this.sortFPI = function(){
    if(this.currSorted===this.FPI && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.fpi) < parseFloat(b.fpi)) {return -1;}
        if (parseFloat(a.fpi) > parseFloat(b.fpi)) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.FPI;
      this.sortedState = this.DESCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.fpi) < parseFloat(b.fpi)) {return 1;}
        if (parseFloat(a.fpi) > parseFloat(b.fpi)) {return -1;}
        return 0;})
    }
  };

  this.sortWC = function(){
    if(this.currSorted===this.WC && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.wildcard) < parseFloat(b.wildcard)) {return -1;}
        if (parseFloat(a.wildcard) > parseFloat(b.wildcard)) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.WC;
      this.sortedState = this.DESCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.wildcard) < parseFloat(b.wildcard)) {return 1;}
        if (parseFloat(a.wildcard) > parseFloat(b.wildcard)) {return -1;}
        return 0;})
    }
  };

  this.sortDiv = function(){
    if(this.currSorted===this.DIV && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.divisional) < parseFloat(b.divisional)) {return -1;}
        if (parseFloat(a.divisional) > parseFloat(b.divisional)) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.DIV;
      this.sortedState = this.DESCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.divisional) < parseFloat(b.divisional)) {return 1;}
        if (parseFloat(a.divisional) > parseFloat(b.divisional)) {return -1;}
        return 0;})
    }
  };

  this.sortConf = function(){
    if(this.currSorted===this.CONF && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.conference) < parseFloat(b.conference)) {return -1;}
        if (parseFloat(a.conference) > parseFloat(b.conference)) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.CONF;
      this.sortedState = this.DESCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.conference) < parseFloat(b.conference)) {return 1;}
        if (parseFloat(a.conference) > parseFloat(b.conference)) {return -1;}
        return 0;})
    }
  };

  this.sortSB = function(){
    if(this.currSorted===this.SB && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.superbowl) < parseFloat(b.superbowl)) {return -1;}
        if (parseFloat(a.superbowl) > parseFloat(b.superbowl)) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.SB;
      this.sortedState = this.DESCENDING;
      this.teamPercents.sort(function(a, b){
        if (parseFloat(a.superbowl) < parseFloat(b.superbowl)) {return 1;}
        if (parseFloat(a.superbowl) > parseFloat(b.superbowl)) {return -1;}
        return 0;})
    }
  };

  this.sortTeam = function(){
    if(this.currSorted===this.NAME && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamPercents.sort(function(a, b){
        if (a.teamName < b.teamName) {return 1;}
        if (a.teamName > b.teamName) {return -1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.NAME;
      this.sortedState = this.DESCENDING;
      this.teamPercents.sort(function(a, b){
        if (a.teamName < b.teamName) {return -1;}
        if (a.teamName > b.teamName) {return 1;}
        return 0;})
    }
  };

  this.getFPI = function(teamName) {
    return teamService.getTeam(teamName).fpi;
  };

  this.getColor = function(withoutSymbol) {
    var percent = Number.parseFloat(withoutSymbol);
    var adjusted = -1/100 * Math.pow(percent * 4/3 - 100,2) + 100;
    if(adjusted > 100) adjusted = 100;
    var red = (-51 * Math.pow(adjusted,2))/2000 + 255;
    var blue = (-153 * Math.pow(adjusted - 50,2))/2000 + 765 / 4;
    var green = (-51 * Math.pow(adjusted - 100,2))/2000 + 255;
    return "rgb(" + Math.round(red) + ", " + Math.round(green) + ", " + Math.round(blue) + ")";
  }

  this.style = function(team) {
    if(team.seed <= 2)
      return "grey";
    else
      return this.getColor(team.wildcard);
  };

  this.verify = function() {
    if(this.amerPerc === undefined  || this.changed === true) {
      this.makeCalculations();
      this.changed = false;
    }
  }

  this.wildcard = function(index) {
    if(this.teamPercents[index].seed === 1 || this.teamPercents[index].seed === 2)
      return " ";
    else
      return (this.teamPercents[index].wildcard + "%");
  };

  this.getLogo = function(teamName) {
    return logoService.getLogo(teamName);
  }

  this.getCarrot = function(type) {
    if(this.currSorted === type) {
      if(this.sortedState === this.DESCENDING){
        return ('fas fa-caret-down');
      }
      else {
        return ("fas fa-caret-up");
      }
    }
    else return "";

  }

}