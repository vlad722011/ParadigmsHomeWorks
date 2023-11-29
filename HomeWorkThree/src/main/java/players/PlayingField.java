package players;
public class PlayingField {

    public PlayingField() {
    }

    public char[][] getPlayDesk() {
        char[][] playDesk = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                playDesk[i][j] = '*';
            }
        }
        return playDesk;
    }

}