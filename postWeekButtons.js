angular.module('nflforecast').component('postWeekButtons', {
  controller: PWBController,
  bindings: {
    data: "<"
  },
  templateUrl: "htmlTemplates/postWeekButtons.html"


});

function PWBController()
{
  this.selected = 0;

  this.$onInit = function(){
    this.weeks = this.data.postSched.playoffWeeks;
  };

  this.name = function(week){
    if(week === 0)
      return "Wildcard";
    else if(week === 1)
      return "Divisional";
    else if(week === 2)
      return "Conference Championship";
    else if(week === 3)
      return "Super Bowl";
    else return "Playoffs"
  }
}