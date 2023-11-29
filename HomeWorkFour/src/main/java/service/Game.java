package Service;
import players.Player;
import players.PlayerOne;
import players.PlayerTwo;
import players.PlayingField;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    PlayingField playingField = new PlayingField();

    Player makingAMove = new Player();
    PlayerOne playerOne = new PlayerOne();
    PlayerTwo playerTwo = new PlayerTwo();



    public Game(PlayerOne playerOne, PlayerTwo playerTwo, PlayingField playingField) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playingField = playingField;
    }
    char[][] boards = playingField.getPlayDesk();

    public Game(Player one, Player two) {
    }
    void gameRun(PlayerOne playerOne, PlayerTwo playerTwo, char[][] boards) {
        System.out.println("Печатаем начальное игровое поле");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(boards[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Кидаем жребий, кто будет ходить первым.");
        int num = random.nextInt(1, 3);
        System.out.println("Выпало: " + num);
        if (num == 1) {
            System.out.printf("Первым ходит %s%n", playerOne.getName());
        } else {
            System.out.printf("Первым ходит %s%n", playerTwo.getName());
        }

        int count = num;
        for (int i = 0; i < 9; i++) {
            count = count + i;
            if (count % 2 != 0) {
                makingAMove = playerOne;
            } else {
                makingAMove = playerTwo;
            }
            System.out.printf("Игрок %s введите координаты поля, в которое хотите сделать ход:", makingAMove.getName());
            System.out.println();
            System.out.println("Введите координату Х игрового поля: ");
            int x = scanner.nextInt();
            System.out.println("Введите координату Y игрового поля: ");
            int y = scanner.nextInt();
            if (boards[x][y] == 'X' || boards[x][y] == '0') {
                do {
                    System.out.println("Это поле уже занято, выберите другое поле для хода.");
                    System.out.println("Введите координату Х игрового поля: ");
                    x = scanner.nextInt();
                    System.out.println("Введите координату Y игрового поля: ");
                    y = scanner.nextInt();
                }
                while (boards[x][y] != '*');
            }
            if (boards[x][y] == '*') {
                makingAMove.makeAMove(x, y, boards);
            }
            if ((boards[0][0] == 'X' && boards[0][1] == 'X' && boards[0][2] == 'X')
                    || (boards[1][0] == 'X' && boards[1][1] == 'X' && boards[1][2] == 'X')
                    || (boards[2][0] == 'X' && boards[2][1] == 'X' && boards[2][2] == 'X')

                    || (boards[0][0] == 'X' && boards[1][0] == 'X' && boards[2][0] == 'X')
                    || (boards[0][1] == 'X' && boards[1][1] == 'X' && boards[1][2] == 'X')
                    || (boards[0][2] == 'X' && boards[1][2] == 'X' && boards[2][2] == 'X')

                    || (boards[0][0] == 'X' && boards[1][1] == 'X' && boards[2][2] == 'X')
                    || (boards[2][0] == 'X' && boards[1][1] == 'X' && boards[0][2] == 'X')
            )
            {
                System.out.printf("%s выиграл", makingAMove.getName());
                break;
            }
            else if ((boards[0][0] == '0' && boards[0][1] == '0' && boards[0][2] == '0')
                    || (boards[1][0] == '0' && boards[1][1] == '0' && boards[1][2] == '0')
                    || (boards[2][0] == '0' && boards[2][1] == '0' && boards[2][2] == '0')

                    || (boards[0][0] == '0' && boards[1][0] == '0' && boards[2][0] == '0')
                    || (boards[0][1] == '0' && boards[1][1] == '0' && boards[1][2] == '0')
                    || (boards[0][2] == '0' && boards[1][2] == '0' && boards[2][2] == '0')

                    || (boards[0][0] == '0' && boards[1][1] == '0' && boards[2][2] == '0')
                    || (boards[2][0] == '0' && boards[1][1] == '0' && boards[0][2] == '0')) {
                System.out.printf("%s выиграл", makingAMove.getName());
                break;
            }
            else if(i == 9)
            {
                System.out.println("Победивших нет. Игра закончилась в ничью!");
            }
            count = num;
        }
    }
}
