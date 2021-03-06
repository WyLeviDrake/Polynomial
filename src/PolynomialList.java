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
            if (isDegreeEqual(degree)) {
                addToCoefficient(coefficient);
            } else if (isDegreeEqualToNext(degree)) {
                addToNextCoefficient(coefficient);
            } else if (isStartOfList() && isDegreeMoreThanCurrent(degree)) {
                addNodeToStartOfList(coefficient, degree);
            } else {
                addNodeAfterCursor(coefficient, degree);
            }
        }
    }
    private void addNodeAfterCursor(double coefficient, int degree) {
        Node input = new Node(coefficient, degree, cursor.getLink());
        cursor.link = input;
    }
    private void addToCoefficient(double coefficient) {
        cursor.coefficient = cursor.coefficient + coefficient;
    }
    private void addToNextCoefficient(double coefficient) {
        cursor.link.coefficient = cursor.link.coefficient + coefficient;
    }
    private void addNodeToStartOfList(double coefficient, int degree) {
        Node start = new Node(coefficient, degree, head);
        head = start;
    }
    private void findDegreeHome(int degree) {
        if (isStartOfList() && isDegreeEqual(degree)) {
            return;
        } else if (isNotEndOfList() && isDegreeLessThanNext(degree)) {
            findDegreeFromCurrentCursor(degree);
        } else {
            findDegreeFromStart(degree);
        }
    }
    private void findDegreeFromCurrentCursor(int degree) {
        while (isNotEndOfList() && isDegreeLessThanCurrent(degree) && isDegreeLessThanNext(degree)) {
            advanceCursor();
        }
    }
    private void findDegreeFromStart(int degree) {
        resetCursor();
        while (isNotEndOfList() && isDegreeLessThanCurrent(degree) && isDegreeLessThanNext(degree)) {
            advanceCursor();
        }
    }

    private void findDegreeBeforeHomeFromStart(int degree) {
        resetCursor();
        while (isNotEndOfList() && !isDegreeEqualToNext(degree)) {
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
    private boolean isDegreeLessThanCurrent(int degree) {
        if (isNextNull()) {
            return false;
        } else {
            return cursor.degree > degree;
        }
    }
    private boolean isDegreeMoreThanCurrent(int degree) {
        return cursor.degree < degree;
    }
    private boolean isDegreeLessThanNext(int degree) {
        if (isNextNull()) {
            return false;
        } else {
            return cursor.link.degree > degree;
        }
    }
    private boolean isDegreeEqual(int degree) {
            return degree == cursor.degree;
    }
    private boolean isDegreeEqualToNext(int degree) {
        if (isNextNull()) {
            return false;
        } else {
            return degree == cursor.link.degree;
        }
    }
    private boolean isStartOfList() {
        return cursor == head;
    }
    public void advanceCursor() {
        cursor = cursor.link;
    }
    public void resetCursor() {
        cursor = head;
    }

    public void removeNode(int degree) {
        findDegreeBeforeHomeFromStart(degree);
        if (isNotEndOfList() && isDegreeEqualToNext(degree)) {
            cursor.link = cursor.link.link;
        } else {
            throw new IllegalArgumentException("There is no Node with that exponent or degree.");
        }
    }
    public double evaluate(int x){
        double answer = 0;
        resetCursor();
        while (cursor != null) {
            answer = answer + (cursor.coefficient * Math.pow(x, cursor.degree));
            advanceCursor();
        }
        return answer;
    }
}
