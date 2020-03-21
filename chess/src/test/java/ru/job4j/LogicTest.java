package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void moveSuccess () {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void moveFail() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.B6);
        assertThat(rsl, is(false));
    }

    @Test
    public void moveOccupied () {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(false));
    }

    @Test
    public void moveEmpty () {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C2, Cell.H6);
        assertThat(rsl, is(false));
    }

}
