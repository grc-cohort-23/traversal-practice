public class TraversalPractice {
  
  /**
   * Prints the odd values of the nodes in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed post-order.
   * 
   * @param node The root of the tree to print
   */
  public static void printOddNodes(Node<Integer> node) {
    if(node == null) return;
    printOddNodes(node.left);
    printOddNodes(node.right);
    if(node.value % 2 == 1) System.out.println(node.value);
  }

  /**
   * Prints the values of the nodes that have exactly one child in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed pre-order.
   * 
   * @param node The root of the tree to print
   */
  public static void printNodesWithOneChild(Node<?> node) {
      if(node == null) return;
      if(node.left != null && node.right != null){
        printNodesWithOneChild(node.left);
        printNodesWithOneChild(node.right);
      }
      if(node.left != null && node.right == null){
        System.out.println(node.value);
        printNodesWithOneChild(node.left);
      }else if(node.left == null && node.right != null){
        System.out.println(node.value);
        printNodesWithOneChild(node.right);
      }
  }

    /**
   * Returns the sum of the values of all nodes in a tree.
   * Edge Case:
   *   Returns 0 if node is null
   *  
   * @param node The root of the tree
   * @return the sum 
   */
  public static int treeSum(Node<Integer> node) {
    if(node == null) return 0;
    int sum = node.value;
    sum += treeSum(node.left);
    sum += treeSum(node.right);
    return sum;
  }

  /**
   * Returns the maximum value stored in a tree.
   * Assumes all values are positive.
   * Edge case:
   *   Returns 0 if node is null.
   * 
   * @param node The root of the tree
   * @return the max value
   */
  public static int maxVal(Node<Integer> node) {
    if(node == null) return 0;
    int max = node.value;
    int left = maxVal(node.left);
    if(max < left) max = left;
    int right = maxVal(node.right);
    if(max < right) max = right;
    return max;
  }

  /**
   * Returns the number of levels in the tree.
   * Edge cases: 
   *   Returns 0 if node is null, returns 1 if there is only a root with no children.
   * 
   * @param node The root of the tree
   * @return The number of levels in the tree
   */
  public static int numLevels(Node<?> node) {
    if(node == null) return 0;
    int levels = 1;
    int left = numLevels(node.left);
    int right = numLevels(node.right);
    if(left > 0 || right > 0){
      levels += Math.max(left, right);
    }
    return levels;
  }

  public static void main(String[] args) {
    /*
     *         99
     *       /    \
     *     45      82
     *    /  \        \
     *   9   5       16
     */

     // Replace the below line to create a tree 
     // as represented in the diagram above
     Node<Integer> smallTree = new Node<>(99,
        new Node<>(45,
          new Node<>(9, null, null),
          new Node<>(5, null, null)
        ),
        new Node<>(82,
          null,
          new Node<>(16, null, null)));


    /*
     *              42
     *          /       \
     *       17           63
     *      /  \            \
     *     9    21           87
     *    /    /  \          /
     *   3    19   25     76
    */

    Node<Integer> largeTree = new Node<>(42,
        new Node<>(17, // 17 is left child of 42
                new Node<>(9, // 9 is the left child of 17
                        new Node<>(3, null, null), // 3 is the left child of 9
                        null), // no right child of 9
                new Node<>(21, // 21 is the right child of 17
                        new Node<>(19, null, null), // 19 is the left child of 21
                        new Node<>(25, null, null))), // 25 is the right child of 21
        new Node<>(63, // 63 is right child of 42
                null, // no left child of 63
                new Node<>(87, // 87 is right child of 63
                        new Node<>(76, null, null), // 76 is the left child of 87
                        null))); // no right child of 87
  }
}