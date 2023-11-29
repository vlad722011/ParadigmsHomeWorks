package players;

public class PlayerTwo extends Player implements IPlayable{
    @Override
    public char[][] makeAMove(int x, int y, char [][] playDesk) {
        playDesk[x][y] = '0';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(playDesk[i][j] + " ");
            }
            System.out.println();
        }
        return playDesk;
    }

}
