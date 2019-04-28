angular.module('nflforecast').component('standingsTable', {
  controller: ["logoService", "playoffService", STController],
  bindings: {
    teams: "="
  },
  templateUrl: "htmlTemplates/standingsTable.html"

});

function STController(logoService, playoffService)
{
  this.TEAMNAME = 0;
  this.FPI = 1;
  this.WINS = 2;
  this.LOSSES = 3;
  this.TIES = 4;
  this.currSorted = this.WINS;
  this.DESCENDING = false;
  this.ASCENDING = true;
  this.sortedState = this.DESCENDING;

  this.$onInit = function(){
    this.teamArr = angular.copy(this.teams);
  };
  this.getSpecialCharacters = function(teamName){
    return playoffService.getSpecialCharacters(teamName);
  };

  this.getLogo = function(teamName){
    return logoService.getLogo(teamName);
  };

  this.sortTeamName = function(){
    if(this.currSorted===this.TEAMNAME && this.sortedState === this.ASCENDING)
    {
      this.sortedState = this.DESCENDING;
      this.teamArr.sort(function(a, b){
        if (a.name < b.name) {return 1;}
        if (a.name > b.name) {return -1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.TEAMNAME;
      this.sortedState = this.ASCENDING;
      this.teamArr.sort(function(a, b){
        if (a.name < b.name) {return -1;}
        if (a.name > b.name) {return 1;}
        return 0;})
    }
  };
  this.sortFPI = function(){
    if(this.currSorted===this.FPI && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamArr.sort(function(a, b){
        if (a.FPI < b.FPI) {return -1;}
        if (a.FPI > b.FPI) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.FPI;
      this.sortedState = this.DESCENDING;
      this.teamArr.sort(function(a, b){
        if (a.FPI < b.FPI) {return 1;}
        if (a.FPI > b.FPI) {return -1;}
        return 0;})
    }
  };
  this.sortWins = function(){
    if(this.currSorted===this.WINS && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamArr.sort(function(a, b){
        if (a.wins < b.wins) {return -1;}
        if (a.wins > b.wins) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.WINS;
      this.sortedState = this.DESCENDING;
      this.teamArr.sort(function(a, b){
        if (a.wins < b.wins) {return 1;}
        if (a.wins > b.wins) {return -1;}
        return 0;})
    }
  };
  this.sortLosses = function(){
    if(this.currSorted===this.LOSSES && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamArr.sort(function(a, b){
        if (a.losses < b.losses) {return -1;}
        if (a.losses > b.losses) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.LOSSES;
      this.sortedState = this.DESCENDING;
      this.teamArr.sort(function(a, b){
        if (a.losses < b.losses) {return 1;}
        if (a.losses > b.losses) {return -1;}
        return 0;})
    }
  };
  this.sortTies = function(){
    if(this.currSorted===this.TIES && this.sortedState === this.DESCENDING)
    {
      this.sortedState = this.ASCENDING;
      this.teamArr.sort(function(a, b){
        if (a.ties < b.ties) {return -1;}
        if (a.ties > b.ties) {return 1;}
        return 0;})
    }
    else
    {
      this.currSorted=this.TIES;
      this.sortedState = this.DESCENDING;
      this.teamArr.sort(function(a, b){
        if (a.ties < b.ties) {return 1;}
        if (a.ties > b.ties) {return -1;}
        return 0;})
    }
  };
}