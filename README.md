# EconomyManager

####Implementing EconomyManager - EconomyManager for your economy plugin

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
  
  public void onServerStarting(ServerStartingEvent event){
    //Create a new EconomyAPI instance using the implementation of the economy interface created in step 1
    EconomyAPI economyAPI = new EconomyAPI(new MyEconomy());
    //Register the economy as the servers economy - EconomyAPI will handle all logging and errors
    economyAPI.registerEconomy();
  }
  
}

```
