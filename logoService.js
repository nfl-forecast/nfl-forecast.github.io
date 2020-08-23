angular.module('nflforecast').service('logoService',logoService);
function logoService()
{
  this.logoMap = new Map();

  this.initlogomap = function(logoMap){
    logoMap.set("New Orleans Saints", {image: "images/New-Orleans-Saints.png"});
    logoMap.set("Los Angeles Rams", {image: "images/Los-Angeles-Rams.png"});
    logoMap.set("Chicago Bears", {image: "images/Chicago-Bears.png"});
    logoMap.set("Dallas Cowboys", {image: "images/Dallas-Cowboys.png"});
    logoMap.set("Seattle Seahawks", {image: "images/Seattle-Seahawks.png"});
    logoMap.set("Philadelphia Eagles", {image: "images/Philadelphia-Eagles.png"});
    logoMap.set("Minnesota Vikings", {image: "images/Minnesota-Vikings.png"});
    logoMap.set("Carolina Panthers", {image: "images/Carolina-Panthers.png"});
    logoMap.set("Atlanta Falcons", {image: "images/Atlanta-Falcons.png"});
    logoMap.set("Washington Football Team", {image: "images/Washington-Football-Team.png"});
    logoMap.set("Green Bay Packers", {image: "images/Green-Bay-Packers.png"});
    logoMap.set("Detroit Lions", {image: "images/Detroit-Lions.png"});
    logoMap.set("Tampa Bay Buccaneers", {image: "images/Tampa-Bay-Buccaneers.png"});
    logoMap.set("New York Giants", {image: "images/New-York-Giants.png"});
    logoMap.set("San Francisco 49ers", {image: "images/San-Francisco-49ers.png"});
    logoMap.set("Arizona Cardinals", {image: "images/Arizona-Cardinals.png"});
    logoMap.set("Kansas City Chiefs", {image: "images/Kansas-City-Chiefs.png"});
    logoMap.set("New England Patriots", {image: "images/New-England-Patriots.png"});
    logoMap.set("Houston Texans", {image: "images/Houston-Texans.png"});
    logoMap.set("Baltimore Ravens", {image: "images/Baltimore-Ravens.png"});
    logoMap.set("Los Angeles Chargers", {image: "images/Los-Angeles-Chargers.png"});
    logoMap.set("Indianapolis Colts", {image: "images/Indianapolis-Colts.png"});
    logoMap.set("Pittsburgh Steelers", {image: "images/Pittsburgh-Steelers.png"});
    logoMap.set("Tennessee Titans", {image: "images/Tennessee-Titans.png"});
    logoMap.set("Cleveland Browns", {image: "images/Cleveland-Browns.png"});
    logoMap.set("Miami Dolphins", {image: "images/Miami-Dolphins.png"});
    logoMap.set("Denver Broncos", {image: "images/Denver-Broncos.png"});
    logoMap.set("Cincinnati Bengals", {image: "images/Cincinnati-Bengals.png"});
    logoMap.set("Buffalo Bills", {image: "images/Buffalo-Bills.png"});
    logoMap.set("Jacksonville Jaguars", {image: "images/Jacksonville-Jaguars.png"});
    logoMap.set("New York Jets", {image: "images/New-York-Jets.png"});
    logoMap.set("Las Vegas Raiders", {image: "images/Las-Vegas-Raiders.png"});
    logoMap.set("trophy", {image:"images/Lombardi-Trophy.png"});
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