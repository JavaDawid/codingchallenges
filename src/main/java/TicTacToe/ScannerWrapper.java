package TicTacToe;

import java.util.Scanner;

public class ScannerWrapper {
    private Scanner scanner = new Scanner(System.in);

    public int nextInt() {
        return scanner.nextInt();
    }

    public void nextLine() {
        scanner.nextLine();
    }
}