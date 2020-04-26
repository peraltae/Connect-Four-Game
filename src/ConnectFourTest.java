
import static org.junit.Assert.*;

public class ConnectFourTest {

    private ConnectFourModel model1;
    private ConnectFourModel model2;
    private ConnectFourModel model3;
    private ConnectFourModel model4;
    private ConnectFourModel model5;
    private ConnectFourModel model6;
    private ConnectFourModel model7;
    private ConnectFourModel model8;

    //test for controller
    private ConnectFourController controller1;
    private ConnectFourController controller2;
    private ConnectFourController controller3;
    private ConnectFourController controller4;
    private ConnectFourController controller5;
    private ConnectFourController controller6;
    private ConnectFourController controller7;




    



    @org.junit.Before
    public void setUp() throws Exception {
        model1 = new ConnectFourModel();
        model2 = new ConnectFourModel();
        model3 = new ConnectFourModel();
        model4 = new ConnectFourModel();
        model5 = new ConnectFourModel();
        model6 = new ConnectFourModel();
        model7 = new ConnectFourModel();
        model8 = new ConnectFourModel();


        //test for rotate player
        controller1 = new ConnectFourController(model2, Pieces.ORANGE);
        //test for invalid move and Orange wins
        controller2 = new ConnectFourController(model4, Pieces.ORANGE);
        //test for valid move
        controller3 = new ConnectFourController(model3, Pieces.ORANGE);
        //test for blue wins
        controller4 = new ConnectFourController(model5, Pieces.BLUE);
        //test for draw
        controller5 = new ConnectFourController(model6, Pieces.ORANGE);
        controller6 = new ConnectFourController(model7, Pieces.BLUE);
        //test for initial states in controller and view
        controller7 = new ConnectFourController(model8, Pieces.ORANGE);





        //check row winner
        model2.checkMove(5,1,Pieces.ORANGE);
        model2.checkMove(5,2,Pieces.ORANGE);
        model2.checkMove(5,3,Pieces.ORANGE);
        model2.checkMove(5,4,Pieces.ORANGE);
        //check column winner
        model2.checkMove(5,0,Pieces.ORANGE);
        model2.checkMove(4,0,Pieces.ORANGE);
        model2.checkMove(3,0,Pieces.ORANGE);
        model2.checkMove(2,0,Pieces.ORANGE);
        //fill pieces up
        model2.checkMove(4,2,Pieces.ORANGE);
        model2.checkMove(4,3,Pieces.ORANGE);
        model2.checkMove(3,3,Pieces.BLUE);
        model2.checkMove(4,4,Pieces.ORANGE);
        model2.checkMove(3,4,Pieces.ORANGE);
        model2.checkMove(2,4,Pieces.ORANGE);

        //check diagonal up winner
        model2.checkMove(4,1,Pieces.BLUE);
        model2.checkMove(3,2,Pieces.BLUE);
        model2.checkMove(2,3,Pieces.BLUE);
        model2.checkMove(1,4,Pieces.BLUE);

        //no column winner
        model3.checkMove(5,4,Pieces.ORANGE);
        model3.checkMove(4,4,Pieces.ORANGE);
        model3.checkMove(3,4,Pieces.ORANGE);
        model3.checkMove(2,4,Pieces.BLUE);
        model3.checkMove(1,4,Pieces.ORANGE);

        //no row winner
        model3.checkMove(5,1,Pieces.BLUE);
        model3.checkMove(5,2,Pieces.BLUE);
        model3.checkMove(5,3,Pieces.BLUE);
        model3.checkMove(5,5,Pieces.BLUE);

        //fill up pieces
        model4.checkMove(5,0, Pieces.BLUE);
        model4.checkMove(4,0,Pieces.ORANGE);
        model4.checkMove(3,0, Pieces.BLUE);
        model4.checkMove(2,0,Pieces.ORANGE);
        model4.checkMove(5,1, Pieces.BLUE);
        model4.checkMove(4,1,Pieces.ORANGE);
        model4.checkMove(3,1, Pieces.BLUE);
        model4.checkMove(5,2, Pieces.ORANGE);
        model4.checkMove(4,2,Pieces.BLUE);
        model4.checkMove(5,3,Pieces.ORANGE);


        //check diagonal down winner
        model4.checkMove(1,0,Pieces.ORANGE);
        model4.checkMove(2,1,Pieces.ORANGE);
        model4.checkMove(3,2, Pieces.ORANGE);
        model4.checkMove(4,3, Pieces.ORANGE);
        model4.checkMove(5,4, Pieces.ORANGE);

        //row blue winner (test for controller)
        model5.checkMove(5,0, Pieces.BLUE);
        model5.checkMove(5,1, Pieces.BLUE);
        model5.checkMove(5,2, Pieces.BLUE);
        model5.checkMove(5,3, Pieces.BLUE);

        //fill up pieces for draw
        controller5.takeTurn(5,0);
        controller5.takeTurn(4,0);
        controller5.takeTurn(3,0);
        controller5.takeTurn(2,0);
        controller5.takeTurn(1,0);
        controller5.takeTurn(0,0);

        controller5.takeTurn(5,1);
        controller5.takeTurn(4,1);
        controller5.takeTurn(3,1);
        controller5.takeTurn(2,1);
        controller5.takeTurn(1,1);
        controller5.takeTurn(0,1);

        controller5.takeTurn(5,3);
        controller5.takeTurn(5,2);
        controller5.takeTurn(4,2);
        controller5.takeTurn(4,3);
        controller5.takeTurn(5,4);
        controller5.takeTurn(3,2);
        controller5.takeTurn(4,4);
        controller5.takeTurn(3,3);
        controller5.takeTurn(3,4);
        controller5.takeTurn(2,3);
        controller5.takeTurn(2,2);
        controller5.takeTurn(1,2);
        controller5.takeTurn(1,3);
        controller5.takeTurn(0,3);
        controller5.takeTurn(0,2);
        controller5.takeTurn(2,4);
        controller5.takeTurn(1,4);
        controller5.takeTurn(0,4);
        controller5.takeTurn(5,5);
        controller5.takeTurn(5,6);
        controller5.takeTurn(4,5);
        controller5.takeTurn(4,6);
        controller5.takeTurn(3,6);
        controller5.takeTurn(3,5);
        controller5.takeTurn(2,5);
        controller5.takeTurn(2,6);
        controller5.takeTurn(1,6);
        controller5.takeTurn(1,5);
        controller5.takeTurn(0,6);
        controller5.takeTurn(0,5);



    }
    @org.junit.Test
    public void getNumOfRows(){
        assertEquals(model2.getNumOfRows(), 6);
    }

    @org.junit.Test
    public void getNumOfColumns(){
        assertEquals(model2.getNumOfColumns(), 7);
    }

    @org.junit.Test
    public void getGrid(){
        //views and models grid are the same size
        assertEquals(model1.getGrid().length * model1.getGrid()[0].length, 42);
        assertEquals(controller7.getView().getGrid().length * controller7.getView().getGrid()[0].length, 42);
    }


    @org.junit.Test
    public void buildGrid() {
        for(int y = 0; y < model1.getNumOfRows(); ++y) {
            for (int x = 0; x < model1.getNumOfColumns(); ++x) {
                assertEquals(model1.getGrid()[y][x], Pieces.EMPTY);
            }
        }
    }
    @org.junit.Test
    public void checkMove() {
        assertEquals(model1.checkMove(5, 3, Pieces.ORANGE), true);
        assertEquals(model1.checkMove(3,0, Pieces.ORANGE), false);
        //cannot place a piece ontop of a piece that exists already
        assertEquals(model2.checkMove(3,2, Pieces.BLUE), false);
    }


    @org.junit.Test
    public void checkRow() {
        assertEquals(model2.checkRow(Pieces.ORANGE), true);
        //model4 only has a diagonal down winner
        assertEquals(model4.checkRow(Pieces.ORANGE), false);
        assertEquals(model4.checkRow(Pieces.BLUE), false);
        assertEquals(model3.checkRow(Pieces.BLUE),false);
    }

    @org.junit.Test
    public void checkColumn() {
        assertEquals(model2.checkColumn(Pieces.ORANGE), true);
        assertEquals(model3.checkColumn(Pieces.ORANGE),false);
        //model4 only has a diagonal down winner
        assertEquals(model4.checkColumn(Pieces.ORANGE), false);
        assertEquals(model4.checkColumn(Pieces.BLUE), false);


    }

    @org.junit.Test
    public void checkUpDiagonal() {
        assertEquals(model2.checkUpDiagonal(Pieces.BLUE), true);
        //model2 only has blue as up diagonal winner
        assertEquals(model2.checkUpDiagonal(Pieces.ORANGE), false);
        //model4 only has down diagonal winner
        assertEquals(model4.checkUpDiagonal(Pieces.ORANGE), false);
    }

    @org.junit.Test
    public void checkDownDiagonal() {
        assertEquals(model4.checkDownDiagonal(Pieces.ORANGE), true);
        //model2 only has up diagonal winner
        assertEquals(model2.checkDownDiagonal(Pieces.ORANGE), false);
        assertEquals(model2.checkDownDiagonal(Pieces.BLUE), false);
    }

    @org.junit.Test
    public void isWinner() {
        assertEquals(model2.isWinner(Pieces.ORANGE), true);
        assertEquals(model2.isWinner(Pieces.BLUE), true);
        assertEquals(model4.isWinner(Pieces.ORANGE), true);
        assertEquals(model4.isWinner(Pieces.BLUE), false);
        assertEquals(model3.isWinner(Pieces.ORANGE), false);
        assertEquals(model3.isWinner(Pieces.BLUE), false);
    }

    //Testing Controller
    @org.junit.Test
    public void getPlayer(){
        assertEquals(controller1.getPlayer(), Pieces.ORANGE);
    }
    @org.junit.Test
    public void getTestFlag(){
        assertEquals(controller1.getTestFlag(), "");
    }

    @org.junit.Test
    public void rotatePlayer(){
        controller1.rotatePlayer();
        assertEquals(controller1.getPlayer(), Pieces.BLUE);
        controller1.rotatePlayer();
        assertEquals(controller1.getPlayer(), Pieces.ORANGE);
    }
    @org.junit.Test
    public void checkWinner(){
        assertEquals(controller2.checkWinner(Pieces.ORANGE), true);
        assertEquals(controller2.checkWinner(Pieces.BLUE), false);
    }
    @org.junit.Test
    public void takeTurn(){
        controller2.takeTurn(5,1);
        assertEquals(controller2.getTestFlag(), "invalidMove");
        controller3.takeTurn(4,3);
        assertEquals(controller3.getTestFlag(), "validMove");
        controller2.takeTurn(5,5);
        assertEquals(controller2.getTestFlag(), "Orange wins");
        controller4.takeTurn(4,0);
        assertEquals(controller4.getTestFlag(), "Blue wins");
        assertEquals(controller5.getTestFlag(), "Draw");
    }
    //Testing view
    @org.junit.Test
    public void getOutcome(){
        assertEquals(controller7.getView().getOutcome(), Outcome.PENDING);
    }
    @org.junit.Test
    public void isGameOver(){
        assertEquals(controller7.getView().isGameOver(), false);
    }


    @org.junit.Test
    public void update() {
        controller6.takeTurn(5, 2);
        assertEquals(controller6.getView().getGrid()[5][2], Pieces.BLUE);
        controller6.takeTurn(4, 2);
        assertEquals(controller6.getView().getGrid()[4][2], Pieces.ORANGE);
    }

    @org.junit.Test
    public void shareOutcome(){
        controller6.takeTurn(5, 2);
        controller6.takeTurn(4, 2);
        controller6.takeTurn(5,1);
        controller6.takeTurn(4,1);
        controller6.takeTurn(5,0);
        controller6.takeTurn(4,0);
        //last piece before blue wins
        controller6.takeTurn(5,3);
        assertEquals(controller6.getView().getOutcome(), Outcome.BLUE_WIN);
        assertEquals(controller6.getView().isGameOver(),true);
        assertEquals(controller5.getView().getOutcome(),Outcome.DRAW);

    }
    @org.junit.Test
    public void maxNumOfMoves(){
        assertEquals(controller6.getView().maxNumOfMoves(), 42);
    }


}