angular.module('nflforecast').component('seedButtons', {
  controller: ["teamService", "logoService", SBController],
  bindings: {
    allseeds: "=",
    index: "<",
    allteams: "=",
    name: "=",
    changed: "=",
    funmode: "<"
  },
  templateUrl: "htmlTemplates/seedButtons.html"

});

function SBController(teamService, logoService) {
  this.$onInit = function() {
  };

  this.clicked = function(teamName) {
    var teamIndex= this.getIndex(teamName);
    if(!this.funmode) {
      if (teamIndex !== -1)//currently in a playoff position
      {
        if (this.getSeed(teamName) < 4) //currently in divisional spot
        {
          if (this.index < 4 || (this.index > 5 && this.index < 10)) //in division spot going for division spot
          {
            if (!(teamIndex === this.index)) //in division spot that isn't spot going for
            {
              var temp = angular.copy(this.allseeds[this.index]);
              this.allseeds[this.index] = angular.copy(teamName);
              this.allseeds[teamIndex] = temp;
              this.changed = true;
            }
          } else //in division spot going for wildcard spot
          {
            var teamsindivision = teamService.getNames(teamService.getDivisionTeams(teamName));
            var flag = false;
            for (var i = 4; i < 6; i++) {
              for (var j = 0; j < teamsindivision.length; j++) {
                if (this.allseeds[i] === teamsindivision[j] && flag) {
                  flag = false;
                  var temp = angular.copy(this.allseeds[i]);
                  this.allseeds[i] = angular.copy(this.allseeds[teamIndex]);
                  this.allseeds[teamIndex] = angular.copy(temp);
                  this.changed = true;
                  this.clicked(teamName);
                }
              }
            }
            for (var i = 10; i < 12; i++) {
              for (var j = 0; j < teamsindivision.length; j++) {
                if (this.allseeds[i] === teamsindivision[j] && flag) {
                  flag = false;
                  var temp = angular.copy(this.allseeds[i]);
                  this.allseeds[i] = angular.copy(this.allseeds[teamIndex]);
                  this.allseeds[teamIndex] = angular.copy(temp);
                  this.changed = true;
                  this.clicked(teamName);
                }
              }
            }
            if (!flag) {
              var rand = teamService.getRandomDivTeam(teamName);
              this.allseeds[teamIndex] = rand;
              this.changed = true;
              this.clicked(teamName);
            }
          }
        } else //currently in wildcard spot
        {
          if (this.index < 4 || (this.index > 5 && this.index < 10)) //in a wildcard spot going for division spot
          {
            var divIndex = teamService.getDivisionalRivalIndex(teamName, this.allseeds);
            var temp = angular.copy(this.allseeds[divIndex]);
            var temp1 = angular.copy(this.allseeds[this.getIndex(teamName)]);
            this.allseeds[divIndex] = angular.copy(temp1);
            this.allseeds[teamIndex] = angular.copy(temp);
            this.changed = true;
            this.clicked(teamName);
          } else //in a wildcard spot going for wildcard spot
          {
            if (!(this.getSeed(teamName) === this.index)) {
              var temp = angualt.copy(this.allseeds[this.index]);
              this.allseeds[this.index] = angular.copy(this.allseeds[teamIndex]);
              this.allseeds[teamIndex] = angular.copy(temp);
              this.changed = true;
            }
          }
        }
      } else //not in playoffs
      {
        if (this.index < 4 || (this.index > 5 && this.index < 10)) //not in a playoff spot going for division spot
        {
          this.allseeds[teamService.getDivisionalRivalIndex(teamName, this.allseeds)] = teamName;
          this.changed = true;
          this.clicked(teamName);
        } else //not in a playoff spot going for wildcard spot
        {
          this.allseeds[this.index] = angular.copy(teamName);
          this.changed = true;
        }
      }
    }
    else
    {
      this.allseeds[this.index] = angular.copy(teamName);
      this.changed = true;
    }
    // if(!this.allseeds.includes(teamName))
    // {
    //   var afterSeeds = angular.copy(this.allseeds);
    //   afterSeeds[this.index] = teamName;
    //   if(teamService.validPlayoffs(afterSeeds)) {
    //     this.allseeds[this.index] = teamName;
    //     this.changed = true;
    //   }
    // }
  };

  this.getLogo = function(teamName) {
    return logoService.getLogo(teamName);
  };

  this.color = function(teamName) {
    if(this.allseeds[this.index] === teamName)
    {
      return "green";
    }
    if(this.allseeds.includes(teamName)) {
      return "red";
    }
    return "white";
  }

  this.getSeed = function(teamName) {
    if(!this.allseeds.includes(teamName)) return -1;
    else
    {
      for(var i = 0; i < 6; i++)
      {
        if(teamName === this.allseeds[i])
          return i;
      }
      for(var i = 6; i < 12; i++)
      {
        if(teamName === this.allseeds[i])
          return i-6;
      }
    }
  };

  this.getIndex = function(teamName) {
    if(!this.allseeds.includes(teamName)) return -1;
    else
    {
      for(var i = 0; i < 12; i++)
      {
        if(teamName === this.allseeds[i])
          return i;
      }
    }
  }
}