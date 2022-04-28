public class PolynomialList {

    private Node head;

    class Node implements Cloneable {

        private double coefficient;
        private int degree;
        private Node link;

        public Node() {
            coefficient = 0;
            degree = 0;
            link = null;
        }
        public Node(double inputCoefficient, int inputDegree, Node inputLink) {
            coefficient = inputCoefficient;
            degree = inputDegree;
            link = inputLink;
        }
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

    public void addNode(double inputCoefficient, int inputDegree) {
        if (inputDegree > head.degree) {
            head = new Node(inputCoefficient, inputDegree, head);
        } else if (head == null) {
            head = new Node(inputCoefficient, inputDegree, null);
        } else if (inputDegree <= head.degree) {
            Node cursor = new Node(head);
            while (inputDegree < cursor.link.link.degree) {
                cursor.link = cursor.link.link;
            }
            if (inputDegree == cursor.link.degree) {
                cursor.link.coefficient = cursor.link.coefficient + inputCoefficient;
            } else {
                cursor.link = new Node(inputCoefficient, inputDegree, cursor.link);
            }
        }
    }
    public void removeNode(int degree) {
        this.link = cursor.link.getLink();
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
