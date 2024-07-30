package bubbleSort;
import java.util.*;
public class BubbleSort {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Array before sorting");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
		System.out.println("Array after sorting");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		sc.close();
	}
}

/*
 Best Case: O(n)
 Avg Case: O(n*n)
 Worst Case: O(n*n)
*/

