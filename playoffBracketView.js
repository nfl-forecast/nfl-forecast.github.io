angular.module('nflforecast').component('playoffBracketView', {
  controller: ["logoService",PBVController],
  bindings: {
    playoffs: "<"
  },
  templateUrl: "htmlTemplates/playoffBracketView.html"

});

function PBVController(logoService)
{
  this.getLogo = function(teamName){
    return logoService.getLogo(teamName);
  };
  this.getPredictedSBWinner = function() {
    var greatest = 0;
    for(var i = 1; i < 12; i++)
    {
      if(parseFloat(this.playoffs.superBowl[i]) > parseFloat(this.playoffs.superBowl[greatest]))
        greatest = i;
    }
    return greatest;
  };

  this.teams = function(index) {
    var returning = " ";
    if(index < 6)
      returning = this.playoffs.afcteams[index];
    else if(index < 12)
      returning =  this.playoffs.nfcteams[index - 6];
    return returning;
  }
}
