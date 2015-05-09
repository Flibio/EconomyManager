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

//!!!!!IMPORTANT!!!!! Make sure you include EconomyManager as a required after dependency in your plugin annotation
@Plugin(id = "EconomyExample", name = "EconomyExample", version = "1.0.0", dependencies = "required-after:EconomyManager;")
public class MainClass{
  
  //!!!IMPORTANT!!! Make sure you register your economy in the ServerStartingEvent, not the ServerStartedEvent
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

Implementing EconomyManager support into any plugin that uses an economy is easy to do.

**Part 1:** Setting up the main class

```java
package economy.example;

import me.Flibio.EconomyManager.EconomyAPI;

import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.plugin.Plugin;

//!!!!!IMPORTANT!!!!! Make sure you include EconomyManager as a required after dependency in your plugin annotation
@Plugin(id = "EconomyExample", name = "EconomyExample", version = "1.0.0", dependencies = "required-after:EconomyManager;")
public class MainClass{
  
  //!!!IMPORTANT!!! Make sure you test for an economy in the ServerStartedEvent, not the ServerStartingEvent
  @Subscribe
  public void serverStarted(ServerStartedEvent event){
    //If an economy is optional for your plugin, skip this step
    
    //Get a new instance of the EconomyAPI
    EconomyAPI economyAPI = new EconomyAPI();
    //Check if an economy doesn't exists
    if(!economyAPI.economyRegistered()){
      //TODO: Send an error to the console that no economy could be found and one is required
    }
    
  }
  
}

```

**Part 2:** Using the economy interface in other classes

```java
package economy.example;

import me.Flibio.EconomyManager.EconomyAPI;
import me.Flibio.EconomyManager.Economy;

public class UseClass{
  
  public void resetBalance(String name){
    //Get the EconomyAPI
    EconomyAPI economyAPI = new EconomyAPI();
    //Get the Economy
    Economy economy = economyAPI.getEconomy();
    //Use any method found in the Economy interface
    economy.setBalance(name, 0)
  }
  
}

```
