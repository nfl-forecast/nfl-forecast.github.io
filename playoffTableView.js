angular.module('nflforecast').component('playoffTableView', {
  controller: ["logoService",PTVController],
  bindings: {
    playoffs: "<"
  },
  templateUrl: "htmlTemplates/playoffTableView.html"

});

function PTVController(logoService)
{
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
  this.playoffData = [];
  this.originalOrder = [];
  this.$onInit = function(){
    this.playoffsCopy = angular.copy(this.playoffs);
    this.seeds = [1,2,3,4,5,6,1,2,3,4,5,6];
    this.totalNames = [];
    this.totalNames = this.totalNames.concat(this.playoffsCopy.afcteams);
    this.totalNames = this.totalNames.concat(this.playoffsCopy.nfcteams);
    this.fpiValues = [];
    this.fpiValues = this.fpiValues.concat(this.playoffsCopy.fpi);
    this.totalWildCard = [];
    this.totalWildCard = this.totalWildCard.concat(this.playoffsCopy.afcwildCard);
    this.totalWildCard = this.totalWildCard.concat(this.playoffsCopy.nfcwildCard);
    this.totalDivisional = [];
    this.totalDivisional = this.totalDivisional.concat(this.playoffsCopy.afcdivisional);
    this.totalDivisional = this.totalDivisional.concat(this.playoffsCopy.nfcdivisional);
    this.totalConference = [];
    this.totalConference = this.totalConference.concat(this.playoffsCopy.afcconference);
    this.totalConference = this.totalConference.concat(this.playoffsCopy.nfcconference);
    this.superBowl = this.playoffsCopy.superBowl;

    for(var i = 0; i < 12; i++) {
      this.playoffData[i] = {seed:this.seeds[i], name:this.totalNames[i], fpi:this.fpiValues[i], wildcard:parseFloat(this.totalWildCard[i]), divisional:parseFloat(this.totalDivisional[i]), conference:parseFloat(this.totalConference[i]), superbowl:parseFloat(this.superBowl[i])};
    }
    this.originalOrder = angular.copy(this.playoffData);
  };

  this.getLogo = function(teamName){
    return logoService.getLogo(teamName);
  };

  this.wildcard = function(index) {
    if(this.playoffData[index].seed === 1 || this.playoffData[index].seed === 2)
      return " ";
    else
      return (this.playoffData[index].wildcard + "%");
  };

  this.sortSeed = function(){
    this.currSorted = this.SEED;
    this.playoffData = angular.copy(this.originalOrder);
  };

  this.sortFPI = function(){
    if(this.currSorted===this.FPI && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.playoffData.sort(function(a, b){
        if (parseFloat(a.fpi) < parseFloat(b.fpi)) {return -1;}
        if (parseFloat(a.fpi) > parseFloat(b.fpi)) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.FPI;
      this.sortedState = this.DESCENDING;
      this.playoffData.sort(function(a, b){
        if (parseFloat(a.fpi) < parseFloat(b.fpi)) {return 1;}
        if (parseFloat(a.fpi) > parseFloat(b.fpi)) {return -1;}
        return 0;})
    }
  };
  
  this.sortWC = function(){
    if(this.currSorted===this.WC && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.playoffData.sort(function(a, b){
        if (a.wildcard < b.wildcard) {return -1;}
        if (a.wildcard > b.wildcard) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.WC;
      this.sortedState = this.DESCENDING;
      this.playoffData.sort(function(a, b){
        if (a.wildcard < b.wildcard) {return 1;}
        if (a.wildcard > b.wildcard) {return -1;}
        return 0;})
    }
  };

  this.sortDiv = function(){
    if(this.currSorted===this.DIV && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.playoffData.sort(function(a, b){
        if (a.divisional < b.divisional) {return -1;}
        if (a.divisional > b.divisional) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.DIV;
      this.sortedState = this.DESCENDING;
      this.playoffData.sort(function(a, b){
        if (a.divisional < b.divisional) {return 1;}
        if (a.divisional > b.divisional) {return -1;}
        return 0;})
    }
  };

  this.sortConf = function(){
    if(this.currSorted===this.CONF && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.playoffData.sort(function(a, b){
        if (a.conference < b.conference) {return -1;}
        if (a.conference > b.conference) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.CONF;
      this.sortedState = this.DESCENDING;
      this.playoffData.sort(function(a, b){
        if (a.conference < b.conference) {return 1;}
        if (a.conference > b.conference) {return -1;}
        return 0;})
    }
  };

  this.sortSB = function(){
    if(this.currSorted===this.SB && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.playoffData.sort(function(a, b){
        if (a.superbowl < b.superbowl) {return -1;}
        if (a.superbowl > b.superbowl) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.SB;
      this.sortedState = this.DESCENDING;
      this.playoffData.sort(function(a, b){
        if (a.superbowl < b.superbowl) {return 1;}
        if (a.superbowl > b.superbowl) {return -1;}
        return 0;})
    }
  };

  this.sortTeam = function(){
    if(this.currSorted===this.NAME && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.playoffData.sort(function(a, b){
        if (a.name < b.name) {return 1;}
        if (a.name > b.name) {return -1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.NAME;
      this.sortedState = this.DESCENDING;
      this.playoffData.sort(function(a, b){
        if (a.name < b.name) {return -1;}
        if (a.name > b.name) {return 1;}
        return 0;})
    }
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
