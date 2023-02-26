package Driver;

import Inventory.Product;
import VendingMachine.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Product hersheys = new Product("hersheys",1,5.0);

        for(int i=1;i<=3;i++)
        {
            vendingMachine.addProduct(hersheys);
        }

        Product biskFarm = new Product("biskFarm",2,2.0);
        for(int i=1;i<=3;i++)
        {
            vendingMachine.addProduct(biskFarm);
        }
//          throws exception as out of space
//        Product Mazza = new Product("Mazza",2,10.0);
//        for(int i=1;i<=3;i++)
//        {
//            vendingMachine.addProduct(Mazza);
//        }

        vendingMachine.insertCoin(5.0);
        vendingMachine.insertCoin(3.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(5.0);
        vendingMachine.pressButton(1);
        vendingMachine.insertCoin(7.0);
        vendingMachine.pressButton(2);
    }
}
