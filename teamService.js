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
  }

  this.getConferenceNames = function() {
    return ["AFC", "NFC"]
  }
}