import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
class Lab6Program1
{
    private static int sum;
    private static int result;
    private static int[] coins;
    private static CountDownLatch c1 = new CountDownLatch(1);
    private static int coin(int[] coins, int sum) {
        return count(coins, coins.length, sum);
    }
    private static int count(int[] coins, int length , int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || length <= 0) {
            return 0;
        }
        return count(coins, length, sum - coins[length - 1]) + count(coins, length - 1, sum);
    }
        public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a=0;
        do{
        Thread t1 = new Thread(()->
        {
        System.out.println("Enter the Sum");
        sum = sc.nextInt();
        System.out.println("Enter the number of coins");
        int n = sc.nextInt();
        coins=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the value for coint "+(i+1)+":");
            coins[i] = sc.nextInt();
        }
        c1.countDown();
    });
        Thread t2 = new Thread(()->
        {
            try {
                c1.await(); // Wait for initialization to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        result = coin(coins,sum);
    });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("There are " + result + " ways");
        System.out.println("Do you want to:1.Continue 2.Exit");
        a=sc.nextInt();
    }while(a!=2);
    System.out.println("Thank you");
    }
}