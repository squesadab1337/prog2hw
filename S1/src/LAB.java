package src;

public class LAB extends Thread {

    int[] playerCoords = {0, 0};
    char player = '✈';

    char[][] laberinto = {
        {'□','#','#','#','#','#'}, 
        {'□','□','□','#','#','#'},
        {'#','#','□','#','#','#'},
        {'#','#','□','□','#','#'},
        {'#','#','#','□','#','#'},
        {'#','#','#','□','#','#'},
        {'#','#','#','□','#','#'}, 
    };

    private boolean resolver(int x, int y) {

        if (x < 0 || y < 0 || x >= laberinto.length || y >= laberinto[0].length) {
            return false;
        }

        if (laberinto[x][y] == '#' || laberinto[x][y] == 'x') {
            return false;
        }

        if (x == laberinto.length - 1) {
            laberinto[x][y] = player;
            frame();
            return true;
        }

        laberinto[x][y] = 'x';

        playerCoords[0] = x;
        playerCoords[1] = y;

        frame();

        try { Thread.sleep(200); } catch (Exception e) {}

        if (resolver(x + 1, y)) return true;
        if (resolver(x - 1, y)) return true;
        if (resolver(x, y + 1)) return true;
        if (resolver(x, y - 1)) return true;

        return false;
    }

    private void frame() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {

                if (i == playerCoords[0] && j == playerCoords[1]) {
                    System.out.print(player + " ");
                } else {
                    System.out.print(laberinto[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LAB lab = new LAB();

        boolean path = lab.resolver(0, 0);
    }
}
