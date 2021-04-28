import java.util.ArrayList;


public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    private TreeNode<String> root = null;
    private String fetchedLetter;


    public MorseCodeTree() {
        buildTree();
    }

    /**
     * Returns a reference to the root
     *
     * @return reference to the root
     */
    public TreeNode<String> getRoot() {
        return this.root;
    }

    /**
     * sets the root of the of the MorseCodeTree
     *
     * @param newNode a copy of newNode will be the new root
     */
    public void setRoot(TreeNode<String> newNode) {

        root = newNode;
    }

    /**
     * Adds element to the correct position in the tree
     *
     * @param code   the code for the new node to be added, example ".-."
     * @param letter the letter for the new node to be added, example "r"
     * @return the MorseCodeTree with the new node added
     */
    public MorseCodeTree insert(String code, String letter) {

        addNode(root, code, letter);

        return this;
    }

    /**
     * @param root   the root of the tree for this particular recursive instance of addNode
     * @param code   the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */

    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                root.left = new TreeNode<>(letter);
            } else {
                root.right = new TreeNode<>(letter);
            }

        } else {
            if (code.substring(0, 1).equals(".")) {
                addNode(root.left, code.substring(1), letter);
            } else {
                addNode(root.right, code.substring(1), letter);
            }
        }
    }


    /**
     * Fetch the data in the tree based on the code
     *
     * @param code the code that describes the traversals to retrieve the string (letter)
     * @return the string (letter) that corresponds to the code
     */

    public String fetch(String code) {

        return fetchNode(root, code);
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode
     *
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return the string (letter) corresponding to the code
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                fetchedLetter = root.left.getData();
            } else {
                fetchedLetter = root.right.getData();
            }
        } else {
            if (code.substring(0, 1).equals(".")) {

                fetchNode(root.left, code.substring(1));
            } else {

                fetchNode(root.right, code.substring(1));
            }
        }

        return fetchedLetter;
    }


    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */

    public MorseCodeTree delete(String data) throws UnsupportedOperationException {
        return null;
    }


    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public MorseCodeTree update() throws UnsupportedOperationException {
        return null;
    }

    /**
     * This method builds the MorseCodeTree
     */

    public void buildTree() {
        root = new TreeNode<>("");

        insert(".", "e");
        insert("-", "t");

        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order. Used for testing to make sure tree is built correctly
     *
     * @return an ArrayList of the items in the linked Tree
     */

    public ArrayList<String> toArrayList() {
        ArrayList<String> printTree = new ArrayList<String>();

        LNRoutputTraversal(root, printTree);

        return printTree;
    }

    /**
     * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
     *
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */

    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.left, list);
            list.add(root.getData());
            LNRoutputTraversal(root.right, list);
        }
    }
}
