/**
*		Names: DJ Renzo Emmanuel Bince
*			   Sheil Ann Ashely Bruas
*			   Lance Parantar
*
*		Section CC12/CC13 - CCA
*		Money Transfer Program
*
*/
import java.util.Scanner;
import java.io.*;
public class MoneyTransfer{
	public static void main(String[] args) throws IOException{
		
		Queue q = new Queue();
		Scanner input = new Scanner(System.in);
		boolean repeater = true;
		int potato = 0;
		while(repeater){
			linethingy();
			System.out.print("Current User:");
				if(q.head == null){
					System.out.println("None");
				}
				else{
					System.out.println(q.head.name);
					System.out.print("Balance:");
					System.out.println(q.head.bal);
				}
			linethingy();
			System.out.println("0 - Exit Program");
			System.out.println("1 - Close Current Account");
			System.out.println("2 - Register New User");
			System.out.println("3 - Change User");
			System.out.println("4 - Send Money");
			System.out.println("5 - Display All Existing Users");
			System.out.println("6 - Logs");
			System.out.println("7 - Sort Logs");
			System.out.println("8 - Search Logs");
			linethingy();
			
	
		potato = input.nextInt();
		
		
			switch(potato){
				case 0: repeater = false;
						break;
				case 1: linethingy();
						q.DelCurUser();
						break;
				case 2: linethingy();
						System.out.println("Enter Name: ");
						String addname = input.next();
						System.out.println("Enter starting balance: ");
						float balance = input.nextFloat();
						q.AddNameBal(addname, balance);
						break;
				case 3:linethingy();
						q.ChangeUser();
						break;
				case 4:linethingy();
						q.SendMoney();
						break;
				case 5:linethingy();
						q.Display();
						break;
				case 6:linethingy();
						q.ViewLog();
						break;
				case 7:linethingy();
						q.ViewLogSortedAsc();
						break;
				case 8:linethingy();
						q.Search();
						break;
			}
		}
	}
	public static void linethingy(){
			System.out.println("---------------------------------------");
		}
}
