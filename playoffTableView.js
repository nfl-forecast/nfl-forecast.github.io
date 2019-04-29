angular.module('nflforecast').component('playoffTableView', {
  controller: ["logoService",PTVController],
  bindings: {
    playoffs: "<"
  },
  templateUrl: "htmlTemplates/playoffTableView.html"

});

function PTVController(logoService)
{
  this.getLogo = function(teamName){
    return logoService.getLogo(teamName);
  };

  this.afcWildCard = function(index) {
    if(index === 0 || index === 1)
      return " ";
    else
      return this.playoffs.afcwildCard[index];
  }

  this.nfcWildCard = function(index) {
    if(index === 0 || index === 1)
      return " ";
    else
      return this.playoffs.nfcwildCard[index];
  }
}