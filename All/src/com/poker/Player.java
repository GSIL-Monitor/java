package com.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public int ID;
    public String name;
    public List<Card> handCard;

    public Player(int ID, String name){
        this.ID = ID;
        this.name = name;
        handCard = new ArrayList<Card>();
    }


}
