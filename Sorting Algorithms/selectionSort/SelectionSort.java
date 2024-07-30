package selectionSort;

import java.util.Scanner;

public class SelectionSort {
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
			int mini=i;
			for(int j=i+1;j<n;j++)
			{
				if(a[j]<a[mini])
				{
					mini=j;
				}
			}
			int t=a[i];
			a[i]=a[mini];
			a[mini]=t;
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
 Best Case: O(n*n)
 Avg Case: O(n*n)
 Worst Case: O(n*n)
*/