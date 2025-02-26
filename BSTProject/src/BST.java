import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root = new TreeNode(null);

    public BST () {
        root=null;
    }
    // add
    public void add(Comparable val) {
        if(root == null)
	            root = new TreeNode(val, null,null);
        else if (val.compareTo(root.getValue()) <= 0) {
	        addHelper(val, root.getLeft(), root);
        }
        else {
	        addHelper(val, root.getRight(), root);
        }
    }

        // add helper   
        private void addHelper(Comparable val, TreeNode child, TreeNode parent)
        {
            if (child == null) {
	            if (val.compareTo(parent.getValue()) <=0) {
			            parent.setLeft(new TreeNode(val));
                } // end if
                if (val.compareTo(parent.getValue()) >0) {
			parent.setRight(new TreeNode(val));
            } // end if
            } // end if
	         else if (val.compareTo(child.getValue()) <=0) {
                addHelper(val, child.getLeft(), child);
            } // end else if
	        else {
                addHelper(val, child.getRight(), child);
            } // end else
        } // end add helper


        public void printInOrder() // prints the list in order
        {
            System.out.println("In order:");
            if (root == null) {
                System.out.println("In order: ____");
            } // end if
            if (root.getLeft()!= null) {
                inOrderHelper(root.getLeft());
            } // end if
            System.out.println(root.getValue());
            if (root.getRight()!= null) {
                inOrderHelper(root.getRight());
            } // end if
        }



        //in order helper
        public void inOrderHelper(TreeNode child) {
            if(child.getLeft() !=null) {
                inOrderHelper(child.getLeft());
            }
            System.out.println(child.getValue() + " ");
            if(child.getRight() !=null) {
                inOrderHelper(child.getRight());
            }
            return;
        }

        public void printPreOrder() // prints in pre order
        {
            System.out.println("Pre order:");
            if (root == null) {
                System.out.println("Pre order: ____");
            } // end if
            System.out.println(root.getValue());
            if (root.getLeft()!= null) {
                preOrderHelper(root.getLeft());
            } // end if
            if (root.getRight()!= null) {
                preOrderHelper(root.getRight());
            } // end if
        } // end print preorder

        // preorder helper
        public void preOrderHelper(TreeNode child) {
            System.out.println(child.getValue() + " ");
            if(child.getLeft() !=null) {
                preOrderHelper(child.getLeft());
            }
            if(child.getRight() !=null) {
                preOrderHelper(child.getRight());
            }
            return;
        }

        public void printPostOrder() // prints in post order
        {
            System.out.println("Post order:");
            if (root == null) {
                System.out.println("Post order: ____");
            } // end if
            if (root.getLeft()!= null) {
                postOrderHelper(root.getLeft());
            } // end if
            if (root.getRight()!= null) {
                postOrderHelper(root.getRight());
            } // end if
            System.out.println(root.getValue());
        } // end printpostorder

        // postorder helper
        public void postOrderHelper(TreeNode child) {
            if(child.getLeft() !=null) {
                postOrderHelper(child.getLeft());
            }
            if(child.getRight() !=null) {
                postOrderHelper(child.getRight());
            }
            System.out.println(child.getValue() + " ");
            return;
        }

    }   
