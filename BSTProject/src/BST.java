import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root = new TreeNode(null);

    public BST () {
        root=null;
    }
    
    public void add(Comparable val) {
        if(root = null)
	            root = new TreeNode(val, null,null);
        else if (val.compareTo(root.getValue())) {
	        addHelper(val, root.getLeft(), root);
        }
        else {
	        addHelper(val, root.getRight(), root);
        }
    }
        private void addHelper(Comparable val, TreeNode child, TreeNode parent)
        {
            if (child == null) {
	            if (parent.getValue().compareTo(val) >=0) {
			            parent.setLeft(new TreeNode(val));
                }
		    else {
			parent.setRight(new TreeNode(val));
            }
            }
	        else if (val.compareTo(child.getValue()) <0) {
                addHelper(val, child.getLeft(), child);
            }
	        else {
                addHelper(val, child.getRight(), child);
            }
        }
        public void printInOrder() // prints the list in order
        {
            if (root== null) {
                System.out.println("In order: ____");
            }
            if (root.getLeft()!= null) {
                inOrderHelper(root.getLeft());
                System.out.println(root.getValue());
            }
            if (root.getRight()!= null) {
                inOrderHelper(root.getRight());
            }
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
