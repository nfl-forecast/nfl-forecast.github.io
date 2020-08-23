package dataFromHTML;

import java.util.List;

public class OverallStats
{
	private String lastUpdatedOn;
	private List<FullStats> statEntry;
	
	public String toString()
	{
		String str = "";
		for(FullStats t : statEntry)
			str += t.toString() + "\n\n";
		return str;
	}
	public void setLastUpdatedOn(String str)
	{
		lastUpdatedOn = str;
	}
	public void setStatEntry(List<FullStats> t)
	{
		statEntry = t;
	}
	public List<FullStats> getStatEntry()
	{
		return statEntry;
	}
}
