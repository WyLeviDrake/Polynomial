import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PolynomialListTest {

    @Test
    public void constructorPolynomialList_constructsHeadNodeAsNull_givenNoInputs() {
        PolynomialList test = new PolynomialList();
        assertNull(test.getHead());
    }
    @Test
    public void addNode_addsANodeToTheHeadReference_givenAnEmptyLinkedList() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 1);
        assertAll(
                () -> assertEquals(1, test.getHead().getLink())

        );
    }

}
