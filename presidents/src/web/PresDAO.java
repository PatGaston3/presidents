package web;

import java.util.List;

public interface PresDAO {
	
	public President getPresident(int term);
	public List<President> getPresidents();

	
	
	
}
