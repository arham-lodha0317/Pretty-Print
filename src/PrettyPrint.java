public class PrettyPrint {

    public static void main(String[] args) throws Exception {

        double[] arr = {72, 5, 2, 6, 5.5, 7.5, 1, 3, 9};

        BST bst = new BST();
        bst.setOverallRoot(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            bst.insertValues(arr[i]);
        }

        System.out.println(bst);
    }

}
