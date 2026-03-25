import java.util.*;

abstract class account{
  long accno;
  String name;
  String branch;
  String ifsc;
  long phno;
  double bal;
  account(long accno, String name , String branch, String ifsc , long phno, double bal){
    this.accno=accno;
    this.name=name;
    this.branch=branch;
    this.ifsc=ifsc;
    this.phno=phno;
    this.bal=bal;
  }

abstract void deposit(double amt);
abstract void withdraw(double amt);
abstract void transfer(long accno, String branch, String ifsc);
abstract void details();
}
class bank extends account{
  bank(long accno, String name , String branch, String ifsc , long phno, double bal){
    super(accno,name,branch,ifsc,phno,bal);
  }
  @Override
  public void deposit(double amt)
  {
    bal+=amt;
    System.out.println("Balance: "+bal);
  }
  @Override
  public void withdraw(double amt)
  {
    if(amt<=bal)
    {
      bal-=amt;
      System.out.println("Balance: "+bal);
    }
    else
    System.out.println("Insufficient Balance");
  }
  @Override
  public void transfer(long accno, String branch, String ifsc)
  {
    System.out.println("!Account Transfered!");
    System.out.println("Account no: "+accno);
    System.out.println("Branch: "+branch);
    System.out.println("IFSC code: "+ifsc);
  }
  @Override
  public void details()
  {
        System.out.println("Account Number: "+accno);
        System.out.println("Name: "+name);
        System.out.println("Branch: "+branch);
        System.out.println("IFSC Code: "+ifsc);
        System.out.println("Phone Number: "+phno);
        System.out.println("Balance: "+bal);
  }
}
public class Main{
  public static void main(String args[])
  {
    Scanner in =new Scanner (System.in);
    Boolean as=true;
          bank b1= new bank(45263747,"April","SBI","SBI782297",4837695,70000.70);

    while(as){
      System.out.println("Enter Ur Choice: ");
      System.out.println("1.Deposit \n2.Withdraw \n3.Transfer Account to Another Bank \n4.Show Account Details \n5.Exit");
      int a=in.nextInt();

      switch(a)
    {
      case 1: 
        System.out.println("Enter Amount to be Deposited: ");
        int amt=in.nextInt();
        b1.deposit(amt);
        break;
      case 2:
        System.out.println("Enter Amount to be withdraw: ");
        amt=in.nextInt();
        b1.withdraw(amt);
        break;
      case 3:
        System.out.println("Enter Account to be transfered: ");
        int accno1=in.nextInt();
        String branch1=in.next();
        String ifsc1=in.next();
        
        b1.accno=accno1;
        b1.branch=branch1;
        b1.ifsc=ifsc1;
        
        b1.transfer(accno1,branch1,ifsc1);
        break;
      case 4:
        b1.details();
        break;
      case 5:
        System.out.println("!Exit!");
        as=false;
        break;
      default:
      System.out.println("Invalid Choice!!");
      as=false;
      break;
    }
  }
}
}