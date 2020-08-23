package scheduleFromHTML;

public class FullSchedule
{
	public Schedule fullgamesschedule;
	public void setFullgamesschedule(Schedule s)
	{
		fullgamesschedule = s;
	}
	
	public String toString()
	{
		return fullgamesschedule.toString();
	}
	public Schedule getSchedule()
	{
		return fullgamesschedule;
	}
}
