import java.util.*;
class Lab2Program2{
	static int maxProfit=0;
	static void findMaxProfit(int array[]){
		maxProfit=0;
		int buy1=array[0];
		int sell1=0;
		int buy2=array[2];
		int sell2=0;
		int flag=0;
		for(int i=2;i<array.length;i++){
			if(array[i]<=buy2){
				buy2=array[i];
				flag=i;
			}
		}
		for(int j=1;j<flag;j++){
			if(array[j]>sell1){
				sell1=array[j];
			}
		}
		for(int k=flag+1;k<array.length;k++){
			if(array[k]>sell2){
				sell2=array[k];
			}
		}
		if(buy1>sell1||buy2>sell2){
			maxProfit=0;
			sell1=0;
			for (int l=1;l<array.length;l++) {
				if(array[l]>sell1){
					sell1=array[l];
				}
			}
			maxProfit=sell1-buy1;
		}
		else{
			maxProfit=(sell1-buy1)+(sell2-buy2);
		}
		System.out.println("Profit="+maxProfit);
	}
	public static void main(String[] args) {
		int x=0;
		int a=0;
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("Enter the number of elements");
			do{
				while(!sc.hasNextInt()){
					String input=sc.next();
					System.out.printf("\"%s\" is not a positive number.\n", input);
				}
				a=sc.nextInt();
			}while(a<=0);
			int array[]=new int[a];
			for(int i=0;i<a;i++){
				int k=i+1;
				System.out.println("Enter element number "+k);
				do{
					while(!sc.hasNextInt()){
						String input=sc.next();
						System.out.printf("\"%s\" is not a positive number.\n", input);
					}
					array[i]=sc.nextInt();
				}while(array[i]<0);
			}
			findMaxProfit(array);
			System.out.println("Do you want to play again:\n1.Yes\n2.No");
			x=sc.nextInt();
		}while(x!=2);
		System.out.println("Thank You");
	}
}
