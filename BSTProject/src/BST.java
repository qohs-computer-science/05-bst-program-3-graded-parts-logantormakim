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
		    else {
			parent.setRight(new TreeNode(val));
            } // end else
            } // end if
	        else if (val.compareTo(child.getValue()) >=0) {
                addHelper(val, child.getLeft(), child);
            } // end else if
	        else {
                addHelper(val, child.getRight(), child);
            } // end else
        } // end add helper


        public void printInOrder() // prints the list in order
        {
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
            System.out.println(root.getValue());
            if(child.getRight() !=null) {
                inOrderHelper(child.getRight());
            }
            return;
        }
    }   
