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
        test.addNode(1, 1);
        test.addNode(2, 2);
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
        test.addNode(2.0, 1);
        test.addNode(1.0,1);
        assertEquals(3.0, test.getHead().getCoefficient());
    }
    @Test
    public void addNode_addsCoefficients_givenTheSecondNodeHasTheSameDegree() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 5);
        test.addNode(1, 1);
        test.addNode(1, 1);
        assertEquals(2.0, test.getHead().getLink().getCoefficient());
    }
    @Test
    public void addNode_usesCurrentCursorPositionToFindNodeHome_givenCursorIsAtStartPosition() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 1);
        test.addNode(3, 3);
        test.addNode(4, 4);
        test.resetCursor();
        test.addNode(2, 2);
        assertEquals(2, test.getHead().getLink().getLink().getDegree());
    }
    @Test
    public void addNode_resetsCursorAndFindsCorrectPosition_givenCursorIsNull() {
        PolynomialList test = new PolynomialList();
        test.addNode(1,1);
        test.addNode(1, 5);
        test.addNode(1, 6);
        test.advanceCursor();
        test.advanceCursor();
        test.addNode(1, 2);
        assertEquals(2, test.getHead().getLink().getLink().getDegree());
    }
    @Test
    public void addNode_addsToCorrectCoefficient_givenInputDegreeIsEqualToTheSecondNode() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 5);
        test.addNode(1, 1);
        test.resetCursor();
        test.addNode(1, 1);
        assertEquals(2, test.getHead().getLink().getCoefficient());
    }
    @Test
    public void addNode_addsToCorrectCoefficient_givenInputDegreeIsEqualToExistingNodeAndCursorIsPastHome() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 5);
        test.addNode(1, 4);
        test.addNode(1, 3);
        test.addNode(1, 2);
        test.addNode(1, 1);
        test.addNode(1, 3);
        assertEquals(2, test.getHead().getLink().getLink().getCoefficient());
    }
    @Test
    public void addNode_addsToCorrectCoefficient_givenInputDegreeIsEqualToExistingNodeAndCursorIsBeforeHome() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 5);
        test.addNode(1, 4);
        test.addNode(1, 3);
        test.addNode(1, 2);
        test.addNode(1, 1);
        test.resetCursor();
        test.addNode(1, 3);
        assertEquals(2, test.getHead().getLink().getLink().getCoefficient());
    }

    @Test
    public void removeNode_removesCorrectNode_givenNodeExists() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 1);
        test.addNode(2, 2);
        test.addNode(3, 3);
        test.addNode(4, 4);
        test.removeNode(2);
        assertEquals (1, test.getHead().getLink().getLink().getDegree());
    }
    @Test
    public void removeNode_throwsException_givenNodeDoesNotExist() {
        PolynomialList test = new PolynomialList();
        try {
            test.removeNode(2);
            fail("Did not throw exception.");
        } catch (IllegalArgumentException e) {

        }
    }
    @Test
    public void removeNode_removesCorrectNode_givenCursorAtStart() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 1);
        test.addNode(2, 2);
        test.addNode(3, 3);
        test.addNode(4, 4);
        test.resetCursor();
        test.removeNode(2);
        assertEquals(1, test.getHead().getLink().getLink().getDegree());
    }

    @Test
    public void evaluate_returnsCorrectAnswer_givenExistingPolynomialList() {
        PolynomialList test = new PolynomialList();
        test.addNode(1, 1);
        test.addNode(2, 2);
        test.addNode(3, 3);
        assertEquals(102, test.evaluate(3));
    }
}


