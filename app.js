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
  this.HOW = 4;
  this.shown = this.SCHEDULE;
}