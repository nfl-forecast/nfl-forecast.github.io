angular.module('nflforecast').service('teamService',teamService);
function teamService()
{
  this.afcTeams =[];
  this.nfcTeams = [];
  this.allTeams = [];
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

  this.getConferenceTeams = function(conferenceName) {
    if(conferenceName === "AFC") {
      if (this.afcTeams.length === 0){
        return (this.afcTeams = this.makeConferenceTeams(conferenceName));
      }
      else
        return this.afcTeams;
    }
    else
    {
      if (this.nfcTeams.length === 0){
        return (this.nfcTeams = this.makeConferenceTeams(conferenceName));
      }
      else
        return this.nfcTeams;
    }
  };

  this.getAllTeams = function() {
    if (this.allTeams.length === 0){
      return (this.allTeams = this.makeAllTeams());
    }
    else
      return this.allTeams;
  }

  this.makeConferenceTeams = function (conferenceName) {
    var conference = forecastData[conferenceName];
    var teamArr = [];
    /*for(var division in conference){
      var teams = conference[division].teams
      teamArr = teamArr.concat(teams);
    }*/
    var divisions = ["North", "East", "West", "South"];
    for(var i = 0; i < divisions.length; i++)
    {
      var division = conference[divisions[i]];
      var teams = division.teams;
      teamArr = teamArr.concat(teams);
    }
    return teamArr;
  };

  this.makeAllTeams = function(){
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