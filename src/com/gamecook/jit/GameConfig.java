package com.gamecook.jit;

/**
 * User: Jesse Freeman
 * Date: 11/28/10
 * Time: 9:59 PM
 */
public interface GameConfig {
    int getDifficultyLevel();

    void setDifficultyLevel(int difficultyLevel);

    int getCurrentLocation();

    void setCurrentLocation(int currentLocation);

    double getSavings();

    void setSavings(double savings);

    double getLoan();

    void setLoan(double loan);

    double getInterest();

    void setInterest(double interest);

    double getCash();

    void setCash(double cash);

    int getDays();

    void setDays(int days);

    int getTotalDays();

    void setTotalDays(int totalDays);
}