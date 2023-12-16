import java.util.*;
abstract class Robber{
	void RobbingClass(){
		System.out.println("MScAI&ML");
	}
	Robber(){
		System.out.println("I love MachineLearning.");
	}
	abstract int RowHouses(int a[]);
	abstract int RoundHouses(int a[]);
	abstract int SquareHouse(int a[]);
	abstract int MultiHouse(int a[]);
}
class JAVAProfessionalRobber extends Robber{
	int RowHouses(int a[]){
		int max[]=new int[3];
		max[0]=a[0]+a[2];//adding 1st and 3rd
		max[1]=a[1]+a[3];//adding 2nd and 4th
		max[2]=a[0]+a[3];//adding 1st and 4th
		int maxi=0;
		for(int i=0;i<3;i++){
			if(maxi<max[i]){
				maxi=max[i];
			}
		}
		return maxi;
	}
	int RoundHouses(int a[]){
		int left=0,right=0;
		for(int i=0;i<a.length;i++){
			if(i%2==0){
				left+=a[i];//adding even places
			}
			else{
				right+=a[i];//adding odd places
			}
		}
		if(left>right){
			return left;
		}
		else{
			return right;
		}
	}
	int SquareHouse(int a[]){
		int left=0,right=0;
		for(int i=0;i<a.length;i++){
			if(i%2==0){
				left+=a[i];//adding even places
			}
			else{
				right+=a[i];//adding odd places
			}
		}
		if(left>right){
			return left;
		}
		else{
			return right;
		}
	}
	int MultiHouse(int a[]){
		int max[]=new int[4];
		int maxi=0;
		max[0]=a[0]+a[3];//adding 1st and 4th
		max[1]=a[0]+a[2]+a[4];//adding odd places
		max[2]=a[1]+a[3]+a[5];//adding even places
		max[3]=a[2]+a[5];//adding 3rd and 6th
		for(int i=0;i<4;i++){
			if(maxi<max[i]){
				maxi=max[i];
			}
		}
		return maxi;
	}
}
class Lab4{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=0,max=0;
		JAVAProfessionalRobber obj=new JAVAProfessionalRobber();
		int array[]=new int[6];
		do
		{
			System.out.println("Choose a housing type:\n1.Row House\n2.Square House\n3.Circle House\n4.Multi House");
			int b=sc.nextInt();
			if(b!=4){//first 3 cases need 4 houses
				for(int i=0;i<4;i++){
					System.out.println("Enter amount in house "+(i+1));
					array[i]=sc.nextInt();
				}
			}
			else{//last case needs 6 houses
				for(int i=0;i<6;i++){
					System.out.println("Enter amount in house "+(i+1));
					array[i]=sc.nextInt();
				}
			}
			switch(b){
				case 1: max=obj.RowHouses(array);
						break;
				case 2: max=obj.SquareHouse(array);
						break;
				case 3: max=obj.RoundHouses(array);
						break;
				case 4: max=obj.MultiHouse(array);
						break;
				default: System.out.println("Invalid Choice!");
			}
			System.out.println("Profit="+max);
			System.out.println("Do you want to Rob again:\n1.Yes\n2.No");
			a=sc.nextInt();
		}while(a!=2);
		System.out.println("Good");
	}
}