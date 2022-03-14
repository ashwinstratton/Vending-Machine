
package vendingmachine;

/**
 *
 * @author ashwi
 */
import java.util.Scanner;

public class Driver {

public static void main(String[] args) {

// for input
Scanner sc=new Scanner(System.in);
CandyVendingMachine cvm=new CandyVendingMachine() {
    @Override
    public Object VendItem(String slotCode) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
};
cvm.init(); // Initialize

for(;;){
System.out.println(cvm.DisplayContents());
System.out.print("\n Enter your Choice ; ");

// user input
String choice=sc.next();

// if stop break loop
if(choice.charAt(0)=='S'){
break;
}
// set user choice
cvm.userChoice(choice.charAt(0));
String c="X";
double amount=0;
for(;;){
// enter amount
System.out.print("\n Enter amount ; $");
amount=sc.nextDouble();
cvm.TakeMoney(amount);
// if insufficient bvalance
if(cvm.getStatus()){
System.out.println("\nA)ADD amount\nB)Stop Transaction; ");
c=sc.next();
// fore wrong choice
if(c.charAt(0)!='A' && c.charAt(0)!='B'){
for(;;){
System.out.println("\nWrong Choice");
System.out.println("\nA)ADD amount\nB)Stop Transaction; ");
c=sc.next();
if(c.charAt(0)=='A' || c.charAt(0)=='B'){
break;
}
}
}
// if transaction break;
if(c.charAt(0)=='B'){
break;
}
}
// if sufficient balance , break loop
else{
break;
}
}
if(c.charAt(0)=='B'){
// return money
System.out.printf("\nTake money $%.2f",cvm.getAmount());
// set again
cvm.setAmount();
cvm.setStatus(false);
}
}
}
}