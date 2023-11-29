package service;

import players.Player;
import players.PlayerOne;
import players.PlayerTwo;
import players.PlayingField;

import java.util.Random;
import java.util.Scanner;

public class Game {
    boolean isDraw = true;
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

    public void gameRun(PlayerOne playerOne, PlayerTwo playerTwo, char[][] boards) throws ArrayIndexOutOfBoundsException {
        /*
        Кидаем жребий, кто будет ходить первым.
         */
        int num = GetDraw(playerOne, playerTwo);
        /*
        Печатаем стартовое игровое поле.
         */
        PrintGameField(boards);
        /*
        Запускаем игру.
         */
        Run(playerOne, playerTwo, boards, num);
    }


    /*
       Метод отвечающий за ходы игроков. Игроки делают свои ходы по очереди. Игровое поле перерисовывается с учетом
       сделанного хода. После перерисовки поле проверяется на случай - не выявлен ли победитель?
       Если победитель обнаружен - выводится результат игры.
       Если победителя так и не нашлось, а все возможные ходы уже исчерпаны - объявляется "Ничья".
    */
    private void Run(PlayerOne playerOne, PlayerTwo playerTwo, char[][] boards, int num) throws ArrayIndexOutOfBoundsException {
        int count = num;
        for (int i = 0; i < 9; i++) {
            count = count + i;
            if (count % 2 != 0) {
                makingAMove = playerOne;
            } else {
                makingAMove = playerTwo;
            }
            System.out.printf("Игрок %s введите координаты  поля, в которое хотите сделать ход:", makingAMove.getName());
            System.out.println();
            System.out.println("Введите координату Х игрового поля (в интервале от 1 до 3): ");
            int x = scanner.nextInt() - 1;
            System.out.println("Введите координату Y игрового поля (в интервале от 1 до 3): ");
            int y = scanner.nextInt() - 1;
            try {
                if (boards[x][y] == 'X' || boards[x][y] == '0') {
                    do {
                        System.out.println("Это поле уже занято, выберите другое поле для хода.");
                        System.out.println("Введите координату Х игрового поля (в интервале от 1 до 3): ");
                        x = scanner.nextInt() - 1;
                        System.out.println("Введите координату Y игрового поля (в интервале от 1 до 3): ");
                        y = scanner.nextInt() - 1;
                    }
                    while (boards[x][y] != '*');
                }

                if (boards[x][y] == '*') {
                    makingAMove.makeAMove(x, y, boards);
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Вы ошиблись с вводом координаты поля.");
                System.out.println("Координаты поля могут быть только в интервале от 1 до 3.");
                i -= 1;
            }

            if (String.valueOf(boards[0][0]).equals(String.valueOf(boards[0][1]))
                    && String.valueOf(boards[0][1]).equals(String.valueOf(boards[0][2]))
                    && (!String.valueOf(boards[0][2]).equals(String.valueOf('*')))

                    || String.valueOf(boards[1][0]).equals(String.valueOf(boards[1][1]))
                    && String.valueOf(boards[1][1]).equals(String.valueOf(boards[1][2]))
                    && (!String.valueOf(boards[1][2]).equals(String.valueOf('*')))

                    || String.valueOf(boards[2][0]).equals(String.valueOf(boards[2][1]))
                    && String.valueOf(boards[2][1]).equals(String.valueOf(boards[2][2]))
                    && (!String.valueOf(boards[2][2]).equals(String.valueOf('*')))

                    || String.valueOf(boards[0][0]).equals(String.valueOf(boards[1][0]))
                    && String.valueOf(boards[1][0]).equals(String.valueOf(boards[2][0]))
                    && (!String.valueOf(boards[2][0]).equals(String.valueOf('*')))

                    || String.valueOf(boards[0][1]).equals(String.valueOf(boards[1][1]))
                    && String.valueOf(boards[1][1]).equals(String.valueOf(boards[2][1]))
                    && (!String.valueOf(boards[2][1]).equals(String.valueOf('*')))

                    || String.valueOf(boards[0][2]).equals(String.valueOf(boards[1][2]))
                    && String.valueOf(boards[1][2]).equals(String.valueOf(boards[2][2]))
                    && (!String.valueOf(boards[2][2]).equals(String.valueOf('*')))

                    || String.valueOf(boards[0][0]).equals(String.valueOf(boards[1][1]))
                    && String.valueOf(boards[1][1]).equals(String.valueOf(boards[2][2]))
                    && (!String.valueOf(boards[2][2]).equals(String.valueOf('*')))

                    || String.valueOf(boards[2][0]).equals(String.valueOf(boards[1][1]))
                    && String.valueOf(boards[1][1]).equals(String.valueOf(boards[0][2]))
                    && (!String.valueOf(boards[0][2]).equals(String.valueOf('*')))) {
                System.out.printf("%s выиграл", makingAMove.getName());
                isDraw = false;
                break;
            }
            count = num;
        }
        if (isDraw) {
            System.out.println("Победивших нет. Игра закончилась в ничью!");
        }
    }


    /*
       Определяется какой игрок будет начинать игру.
    */
    private int GetDraw(PlayerOne playerOne, PlayerTwo playerTwo) {
        System.out.println("Кидаем жребий, кто будет ходить первым.");
        int num = random.nextInt(1, 3);
        System.out.println("Выпало: " + num);
        if (num == 1) {
            System.out.printf("Первым ходит %s%n", playerOne.getName());
        } else {
            System.out.printf("Первым ходит %s%n", playerTwo.getName());
        }
        return num;
    }

    /*
       Метод отвечающий за печать стартового игрового поля.
    */
    private static void PrintGameField(char[][] boards) {
        System.out.println("Печатаем начальное игровое поле");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(boards[i][j] + " ");
            }
            System.out.println();
        }
    }
}
