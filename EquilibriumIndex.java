/**
Check for Equilibrium Index

An index i in an array A is an equilibrium index if the sum of elements to the left of i is equal to the sum of elements to the right of i. Find all such indices.
*/

import java.util.*;

public class EquilibriumIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] A = new int[n];

        // Input the array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Call the function to find equilibrium indices
        List<Integer> equilibriumIndices = findEquilibriumIndices(A);

        // Output the result
        System.out.println("Equilibrium Indices: " + equilibriumIndices);

        scanner.close();
    }

    public static List<Integer> findEquilibriumIndices(int[] A) {
        // Placeholder for the logic
        // Implement the logic to find equilibrium indices
        ArrayList<Integer> ans=new ArrayList<>();

        /** 
        //Brute Force Approach
        for(int i=0;i<A.length;i++){
            int l=0,r=0;
            for(int j=0;j<i;j++){
                l+=A[j];
            }
            for(int k=i+1;k<A.length;k++){
                r+=A[k];
            }
            if(l==r){
                ans.add(i);
            }
        }
        */

        //optimized Approch 
        int leftSum=0, rightSum=0;
        int totalSum=0;
        for(int num:A){
            totalSum+=num;
        }
        for(int i=0;i<A.length;i++){
            rightSum=totalSum-leftSum-A[i];
            if(leftSum==rightSum){
                ans.add(i);
            }
            leftSum+=A[i];
        }
        
        return ans; 
    }
    
}
