package Class;

import java.util.HashMap;

import net.risingworld.api.Plugin;
import net.risingworld.api.objects.Player;
import utils.RWCommand;
import utils.RWUtils;

public class main extends Plugin {
	public HashMap<Integer, ChestProtection> chest = new HashMap<Integer, ChestProtection>();
	public RWUtils utils;
	public RWCommand cmds;
	public Global global;

    @Override
    public void onEnable(){
    	utils = new RWUtils(this);
    	cmds = new RWCommand(this);
		global = new Global(this);
		this.registerEventListener(global);
    }

    @Override
    public void onDisable(){
    	this.unregisterEventListener(global);
    }

	public int RWcmd(Player player, String command) {
		if (command.startsWith("/") && player.isAdmin())
		{
			cmds.getCommand(command, player.getName());
			return (1);
		}
		return (0);
	}
    


}
