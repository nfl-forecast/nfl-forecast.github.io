var app = angular.module('nflforecast', []);

app.component('main', {
  controller: MainController,
  templateUrl: "htmlTemplates/app.html"

});

function MainController()
{
  this.data = forecastData;//initialize data to be data imported from JSON
}