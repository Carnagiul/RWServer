package api;

import java.util.ArrayList;
import java.util.List;

import net.risingworld.api.objects.Player;
import net.risingworld.api.utils.Quaternion;
import net.risingworld.api.utils.Vector3f;

public class RWPlayer {
	private Player p;
	private List<RWLocation> home = new ArrayList<RWLocation>();
	
	public RWPlayer(Player p)
	{
		this.setP(p);
	}
	
	public void teleportToLoc(Vector3f loc, Quaternion qt)
	{
		if (loc != null)
			this.getP().setPosition(loc);
		if (qt != null)
			this.getP().setRotation(qt);
	}
	
	public void teleportTo(Player to)
	{
		teleportToLoc(to.getPosition(), to.getRotation());
	}
	
	public int can_tp(RWLocation loc)
	{
		for (RWLocation home:this.getHome())
		{
			if (home.equals(loc))
				return (1);
		}
		return (0);
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public List<RWLocation> getHome() {
		return home;
	}

	public void setHome(List<RWLocation> home) {
		this.home = home;
	}
	
	public void addHome(RWLocation loc)	{
		this.home.add(loc);
	}
}
