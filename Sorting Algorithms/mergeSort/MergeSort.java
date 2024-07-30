package mergeSort;

import java.util.Scanner;

public class MergeSort {
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
		Mergesort(a,0,n-1);
		System.out.println("Array after sorting");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		sc.close();
	}

	private static void Mergesort(int[] a, int l, int r) {
		if (l < r)
		{
			int m=(l+r)/2;
			Mergesort(a,l,m);
			Mergesort(a,m+1,r);
			merge(a,l,m,r);
		}
	}

	private static void merge(int[] a, int l, int m, int r) {
		int n1=(m-l)+1;
		int n2=r-m;
		int a1[]=new int[n1];
		int a2[]=new int[n2];
		for(int i=0;i<n1;i++)
		{
			a1[i]=a[l+i];
		}
		for(int i=0;i<n2;i++)
		{
			a2[i]=a[m+1+i];
		}
		int i=0;
		int j=0;
		int k=l;
		while(i<n1 && j<n2)
		{
			if(a1[i] <= a2[j])
			{
				a[k++]=a1[i++];
			}
			else if(a1[i] >= a2[j])
			{
				a[k++]=a2[j++];
			}
			else
			{
				a[k++]=a1[i++];
				a[k++]=a2[j++];
			}
		}
		while(i<n1)
		{
			a[k++]=a1[i++];
		}
		while(j<n2)
		{
			a[k++]=a2[j++];
		}
	}

}

/*
Best Case: O(n log n)
Avg Case: O(n log n)
Worst Case: O(n log n)
*/