angular.module('nflforecast').component('weekButtons', {
  controller: WBController,
  bindings: {
    data: "<"
  },
  templateUrl: "htmlTemplates/weekButtons.html"


});

function WBController()
{
  this.selected = 0;

  this.$onInit = function(){
    this.firstLine = this.data.season.weeks.slice(0, 9);
    this.secondLine = this.data.season.weeks.slice(9);
  }
}