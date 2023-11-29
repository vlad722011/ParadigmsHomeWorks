import players.PlayerOne;
import players.PlayerTwo;
import players.PlayingField;
import service.Game;

public class Main {
    public static void main(String[] args) {

        /*
         * Создаем двух игроков.
         */

        PlayerOne one = new PlayerOne();
        one.setName();
        PlayerTwo two = new PlayerTwo();
        two.setName();


        /*
         * Создаем игровое поле.
         */

        PlayingField playingField = new PlayingField();
        char [][] boards = playingField.getPlayDesk();

        /*
         * Запускаем игру.
         */

        Game game = new Game(one, two);
        game.gameRun(one, two, boards );

    }
}
