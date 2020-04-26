
/**
 * CS5004 HW 6: MVC Arch
 * Authors: Esteban Peralta, Pedram Shahroodi
 * July 2019
 */

public class ConnectFourController {
    private ConnectFourModel model;
    private ConnectFourView view;
    public int numOfTurns = 0;
    private Pieces player;
    //for testing controller functions
    private String testFlag;



    public ConnectFourController(ConnectFourModel model, Pieces player){
        this.model = model;
        this.view = new ConnectFourView(this);
        this.player = player;
        this.testFlag = "";


    }

    /**
     * @return player color
     */
    public Pieces getPlayer(){
        return this.player;
    }

    /**
     * @return what is being tested
     */
    public String getTestFlag(){
        return this.testFlag;
    }

    /**
     * @return the view of connect4 game
     */
    public ConnectFourView getView(){
        return this.view;
    }

    public void rotatePlayer(){
        switch (this.player){
            case ORANGE:
                this.player = Pieces.BLUE;
                break;


            case BLUE:
                this.player = Pieces.ORANGE;
                break;

            default:


        }
    }

    public boolean checkWinner(Pieces player) {return this.model.isWinner(player);}


    public void takeTurn(int row, int col) throws IllegalStateException {

        boolean validMove = this.model.checkMove(row, col, this.player);
        if (!validMove) {
            this.testFlag = "invalidMove";
            return;
        }
        this.testFlag = "validMove";

        this.view.update(this.player, row, col);

        this.model.printPosition(row,col);

        this.numOfTurns++;

        if (this.checkWinner(this.player)){
            switch (this.player) {
                case ORANGE:
                    this.testFlag = "Orange wins";
                    System.out.println("Winner: Orange!");
                    this.view.shareOutcome(Outcome.ORANGE_WIN);
                    break;

                case BLUE:
                    this.testFlag = "Blue wins";
                    System.out.println("Winner: Blue!");
                    this.view.shareOutcome(Outcome.BLUE_WIN);
                    break;

                case INVALID:
                    throw new IllegalStateException("Error in model");

                default:

            }

        }

        if(this.numOfTurns >= view.maxNumOfMoves()){
            this.testFlag = "Draw";
            this.view.shareOutcome(Outcome.DRAW);
            return;
        }

        rotatePlayer();


    }

    public static void main(String[] args) {
        ConnectFourModel model = new ConnectFourModel();
        ConnectFourController controller = new ConnectFourController(model,Pieces.ORANGE);
    }

}
