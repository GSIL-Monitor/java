package com.poker;

import java.util.*;

public class Poker {
    List<Card> listCard = new ArrayList<Card>();
    List<Card> compareList = new ArrayList<Card>();
    List<Player> playerList = new ArrayList<Player>();
    Scanner scan = new Scanner(System.in);


    String[] numbers = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    String[] colors = new String[]{"方块", "梅花", "红桃", "黑桃"};


    public void createCard() {
        for (int i = 0; i < 13; i++) {
            int j = 0;
            do {
                listCard.add(new Card(numbers[i], colors[j]));
                j++;
            } while (j < 4);

        }

        System.out.println("Card created: ");
        for (Card cad : listCard) {
            System.out.print(cad.color + " " + cad.number);
        }
    }


    public void shuffle() {
/*        int cardNumber = listCard.size();
        Integer r;
        List<Integer> randomList = new ArrayList<Integer>();
        for (int i = 0; i < cardNumber; i++) {
            do {
                Random random = new Random();
                r = random.nextInt(cardNumber);

            } while (randomList.contains(r));
            randomList.add(r);
        }


        for (int k = 0; k < cardNumber; k++) {
            newListCard.add(k, listCard.get(randomList.get(k).intValue()));
        }
*/
        Collections.shuffle(listCard);

        System.out.println();
        System.out.println("Card shuffled: ");
        for (Card cad : listCard) {
            System.out.print(cad.color + " " + cad.number);
        }
        System.out.println();

    }


    public void createPlayer() {
        int i = 0;
        String n = "";
        for (int j = 1; j <= 2; j++) {
            System.out.println("please enter ID of Player " + j);
            try {
                i = scan.nextInt();
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("please reenter ID! ");
                scan = new Scanner(System.in);
                j--;
                continue;
            }

            System.out.println("please enter name of Player " + j);
            n = scan.next();
            playerList.add(new Player(i, n));
        }

        System.out.println("player : " + playerList.get(0).name + " welcome");
        System.out.println("player : " + playerList.get(1).name + " welcome");
    }



    public void dealCard() {
        for (int j = 0; j < 4; j += 2) {
            System.out.println("deal card to player " + playerList.get(0).name);
            playerList.get(0).handCard.add(listCard.get(j));
            System.out.println("deal card to player " + playerList.get(1).name);
            playerList.get(1).handCard.add(listCard.get(j + 1));
        }
        System.out.println("Card deal finish! game start! ");
        System.out.println("Cards of players in hand: ");
        System.out.println(playerList.get(0).name + ": " + playerList.get(0).handCard.get(0).color + playerList.get(0).handCard.get(0).number + ", " + playerList.get(0).handCard.get(1).color + playerList.get(0).handCard.get(1).number);
        System.out.println(playerList.get(1).name + ": " + playerList.get(1).handCard.get(0).color + playerList.get(1).handCard.get(0).number + ", " + playerList.get(1).handCard.get(1).color + playerList.get(1).handCard.get(1).number);
    }


    public void compareCard() {

        compareList.add(playerList.get(0).handCard.get(0));
        compareList.add(playerList.get(0).handCard.get(1));
        compareList.add(playerList.get(1).handCard.get(0));
        compareList.add(playerList.get(1).handCard.get(1));

        Collections.sort(compareList, new Compare());

        for (Card cad : compareList) {
            System.out.print(cad.color + cad.number + " ");
        }
        System.out.println();
        if (playerList.get(0).handCard.contains(compareList.get(3))) {
            System.out.println("player " + playerList.get(0).name + " wins!");
        } else
            System.out.println("player " + playerList.get(1).name + " wins!");
        System.out.println("the biggest card is " + compareList.get(3).color + compareList.get(3).number);
    }


    public static void main(String[] args) {
        Poker p = new Poker();
        p.createCard();
        p.shuffle();
        p.createPlayer();
        p.dealCard();
        p.compareCard();
    }

}

