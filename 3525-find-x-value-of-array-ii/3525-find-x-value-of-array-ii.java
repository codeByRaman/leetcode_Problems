import java.util.ArrayList;
import java.util.List;

class Solution {

    static class Node {
        int[] remain = new int[5];
        int prod = 1;
    }

    static class SegmentTree {
        private final int n;
        private final int k;
        private final Node[] tree;

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }
            build(nums, 0, 0, n - 1);
        }

        private Node merge(Node left, Node right) {
            Node res = new Node();
            res.prod = (left.prod * right.prod) % k;

            // Count prefixes strictly inside left child
            for (int i = 0; i < k; i++) {
                res.remain[i] += left.remain[i];
            }

            // Count prefixes extending from left into right child
            for (int i = 0; i < k; i++) {
                res.remain[(i * left.prod) % k] += right.remain[i];
            }

            return res;
        }

        private void build(int[] nums, int cur, int left, int right) {
            if (left == right) {
                int val = nums[left] % k;
                tree[cur].remain[val] = 1;
                tree[cur].prod = val;
                return;
            }
            int mid = left + (right - left) / 2;
            build(nums, 2 * cur + 1, left, mid);
            build(nums, 2 * cur + 2, mid + 1, right);
            tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
        }

        public void update(int cur, int lo, int hi, int idx, int val) {
            if (lo == hi) {
                for (int j = 0; j < k; j++) {
                    tree[cur].remain[j] = 0;
                }
                int v = val % k;
                tree[cur].remain[v] = 1;
                tree[cur].prod = v;
                return;
            }
            int mid = lo + (hi - lo) / 2;
            if (idx <= mid) {
                update(2 * cur + 1, lo, mid, idx, val);
            } else {
                update(2 * cur + 2, mid + 1, hi, idx, val);
            }
            tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
        }

        public Node query(int cur, int lo, int hi, int ql, int qr) {
            if (ql <= lo && hi <= qr) {
                return tree[cur];
            }
            int mid = lo + (hi - lo) / 2;
            if (qr <= mid) {
                return query(2 * cur + 1, lo, mid, ql, qr);
            }
            if (ql > mid) {
                return query(2 * cur + 2, mid + 1, hi, ql, qr);
            }

            Node leftRes = query(2 * cur + 1, lo, mid, ql, qr);
            Node rightRes = query(2 * cur + 2, mid + 1, hi, ql, qr);
            return merge(leftRes, rightRes);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Point update at position idx
            tree.update(0, 0, n - 1, idx, val);

            // Query range [start, n - 1]
            Node res = tree.query(0, 0, n - 1, start, n - 1);
            ans[i] = res.remain[x];
        }

        return ans;
    }
}