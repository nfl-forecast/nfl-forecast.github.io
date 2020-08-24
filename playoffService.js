angular.module('nflforecast').service('playoffService',playoffService);
function playoffService()
{
  this.characterMap = new Map();

  this.getWildcardPCT = function(teamName) {
    for(var i = 0; i < 12; i++)
    {
      if(forecastData.playoffs.afcteams[i] === teamName)
      {
        return forecastData.playoffs.afcwildCard[i];
      }
      if(forecastData.playoffs.nfcteams[i] === teamName)
      {
        return forecastData.playoffs.nfcwildCard[i];
      }
    }
    return 0;
  };

  this.initcharacterMap = function(characterMap){
    var afcTeams = forecastData.playoffs.afcteams;
    var afc1=afcTeams[0];
    var afc2=afcTeams[1];
    var afc3=afcTeams[2];
    var afc4=afcTeams[3];
    var afc5=afcTeams[4];
    var afc6=afcTeams[5];
    var afc7 = afcTeams[6]

    var nfcTeams = forecastData.playoffs.nfcteams;
    var nfc1=nfcTeams[0];
    var nfc2=nfcTeams[1];
    var nfc3=nfcTeams[2];
    var nfc4=nfcTeams[3];
    var nfc5=nfcTeams[4];
    var nfc6=nfcTeams[5];
    var nfc7=nfcTeams[6];
    characterMap.set(afc1, {character: "HOME"});
    characterMap.set(afc2, {character: "DIV"});
    characterMap.set(afc3, {character: "DIV"});
    characterMap.set(afc4, {character: "DIV"});
    characterMap.set(afc5, {character: "WC"});
    characterMap.set(afc6, {character: "WC"});
    characterMap.set(afc7, {character: "WC"});
    characterMap.set(nfc1, {character: "HOME"});
    characterMap.set(nfc2, {character: "DIV"});
    characterMap.set(nfc3, {character: "DIV"});
    characterMap.set(nfc4, {character: "DIV"});
    characterMap.set(nfc5, {character: "WC"});
    characterMap.set(nfc6, {character: "WC"});
    characterMap.set(nfc7, {character: "WC"});

  };

  this.initcharacterMap(this.characterMap);

  this.getSpecialCharacters = function(teamName)
  {
    var character = this.characterMap.get(teamName);
    if(character !== undefined)
    {
      return character.character;
    }
    else
    {
      return " ";
    }
  }

}