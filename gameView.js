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
      return team.FPI;
    }
    else
      return undefined;
  };
  this.getTeamImage = function(teamName)
  {
    return logoService.getLogo(teamName);
  }
}