import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BST {
    Node overallRoot;

    public BST(){
    }
    public BST(Node overallRoot){
        this.overallRoot = overallRoot;
    }

    public void insertValues(double k) throws Exception {
        Node parent = findParent(k, overallRoot);
        if(k <= parent.getData()){
            while (parent.getLeft() != null){
                parent = findParent(k, parent.getLeft());
            }

            parent.setLeft(new Node(k));
        }
        else{
            if(parent.getRight() == null){
                parent.setRight(new Node(k));
            }

        }

    }

    public Node findParent(double k, Node v){
        if(k <= v.getData() && v.getLeft() == null){
            return v;
        }
        else if(k > v.data && v.getRight() == null){
            return v;
        }
        else{
            if(k <= v.data){
                return findParent(k, v.getLeft());
            }
            else return findParent(k, v.getRight());
        }
    }

    public Node getOverallRoot() {
        return overallRoot;
    }

    public void setOverallRoot(Double overallRoot) {
        this.overallRoot = new Node(overallRoot);
    }

    public List<Double> inOrderList(){
        ArrayList<Double> list = new ArrayList<>();
        inOrderList(overallRoot, list);
        return list;
    }

    private void inOrderList(Node node, ArrayList<Double> list){
        if(node == null){
            return;
        }

        inOrderList(node.left, list);
        list.add(node.data);
        inOrderList(node.right, list);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(horizontal(overallRoot) + "\n\n In order: ");
        List<Double> list = inOrderList();
        list.forEach(n -> string.append(n).append(", "));
        return string.toString();
    }

    public String horizontal(Node node){
        if(node == null){
            return "";
        }
        else if(node.left == null && node.right == null){
            return " ".repeat(getLevel(node) * 4) + node.data;
        }
        else if(node.right == null){
            return " ".repeat(getLevel(node) * 4) + node.data + "\n"+
                    horizontal(node.left);
        }
        else if(node.left == null){
            return horizontal(node.right) + "\n"
                    + " ".repeat(getLevel(node) * 4) + node.data;
        }
        return  horizontal(node.right) + "\n"
                + " ".repeat(getLevel(node) * 4) + node.data + "\n" +
                horizontal(node.left);

    }

    public int getLevel(Node target, Node node, int level){
        if(target == null || node == null){
            return 0;
        }
        else if(target.equals(node)){
            return level;
        }

        return getLevel(target, node.left, level+1) + getLevel(target, node.right, level+1);
    }
    public int getLevel(Node target){
        return getLevel(target, overallRoot, 0);
    }

    private class Node{
        private double data;
        private Node left;
        private Node right;

        public Node(double data){
            this.data = data;
        }

        public Node(){}

        public Node(double data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setData(int data) {
            this.data = data;
        }

        public double getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Double.compare(node.data, data) == 0 &&
                    equals(left, node.left) &&
                    equals(right, node.right);
        }

        public boolean equals(Node n1, Node n2){
            return n1.equals(n2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, left, right);
        }
    }

}
