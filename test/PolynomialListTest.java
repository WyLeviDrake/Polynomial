import org.junit.jupiter.api.BeforeEach;
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
        try {
            test.addNode(1, 1);
            assertEquals(1, test.getHead().getCoefficient());
        } catch (Exception e) {
            fail("Method should account for head being set to null.");
        }
    }
    @Test
    public void addNode_addsANodeAtHeadReference_givenNextNodeHasALowerDegree() {
        PolynomialList test = new PolynomialList();
        test.addNode(1,1);
        test.addNode(1,2);
        assertEquals(2, test.getHead().getDegree());
    }
    @Test
    public void addNode_addsANodeInTheOrderItBelongs_givenAnExistingPolynomialList() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 1);
        test.addNode(1,5);
        test.addNode(1,2);
        assertEquals(2, test.getHead().getLink().getDegree());
    }
    @Test
    public void addNode_addsCoefficients_givenTheInputDegreeAlreadyExists() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 1);
        test.addNode(1,1);
        assertEquals(2, test.getHead().getCoefficient());
    }

    @Test
    public void removeNode_removes

}
