
/**
 * CS5004 HW 6: MVC Arch
 * Authors: Esteban Peralta, Pedram Shahroodi
 * July 2019
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConnectFourView extends JPanel implements IView, KeyListener {
    private Pieces [][] grid;
    //private Outcome outcome;
    private ConnectFourController controller;
    private JFrame window;
    private int cursorRow = 0;
    private int cursorCol = 0;
    private int paintRow;
    private int paintCol;
    private int numOfRows = 6;
    private int numOfColumns = 7;
    private Outcome outcome;
    private boolean gameOver = false;


    private static final int TITLE_BAR = 23;
    private static final int CELL_SIZE = 100;


    /** Constructor initializes the grid, window, passes in the controller,
     * and enables movement of keys.
     * @param controller is passed in from the connect4 game
     */
    public ConnectFourView(ConnectFourController controller){
        initializeGrid();
        makeWindow();
        this.controller = controller;
        window.addKeyListener(this);
    }


    /**
     * @return the grid for the view of connect4 game
     */
    public Pieces[][] getGrid(){
        return this.grid;
    }

    /**
     * @return the outcome in the connect4 game
     */
    public Outcome getOutcome(){
        return this.outcome;
    }

    /**
     * @return true if game is over, else false
     */
    public boolean isGameOver(){
        return this.gameOver;
    }

    /**
     * Make a JFrame window
     */
    private void makeWindow(){
        window = new JFrame("Connect Four");
        window.setContentPane(this);

        //Window size will be a function of the number of rows and columns. This allows us to set the number of
        //rows and columns however we see fit
        window.setSize(numOfColumns * 100,TITLE_BAR + (numOfRows * 100));
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public void update(Pieces player, int row, int col){

        this.grid[row][col] = player;
        this.repaint();


        //DEBUGGING: Following print statements show which Piece is being stored in the view's this.gird
        // as each user takes a turn
        System.out.println("Current move: " + controller.numOfTurns);
        System.out.println("At: " + paintRow + " & " + paintCol + " Piece: " + this.grid[row][col]);


    }

    public void shareOutcome(Outcome outcome){
        this.outcome = outcome;
        this.gameOver = true;


    }

    public int maxNumOfMoves(){ return numOfRows * numOfColumns;}


    private void initializeGrid(){
        this.grid = new Pieces[numOfRows][numOfColumns];

        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfColumns; j++){
                this.grid [i][j] = Pieces.EMPTY;
            }
        }

        this.outcome = Outcome.PENDING;
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.paintCursor(g);
        this.paintLattice(g);
        this.paintGrid(g);
        this.paintOutcome(g);
    }

    private void paintCursor(Graphics g){
        int x = cursorCol * CELL_SIZE;
        int y = cursorRow * CELL_SIZE;
        Color currentColor = g.getColor();
        g.setColor(Color.PINK);
        g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        g.setColor(currentColor);


    }

    private void paintLattice(Graphics g) {

        int yTop = 0;
        int yBottom = numOfRows * 100;
        int xLeft = 0;
        int xRight = numOfColumns * 100;

        //Make rows
        for (int i = 0; i < this.numOfRows; i++){
            g.drawLine(xLeft, yTop+CELL_SIZE, xRight, yTop+CELL_SIZE);
            g.drawLine(xLeft, yTop+i*CELL_SIZE, xRight, yTop+i*CELL_SIZE);

        }

        //Make columns
        for (int j = 0; j < this.numOfColumns; j++){
            g.drawLine(xLeft+CELL_SIZE, yTop, xLeft+CELL_SIZE, yBottom);
            g.drawLine(xLeft+j*CELL_SIZE, yTop, xLeft+j*CELL_SIZE, yBottom);

        }


        drawHoles(g);

    }


    private void drawHoles(Graphics g){
        for(int i = 0; i < numOfColumns; i++){
            for(int j = 0; j < numOfRows; j++){
                g.drawOval(i * 100,j *100,(int)(CELL_SIZE * 0.95),(int)(CELL_SIZE * 0.95));


            }
        }

    }

    private void paintGrid(Graphics g) {


        for (int row=0; row< numOfRows; row++) {
            for (int col=0; col< numOfColumns; col++) {

                switch (grid[row][col]) {
                    case ORANGE:
                        this.paintOrange(g, col, row);
                        break;

                    case BLUE:
                        this.paintBlue(g, col, row);
                        break;

                    default:
                }
            }
        }
    }

    private void paintOrange(Graphics g, int x, int y){

        g.drawOval(x * 100,y *100,(int)(CELL_SIZE * 0.95),(int)(CELL_SIZE * 0.95));
        Color currentColor = g.getColor();
        g.setColor(Color.ORANGE);
        g.fillOval(x * 100,y * 100,(int)(CELL_SIZE * 0.95),(int)(CELL_SIZE * 0.95));
        g.setColor(currentColor);


    }

    private void paintBlue(Graphics g, int x, int y){

        Color currentColor = g.getColor();
        g.setColor(Color.BLUE);
        g.fillOval(x*100,y*100,(int)(CELL_SIZE * 0.95),(int)(CELL_SIZE * 0.95));
        g.setColor(currentColor);
    }




    private void paintOutcome(Graphics g) {



        switch (this.outcome){

            case ORANGE_WIN:
                g.drawString("Orange wins!!!", (paintCol * 100) + (CELL_SIZE/2),
                        (paintRow * 100) + (CELL_SIZE/2));
                break;

            case BLUE_WIN:
                g.drawString("Blue WINS!!!", (paintCol * 100) + (CELL_SIZE/2),
                        (paintRow * 100) + (CELL_SIZE/2));
                break;

            case DRAW:
                g.drawString("Draw! No winner!", (paintCol * 100) + (CELL_SIZE/2),
                        (paintRow * 100) + (CELL_SIZE/2));
                break;

            default:

                //Dont put code here because this is what is initially displayed

        }
    }




    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) {
        if(this.gameOver) return;

        switch(e.getKeyCode()) {


            case KeyEvent.VK_LEFT:
                if(this.cursorCol > 0){
                    this.cursorCol--;
                    break;
                }

                else {break;}

            case KeyEvent.VK_RIGHT:
                if(this.cursorCol< this.numOfColumns -1){
                    this.cursorCol++;
                    break;

                }

                else{break;}



            case KeyEvent.VK_ENTER:


                for(int i = numOfRows - 1; i >= 0; i--){
                    if (grid[cursorRow + i][cursorCol] == Pieces.EMPTY){
                        paintRow = cursorRow + i;
                        paintCol = cursorCol;

                        this.controller.takeTurn(paintRow,paintCol);
                        return;

                    }
                }



                break;

            default:
        }



        repaint();


    }



}