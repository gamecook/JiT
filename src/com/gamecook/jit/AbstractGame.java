package com.gamecook.jit;

import com.gamecook.jit.collections.Inventory;
import com.gamecook.jit.collections.Locations;
import com.gamecook.jit.collections.Store;
import com.gamecook.jit.commerce.Bank;
import com.gamecook.jit.commerce.Wallet;
import com.gamecook.jit.player.Player;
import com.gamecook.jit.time.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 18, 2010
 * Time: 8:35:25 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractGame {

    protected Inventory inventory;
    protected Locations locations;
    protected Bank bank;
    protected Wallet wallet;
    protected Player player;
    protected Calendar calendar;

    public abstract void startGame(GameConfig config);

    public abstract void nextTurn();

    public Locations getLocations() {
        if (locations == null) locations = new Locations();
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public Bank getBank() {
        if (bank == null) bank = new Bank(0);
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Wallet getWallet() {
        if (wallet == null) wallet = new Wallet(0);
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Player getPlayer() {
        if (player == null) player = new Player("No Name");
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Calendar getCalendar() {
        if (calendar == null) calendar = new Calendar(0);
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Inventory getInventory() {
        if (inventory == null) inventory = new Inventory(100);
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
