angular.module('nflforecast').component('playoffGameView', {
  controller: ["logoService", "teamService", "playoffService", PGVController],
  bindings: {
    team1: "<",
    team2: "<"
  },
  templateUrl: "htmlTemplates/playoffGameView.html"

});

function PGVController(logoService, teamService, playoffService) {
  this.fakeGame = false;
  this.$onInit = function() {
    this.t1 = teamService.getTeam(this.team1);
    this.t2 = teamService.getTeam(this.team2);
    if(this.t1 === undefined || this.t2===undefined)
      this.fakeGame = true;
  };

  this.getLogo = function(teamName) {
    var teamLogo = logoService.getLogo(teamName);
    if(teamLogo !== undefined)
      return logoService.getLogo(teamName);
    else if(teamName.includes("AFC"))
      return logoService.getLogo("AFC");
    else return logoService.getLogo("NFC");
  };

  this.getWildCard = function(teamName) {
    return playoffService.getWildcardPCT(teamName);
  };

  this.getTeam2 = function() {
    var test = !(this.t2 ===undefined);
    return test;
  }
}