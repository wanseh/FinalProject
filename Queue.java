import java.util.Scanner;

public class Queue
{
  public Node head;
  public Node tail;
  public int size;
	Scanner input = new Scanner(System.in);
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
	AddToLog("Registered new user " + head.name );
	
  	this.size++;
  }
	//Deletes the current user
  public void DelCurUser()
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
	  AddNameBal(head.name, head.bal);
	  DelCurUser();
	}
	public void SendMoney(){
		System.out.println("How much money would you like to send?");
		float amount = input.nextFloat();
		float fee = amount*0.01f;
		float cost = amount + fee;
		if(amount > head.bal){
			System.out.println("Insufficient Funds");
		}
		else{
			
			System.out.println("Send to");
			head.bal = head.bal - cost;
			ChangeUser();
			System.out.println("Sending "+ amount +" will incur a " + fee + " fee. Continue?");
			promptEnterKey();
			head.bal = head.bal + amount;
			AddToLog("Recieved Money from " + tail.name);
		}
	}
	public void AddToLog(String act){
		head.Log = tail.name;
		head.LogBal = tail.bal;
		head.Action = act;

	}
	public void ViewLog(){
		Node pointer;
		pointer = this.head;
		if(head != null){
			for(int i = 0; pointer != null; i++){
				System.out.println(pointer.Action);
				System.out.println(pointer.Log);
				System.out.println(pointer.LogBal);
				pointer = pointer.link;
			}
		}
		else{
		System.out.println("No logs to display.");
		}
  }
	public static void promptEnterKey(){
		System.out.println("Press ENTER to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}
