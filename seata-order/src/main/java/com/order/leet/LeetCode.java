package com.order.leet;

import java.time.Instant;
import java.time.ZoneId;
import java.util.*;

/**
 * @author xiaojw
 * @describe leetCode
 * @date 2021/1/26 17:49
 */
public class LeetCode {
    public static void main(String[] args) {
        ListNode node5 = ListNode.builder().val(5).build();
        ListNode node4 = ListNode.builder().val(4).next(node5).build();
        ListNode node3 = ListNode.builder().val(8).next(node4).build();
        ListNode node2a = ListNode.builder().val(1).next(node3).build();
        ListNode node2 = ListNode.builder().val(9).next(node2a).build();
        ListNode node1 = ListNode.builder().val(5).next(node2).build();

        ListNode nodeA5 = ListNode.builder().val(5).build();
        ListNode nodeA4 = ListNode.builder().val(4).next(nodeA5).build();
        ListNode nodeA3 = ListNode.builder().val(4).next(nodeA4).build();
        ListNode nodeA2 = ListNode.builder().val(1).next(nodeA3).build();
        ListNode nodeA1 = ListNode.builder().val(1).next(nodeA2).build();
//        node5.next = node2;

        Long start = System.currentTimeMillis();
//        System.out.println(reverseList(node1));
//        System.out.println(deleteDuplicates(node1));
//        System.out.println(removeDuplicates(new int[]{1, 2, 2, 2, 2, 3, 4, 4, 6}));
//        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
//        System.out.println(hasCycle(node1));
//        System.out.println(hasCycleII(node1));
//        System.out.println(isPalindrome(node1));
//        removeElements(node1,1);
//        System.out.println(reversePrint(node1));HavalPointThreadLikeValidatePolicy
//        System.out.println(getKthFromEnd(node1,2));
//        System.out.println(getIntersectionNode(nodeA1,node1));
//        System.out.println(removeNthFromEnd(nodeA4,2));
//        System.out.println(deleteDuplicates2(nodeA1));
//        merge(new int[]{5,6,7,0,0,0},3,new int[]{1,2,3},3);
//        System.out.println(CheckPermutation("acb","bca"));
//        System.out.println(climbStairs(5));
//        System.out.println(getIntersectionNode(nodeA1,node1));
//        System.out.println(singleNumber(new int[]{2,2,1}));
//        TreeNode node = new TreeNode(1,new TreeNode(2,null,new TreeNode(3,null,null)),new TreeNode(2,null,new TreeNode(3,null,null)));
//        System.out.println(invertTree(node));
//        System.out.println(isSymmetric(node));
//        timeTestCase();

//        int[] nums = {7,2,10,4,1,3,9};
//        quickSort(nums);
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
//        threeSum(new int[]{-1,0,1,2,-1,-4});
//        System.out.println(coinChange(new int[]{2,5,7},27));
//        System.out.println(canIWin(10,11));
//        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
//        System.out.println(rob(new int[]{2,1,1,2}));
//        System.out.println(countNumbersWithUniqueDigits(0));
        System.out.println("总耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println(("xiao\n\r" +
                "xiao").replace("\n","\\\\n").replace("\r","\\\\r"));
    }

    public static  int countNumbersWithUniqueDigits(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 10;
        for(int i = 2; i<=n;i++){
            int sum = 9;
            for(int j =1;j<i;j++){
                sum = sum*(10-j);
            }
            f[i] = f[i-1] +sum;
        }
        return f[n];
    }
    public static int integerBreak(int n) {

        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                f[i] = Math.max(f[i], Math.max(j * (i - j), j * f[i - j]));
            }
        }
        return f[n];
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        if (n == 1) {
            return nums[0];
        }
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            if (i == n - 1) {
                f[i] = Math.max(f[i - 2] + (i % 2 == 0 ? 0 : nums[i]), f[i - 1]);
            } else {
                f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
            }
        }
        return f[n - 1];

    }

    public static void timeTestCase() {
        Instant instant = Instant.now();
        System.out.println(instant.toString());
//        System.out.println(instant.atZone(ZoneId.systemDefault()).toString());
        System.out.println(instant.atZone(ZoneId.of("Europe/Paris")).toInstant().toString());
        System.out.println();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lis = new ArrayList<>();
        if (nums.length < 3) {
            return lis;
        }
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            i = k + 1;
            j = nums.length - 1;
            int target = -nums[k];
            while (i < j) {
                if (nums[i] + nums[j] < target) {
                    i++;
                } else if (nums[i] + nums[j] > target) {
                    j--;
                } else {
                    lis.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) i++; // 去重
                    while (i < j && nums[j] == nums[j - 1]) j--; // 去重
                    i++;
                    j--;
                }
            }
        }
        return lis;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            num[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            num[k++] = nums2[j++];
        }
        k = num.length;
        if (k % 2 == 0) {
            return (num[k / 2] + num[k / 2 - 1]) / 2.0;
        } else {
            return num[k / 2];
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int size = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (!set.contains(chars[j])) {
                    set.add(chars[j]);
                } else {
                    size = size > set.size() ? size : set.size();
                    set.clear();
                    set.add(chars[j]);
                }
            }
            size = size > set.size() ? size : set.size();
            set.clear();
        }
        return size;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        /**
         * 迭代
         */
        ListNode pre = null;  //前驱节点
        ListNode p = head;    //工作节点
        ListNode tmp = null;  //中转节点
        //p!=null遍历到n , p.next!=null遍历到n-1个
        while (p != null) {
            tmp = p;
            p = p.next; //前进
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
        /**递归**/
//        if(head == null || head.next==null){
//            return head;
//        }
//        ListNode curr = head.next;
//        ListNode node = reverseList(curr);
//        curr.next = head;
//        head.next = null;
//        return node;

    }

    /**
     * 删除重复的元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                ListNode tmp = curr.next;
                curr.next = tmp.next;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * 删除数组中的重复元素
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        //标记点
        int mark = 0;
        //数组下标
        int curr = 1;
        while (curr < nums.length) {
            if (nums[mark] != nums[curr]) {
                nums[mark + 1] = nums[curr];
                mark++;
            }
            curr++;
        }
        return mark + 1;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
//        int mark = 0;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            if (mark == 1 || i == digits.length - 1) {
//                digits[i] = digits[i] + 1;
//            }
//            if (digits[i] == 10 && i != 0) {
//                digits[i] = 0;
//                mark = 1;
//            } else {
//                mark = 0;
//            }
//
//        }
//        //扩容
//        if (digits[0] == 10) {
//            int[] expand = new int[digits.length + 1];
//            expand[0] = 1;
//            expand[1] = 0;
//            for (int j = 2; j < digits.length; j++) {
//                expand[j] = digits[j - 1];
//            }
//            return expand;
//        } else {
//            return digits;
//        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode hasCycleII(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                break;
            }
        }
        quick = head;
        if (quick == null || quick.next == null) {
            return null;
        }
        while (quick != null && quick.next != null) {
            quick = quick.next;
            slow = slow.next;
            if (quick == slow) {
                return quick;
            }
        }
        return null;
    }

    /**
     * 移除链表203
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode curr = pre;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * 回文链表234
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = low;
            low = low.next;
            tmp.next = pre;
            pre = tmp;
        }
        if (fast != null) {
            low = low.next;
        }
        while (low != null) {
            if (low.val != pre.val) {
                return false;
            } else {
                pre = pre.next;
                low = low.next;
            }
        }
        return true;
    }

    /**
     * 从尾到头反转链表
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        /*先反转链表，再打印
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode curr = head;//驱动链表
        ListNode work = null;//工作链表
        //反转链表
        while (curr != null){
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = work;
            work = tmp;
        }
        curr = work;
        while (curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
         */
        /*利用递归直接添加链表中元素到数组*/
        ArrayList<Integer> list = new ArrayList<Integer>();
        recur(head, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void recur(ListNode node, List<Integer> list) {
        if (node != null) {
            recur(node.next, list);
            list.add(node.val);
        }
    }

    /**
     * 倒数第几个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int i = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            i++;
        }
        curr = head;
        int min = 0, max = i - k < 0 ? 0 : i - k;
        while (min < max) {
            min++;
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 第一个公共节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;

//        HashSet<ListNode> set = new LinkedHashSet<>();
//        ListNode curr = headA;
//        while(curr!=null){
//            set.add(curr);
//            curr = curr.next;
//        }
//        curr = headB;
//        while(curr!=null){
//            if(set.contains(curr)){
//                return curr;
//            }else{
//                curr = curr.next;
//            }
//        }
//        return null;
    }

    /**
     * 移除倒数第K个元素
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode H = new ListNode();
        H.next = head;
        ListNode curr = H;
        ListNode slow = H;
        int i = 0;
        while (curr != null) {
            if (i > n) {
                slow = slow.next;
            }
            curr = curr.next;
            i++;
        }
        ListNode rev = slow.next;
        if (rev.next != null) {
            rev.val = rev.next.val;
            rev.next = rev.next.next;
        } else {
            slow.next = null;
        }
        return H.next;
    }

    /**
     * 去重所有重复元素（82）
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode H = new ListNode();
        H.next = head;
        ListNode curr = H;
        ListNode next = null;
        ListNode third = null;
        while (curr.next != null && curr.next.next != null) {
            next = curr.next;
            third = curr.next.next;
            if (next.val == third.val) {
                while (next.val == third.val) {
                    third = third.next;
                }
                curr.next = third;
            } else {
                curr = curr.next;
            }
        }
        return H.next;
    }

    /**
     * 合并两个排序数组
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (m >= 0 && A[m] >= B[n]) {
                A[i] = A[m];
                m--;
            } else {
                A[i] = B[n];
                n--;
            }
            i--;
        }
        System.out.println(A.toString());
    }

    /**
     * 判定是否互为字符重排
     */
    public static boolean CheckPermutation(String s1, String s2) {
        int[] idx = new int[128];
        int i = 0;
        idx[i]++;
        return true;
    }


    public static int climbStairs(int n) {
//        if (n <=3) return n;
//        return climbStairs(n - 1) + climbStairs(n - 2);
        //====
//        int idx = 0;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        while(idx <=n) {
//            if (idx <= 3) {
//                map.put(idx, idx);
//            } else {
//                map.put(idx, map.get(idx - 1) + map.get(idx - 2));
//            }
//            idx++;
//        }
//        return map.get(n);
        //=======
        int[] nums = new int[n + 1];
        int i = 1;
        while (i <= n) {
            if (i <= 3) {
                nums[i] = i;
            } else {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            i++;
        }
        return nums[n];
    }

    public static int coinChange(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;
        f[0] = 0;
        int i, j;
        for (i = 1; i <= M; ++i) {
            f[i] = Integer.MAX_VALUE;
            //f[i] = min(f[i-A[0]]+1,...,f[i-A[n-1]+1]
            for (j = 0; j < n; ++j) {
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE)
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
            }
        }
        if (f[M] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[M];
    }


    /**
     * can i win?
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    // TODO: 2021/4/30 it does not work
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int[] f = new int[desiredTotal + 1];

        f[0] = 0;
        int i, j;
        for (i = 1; i <= desiredTotal; i++) {
            f[i] = 300;
            for (j = 1; j <= maxChoosableInteger; ++j) {
                if (i >= j && f[i - j] != 300) {
                    f[i] = Math.min(f[i - j] + 1, f[i]);
                }
            }
        }
        return Math.floorMod(f[desiredTotal], 2) != 0;
    }

    /**
     * 64 最小和路径
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m, n;
        m = grid.length;
        n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
                } else if (i > 0) {
                    f[i][j] = grid[i][j] + f[i - 1][j];
                } else if (j > 0) {
                    f[i][j] = grid[i][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        Integer[] its = map.keySet().toArray(new Integer[0]);
        return its[0];
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }

    public static boolean isSymmetric(TreeNode root) {
        TreeNode node = root;
        return root == invertTree(node);
    }

    public static void quickSort(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
//        quickS(nums,l,r,mid);
        System.out.println(Arrays.toString(nums));
    }

}
