angular.module('nflforecast').component('seedButtons', {
  controller: ["teamService", "logoService", SBController],
  bindings: {
    allseeds: "=",
    index: "=",
    allteams: "=",
    name: "=",
    changed: "="
  },
  templateUrl: "htmlTemplates/seedButtons.html"

});

function SBController(teamService, logoService) {
  this.$onInit = function() {
  };

  this.clicked = function(teamName) {
    if(!this.allseeds.includes(teamName))
    {
      var afterSeeds = angular.copy(this.allseeds);
      afterSeeds[this.index] = teamName;
      if(teamService.validPlayoffs(afterSeeds)) {
        this.allseeds[this.index] = teamName;
        this.changed = true;
      }
    }
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
}