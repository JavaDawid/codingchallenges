package TicTacToe;

import java.util.Scanner;

public class ScannerWrapper {
    Scanner scanner = new Scanner(System.in);

    public int input() {
        return scanner.nextInt();
    }

    public void cleaner() {
        scanner.nextLine();
    }
}