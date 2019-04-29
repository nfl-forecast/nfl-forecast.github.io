angular.module('nflforecast').component('standingsView', {
  controller: [SVController],
  bindings: {
    data: "<"
  },
  templateUrl: "htmlTemplates/standingsView.html"

});

function SVController()
{
  this.DIVISIONVIEW = 0;
  this.CONFERENCEVIEW = 1;
  this.LEAGUEVIEW = 2;
  this.selectedView = this.CONFERENCEVIEW;
}