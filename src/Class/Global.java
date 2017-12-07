package Class;

import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.Listener;
import net.risingworld.api.events.player.PlayerChatEvent;
import net.risingworld.api.events.player.PlayerChestAccessEvent;
import net.risingworld.api.events.player.PlayerCommandEvent;
import net.risingworld.api.events.player.world.PlayerPlaceBlockEvent;
import net.risingworld.api.events.player.world.PlayerPlaceObjectEvent;
import net.risingworld.api.objects.Player;

public class Global implements Listener{
	private main p;

	public Global(main m)
	{
		this.setP(m);
	}

	private void setP(main m) {
		this.p = m;
	}

    @EventMethod
    public void PlayerAcessChest(PlayerChestAccessEvent ev)
    {
    	Player Player = ev.getPlayer();

    	if (Player.isAdmin())
    		return ;
    	if (this.p.chest.containsKey(ev.getChestID()))
    	{
        	ChestProtection chest = this.p.chest.get(ev.getChestID());
     		if (chest.getOwner().equals(Player))
    			return ;
    		for(String allowed:chest.getAllowed())
    		{
    			if (allowed.equalsIgnoreCase(Player.getName()))
    				return ;
    		}
    	}
    	else
    		return ;
    	ev.setCancelled(true);
    	return ;
    }

    @EventMethod
    public void test(PlayerPlaceObjectEvent ev)
    {
    	System.out.printf("Objet place == %d\n", ev.getObjectInfoID());
    	ev.setCancelled(false);
    }
    
    @EventMethod
    public void test2(PlayerPlaceBlockEvent ev)
    {
    	System.out.printf("Block place == %d\n", ev.getBlockID());
    	ev.setCancelled(false);
    }
    
    @EventMethod
    public void onCommand1(PlayerChatEvent ev)
    {
    	this.p.RWcmd(ev.getPlayer(), ev.getChatMessage());
    }
    
    @EventMethod
    public void onCommand1(PlayerCommandEvent ev)
    {
    	this.p.RWcmd(ev.getPlayer(), ev.getCommand());
    }
}
