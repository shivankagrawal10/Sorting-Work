package sort;

import odd.First;

public class sort {
	public int[] arr, temp;
	public sort (int a) {
		int size= (int)Math.pow(10, a);
		
		arr= new int[size];
		int x= arr.length;
		//int []num = {8,7,6,5,4,3,2,1};
		for (int i=0;i<arr.length;i++) {
			//num[i]=(int)(Math.random()*100);
			//System.out.print(num[i]+", ");
			arr[i]=x;
			x--;
		}
		System.out.print("done assigning \n");
	}
	
	
	
	
	public void callmergesort() {
		mergesort(arr, 0, arr.length - 1);
	}
	
	//driver function for mergesort --> calls the recursive to split and then merge
	
	public void mergesort(int[] a, int startI, int endI) {
		
		//int si= a.length-1;
		int [] val = new int[1];
		int midPoint;
		long heapSize = Runtime.getRuntime().totalMemory();
		long heapFreeSize = Runtime.getRuntime().freeMemory(); 
		//System.out.println("current heap size "+heapsize);
		midPoint = (endI+startI)/2; //midpoint for array
		
		if(heapFreeSize<1212015976)
		System.out.println("Start: "+startI+" End: "+endI+" Mid: "+midPoint+" current heap size "+heapSize+" current free heap "+heapFreeSize);
		if (endI-startI < 1) {
			val[0]=a[startI];
			//System.out.println("returning "+val[0]);
			return ;
		}
		/*try
		{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}*/
	
		mergesort(a, startI, midPoint); //split left
		
		
		//System.out.println("Start 2: "+startI+" End: "+endI+" Mid: "+midPoint);
		mergesort(a, midPoint+1, endI);		//split right
		temp=mergeSortedArrays(a, startI, midPoint, midPoint+1, endI); //by defining positions in array, we are taking out array slices
		/*for (int i=0;i<temp.length;i++) {
			a[i]=temp[i];
		}*/
		/*System.out.println("Printing Temp=>");
		
		for (int i=0;i<temp.length;i++) {
			System.out.print(temp[i]+", ");
		}
		System.out.println("\n Printing A=>");
		
		for (int i=startI;i<endI;i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println("==>");
		return a;*/
		
		//System.out.println("==>");
		int fill = startI;
		for (int i=0;i<temp.length;i++) {
			a[fill]=temp[i];
			fill++;
		}
		return ;
	}
	
	
	
	public void printArray(int mya[], String name) {
		System.out.print(name+"==>");
		for (int c=0;c<mya.length;c++) {
			System.out.print(mya[c]+",");
		}
		System.out.println("==>"+name);
	}
	
	// 
	
	public int[] mergeSortedArrays(int[] a, int aStartI, int aEndI, int bStartI, int bEndI) {
		int [] mergearr = new int [(aEndI-aStartI+1)+(bEndI-bStartI+1)];
		int i = aStartI, j=bStartI;
		
		//System.out.println("\n** mergeSortedArrays astartI="+aStartI+" aEndI="+aEndI+" bStartI="+bStartI+" bEndI="+bEndI + " mergeArr Len="+mergearr.length+"\n" );
		
		for (int c=0;c<mergearr.length;c++) {
			
			if((i<=aEndI)&&(j<=bEndI)) {
				//System.out.println("=>mergeSortedArrays I="+i+" a[i]="+a[i]+" And J="+j+" a[j]="+a[j]+ "Starting c=>"+c);
		        //printArray(mergearr, "mergearr");
		        //printArray(a, "A Array");
		        int left = a[i], right = a[j];
				if (left<right) {
					mergearr[c]=left;
					i++;
				}
				else if (right<left) {
					mergearr[c]=right;
					j++;
				}
				else if (left==right) {
					mergearr[c]=left;
					mergearr[c+1]=right;
					c=c+1;
					i++;
					j++;
				}
				continue;
			}
			
			//System.out.println("mergeSortedArrays2 I="+i+" And J="+j+ " bEndI= "+bEndI);
			if(i>aEndI) {
				//c=c+1;
				mergearr[c]=a[j];
				j++;
			}
			else if(j>bEndI) {
				//c=c+1;
			
				mergearr[c]=a[i];
				i++;
			}
		}
		//System.out.println("Returning mergearr");
		return mergearr;
	}
	
	//=============
	//bubble sort
	public int[] bubble() {
		boolean done = false;
		int counter=0,temp=0;
		while (done==false) {
			for (int i=0;i<arr.length-1;i++) {
				if(arr[i]>arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					counter++;
				}
			}
			if (counter==0) {
				done=true;
			} 
			counter=0;
		}
		/*for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+", ");
		}*/
		return arr;
		
	}
	
	public static void main(String[] args) {
		double [] times = new double [6], timemerge = new double[10];
		int count=0;
		for (int s=1;s<=4;s++) {
			
			
			sort first= new sort(s);
			//sort second = new sort(num);
			
			System.out.print("starting bubble sort for array size: "+first.arr.length+"\n");
			long startTime = System.nanoTime();
		
			first.bubble();
			//second.callmergesort();
	
			long endTime = System.nanoTime();
			
			System.out.print("done sort\n");
			for (int i=0;i<10;i++) {
				System.out.print(first.arr[i]+", ");
				//System.out.println(second.arr[i]);
			}
			for (int i=first.arr.length-1;i>=first.arr.length-10;i--) {
				System.out.print(first.arr[i]+", ");
				//System.out.println(second.arr[i]);
			}
			System.out.print("\n");
			System.out.println("Took "+(endTime - startTime)/Math.pow(10, 9) + " s "+(endTime - startTime) + " ns"); 
			times[count]=(endTime - startTime)/Math.pow(10, 9);
			count++;
		}
		
		System.out.println();
		count=0;
		for (int s=1;s<=9;s++) {
			try
			{
			    Thread.sleep(3000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			//System.out.print("done assigning \n");
			//sort first= new sort(s);
			sort second = new sort(s);
			
			System.out.print("starting merge sort for array size: "+second.arr.length+"\n");
			long startTime = System.nanoTime();
		
			//first.bubble();
			second.callmergesort();
	
			long endTime = System.nanoTime();
			
			System.out.print("done sort\n");
			for (int i=0;i<10;i++) {
				//System.out.print(first.arr[i]+", ");
				System.out.println(second.arr[i]+", ");
			}
			System.out.print("\n");
			for (int i=second.arr.length-1;i>= second.arr.length-10;i--) {
				//System.out.print(first.arr[i]+", ");
				System.out.print(second.arr[i]+", ");
			}
			System.out.print("\n");
			System.out.println("Took "+(endTime - startTime)/Math.pow(10, 9) + " s "+(endTime - startTime) + " ns"); 
			timemerge[count]=(endTime - startTime)/Math.pow(10, 9);
			count++;
		}
		for (int i =0;i<times.length;i++) {
			System.out.print(times[i]+", ");
		}
		System.out.println();
		for (int i =0;i<timemerge.length;i++) {
			System.out.print(timemerge[i]+", ");
		}
		
		
	}
	

}
