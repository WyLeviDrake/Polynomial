public class PolynomialList {

    Node head;

    class Node implements Cloneable {

        private double coefficient;
        private int degree;
        private Node link;

        public Node() {
            coefficient = 0;
            degree = 0;
            link = null;
        }
        public Node(double inputCoefficient) {
            coefficient = inputCoefficient;
            degree = 0;
            link = null;
        }
        public Node(Node input) {
            coefficient = input.getCoefficient();
            degree = 0;
            link = null;
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

        public void addToCoefficient(double amount) {
            coefficient = coefficient + amount;
        }
        public void assignCoefficient(double newCoefficient) {
            coefficient = newCoefficient;
        }
    }

    public PolynomialList() {
        head = null;
    }

    public void removeNode() {
        Node cursor = head;
        cursor.link = cursor.link.getLink();
    }
    public double evaluate(Node target, double x){
        double answer = 0;
        while (target.getLink() != null) {
            answer = answer + (target.coefficient * Math.pow(x, target.degree));
            target.link = target.getLink();
        }
        return answer;
//        for (Node i = target; i.getLink() != null; i.link = i.getLink()) {
//            answer = answer + (target.coefficient * Math.pow(x, target.degree));
//        }


    }
}
