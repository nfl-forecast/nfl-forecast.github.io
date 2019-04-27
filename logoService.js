angular.module('nflforecast').service('logoService',logoService);
function logoService()
{
  this.logoMap = new Map();

  this.initlogomap = function(logoMap){
    logoMap.set("Pittsburgh Steelers", {image: "images/NFL-logo.jpg"});
    
  };

  this.initlogomap(this.logoMap);

  this.getLogo = function(teamName)
  {
      var logo = this.logoMap.get(teamName);
      if(logo !== undefined)
      {
        return logo.image;
      }
      else
      {
        return undefined;
      }
  }

}