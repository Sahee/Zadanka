package pl.sahee;

import java.io.LineNumberReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static Core core;
    private static BJPlayer bjPlayer;
    private static boolean loop = true;

    public static void main(String[] args) {
        core = Core.getInst();
        bjPlayer = new BJPlayer();
        while (loop) {
            chckCash();
            chckGame();
        }
    }

    private static void chckCash() {
        System.out.println("Stan twojego konta: " + core.getMoney() + "$");
        if (core.getMoney() <= 0) {
            System.out.println("Rozpoczynajac gre musisz miec minimum 20$");
            System.out.println("Czy chcesz wpaacic potrzebne fundusze?");
            System.out.print("$$$$$$$$$$$$$$$$$$$$ Opcje $$$$$$$$$$$$$$$$$$$\n");
            System.out.print("$                                            $\n");
            System.out.print("$            (T)ak          (N)ie            $\n");
            System.out.print("$                                            $\n");
            System.out.print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n     ");

            String select = input().toLowerCase();

            switch (select.charAt(0)) {
                case 't':
                    core.setMoney(20);
                    break;
                case 'n':
                    System.out.println("Nie masz wystarczajaco dużo pieniedzy by grac.");
                    loop = false;
                    break;
                default:
                    System.out.print("\n B�ad wyboru!!!\n");
                    select = "INVALID_INPUT";
                    chckCash();
                    break;
            }
        }
    }

    private static void chckGame() {
        System.out.print("$$$$$$$$$$$$$$$$$$$ Opcje $$$$$$$$$$$$$$$$$$$$\n");
        System.out.print("$                                            $\n");
        System.out.print("$                (B)lackJack                 $\n");
        System.out.print("$                (S)tan konta                $\n");
        System.out.print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n     ");

        String select = input().toLowerCase();

        switch (select.charAt(0)) {
            case 's':
                System.out.println("Twoj stan konta to: " + core.getMoney() + "$");
                chckGame();
                break;
            case 'b':
                boolean bjLoop = true;
                while (bjLoop) {
                    bjPlayer.play();

                    System.out.println("\nChcesz grac dalej?");
                    System.out.print("$$$$$$$$$$$$$$$$$$$$ Opcje $$$$$$$$$$$$$$$$$$$\n");
                    System.out.print("$                                            $\n");
                    System.out.print("$            (T)ak          (N)ie            $\n");
                    System.out.print("$                                            $\n");
                    System.out.print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n     ");

                    select = input().toLowerCase();

                    switch (select.charAt(0)) {
                        case 't':
                            break;
                        case 'n':
                            chckMoneyAfterBlackJack();
                            bjPlayer = new BJPlayer();
                            bjLoop = false;
                            break;
                        default:
                            System.out.print("\n Blad wyboru!!!\n");
                            select = "INVALID_INPUT";
                            chckMoneyAfterBlackJack();
                            chckGame();
                            break;
                    }
                }
                break;
            default:
                System.out.print("\n Blad wyboru!!!\n");
                select = "INVALID_INPUT";
                chckGame();
                break;
        }
    }

    private static void chckMoneyAfterBlackJack() {
        core.addMoney(bjPlayer.getpWins() * 20);
        core.substractMoney(bjPlayer.getdWins() * 20);
    }

    public static String input() {
        LineNumberReader onion = new LineNumberReader(new InputStreamReader(System.in));
        String in = "";
        try {
            in = onion.readLine();
        } catch (IOException APPLE) {
            System.err.println("INPUT ERROR!!!");
        }
        return in;
    }
}
