import java.util.*;

class GenericTree {
    public static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<>();

        Node(int val) {
            this.val = val;
        }
    }

    public static int size(Node root) {
        int s = 0;

        for (Node child : root.children) {
            s += size(child);
        }

        return s + 1;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int h = 0;

        for (Node child : root.children) {
            int ch = maxDepth(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        for (Node child : node.children) {
            boolean fic = find(child, data);
            if (fic) {
                return true;
            }
        }

        return false;
    }

    static Node predecessor;
    static Node successor;
    static int state;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state++;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state++;
        }

        for (Node child : node.children) {
            predecessorAndSuccessor(child, data);
        }
    }

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }

        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }

        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k) {
        int data = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            ceilAndFloor(node, data);
            data = floor;
            floor = Integer.MIN_VALUE;
        }

        return data;
    }

    static int mSum = 0;
    static int mSumNode = 0;

    public static int nodeWithMaximumSubtreeSum(Node node) {
        int sum = 0;

        for (Node child : node.children) {
            int cstSum = nodeWithMaximumSubtreeSum(child);
            sum += cstSum;
        }
        sum += node.data;

        if (sum > mSum) {
            mSum = sum;
            mSumNode = node.data;
        }

        return sum;
    }

    static int dia = 0;

    public static int diameter(Node node) {
        int ht = -1;

        int sh = -1;
        for (Node child : node.children) {
            int ch = diameter(child);
            if (ch >= ht) {
                sh = ht;
                ht = ch;
            } else if (ch >= sh) {
                sh = ch;
            }
        }

        if (sh + ht + 2 > dia) {
            dia = sh + ht + 2;
        }

        ht += 1;
        return ht;
    }

    public static boolean find2(Node node, int data) {
        if (node.val == data)
            return true;

        for (Node child : node.childs) {
            if (find(child, data))
                return true;
        }

        return false;
    }

    public static int find01(Node node, int data) {
        if (node.val == data)
            return 0;

        int depth = -1;
        for (Node child : node.childs) {
            depth = find01(child, data);
            if (depth != -1)
                break;
        }

        if (depth != -1)
            depth++;

        return depth;
    }

    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> ans) {
        if (root.val == data) {
            ans.add(root);
            return true;
        }

        boolean res = false;
        for (Node child : root.childs) {
            res = res || rootToNodePath(child, data, ans);
            // if(res) break;
        }

        if (res)
            ans.add(root);

        return res;
    }

    public static ArrayList<Node> rootToNodePath(Node root, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        rootToNodePath(root, data, ans);

        return ans;

    }

    public static Node LCA(Node root, int d1, int d2) {
        ArrayList<Node> l1 = new ArrayList<>();
        rootToNodePath(root, d1, l1);

        ArrayList<Node> l2 = new ArrayList<>();
        rootToNodePath(root, d2, l2);

        int i = l1.size() - 1;
        int j = l2.size() - 1;

        Node LCA = null;
        while (i >= 0 && j >= 0) {
            if (l1.get(i) != l2.get(j))
                break;

            LCA = l1.get(i);
            i--;
            j--;
        }

        return LCA;
    }

    public void kDown(Node root, Node blockNode, int time, List<List<Integer>> ans) {
        if (root == blockNode)
            return;

        if (ans.size() == time)
            ans.add(new ArrayList<>());

        ans.get(time).add(root.val);
        for (Node child : root.childs)
            kDown(child, blockNode, time + 1, ans);

    }

    public static void lineWiseLevelOrder(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        int level = 0;

        while (que.size() != 0) {
            int sz = que.size();
            System.out.print("Level : " + level + " -> ");
            while (sz-- > 0) {
                Node rn = que.removeFirst();
                System.out.print(rn.val + ", ");

                for (Node child : rn.childs) {
                    que.addLast(child);
                }

            }

            level++;
            System.out.println();
        }
    }

    public static boolean isMirror(Node node1, Node node2) {
        if (node1.childs.size() != node2.childs.size())
            return false;
        if (node1.val != node2.val)
            return false;

        for (int i = 0, j = node1.childs.size() - 1; j >= 0; i++, j--) {
            Node child1 = node1.childs.get(i);
            Node child2 = node2.childs.get(j);
            if (!isMirror(child1, child2))
                return false;
        }

        return true;

    }

    // diameter of GT

    public static Node flattern(Node node) {
        if (node.childs.size() == 0)
            return node;

        int n = node.childs.size();
        Node lchild = node.childs.get(n - 1);
        Node gTail = flattern(lchild);

        for (int i = n - 2; i >= 0; i--) {
            Node tempTail = flattern(node.childs.get(i));
            tempTail.childs.add(node.childs.get(i + 1));
            node.childs.remove(i + 1);
        }

        return gTail;
    }

}
