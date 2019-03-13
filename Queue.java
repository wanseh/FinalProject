import java.util.Scanner;
import java.io.*;
public class Queue
{
  public Node head;
  public Node tail;
  public int size;
  static Scanner input = new Scanner(System.in);
  static String[] namelog = new String[100];
  static String[] actionlog = new String[100];
  static float[] balancelog = new float[100];
  static String[] namelogcopy = new String[100];
  static String[] actionlogcopy = new String[100];
  static float[] balancelogcopy = new float[100];
  static int counter = 0;
  public Queue()
  {
    this.head = null;
    this.tail = null;
    this.size = 0;
	
  }
    public void Add(String input){
  	Node newNode = new Node();
    newNode.name = input;
  	if(head == null)
    {
      head = newNode;
      tail = newNode;
    }
    else
    {
      newNode.link = null;
      tail.link = newNode;
      tail = newNode;
    }
  	this.size++;
  }
    public void AddNameBal(String input, float balance){
  	Node newNode = new Node();
    newNode.name = input;
	newNode.bal = balance;
  	if(head == null)
    {
      head = newNode;
      tail = newNode;
    }
    else
    {
      newNode.link = null;
      tail.link = newNode;
      tail = newNode;
    }
	counter++;
	AddToLog(tail.name, tail.bal, "Registered user");
	
  	this.size++;
  }
    public void AddNameBalA(String input, float balance){
  	Node newNode = new Node();
    newNode.name = input;
	newNode.bal = balance;
  	if(head == null)
    {
      head = newNode;
      tail = newNode;
    }
    else
    {
      newNode.link = null;
      tail.link = newNode;
      tail = newNode;
    }
	
  	this.size++;
  }
	//Deletes the current user
  public void DelCurUser()
  {
	counter++;
	AddToLog(head.name, head.bal, "Deleted account");
    if(head == null)
    {
      System.out.println("---------------------------------------");
      System.out.println("No existing users.");
    }
    else
    {
      head = head.link;
      this.size--;
    }

  }
  public void DelCurUserA()
  {
    if(head == null)
    {
      System.out.println("---------------------------------------");
      System.out.println("No existing users.");
    }
    else
    {
      head = head.link;
      this.size--;
    }

  }
  //Displays contents of the list
  public void Display()
  {
    Node discurrent;
    discurrent = this.head;
    if(head != null)
    {
      for(int i = 0; discurrent != null; i++)
      {
        System.out.println(i + " - " + discurrent.name);
		System.out.println("    " + discurrent.bal);
        discurrent = discurrent.link;
      }
    }
    else
    {
      System.out.println("There are no users.");
    }
  }
  
	public void ChangeUser(){
	  Scanner input = new Scanner(System.in);
		if(head != null){
			System.out.println("Select a user:");
			Display();
			int choice = input.nextInt();
			if(choice == 0){
				System.out.println("Already logged in as this user.");
			}
			else{
			for(int i = 0;i < choice;i++){
				backoftheline();
			}
			}
		}
		else{
			System.out.println("There are no users");
		}
  }
	public void backoftheline(){
	  AddNameBalA(head.name, head.bal);
	  DelCurUserA();
	}
	public void SendMoney(){
		System.out.println("How much money would you like to send?");
		float amount = input.nextFloat();
		float fee = amount*0.01f;
		float cost = amount + fee;
		System.out.println("Sending "+ amount +" will incur a " + fee + " fee. Continue?");
		promptEnterKey();
		if(cost > head.bal){
			System.out.println("Insufficient Funds");
		}
		else{
			System.out.println("Send to");
			head.bal = head.bal - cost;
			ChangeUser();
			promptEnterKey();
			head.bal = head.bal + amount;
		}
		counter++;
		AddToLog(tail.name, amount, "Sent Money");
		counter++;
		AddToLog(head.name, amount, "Recieved Money");
	}
	public void AddToLog(String name, float balance, String Action){
		namelog[counter]=name;
		actionlog[counter]=Action;
		balancelog[counter]=balance;
	}
	public void ViewLog(){
		System.out.println("Total logs: "+counter);
			for(int i = 1;i <= counter ; i++){
				System.out.println(actionlog[i]);
				System.out.println(namelog[i]);
				System.out.println(balancelog[i]);
			}
  }
	public static void Search(){
		System.out.println("Search by name: *case sensitive*");
		String searchVal = input.nextLine();
		for(int i = 0; i < 100 ;i++){
			if((searchVal).equals(namelog[i])){
				System.out.println(actionlog[i]);
				System.out.println(namelog[i]);
				System.out.println(balancelog[i]);
			}
		}
	}
	public static void ViewLogSortedAsc(){
		System.arraycopy(balancelog,0,balancelogcopy,0,balancelog.length);
		System.arraycopy(namelog,0,namelogcopy,0,namelog.length);
		System.arraycopy(actionlog,0,actionlogcopy,0,actionlog.length);
		System.out.print(actionlogcopy[1]);
		for(int x = 0;x <= counter ;x++){
			for(int y = x+1; y <= counter ;y++){
				if(balancelogcopy[x]>balancelogcopy[y]){
					float temp=balancelogcopy[y];
					String tempA=namelogcopy[y];
					String tempB=actionlogcopy[y];
						balancelogcopy[y]=balancelogcopy[x];
						namelogcopy[y]=namelogcopy[x];
						actionlogcopy[y]=actionlogcopy[x];
						balancelogcopy[x]=temp;
						namelogcopy[x]=tempA;
						actionlogcopy[x]=tempB;
				}
			}
		}
		System.out.println("Total logs: "+counter);
			for(int i = 1;i <= counter ; i++){
				System.out.println(actionlogcopy[i]);
				System.out.println(namelogcopy[i]);
				System.out.println(balancelogcopy[i]);
			}		
	}

	public static void promptEnterKey(){
		System.out.println("Press ENTER to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}
