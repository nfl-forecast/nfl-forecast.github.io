angular.module('nflforecast').component('leagueStandingsView', {
  controller: ["teamService",LSVController],
  bindings: {
    data: "="
  },
  templateUrl: "htmlTemplates/leagueStandingsView.html"

});

function LSVController(teamService)
{
  this.getTeams = function(){
    return teamService.getAllTeams();
  };
}