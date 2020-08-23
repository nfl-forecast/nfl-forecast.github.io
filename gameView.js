angular.module('nflforecast').component('gameView', {
  controller: ["logoService", "teamService", GVController],
  bindings: {
    game: "<"
  },
  templateUrl: "htmlTemplates/gameView.html"

});

function GVController(logoService, teamService)
{
  this.getFPI = function(teamName)
  {
    var team = teamService.getTeam(teamName);
    if(team !== undefined)
    {
      return team.fpi;
    }
    else
      return undefined;
  };
  this.getTeamImage = function(teamName)
  {
    return logoService.getLogo(teamName);
  };

  this.getPColorAway = function(){
    var arr = this.game.awayTeam.primaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.getSColorAway = function(){
    var arr = this.game.awayTeam.secondaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.getPColorHome = function(){
    var arr = this.game.homeTeam.primaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.getSColorHome = function(){
    var arr = this.game.homeTeam.secondaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };
}