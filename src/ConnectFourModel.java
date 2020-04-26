
/**
 * CS5004 HW 6: MVC Arch
 * Authors: Esteban Peralta, Pedram Shahroodi
 * July 2019
 */

public class ConnectFourModel{

    private int numOfRows = 6;
    private int numOfColumns = 7;
    private Pieces[][] grid = new Pieces[6][7];

    /**
     * constructor for model, initiate the grid
     */
    public ConnectFourModel() {
        this.buildGrid();
    }

    /**
     * @return number of rows for connect4 game
     */
    public int getNumOfRows() {
        return this.numOfRows;
    }

    /**
     * @return number of columns for connect4 game
     */
    public int getNumOfColumns() {
        return this.numOfColumns;
    }

    /**
     * @return the grid of connect4 game
     */
    public Pieces[][] getGrid() {
        return this.grid;
    }

    /**
     * initiate grid with empty cells
     */
    //note 0th row is BOTTOM row and 5th row is TOP row
    public void buildGrid() {
        //initiate grid with EMPTY slots
        for(int y = 0; y < this.numOfRows; ++y) {
            for(int x = 0; x < this.numOfColumns; ++x) {
                this.grid[y][x] = Pieces.EMPTY;
            }
        }

    }


    /**
     * Method validates the legality of a player's move
     * @param row chosen in Connect4 game
     * @param col chosen in Connect4 game
     * @param piece color chosen in Connect4 game
     * @return True if valid move and set piece color on grid. If invalid move, return false.
     */
    public boolean checkMove(int row, int col, Pieces piece){

        //As in real Connect-Four, pieces must be stacked on top of each other. Thus, a user cannot select
        //a tile where there is no piece in the row immediately beneath it.
        if (row < this.numOfRows -1 && this.grid[row + 1][col] == Pieces.EMPTY) {
            System.out.println("Invalid move: empty tile below selected square.");
            return false;
        }

        switch (this.grid[row][col]) {
            case EMPTY:
                this.grid[row][col] = piece;
                return true;
            default:
                return false;
        }
    }

    /**
     * method checks to see if there is a winner in any row
     * @param piece color in connect4 game
     * @return true if we have 4 in a row piece color.
     */

    public boolean checkRow(Pieces piece){

        for (int i = 0; i < this.numOfRows; i++){
            //this.numOfColumns - 4 represents the max limit to check column before out of grid boundary
            for (int j = 0; j <= this.numOfColumns - 4; j++){

                //check if 4 in a row piece
                if (this.grid[i][j] == piece && this.grid[i][j + 1] == piece && this.grid[i][j + 2] == piece &&
                        this.grid[i][j + 3] == piece){

                    return true;
                }
            }
        }

        return false;
    }

    /** method checks to see if there is a winner in any column
     * @param piece color in connect4 game
     * @return true, if there is 4 pieces of the same color side by side in a column
     */
    public boolean checkColumn(Pieces piece){
        for (int i = 0; i < this.numOfColumns; i++){
            for (int j = 0; j <= this.numOfRows - 4; j++){
                if (this.grid[j][i] == piece && this.grid[j + 1][i] == piece && this.grid[j + 2][i] == piece &&
                        this.grid[j + 3][i] == piece){

                    return true;
                }
            }
        }

        return false;
    }

    /** method checks to see if there is a winner in any downward diagonal
     * @param piece color in connect4 game
     * @return true if there is 4 pieces of the same color side by side in any downward diagonal
     */
    public boolean checkDownDiagonal(Pieces piece){
        for (int i = 0; i < this.numOfRows - 4; i++){
            for (int j = 0; j <= this.numOfColumns - 4; j++){
                if (this.grid[i][j] == piece && this.grid[i + 1][j + 1] == piece && this.grid[i + 2][j + 2] == piece &&
                        this.grid[i + 3][j + 3] == piece){
                    return true;
                }
            }
        }

        return false;
    }

    /** method checks to see if there is a winner in any upward diagonal
     * @param piece color in connect4 game
     * @return true if there is 4 pieces of the same color side by side in any upward diagonal.
     */
    public boolean checkUpDiagonal(Pieces piece){

        for (int i = this.numOfRows - 1; i >= 3; i--){
            for (int j = 0; j <= this.numOfColumns - 4; j++){
                if (this.grid[i][j] == piece && this.grid[i - 1][j + 1] == piece && this.grid[i - 2][j + 2] == piece &&
                        this.grid[i - 3][j + 3] == piece){
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Method checks to see if a winner exists in any possible direction
     * @param piece color in connect4 game
     * @return true if there is a winner that fits any one of the conditions of connect4.
     */
    public boolean isWinner(Pieces piece){

        return (checkRow(piece) || checkColumn(piece) || checkUpDiagonal(piece) || checkDownDiagonal(piece));
    }


    /**
     * Method is for debugging purposes. will print out the coordinates and piece stored at row & col in the
     * model's this.grid
     *
     * this method along with similar print statements in other classes in this MVC package are meant to ensure
     * congruency among the classes
     * @param row chosen in connect4 game
     * @param col chosen in connect4 game
     */
    public void printPosition(int row, int col){
        System.out.println("On model grid at " + row + " & " + col + ": " + this.grid[row][col] + "\n");
    }
}