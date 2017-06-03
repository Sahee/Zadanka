package pl.sahee;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;


public class BanditDeck {

    public static final String TWO_CARD = "2";
    public static final String THREE_CARD = "3";
    public static final String FOUR_CARD = "4";
    public static final String FIVE_CARD = "5";

    public static final String CLUBS = "trefl";
    public static final String DIAMONDS = "karo";
    public static final String HEARTS = "kier";
    public static final String SPADES = "pik";

    private List<Card> clubs;
    private List<Card> diamonds;
    private List<Card> hearts;
    private List<Card> spades;

    public BanditDeck() {

        clubs = new ArrayList<>();
        diamonds = new ArrayList<>();
        spades = new ArrayList<>();
        hearts = new ArrayList<>();

        clubs.add(new Card("2 trefl", 2, 0));
        clubs.add(new Card("3 trefl", 3, 0));
        clubs.add(new Card("4 trefl", 4, 0));
        clubs.add(new Card("5 trefl", 5, 0));

        diamonds.add(new Card("2 karo", 2, 0));
        diamonds.add(new Card("3 karo", 3, 0));
        diamonds.add(new Card("4 karo", 4, 0));
        diamonds.add(new Card("5 karo", 5, 0));

        spades.add(new Card("2 pik", 2, 0));
        spades.add(new Card("3 pik", 3, 0));
        spades.add(new Card("4 pik", 4, 0));
        spades.add(new Card("5 pik", 5, 0));

        hearts.add(new Card("2 kier", 2, 0));
        hearts.add(new Card("3 kier", 3, 0));
        hearts.add(new Card("4 kier", 4, 0));
        hearts.add(new Card("5 kier", 5, 0));
    }

    public Card RandCard() {
        Random r = new Random();
        int colour = r.nextInt(4);
        List<Card> cardCol = new ArrayList<>();

        switch (colour) {
            case 0:
                cardCol = clubs;
                break;
            case 1:
                cardCol = diamonds;
                break;
            case 2:
                cardCol = hearts;
                break;
            case 3:
                cardCol = spades;
                break;
        }

        int cardVal = r.nextInt(4);
        return cardCol.get(cardVal);
    }
}