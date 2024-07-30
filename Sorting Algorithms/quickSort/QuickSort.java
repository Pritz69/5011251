package quickSort;

import java.util.Scanner;

public class QuickSort {
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
		Quicksort(a,0,n-1);
		System.out.println("Array after sorting");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		sc.close();
	}

	private static void Quicksort(int[] a, int l,int h) {
		if(l<h)
		{
			int pi=partition(a,l,h);
			Quicksort(a,l,pi-1);
			Quicksort(a,pi+1,h);
		}
	}

	private static int partition(int a[],int l, int h) {
		int pivot=a[h];
		int i=l-1;
		for(int j=l;j<=h;j++)
		{
			if(a[j]<pivot)
			{
				i +=1;
				int t=a[i];							// 12 3 5 8 13 9
				a[i]=a[j];
				a[j]=t;
			}
		}
		int t=a[i+1];
		a[i+1]=a[h];
		a[h]=t;
		return i+1;
	}
}

/*
Best Case: O(n log n)
Avg Case: O(n log n)
Worst Case: O(n*n)
*/