package me.Flibio.EconomyManager;

public interface Economy {
	
	/**
     * Gets name of the economy
     * @return Name of the Economy
     */
	public String getEconomyName();
	
	/**
     * Returns the singular name of the currency being used
     * @return Name of currency (singular)
     */
	public String currencyNameSingular();
	
	/**
     * Returns the plural name of the currency being used
     * @return Name of currency (plural)
     */
	public String currencyNamePlural();
	
	/**
     * Sets the balance of the given player to the given amount
     * @param Name of the player to change the balance of
     * @param Amount to set the player's balance to
     * @return If the method was successful or failed
     */
	public EconomyResponse setBalance(String playerName, double balance);
	
	/**
     * Returns the amount of currency a specified player has
     * @return Current balance of specified player
     */
	public double getBalance(String name);
	
	/**
     * Adds the specified amount of currency to a specified player's balance
     * @return If the method was successful or failed
     */
	public EconomyResponse addCurrency(String name, double amount);
	
	/**
     * Removes the specified amount of currency from a specified player's balance
     * @return If the method was successful or failed
     */
	public EconomyResponse removeCurrency(String name, double amount);
	
	/**
     * Returns if the player has logged into the server or not and generated a account with the economy
     * @return If the player has logged in or not
     */
	public boolean hasAccount(String name);
}
