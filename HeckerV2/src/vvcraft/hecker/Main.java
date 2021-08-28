package vvcraft.hecker;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import vvcraft.hecker.commands.CommandsClear;
import vvcraft.hecker.commands.CommandsCreate;
import vvcraft.hecker.commands.CommandsPing;
import vvcraft.hecker.commands.CommandsPingServer;
import vvcraft.hecker.commands.CommandsInfo;
import vvcraft.hecker.commands.CommandsInvite;

public class Main {
	public static JDA jda;
	public static String prefix = "&";
	public static String GamePlayed = "Eclipse";
	
	//Main method
	
	public static void main(String[] args) throws LoginException
	{
		jda = JDABuilder.createDefault("Token").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setPresence(Activity.playing(GamePlayed), true);
		jda.addEventListener(new CommandsClear());
		jda.addEventListener(new CommandsPing());
		jda.addEventListener(new CommandsInfo());		
		jda.addEventListener(new CommandsCreate());
		jda.addEventListener(new CommandsInvite());
		jda.addEventListener(new CommandsPingServer());
	}
}