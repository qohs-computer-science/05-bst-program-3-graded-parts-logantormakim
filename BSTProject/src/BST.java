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
        
        
    }   
