class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> (row -> min-heap of node values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new ArrayDeque<>();
        
        if (root != null) {
            q.offer(new Tuple(root, 0, 0));
        }

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode curr = t.node;
            int r = t.row;
            int c = t.col;

            map.putIfAbsent(c, new TreeMap<>());
            map.get(c).putIfAbsent(r, new PriorityQueue<>());
            map.get(c).get(r).offer(curr.val);

            if (curr.left != null) {
                q.offer(new Tuple(curr.left, r + 1, c - 1));
            }
            if (curr.right != null) {
                q.offer(new Tuple(curr.right, r + 1, c + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }
}