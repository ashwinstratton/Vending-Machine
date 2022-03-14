
package vendingmachine;

/**
 *
 * @author ashwi
 */


public abstract class CandyVendingMachine implements ICandyVendingMachine{

//data members declare
private Candy [] items; // for candy items
private char [] options;// option names
private int [] qty; // qualtity for corresponding candy
private char choose; // user choose
private double curAmount; // current amout
private boolean status;// if need to add true , if no false
// default constructor
// initialize
public CandyVendingMachine(){
this.items=new Candy[4];
this.qty=new int[4];
this.options=new char[4];
for(int i=0;i<4;i++){
this.items[i]=null;
this.qty[i]=5;
this.options[i]=(char)('A'+i);
}
this.curAmount=0;
this.status=false;
this.choose='N';
}
// add name and price
public void init(){
this.items[0]=new Candy("Skittles",4.20);
this.items[1]=new Candy("Snickers",1.42);
this.items[2]=new Candy("M & M’s",42.42);
this.items[3]=new Candy("Darth Vader",00.00);
}

// taking money from users
public void TakeMoney(double amount) {
this.curAmount+=amount;
// if not sufficient fund for buy
if(this.checkAmount(this.curAmount,this.getIndex(choose))){
System.out.println("\nInsufficient funds");
this.status=true;
}
// got sufficient fund
else{
System.out.println("\nSufficient funds , Thank you");
this.status=false;
}
// if sufficient return process;
if(this.status==false){
this.ReturnMoney(this.curAmount);
}
}
// set status
// when transaction close
// then need to set
public void setStatus(boolean b){
this.status=b;
}

// current index of user choice
public int getIndex(char c){
int ret=-1;
for(int i=0;i<4;i++){
if(this.options[i]==c){
ret=i;
this.choose=c;
}
}
return(ret);
}
// return money
public void ReturnMoney(double amount) {
// get Candy
Candy tmpCndy=this.VendItem(choose);
System.out.printf("Your returned amount is : $%.2f\n",(amount-tmpCndy.getPrice()));
// after returning
// all set
this.curAmount=0;
this.choose='N';
// already status set to false
System.out.println("\n"+tmpCndy.getName()+" Item you have purchashed.");
}

// get vending item
// when confirm
// then call
public Candy VendItem(char slotCode) {
int tmpID=this.getIndex(slotCode);
if(tmpID==-1){
return null;
}
else{
// quantity is reducing by 1
this.qty[tmpID]--;
return(this.items[tmpID]);
}
}
public String GetMachineInfo() {
return("\nChoose List , after Selecting add amount, if it is not sufficient ADD mor money od close transaction .If money is sufficient then show the purchasged information.");
}

// display
public String DisplayContents() {
String ret="";
for(int i=0;i<4;i++){
// if there is no qualtity ,would not display in list
if(this.qty[i]==0){
ret+="\n"+this.items[i].getName()+" is not avalible now";
}
else{
ret+="\n"+this.options[i]+") "+this.items[i].getName()+" ("+this.qty[i]+") - $"+this.items[i].getPrice();
}
}
ret+="\nS) Stop : ";
return(ret);
}
public boolean checkAmount(double a,int i){
// check sufficient balance
if(this.items[i].getPrice()>=a){
return true;
}
return false;
}
// set user choice;
public boolean userChoice(char c){
for(int i=0;i<4;i++){
if(this.options[i]==c){
this.choose=c;
return true;
}
}
if(c=='S'){
return false;
}
return true;
}
// current status
public boolean getStatus(){return(this.status);}
public double getAmount(){return(this.curAmount);}
public void setAmount(){this.curAmount=0;}
}
