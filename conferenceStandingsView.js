angular.module('nflforecast').component('conferenceStandingsView', {
  controller: ["teamService",CSVController],
  bindings: {
    data: "="
  },
  templateUrl: "htmlTemplates/conferenceStandingsView.html"

});

function CSVController(teamService)
{
  this.getConferenceNames = function(){
    return teamService.getConferenceNames()
  };

  this.getConferenceTeams = function(confName){
    return teamService.getConferenceTeams(confName);
  };
}