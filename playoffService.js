angular.module('nflforecast').service('playoffService',playoffService);
function playoffService()
{
  this.characterMap = new Map();

  this.initcharacterMap = function(characterMap){
    var afcTeams = forecastData.playoffs.afcteams;
    var afc1=afcTeams[0];
    var afc2=afcTeams[1];
    var afc3=afcTeams[2];
    var afc4=afcTeams[3];
    var afc5=afcTeams[4];
    var afc6=afcTeams[5];

    var nfcTeams = forecastData.playoffs.nfcteams;
    var nfc1=nfcTeams[0];
    var nfc2=nfcTeams[1];
    var nfc3=nfcTeams[2];
    var nfc4=nfcTeams[3];
    var nfc5=nfcTeams[4];
    var nfc6=nfcTeams[5];
    characterMap.set(afc1, {character: "*"});
    characterMap.set(afc2, {character: "z"});
    characterMap.set(afc3, {character: "y"});
    characterMap.set(afc4, {character: "y"});
    characterMap.set(afc5, {character: "x"});
    characterMap.set(afc6, {character: "x"});
    characterMap.set(nfc1, {character: "*"});
    characterMap.set(nfc2, {character: "z"});
    characterMap.set(nfc3, {character: "y"});
    characterMap.set(nfc4, {character: "y"});
    characterMap.set(nfc5, {character: "x"});
    characterMap.set(nfc6, {character: "x"});

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