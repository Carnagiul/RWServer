package api;

import java.util.ArrayList;
import java.util.List;

import net.risingworld.api.objects.Player;

public class ChestProtection {

	private Player owner;
	private List<String> allowed = new ArrayList<String>();
	private int id;
	
	public List<String> getAllowed() {
		return allowed;
	}
	public void setAllowed(List<String> allowed) {
		this.allowed = allowed;
	}

	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
