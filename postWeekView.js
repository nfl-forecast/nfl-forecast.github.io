angular.module('nflforecast').component('postWeekView', {
  controller: ["logoService", PWVController],
  bindings: {
    week: "<"
  },
  templateUrl: "htmlTemplates/postWeekView.html"
});

function PWVController(logoService)
{
  this.getTeamImage = function(teamName)
  {
    return logoService.getLogo(teamName);
  }
}