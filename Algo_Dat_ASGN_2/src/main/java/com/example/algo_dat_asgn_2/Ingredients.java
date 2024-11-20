package com.example.algo_dat_asgn_2;

public class Ingredients  {
    String iName;
    String description;

    public String getName() {
        return iName;
    }

    public void setName(String iName) {
        this.iName = iName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ingredients(String iName, String description)  {
        this.iName = iName;
        this.description = description;
    }

}
