public class PolynomialList {

    private Node head;
    private Node cursor;

    class Node implements Cloneable {

        private double coefficient;
        private int degree;
        private Node link;

        public Node(double inputCoefficient, int inputDegree, Node inputLink) {
            coefficient = inputCoefficient;
            degree = inputDegree;
            link = inputLink;
        }
        // Constructor to more easily make a cursor
        public Node(Node input) {
            coefficient = 0;
            degree = 0;
            link = input;
        }

        public double getCoefficient() {
            return coefficient;
        }
        public int getDegree() {
            return degree;
        }
        public Node getLink() {
            return link;
        }
    }

    public PolynomialList() {
        head = null;
        cursor = head;
    }

    public Node getHead() {
        return head;
    }
    public void addNode(double coefficient, int degree) {
        if (isEmptyList()) {
            addNodeToStartOfList(coefficient, degree);
        } else {
            findDegreeHome(degree);
            if (isDegreeEqualToNext(degree)) {
                addToCoefficientAfterNext(coefficient);
            } else {
                addNodeAfterCursor(coefficient, degree);
            }
        }
    }
    private void addNodeAfterCursor(double coefficient, int degree) {
        cursor.link = new Node(coefficient, degree, cursor.link);
    }
    private void addToCoefficientAfterNext(double coefficient) {
        cursor.link.coefficient = cursor.link.coefficient + coefficient;
    }
    private void addNodeToStartOfList(double coefficient, int degree) {
        head = new Node(coefficient, degree, null);
    }
    private void findDegreeHome(int degree) {
        if (isNotEndOfList() && isDegreeLessThanNext(degree)) {
            findDegreeFromCurrentCursor(degree);
        } else {
            findDegreeFromStart(degree);
        }
    }
    private void findDegreeFromCurrentCursor(int degree) {
        while (isNotEndOfList() && isDegreeLessThanNext(degree)) {
            advanceCursor();
        }
    }
    private void findDegreeFromStart(int degree) {
        resetCursor();
        while (isNotEndOfList() && isDegreeLessThanNext(degree)) {
            advanceCursor();
        }
    }
    private boolean isNextNull() {
        return cursor.link == null;
    }
    private boolean isEmptyList() {
        return head == null;
    }
    private boolean isNotEndOfList(){
        return cursor != null;
    }
    private boolean isDegreeLessThanNext(int degree) {
        if (isNextNull()) {
            return false;
        } else {
            return cursor.degree > degree;
        }
    }
    private boolean isDegreeEqualToNext(int degree) {
        if (isNextNull()) {
            return false;
        } else {
            return degree == cursor.link.degree;
        }
    }
    private void advanceCursor() {
        cursor = cursor.link;
    }
    private void resetCursor() {
        cursor = head;
    }

    public void removeNode(int inputDegree) {
        Node cursor = new Node(head);
        while (cursor.link.link != null && inputDegree > cursor.link.link.degree) {
            cursor.link = cursor.link.link;
        }
        if (cursor.link.link != null && inputDegree == cursor.link.link.degree) {
            cursor.link.link = cursor.link.link.link;
        } else {
            throw new IllegalArgumentException("There is no Node with that exponent or degree.");
        }
    }
    public double evaluate(Node target, double x){
        double answer = 0;
        while (target.getLink() != null) {
            answer = answer + (target.coefficient * Math.pow(x, target.degree));
            target.link = target.getLink();
        }
        return answer;
    }
}
