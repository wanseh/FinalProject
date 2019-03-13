import java.util.Scanner;
import java.io.*;
public class MoneyTransfer{
	public static void main(String[] args) throws IOException{
		
		Queue q = new Queue();
		/*Scanner in = new Scanner(new File("database.txt"));
		PrintWriter out = null;
		while(in.hasNextLine()){
			q.Add(in.nextLine());		
		}
		while(in.hasNextFloat()){
			q.AddBal(in.nextFloat());		
		}*/
		Scanner input = new Scanner(System.in);
		//Scanner add = new Scanner(System.in);
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
			menu();
			linethingy();
			
	
		potato = input.nextInt();
		
		
			switch(potato){
				case 0: repeater = false;
						//out = new PrintWriter("database.txt");
						//while(q.head != null){
						//	out.println(q.head.name);
						//	q.head = q.head.link;
						//}
						//out.close();
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
						
			}
		}
	}
	public static void linethingy(){
			System.out.println("---------------------------------------");
		}
	public static void menu(){
			System.out.println("0 - Exit Program");
			System.out.println("1 - Close Current Account");
			System.out.println("2 - Register New User");
			System.out.println("3 - Change User");
			System.out.println("4 - Send Money");
			System.out.println("5 - Display All Existing Users");
			System.out.println("6 - Logs");
	}
}
