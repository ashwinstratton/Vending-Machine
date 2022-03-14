
package vendingmachine;

/**
 *
 * @author ashwi
 */

// Getters and Setters

public class Candy {
private String name;
private double price;
public Candy(){
this.name="";
this.price=0;
}
// Name and Price of Candy
public Candy (String a,double b){
this.name=a;
this.price=b;
}
public void setName(String a){this.name=a;}
public void setPrice(double a){this.price=a;}
public String getName(){return(this.name);}
public double getPrice(){return(this.price);}
}