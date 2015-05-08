package me.Flibio.EconomyManager;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "EconomyManager", name = "EconomyManager", version = "1.0.0")
public class EconomyManager {
	
	@Inject
	private Logger logger;
	
	protected static Economy currentEconomy = null;
	
	protected static EconomyManager manager;
	
	private Game game;
	
	@Subscribe
    public void onServerStart(ServerStartedEvent event) {
        logger.info("EconomyManager by Flibio enabling!");
        
        manager = this;
        
        game = event.getGame();
    }
	
	protected static EconomyManager getPlugin(){
		return manager;
	}
	
	protected Logger getLogger(){
		return logger;
	}
	
	protected Game getGame(){
		return game;
	}
}
