import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class DataModel extends Observable {
    private Integer[][] data; // 0 is X,1 is O
    private boolean win;
    private int pre_player;

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public DataModel() {

        data = new Integer[3][3];
        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = rand.nextInt((10000 - 2) + 1) + 2;
            }
        }
    }

    public void set_model(int index, int player) {
        if (index == 0)
            data[0][0] = player;
        else {
            int row = index / 3;
            int col = index % 3;
            data[row][col] = player;
        }
        pre_player = index;

        if (check_win()) {
            // notice jframe to pop out window.
            // reset
            System.out.println("notify");
            win = true;
            setChanged();
            notifyObservers();// notify all observer when changed;
            reset();
        } else if (check_draw()) {
            win = false;
            setChanged();
            notifyObservers();
            reset();
        }

    }

    @Override
    public synchronized void addObserver(Observer o) {

        super.addObserver(o);
    }

    public void reset() {

        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = rand.nextInt((10000 - 2) + 1) + 2;
            }
        }
    }

    public boolean check_win() {
        for (int i = 0; i < data.length; i++) {

            if (data[0][i] == data[1][i] && data[1][i] == data[2][i])
                return true;
            if (data[i][0] == data[i][1] && data[i][1] == data[i][2])
                return true;
        }
        if (data[0][0] == data[1][1] && data[0][0] == data[2][2])
            return true;
        if (data[0][2] == data[1][1] && data[2][0] == data[1][1])
            return true;
        return false;
    }

    public boolean check_draw() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] != 0 && data[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    public void undo() {
        Random rand = new Random();
        if (pre_player == 0)
            data[0][0] = rand.nextInt((10000 - 2) + 1) + 2;
        else {
            int row = pre_player / 3;
            int col = pre_player % 3;
            data[row][col] = rand.nextInt((10000 - 2) + 1) + 2;
        }

    }

}
