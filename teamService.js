angular.module('nflforecast').service('teamService',teamService);
function teamService() {
  this.afcTeams = [];
  this.nfcTeams = [];
  this.allTeams = [];
  this.getTeam = function (teamName) {
    var conferences = this.getConferenceNames()
    for (var confIndex in conferences) {
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

  this.getConferenceNames = function () {
    return ["AFC", "NFC"]
  };

  this.getConferenceTeams = function (conferenceName) {
    if (conferenceName === "AFC") {
      if (this.afcTeams.length === 0) {
        return (this.afcTeams = this.makeConferenceTeams(conferenceName));
      } else
        return this.afcTeams;
    } else {
      if (this.nfcTeams.length === 0) {
        return (this.nfcTeams = this.makeConferenceTeams(conferenceName));
      } else
        return this.nfcTeams;
    }
  };

  this.getAllTeams = function () {
    if (this.allTeams.length === 0) {
      return (this.allTeams = this.makeAllTeams());
    } else
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
    for (var i = 0; i < divisions.length; i++) {
      var division = conference[divisions[i]];
      var teams = division.teams;
      teamArr = teamArr.concat(teams);
    }
    return teamArr;
  };

  this.makeAllTeams = function () {
    var teamArr = [];
    var conferences = this.getConferenceNames();
    for (var confName in conferences) {
      var confTeams = this.getConferenceTeams(conferences[confName]);
      for (var team in confTeams) {
        teamArr.push(confTeams[team]);
      }
    }
    return teamArr;
  };

  this.getPColor = function (teamName) {
    return this.getTeam(teamName).primaryColor;
  };

  this.getSColor = function (teamName) {
    return this.getTeam(teamName).secondaryColor;
  };

  this.oneFrom = function (conference, divWinners) {
    var count = 0;
    for (var team in conference.teams) {
      if (divWinners.includes(conference.teams[team].name))
        count++;
    }
    if (count !== 1)
      return false;
    else return true;
  };

  this.validPlayoffs = function (seeds) {
    var AFCSeeds = seeds.slice(0, 6);
    var NFCSeeds = seeds.slice(6);

    var AFCDiv = AFCSeeds.slice(0, 4);
    var NFCDiv = NFCSeeds.slice(0, 4);

    var afc = true;
    var nfc = true;

    for (var division in forecastData.AFC)
      afc = afc && this.oneFrom(forecastData.AFC[division], AFCDiv);
    for (var division in forecastData.NFC)
      nfc = nfc && this.oneFrom(forecastData.NFC[division], NFCDiv);

    return afc && nfc;
  };
}