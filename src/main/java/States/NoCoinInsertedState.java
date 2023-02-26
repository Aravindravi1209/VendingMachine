package States;

import VendingMachine.VendingMachine;

public class NoCoinInsertedState implements State{
     VendingMachine vendingMachine;
     public NoCoinInsertedState(VendingMachine vendingMachine)
     {
         this.vendingMachine=vendingMachine;
     }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(amount);
        vendingMachine.setCurVendingMachineState(vendingMachine.getCoinInsertedState());
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("No coin is inserted!!!");
    }

    @Override
    public void dispense(int aisleNumber) {
        throw new IllegalStateException("No coin is inserted!!!");
    }
}
