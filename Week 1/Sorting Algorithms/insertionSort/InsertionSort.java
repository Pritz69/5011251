package insertionSort;

import java.util.Scanner;

public class InsertionSort {
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
			int key=a[i];
			int j=i-1;
			while(j>=0 && a[j] > key)
			{
				a[j+1]=a[j];
				j=j-1;
			}
			a[j+1]=key;
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