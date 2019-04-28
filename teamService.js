angular.module('nflforecast').service('teamService',teamService);
function teamService()
{
  this.getTeam = function(teamName){
    var conferences = this.getConferenceNames()
    for(var confIndex in conferences) {
      for (var division in forecastData[conferences[confIndex]]) {
        var conf = forecastData[conferences[confIndex]];
        for (var team in conf[division].teams) {
          if (conf[division].teams[team].name === teamName) {
            return conf[division].teams[team];
          }
        }
      }
    }
    return undefined;
  };

  this.getConferenceNames = function() {
    return ["AFC", "NFC"]
  };

  this.getConferenceTeams = function (conferenceName) {
    var conference = forecastData[conferenceName];
    var teamArr = [];
    for(var division in conference){
      for(var teamIndex in conference[division].teams){
        var team = conference[division].teams[teamIndex];
        teamArr.push(team);
      }
    }
    return teamArr;
  };

  this.getAllTeams = function(){
    var teamArr = [];
    var conferences = this.getConferenceNames();
    for(var confName in conferences){
      var confTeams = this.getConferenceTeams(conferences[confName]);
      for(var team in confTeams) {
        teamArr.push(confTeams[team]);
      }
    }
    return teamArr;
  }
}