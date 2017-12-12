package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.risingworld.api.utils.Vector3f;

public class RWLocation {
	
	private Vector3f pos;
	private List<String> Allowed = new ArrayList<String>();
	private String name;
	private HashMap<String, Integer> Temp = new HashMap<String, Integer>();
	private String owner;

	public RWLocation()
	{
		
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int can_teleport(String name)
	{
		if (name.equalsIgnoreCase(this.getOwner()))
			return (1);
		for (String str: this.getAllowed())
		{
			if (str.equalsIgnoreCase("*"))
				return (1);
			if (str.equalsIgnoreCase(name))
				return (1);
		}
		if (this.getTemp().containsKey(name))
		{
			if (this.getTemp().get(name) > 0)
				return (1);
			return (0);
		}
		return (0);
	}

	public HashMap<String, Integer> getTemp() {
		return Temp;
	}

	public void setTemp(HashMap<String, Integer> temp) {
		Temp = temp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAllowed() {
		return Allowed;
	}

	public void setAllowed(List<String> allowed) {
		Allowed = allowed;
	}

	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}
}
