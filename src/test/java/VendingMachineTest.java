import Homework14.VendingMachine;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
    }
    @Test
    public void testAddItem() {
        vendingMachine.addItem("Ararat", 20);
        vendingMachine.addItem("Aram", 25);
        vendingMachine.addItem("Karen", 30);
        vendingMachine.addItem("Arman", 35);
        vendingMachine.addItem("Artashat", 40);
        vendingMachine.addItem("Stepanakert", 45);
        vendingMachine.addItem("aaaaa", 50);
        vendingMachine.addItem("bbbbb", 55);
        vendingMachine.addItem("ccccc", 60);
        vendingMachine.addItem("ddddd", 65);
    }
    @Test
    public void testRemoveItem() {
        vendingMachine.removeItem("Ararat");
    }

    @Test
    public void testGetItemCount() {
        vendingMachine.getItemCount("Aram");
    }

    @Test
    public void testGetTotalItemCount() {
        vendingMachine.getTotalItemCount();
    }

    @Test
    public void testIsItemAvailable() {
        vendingMachine.isItemAvailable("Aram");
    }
}
