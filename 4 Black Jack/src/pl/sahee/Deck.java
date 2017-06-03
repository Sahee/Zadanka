package pl.sahee;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;


public class Deck {

    private List<Card> clubs;
    private List<Card> diamonds;
    private List<Card> spades;
    private List<Card> hearts;

    public Deck() {
        
        clubs = new ArrayList<>();
        diamonds = new ArrayList<>();
        spades = new ArrayList<>();
        hearts = new ArrayList<>();

        clubs.add(new Card("as trefl", 1, 11));
        clubs.add(new Card("2 trefl", 2, 0));
        clubs.add(new Card("3 trefl", 3, 0));
        clubs.add(new Card("4 trefl", 4, 0));
        clubs.add(new Card("5 trefl", 5, 0));
        clubs.add(new Card("6 trefl", 6, 0));
        clubs.add(new Card("7 trefl", 7, 0));
        clubs.add(new Card("8 trefl", 8, 0));
        clubs.add(new Card("9 trefl", 9, 0));
        clubs.add(new Card("10 trefl", 10, 0));
        clubs.add(new Card("walet trefl", 10, 0));
        clubs.add(new Card("dama trefl", 10, 0));
        clubs.add(new Card("krol trefl", 10, 0));

        diamonds.add(new Card("as karo", 1, 11));
        diamonds.add(new Card("2 karo", 2, 0));
        diamonds.add(new Card("3 karo", 3, 0));
        diamonds.add(new Card("4 karo", 4, 0));
        diamonds.add(new Card("5 karo", 5, 0));
        diamonds.add(new Card("6 karo", 6, 0));
        diamonds.add(new Card("7 karo", 7, 0));
        diamonds.add(new Card("8 karo", 8, 0));
        diamonds.add(new Card("9 karo", 9, 0));
        diamonds.add(new Card("10 karo", 10, 0));
        diamonds.add(new Card("walet karo", 10, 0));
        diamonds.add(new Card("dama karo", 10, 0));
        diamonds.add(new Card("krol karo", 10, 0));

        spades.add(new Card("as pik", 1, 11));
        spades.add(new Card("2 pik", 2, 0));
        spades.add(new Card("3 pik", 3, 0));
        spades.add(new Card("4 pik", 4, 0));
        spades.add(new Card("5 pik", 5, 0));
        spades.add(new Card("6 pik", 6, 0));
        spades.add(new Card("7 pik", 7, 0));
        spades.add(new Card("8 pik", 8, 0));
        spades.add(new Card("9 pik", 9, 0));
        spades.add(new Card("10 pik", 10, 0));
        spades.add(new Card("walet pik", 10, 0));
        spades.add(new Card("dama pik", 10, 0));
        spades.add(new Card("krol pik", 10, 0));

        hearts.add(new Card("as kier", 1, 11));
        hearts.add(new Card("2 kier", 2, 0));
        hearts.add(new Card("3 kier", 3, 0));
        hearts.add(new Card("4 kier", 4, 0));
        hearts.add(new Card("5 kier", 5, 0));
        hearts.add(new Card("6 kier", 6, 0));
        hearts.add(new Card("7 kier", 7, 0));
        hearts.add(new Card("8 kier", 8, 0));
        hearts.add(new Card("9 kier", 9, 0));
        hearts.add(new Card("10 kier", 10, 0));
        hearts.add(new Card("walet kier", 10, 0));
        hearts.add(new Card("dama kier", 10, 0));
        hearts.add(new Card("krol kier", 10, 0));
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

        int cardVal = r.nextInt(13);
        return cardCol.get(cardVal);
    }
}
