import java.util.*;
class Main
{
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
        System.out.print("Enter array length"+'\n');
        Integer l=sc.nextInt();
        Integer n[]=new Integer[l];
	for(int i=0; i<l; i++){
            n[i]=sc.nextInt();
        }
        int max=0;
        int min=1000;
        for(int j=0; j<n.length; j++){
            if(n[j]>max){
                max=n[j];
            }
            if(n[j]<min){
                min=n[j];
            }
        }
        System.out.println("Max number: "+max+", word length: "+Integer.toString(max).length());
        System.out.println("Min number: "+min+", word length: "+Integer.toString(min).length());
        Arrays.sort(n);
        System.out.print("Sorted array: "+Arrays.toString(n)+'\n');
        Arrays.sort(n, Collections.reverseOrder());
        System.out.print("Inverse sorted array: "+Arrays.toString(n));
	}
}
