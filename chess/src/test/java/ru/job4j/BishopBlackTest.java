package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void wayC1G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.C1,Cell.G5);
        Cell[] steps = {Cell.D2,Cell.E3,Cell.F4,Cell.G5};
        assertThat(cells, is(steps));
    }

    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopcopy = bishopBlack.copy(Cell.B1);
        assertThat(bishopcopy.position(), is(Cell.B1));
    }

    @Test(expected = IllegalStateException.class)
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.C1,Cell.C2);
    }

}
