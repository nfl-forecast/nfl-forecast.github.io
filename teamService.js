angular.module('nflforecast').service('teamService',teamService);
function teamService()
{
  this.getTeam = function(teamName)
  {
    for(var division in forecastData.AFC)
    {
      for (var team in forecastData.AFC[division].teams)
      {
        if(forecastData.AFC[division].teams[team].name === teamName)
        {
          return forecastData.AFC[division].teams[team];
        }
      }
    }
    for(var division in forecastData.NFC)
    {
      for (var team in forecastData.NFC[division].teams)
      {
        if(forecastData.NFC[division].teams[team].name === teamName)
        {
          return forecastData.NFC[division].teams[team];
        }
      }
    }
    return undefined;
  }

}