package me.Flibio.EconomyManager;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.service.ProviderExistsException;
import org.spongepowered.api.service.ProvisioningException;

public class EconomyAPI {
	
	Logger logger;
	
	Game game;
	
	public EconomyAPI(){
		logger = EconomyManager.getPlugin().getLogger();
		game = EconomyManager.getPlugin().getGame();
	}
	
	/**
	 * Register your economy with EconomyManager
	 * @return If the economy was successfully registered or not
	 */
	public boolean registerEconomy(Economy economy){
		Economy currentEconomy = EconomyManager.currentEconomy;
		if(currentEconomy!=null){
			logger.error(economy.getEconomyName()+" has tried to overwrite your current economy: "+currentEconomy.getEconomyName());
			logger.warn("Please only install one economy plugin at a time!");
			return false;
		} else {
			EconomyManager.currentEconomy = economy;
			try {
				EconomyManager.getPlugin().getGame().getServiceManager().setProvider(EconomyManager.getPlugin(), Economy.class, economy);
			} catch (ProviderExistsException e) {
				logger.error("An EconomyManager economy has already been provided by an outside plugin!");
				logger.warn("Please only install one economy plugin at a time!");
				return false;
			}
			logger.warn(economy.getEconomyName()+" has registered as the current economy!");
			return true;
		}
	}
	
	/**
	 * Returns an instance of the registered economy class
	 * @return Null if there is no registered class, Economy if there is a registered class
	 */
	public Economy getEconomy(){
		if(economyRegistered()){
			try {
				return game.getServiceManager().provideUnchecked(Economy.class);
			} catch(ProvisioningException e){
				logger.error("Error loading economy: Economy not found");
				logger.error("DETAILED ERROR:");
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * Checks if there is an economy currently registered
	 * @return If there is an economy registered with EconomyManager
	 */
	public boolean economyRegistered(){
		if(EconomyManager.currentEconomy!=null){
			return true;
		} else {
			return false;
		}
	}
}
