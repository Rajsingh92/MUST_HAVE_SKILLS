class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    tilt = 0

    def findTilt(self, root: TreeNode) -> int:
        self.tilt = 0
        self.helper(root)
        return self.tilt

    def helper(self, root: TreeNode) -> int:
        if root is None:
            return 0

        left = self.helper(root.left)
        right = self.helper(root.right)

        self.tilt += abs(left - right)

        return root.val + left + right


        