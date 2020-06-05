package question;

/**
 * @Description: TODO
 * @Author wang1
 * @Date 2020/6/3
 * @Version V1.0
 **/
public class BuildBST {

    class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }


    }


    private int[] array;


    private Node buildBSTByLRD(int left, int right) {
        if (array == null || array.length == 0) {
            return null;
        }
        Node parent = new Node(array[right]);

        //parent.left = findRightSmallIndex()

        return null;


    }


}
