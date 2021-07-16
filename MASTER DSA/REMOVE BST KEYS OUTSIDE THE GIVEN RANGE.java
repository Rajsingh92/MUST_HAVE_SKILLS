

class Solution{
	public static Node truncate(Node root,int min, int max){
		if(root == null){
			return null;
		}
		
		root.left = truncate(root.left,min, max);
		root.right = truncate(root.right,min, max);
		
		if(root.key < min){
			Node rchild = root.right;
			root = null;
			return rchild;
		}else if(root.key > max){
			Node lchild = root.left;
			root = null;
			return lchild;
		}
		
		return root;
	}
}

