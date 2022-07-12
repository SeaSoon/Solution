package array;

public class FindMedianSortedArrays {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。·
     */
    public static void main(String[] args) {
        int[] num1 = new int[]{0, 0};
        int[] num2 = new int[]{0, 0};
        double medianSortedArrays = findMedianSortedArrays2(num1, num2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 时间复杂度O(m+n)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < len1 && (bStart >= len2 || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    /**
     * 时间复杂度O(log(m+n))
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    private static int getKth(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(num2, start2, end2, num1, start1, end1, k);
        }
        // 数组1空了 那么直接返回数组2的第k小的数就行了
        if (len1 == 0) {
            // 坐标从0开始，第k个数，坐标是k-1
            return num2[start2 + k - 1];
        }
        // k只剩1了 那么直接比较哪个k更小 返回即可
        if (k == 1) {
            return Math.min(num1[start1], num2[start2]);
        }
        // 比较数组长度和要找的k/2谁更小，如果数组长度更小，那么就选择数组长度，这样下次递归数组1就空了
        // 如果k/2更小，那么就正常递归下去 - 1的目的是角标从0开始，直接使用数组长度会越界
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        // 舍弃更小的一方，继续比较下一个k
        if (num1[i] > num2[j]) {
            // 这里的k - (j - start2 + 1)就是反向推导，-start就是Math.min(len2, k / 2) - 1，+1就是Math.min(len2, k / 2)
            // 即算k到底减len2还是减k/2
            return getKth(num1, start1, end1, num2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(num1, i + 1, end1, num2, start2, end2, k - (i - start1 + 1));
        }
    }
}
