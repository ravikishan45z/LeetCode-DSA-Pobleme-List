/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(mat[i], -1);
        }
        
        int toprow = 0, bottomrow = m-1;
        int leftcol = 0, rightcol = n-1; 
        ListNode temp = head; 
        while(temp != null){
            for(int col = leftcol; col <= rightcol; col++){
                if(temp == null){
                    break;
                }
                mat[toprow][col] = temp.val;
                temp = temp.next;
            }
            toprow++;

            for(int row = toprow; row <= bottomrow; row++){
                if(temp == null){
                    break;
                }
                mat[row][rightcol] = temp.val;
                temp = temp.next;
            }
            rightcol--;

            for(int col = rightcol; col >= leftcol; col--){
                if(temp == null){
                    break;
                }
                mat[bottomrow][col] = temp.val;
                temp = temp.next;
            }
            bottomrow--;

            for(int row = bottomrow; row >= toprow; row--){
                if(temp == null){
                    break;
                }
                mat[row][leftcol] = temp.val;
                temp = temp.next;
            }
            leftcol++;
        }
        return mat;
    }
}