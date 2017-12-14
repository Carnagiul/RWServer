package utils;

import java.util.Collection;

import Class.main;
import net.risingworld.api.objects.Player;
import net.risingworld.api.utils.Vector3f;

public class RWUtils {
	private main m;

	public RWUtils(main m)
	{
		this.setM(m);
	}

	public main getM() {
		return m;
	}

	public void setM(main m) {
		this.m = m;
	}
	
	public Player getPlayer(String name)
	{
		Player p = null;
		
		for (Player pp : this.getM().getServer().getAllPlayers())
		{
			if (pp.getName().equalsIgnoreCase(name))
				return (pp);
		}
		return (p);
	}
	
	public int verify_player_is_in_list(String player, Collection<Player> p)
	{
		for (Player pp:p)
		{
			if (pp.getName().equalsIgnoreCase(player))
				return (1);
		}
		return (0);
	}
	
	public int verify_player_is_online(String player)
	{
		return (verify_player_is_in_list(player, this.getM().getServer().getAllPlayers()));
	}
	
	public int whisper_player(String other, String owner, String[] split)
	{
		if (other.equalsIgnoreCase(owner))
		{
			if (this.getPlayer(owner) != null)
				this.getPlayer(owner).sendTextMessage("Vous ne pouvez pas vous envoyer un message à vous même voyons.");
			return (0);
		}
		if (verify_player_is_online(other) == 1)
		{
			String str = "";
			split[0] = "[" + owner +"]";
			split[1] = ":";
			for (int i = 0; i < split.length; i++)
				str = str + split[i] + " ";
			if (this.getPlayer(other) != null && owner != null && str != null)
				this.getPlayer(other).sendTextMessage("Le joueur " + owner + " vous a whisp! " + str + "");
			if (this.getPlayer(owner) != null && other != null && str != null)
				this.getPlayer(owner).sendTextMessage("Vous avez whisp le joueur " + other + "! " + str + "");
			return (0);
		}
		else
		{
			if (this.getPlayer(owner) != null)
				this.getPlayer(owner).sendTextMessage("Cet utilisateur n'es pas connecté.");
			return (0);
		}
	}

	public int teleportTo(String sender, String recieve, String user) {

		if (this.getPlayer(user).isAdmin())
		{
			if (recieve.equalsIgnoreCase(sender))
			{
				if (this.getPlayer(user) != null)
					this.getPlayer(user).sendTextMessage("Vous ne pouvez pas téléporter la même personne.");
				return (0);
			}
			if (this.getPlayer(sender) != null && this.getPlayer(recieve) != null)
			{
				this.getPlayer(sender).setPosition(this.getPlayer(recieve).getPosition());
				this.getPlayer(sender).sendTextMessage("Vous avez été téléporter à " + recieve);
				this.getPlayer(recieve).sendTextMessage(sender + " a été téléporter à vous.");
				this.getPlayer(user).sendTextMessage(sender + " a été téléporter à " + recieve);
				return (0);
			}
			if (this.getPlayer(sender) != null)
				this.getPlayer(user).sendTextMessage(recieve + " n'es pas online!");
			if (this.getPlayer(recieve) != null)
				this.getPlayer(user).sendTextMessage(sender + " n'es pas online!");
			return (0);
		}
		else
			return (-1);
	}
	
	public Vector3f transformStringToVector3f(String vector)
	{
		String		vectorstr;
		Vector3f	v;
		String[]	vectorsplit;

		vectorstr = vector;
		vectorstr = vectorstr.replace("(", "0");
		vectorstr = vectorstr.replace(")", "0");
		vectorsplit = vectorstr.split(", ");
		v = new Vector3f(Float.parseFloat(vectorsplit[0]), Float.parseFloat(vectorsplit[1]), Float.parseFloat(vectorsplit[2]));
		return (v);
	}
}
