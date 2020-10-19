angular.module('nflforecast').component('gameView', {
  controller: ["logoService", "teamService", GVController],
  bindings: {
    game: "<"
  },
  templateUrl: "htmlTemplates/gameView.html"

});

function GVController(logoService, teamService)
{
  this.getTeamImage = function(teamName)
  {
    return logoService.getLogo(teamName);
  };

  this.getPColorAway = function(){
    var arr = this.game.awayPrimaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.getSColorAway = function(){
    var arr = this.game.awaySecondaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.getPColorHome = function(){
    var arr = this.game.homePrimaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.getSColorHome = function(){
    var arr = this.game.homeSecondaryColor;
    return "rgb(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
  };

  this.isAwayWinner = function() {
    var one = this.game.homeScore;
    var two = this.game.awayScore;
    if (one < two) {
      return "bolder";
    }
    if (one > two){
      return "normal";
    }

  }
  this.isHomeWinner = function() {
    var one = this.game.homeScore;
    var two = this.game.awayScore;
    if (one > two) {
      return "bolder";
    }
    if (one < two) {
      return "normal";
    }
  }
}