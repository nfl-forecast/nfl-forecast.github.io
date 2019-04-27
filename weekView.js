angular.module('nflforecast').component('weekView', {
  controller: ["logoService", WVController],
  bindings: {
    week: "="
  },
  templateUrl: "htmlTemplates/weekView.html"
});

function WVController(logoService)
{
  this.getTeamImage = function(teamName)
  {
    return logoService.getLogo(teamName);
  }
}