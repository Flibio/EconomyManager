# EconomyManager

[Download the latest version of EconomyManager here](https://github.com/Flibio/EconomyManager/releases)

####Implementing EconomyManager - For your economy plugin

Implementing EconomyManager into your new or existing economy plugin is simple and easy to do. Just follow the two simple steps and example below to learn how. Have any questions? Submit them [here](https://github.com/Flibio/EconomyManager/issues/new) and select question as the label.

**Step 1:** Creating an instance of the Economy interface

```java

  package example.economy;
  
  import me.Flibo.EconomyManager.Economy;
  import me.Flibo.EconomyManager.EconomyResponse;
  
  public class Example implements Economy{
  
  	@Override
  	public String getEconomyName() {
  		//Name of your economy plugin
  		return "Economy Example";
  	}
  
  	@Override
  	public String currencyNameSingular() {
  		//Name of your plugin's currency (singular)
  		return "Coin";
  	}
  
  	@Override
  	public String currencyNamePlural() {
  		//Name of your plugin's currency (plural)
  		return "Coins";
  	}
  
  	@Override
  	public EconomyResponse setBalance(String playerName, double balance) {
  		//Sets the balance of a player to the specified amount
  		//Returns if it was successful or failed
  		return EconomyResponse.SUCCESS;
  	}
  
  	@Override
  	public double getBalance(String name) {
  		//Returns the balance of the specified player
  		return 0;
  	}
  
  	@Override
  	public EconomyResponse addCurrency(String name, double amount) {
  		//Adds the specified amount of currency to the specified player's balance
  		return EconomyResponse.SUCCESS;
  	}
  
  	@Override
  	public EconomyResponse removeCurrency(String name, double amount) {
  		//Subtracts the specified amount of currency from the specified player's balance
  		return EconomyResponse.SUCCESS;
  	}
  
  	@Override
  	public boolean hasAccount(String name) {
  		//Checks if the player has an account with your plugin
  		return false;
  	}
  
  }

```

**Step 2:** Registering your implementation of the Economy interface with EconomyManager

```java
package example.economy;

import me.Flibio.EconomyManager.Economy;
import me.Flibio.EconomyManager.EconomyAPI;

import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.plugin.Plugin;

//!!!!!IMPORTANT!!!!! Make sure you include EconomyManager as a load after dependency in your plugin annotation
@Plugin(id = "EconomyExample", name = "EconomyExample", version = "1.0.0", dependencies = "after:EconomyManager;")
public class MainClass{
  
  @Subscribe
  public void onServerStarting(ServerStartingEvent event){
    //Create a new EconomyAPI instance
    EconomyAPI economyAPI = new EconomyAPI();
    //Register your economy as the server's economy - EconomyManager will handle all logging and errors
    economyAPI.registerEconomy(new MyEconomy());
  }
  
}

```


####Implementing EconomyManager - Using a registered economy

Tutorial coming soon
