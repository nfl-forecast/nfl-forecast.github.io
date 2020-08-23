package scheduleFromHTML;

public class TeamSchedule
{
	
	public String Name;
	
	public String Abreviation;
	
	public String Score;
	
	
	public void setName(String str)
	{
		Name = str;
	}
	public void setAbreviation(String str)
	{
		Abreviation = str;
	}
	public int getScore() {
		if(Score == "")
			return -1;
		else
			return Integer.parseInt(Score);
	}
	public String getName()
	{
		return Name;
	}
	public String getAbreviation()
	{
		return Abreviation;
	}
	public void setScore(String str) {
		Score = str;
	}
	public String toString()
	{
		return Name;
	}
}
