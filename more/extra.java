import java.io.*;

class GFG {

	static int N = 4;
	static void multiply(int mat1[][],
						int mat2[][], int res[][])
	{
		int i, j, k;
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				res[i][j] = 0;
				for (k = 0; k < N; k++)
					res[i][j] += mat1[i][k]
								* mat2[k][j];
			}
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		int mat1[][] = { { 1, 1, 1, 1 },
						{ 2, 2, 2, 2 },
						{ 3, 3, 3, 3 },
						{ 4, 4, 4, 4 } };

		int mat2[][] = { { 1, 1, 1, 1 },
						{ 2, 2, 2, 2 },
						{ 3, 3, 3, 3 },
						{ 4, 4, 4, 4 } };

		// To store result
		int res[][] = new int[N][N];
		int i, j;
		multiply(mat1, mat2, res);

		System.out.println("Result matrix"
						+ " is ");
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++)
				System.out.print(res[i][j]
								+ " ");
			System.out.println();
		}
	}
}

public class JavaMatrixInverse {
   public static void main(String args[]) {
      int i, j;
      float det, temp;
      float mat[][] = new float[2][2];
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter elements of matrix row wise:");
      for (i = 0; i < 2; ++i)
         for (j = 0; j < 2; ++j)
            mat[i][j] = sc.nextFloat();
      det = (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
      System.out.println("\ndeterminant = " + det);
      temp = mat[0][0];
      mat[0][0] = mat[1][1];
      mat[1][1] = temp;
      mat[0][1] = -mat[0][1];
      mat[1][0] = -mat[1][0];
      System.out.println("\nInverse of matrix is:");
      for (i = 0; i < 2; ++i) {
         for (j = 0; j < 2; ++j)
            System.out.print((mat[i][j] / det) + " ");
         System.out.print("\n");
      }
   }
}



import java.util.Collections;  
import java.util.LinkedList;  
import java.util.List;  
public class JavaListSubListExample3 {  
public static void main(String[] args) {  
        List<String> list= new LinkedList<>();  
list.add("Renu");  
list.add("Heera");  
list.add("Vijay");  
list.add("Geetanjali");  
System.out.println("List : "+list);  
//will sort the string acc to the alphabets  
Collections.sort(list);  
System.out.println("Sorted List : "+list);  
    }  
}  

/*Java Program to Check whether a String is a Palindrome or not using Recursive Function*/
import java.util.Scanner;
public class Main
{
    //Recursive function that checks 
    //whether the string is palindrome or not
    static boolean isPalindrome(String str) 
    { 
        //If string has 0 or 1 character
        if(str.length() == 0 || str.length() == 1)
            return true; 
        //If string has multiple characters
        //Check whether first and last characters are same or not
        if(str.charAt(0) == str.charAt(str.length()-1))
            return isPalindrome(str.substring(1, str.length()-1));
        return false;
    }   
    // Driver Code 
    public static void main(String args[]) 
    { 
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String str = sc.nextLine();   //Input the string
        //Check whether palindrome or not
        if (isPalindrome(str)) 
            System.out.println(str+" is palindrome"); 
        else
            System.out.println(str+ " is not a palindrome"); 
    }     
}

