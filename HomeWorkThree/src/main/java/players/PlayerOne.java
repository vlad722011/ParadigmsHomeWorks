package players;
public class PlayerOne extends Player implements IPlayable{

    @Override
    public char[][] makeAMove(int x, int y, char[][]playDesk) {
        playDesk[x][y] = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(playDesk[i][j] + " ");
            }
            System.out.println();
        }
        return playDesk;
    }

}

