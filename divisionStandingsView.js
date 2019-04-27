angular.module('nflforecast').component('divisionStandingsView', {
  controller: ["teamService", DSVController],
  bindings: {
    data: "="
  },
  templateUrl: "htmlTemplates/divisionStandingsView.html"

});

function DSVController(teamService)
{
  this.getConferenceNames = function(){
    return teamService.getConferenceNames()
  }
}