import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        
        // arr[i][0] = the number itself
        // arr[i][1] = the original index of the number
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        mergeSort(arr, 0, n - 1);
        
        // Convert the primitive int[] array to a List<Integer> for the return type
        List<Integer> res = new ArrayList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void mergeSort(int[][] arr, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
    }

    private void merge(int[][] arr, int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightCount = 0; // Tracks how many elements from the right subarray are smaller
        
        while (i <= mid && j <= right) {
            // If right element is strictly smaller, it "jumps" ahead of the left element
            if (arr[j][0] < arr[i][0]) {
                rightCount++;
                temp[k++] = arr[j++];
            } 
            // If left element is smaller or equal, we process it and record the count
            else {
                count[arr[i][1]] += rightCount;
                temp[k++] = arr[i++];
            }
        }
        
        // Process any remaining elements in the left subarray
        while (i <= mid) {
            count[arr[i][1]] += rightCount;
            temp[k++] = arr[i++];
        }
        
        // Process any remaining elements in the right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Copy the sorted temp array back into the original array
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}