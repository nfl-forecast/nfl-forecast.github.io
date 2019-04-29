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

  this.getPcolor = function(teamName){
    var arr = teamService.getPColor(teamName);
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.getScolor = function(teamName){
    var arr = teamService.getSColor(teamName);
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };
}