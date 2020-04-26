
/**
 * CS5004 HW 6: MVC Arch
 * Authors: Esteban Peralta, Pedram Shahroodi
 * July 2019
 */


public class ConnectFour {

    public ConnectFour() {
    }


    public static void main(String [] args) {
        ConnectFourModel model = new ConnectFourModel();
        ConnectFourController controller = new ConnectFourController(model, Pieces.ORANGE);

    }

}