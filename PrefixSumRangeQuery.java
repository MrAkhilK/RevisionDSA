/*
Q. Find the Sum of Elements in a Given Range
Given an array A and multiple queries where each query consists of two indices L and R, find the sum of elements from index L to R for each query efficiently.
*/

import java.util.Scanner;

public class PrefixSumRangeQuery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] A = new int[n];

        // Input array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Input number of queries
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        int[][] queries = new int[q][2];

        // Input query ranges
        System.out.println("Enter the queries (L R):");
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt(); // L
            queries[i][1] = scanner.nextInt(); // R
        }

        // Call the function
        int[] results = rangeSumQueries(A, queries);

        // Output results
        System.out.println("Query Results:");
        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    public static int[] rangeSumQueries(int[] A, int[][] queries) {
        // Placeholder for actual logic
        // Implement prefix sum logic here and compute results for queries
        int len=A.length;
        int[] ans=new int[queries.length];
      /**
      //Brute Force Approach
        for(int i=0;i<queries.length;i++){
          int l=queries[i][0];
          int r=queries[i][1];
          int sum=0;
          for(int i=l;i<=r;i++){
            sum+=A[i];
          }
          ans[i]=sum;
        }
      **/

      
        int[] pf=new int[len];
        pf[0]=A[0];

        

        for(int i=1;i<len;i++){
            pf[i]=pf[i-1]+A[i];
        }

        for(int i=0;i<queries[0].length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(l>0){
                ans[i]=pf[r]-pf[l-1];
            }else{
                ans[i]=pf[r];
            }

            if(l<0||r>=len||l>r){
                System.out.println("Invalid inputs");
            }
        }
        
        return ans; // Replace with actual results
    }
}

