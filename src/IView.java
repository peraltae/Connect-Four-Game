
/**
 * CS5004 HW 6: MVC Arch
 * Authors: Esteban Peralta, Pedram Shahroodi
 * July 2019
 */

import java.awt.*;

public interface IView {
    void update(Pieces player, int x, int y);
    void shareOutcome(Outcome outcome);

}
