angular.module('nflforecast').service('logoService',logoService);
function logoService()
{
  this.logoMap = new Map();

  this.initlogomap = function(logoMap){
    logoMap.set("New Orleans Saints", {image: "images/New-Orleans-Saints.jpg"});
    logoMap.set("Los Angeles Rams", {image: "images/Los-Angeles-Rams.jpg"});
    logoMap.set("Chicago Bears", {image: "images/Chicago-Bears.jpg"});
    logoMap.set("Dallas Cowboys", {image: "images/Dallas-Cowboys.jpg"});
    logoMap.set("Seattle Seahawks", {image: "images/Seattle-Seahawks.jpg"});
    logoMap.set("Philadelphia Eagles", {image: "images/Philadelphia-Eagles.jpg"});
    logoMap.set("Minnesota Vikings", {image: "images/Minnesota-Vikings.jpg"});
    logoMap.set("Carolina Panthers", {image: "images/Carolina-Panthers.jpg"});
    logoMap.set("Atlanta Falcons", {image: "images/Atlanta-Falcons.jpg"});
    logoMap.set("Washington Redskins", {image: "images/Washington-Redskins.jpg"});
    logoMap.set("Green Bay Packers", {image: "images/Green-Bay-Packers.jpg"});
    logoMap.set("Detroit Lions", {image: "images/Detroit-Lions.jpg"});
    logoMap.set("Tampa Bay Buccaneers", {image: "images/Tampa-Bay-Buccaneers.jpg"});
    logoMap.set("New York Giants", {image: "images/New-York-Giants.jpg"});
    logoMap.set("San Francisco 49ers", {image: "images/San-Francisco-49ers.jpg"});
    logoMap.set("Arizona Cardinals", {image: "images/Arizona-Cardinals.jpg"});
    logoMap.set("Kansas City Chiefs", {image: "images/Kansas-City-Chiefs.jpg"});
    logoMap.set("New England Patriots", {image: "images/New-England-Patriots.jpg"});
    logoMap.set("Houston Texans", {image: "images/Houston-Texans.jpg"});
    logoMap.set("Baltimore Ravens", {image: "images/Baltimore-Ravens.jpg"});
    logoMap.set("Los Angeles Chargers", {image: "images/Los-Angeles-Chargers.jpg"});
    logoMap.set("Indianapolis Colts", {image: "images/Indianapolis-Colts.jpg"});
    logoMap.set("Pittsburgh Steelers", {image: "images/Pittsburgh-Steelers.jpg"});
    logoMap.set("Tennessee Titans", {image: "images/Tennessee-Titans.jpg"});
    logoMap.set("Cleveland Browns", {image: "images/Cleveland-Browns.jpg"});
    logoMap.set("Miami Dolphins", {image: "images/Miami-Dolphins.jpg"});
    logoMap.set("Denver Broncos", {image: "images/Denver-Broncos.jpg"});
    logoMap.set("Cincinnati Bengals", {image: "images/Cincinnati-Bengals.jpg"});
    logoMap.set("Buffalo Bills", {image: "images/Buffalo-Bills.jpg"});
    logoMap.set("Jacksonville Jaguars", {image: "images/Jacksonville-Jaguars.jpg"});
    logoMap.set("New York Jets", {image: "images/New-York-Jets.jpg"});
    logoMap.set("Oakland Raiders", {image: "images/Oakland-Raiders.jpg"});
    logoMap.set("trophy", {image:"images/Lombardi-Trophy.jpg"});
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