public class PolynomialList {

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
            coefficient = input.getCoefficient;
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

        public void reserve(int degree) {
            if else
                if else
                    if else
                        if else
                            if else
                                if else
                                    if else if () {
                
            }
        }
    }

    public void removeNode() {
        link = link.getLink();
    }
    public double evaluate(PolynomialList target, double x){
        double answer;
        for (PolynomialList i = target, i.link != null, i.link = i.getLink()) {
            answer = answer + (coefficient * Math.pow(x, degree));
        }

    }
}
