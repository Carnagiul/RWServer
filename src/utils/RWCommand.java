package utils;

import Class.main;

public class RWCommand {
	private main m;
	private String cmd;
	private String[] data;
	
	public RWCommand(main m)
	{
		this.setM(m);
	}

	public main getM() {
		return m;
	}

	public void setM(main m) {
		this.m = m;
	}
	
	public int getCommand(String command, String owner)
	{
		this.cmd = command;
		this.data = this.cmd.split(" ");
		if (this.data[0].equalsIgnoreCase("/w") || this.data[0].equalsIgnoreCase("/whisper") || this.data[0].equalsIgnoreCase("/whisp") || this.data[0].equalsIgnoreCase("/mp") || this.data[0].equalsIgnoreCase("/msg"))
		{
			if (this.data.length >= 3)
				this.getM().utils.whisper_player(this.data[1], owner, this.data);
			else
				this.getM().utils.getPlayer(owner).sendTextMessage(this.data[0] + " <USERNAME> <<You're message here>>");
		}
		else if (this.data[0].equalsIgnoreCase("/tp") && this.getM().utils.getPlayer(owner).isAdmin())
		{
			if (this.data.length == 3)
				this.getM().utils.teleportTo(this.data[1], this.data[2], owner);
			else
				this.getM().utils.getPlayer(owner).sendTextMessage(this.data[0] + " <<Player1>> --> <<Player2>>");
		}
		else
			this.getM().utils.getPlayer(owner).sendTextMessage("Unknow Command");
		return (0);
	}
}
