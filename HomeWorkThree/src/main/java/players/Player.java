package players;
import java.util.Scanner;

public class Player {
    PlayingField playingField = new PlayingField();
    private String name;

    char [] [] playDesk = playingField.getPlayDesk();

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя игрока:");
        this.name = scanner.nextLine();
    }

    public char[][] makeAMove(int x, int y, char[][] boards) {
        playDesk[x][y] = '*';
        return playDesk;
    }

}
