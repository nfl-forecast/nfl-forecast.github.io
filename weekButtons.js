angular.module('nflforecast').component('weekButtons', {
  controller: WBController,
  bindings: {
    data: "="
  },
  templateUrl: "htmlTemplates/weekButtons.html"


});

function WBController()
{
  this.selected = 0;
}