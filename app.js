var app = angular.module('nflforecast', []);

app.component('main', {
  controller: MainController,
  templateUrl: "htmlTemplates/app.html"

});

function MainController()
{
  this.data = forecastData;//initialize data to be data imported from JSON


  this.SCHEDULE = 0;
  this.STANDINGS = 1;
  this.BRACKET = 2;
  this.TABLE = 3;
  this.CREATE = 4;
  this.shown = this.SCHEDULE;

  this.getCurrTeams = function() {
    var allTeams = angular.copy(this.data.playoffs.nfcteams);
    allTeams = allTeams.concat(angular.copy(this.data.playoffs.afcteams));
    return allTeams;
  };


  this.currTeams = this.getCurrTeams();
}