package States;

import Inventory.Inventory;
import Inventory.Product;
import VendingMachine.VendingMachine;

import java.util.PriorityQueue;

public class DispenseState implements State{
    VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine)
    {
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Product getting dispensed!!!");
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("Product getting dispensed!!!");
    }

    @Override
    public void dispense(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProductAt(aisleNumber);
        inventory.deductProductCount(aisleNumber);
        double change = vendingMachine.getAmount()-product.getPrice();
        vendingMachine.setAmount(0);
        vendingMachine.setCurVendingMachineState(vendingMachine.getNoCoinInsertedState());
        System.out.println("Product with id "+product.getId()+" is getting dispensed. Please collect your change of "+change);
    }
}
