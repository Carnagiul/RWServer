package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.risingworld.api.utils.Vector3f;

public class RWArea {
	private String Owner;
	private List<String> can_build = new ArrayList<String>();
	private HashMap<String, Integer> temp_can_build = new HashMap<String, Integer>();
	private List<String> can_interact = new ArrayList<String>();
	private HashMap<String, Integer> temp_can_interact = new HashMap<String, Integer>();
	private List<String> can_gather = new ArrayList<String>();
	private HashMap<String, Integer> temp_can_gather = new HashMap<String, Integer>();
	private int is_safezone;
	private int is_feedzone;
	private int is_healzone;
	private Vector3f pos1;
	private Vector3f pos2;
	private int is_extend_y;
	
	public RWArea()
	{
		
	}

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}
	
	public void add_inlist(List<String> list, String add)
	{
		list.add(add);
	}
	
	public void add_inhash(HashMap<String, Integer> list, String add, Integer limit)
	{
		list.put(add, limit);
	}

	public List<String> getCan_build() {
		return can_build;
	}

	public void setCan_build(List<String> can_build) {
		this.can_build = can_build;
	}

	public HashMap<String, Integer> getTemp_can_build() {
		return temp_can_build;
	}

	public void setTemp_can_build(HashMap<String, Integer> temp_can_build) {
		this.temp_can_build = temp_can_build;
	}

	public List<String> getCan_interact() {
		return can_interact;
	}

	public void setCan_interact(List<String> can_interact) {
		this.can_interact = can_interact;
	}

	public HashMap<String, Integer> getTemp_can_interact() {
		return temp_can_interact;
	}

	public void setTemp_can_interact(HashMap<String, Integer> temp_can_interact) {
		this.temp_can_interact = temp_can_interact;
	}

	public List<String> getCan_gather() {
		return can_gather;
	}

	public void setCan_gather(List<String> can_gather) {
		this.can_gather = can_gather;
	}

	public HashMap<String, Integer> getTemp_can_gather() {
		return temp_can_gather;
	}

	public void setTemp_can_gather(HashMap<String, Integer> temp_can_gather) {
		this.temp_can_gather = temp_can_gather;
	}

	public int getIs_safezone() {
		return is_safezone;
	}

	public void setIs_safezone(int is_safezone) {
		this.is_safezone = is_safezone;
	}

	public int getIs_feedzone() {
		return is_feedzone;
	}

	public void setIs_feedzone(int is_feedzone) {
		this.is_feedzone = is_feedzone;
	}

	public int getIs_healzone() {
		return is_healzone;
	}

	public void setIs_healzone(int is_healzone) {
		this.is_healzone = is_healzone;
	}

	public Vector3f getPos1() {
		return pos1;
	}

	public void setPos1(Vector3f pos1) {
		this.pos1 = pos1;
	}

	public Vector3f getPos2() {
		return pos2;
	}

	public void setPos2(Vector3f pos2) {
		this.pos2 = pos2;
	}

	public int getIs_extend_y() {
		return is_extend_y;
	}

	public void setIs_extend_y(int is_extend_y) {
		this.is_extend_y = is_extend_y;
	}
}
