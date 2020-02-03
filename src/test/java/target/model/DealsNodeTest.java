package target.model;

import junit.framework.TestCase;

public class DealsNodeTest extends TestCase {
  public void testNormal() {
    DealsNode babyRoot = new DealsNode("Baby");
    //Baby
    DealsNode bestDeals = new DealsNode("Best Deals", 3);
    babyRoot.addChild(bestDeals);
    DealsNode toys = new DealsNode("Toys", 10);
    babyRoot.addChild(toys);
    //Best Deals
    DealsNode item1 = new DealsNode("item1");
    bestDeals.addChild(item1);
    //Toys
    DealsNode boys = new DealsNode("Boys", 5);
    toys.addChild(boys);
    //Boys
    DealsNode newBorn = new DealsNode("New Born", 2);
    boys.addChild(newBorn);
    //New Born
    newBorn.addChild(item1);
    DealsNode item2 = new DealsNode("item2");
    newBorn.addChild(item2);
    //5_10
    DealsNode five10 = new DealsNode("5-10");
    boys.addChild(five10);
    DealsNode item3 = new DealsNode("Item3");
    five10.addChild(item3);

    int item1Dis = item1.finalDiscount();
    System.out.println("Item1 discount: " + item1Dis);
    assertEquals(20, item1Dis);
    int item2Dis = item2.finalDiscount();
    System.out.println("Item2 discount: " + item2Dis);
    assertEquals(17, item2Dis);
    int item3Dis = item3.finalDiscount();
    System.out.println("Item3 discount: " + item3Dis);
    assertEquals(15, item3Dis);
  }

  public void testAssignedModify() {
    DealsNode babyRoot = new DealsNode("Baby");
    //Baby
    DealsNode bestDeals = new DealsNode("Best Deals", 3);
    babyRoot.addChild(bestDeals);
    DealsNode toys = new DealsNode("Toys", 10);
    babyRoot.addChild(toys);
    //Best Deals
    DealsNode item1 = new DealsNode("item1");
    bestDeals.addChild(item1);
    //Toys
    DealsNode boys = new DealsNode("Boys", 5);
    toys.addChild(boys);
    //Boys
    DealsNode newBorn = new DealsNode("New Born", 2);
    boys.addChild(newBorn);
    //New Born
    newBorn.addChild(item1);
    DealsNode item2 = new DealsNode("item2");
    newBorn.addChild(item2);
    //5_10
    DealsNode five10 = new DealsNode("5-10");
    boys.addChild(five10);
    DealsNode item3 = new DealsNode("Item3");
    five10.addChild(item3);

    boys.setAssignedDiscount(6);

    int item1Dis = item1.finalDiscount();
    System.out.println("Item1 discount: " + item1Dis);
    assertEquals(21, item1Dis);
    int item2Dis = item2.finalDiscount();
    System.out.println("Item2 discount: " + item2Dis);
    assertEquals(18, item2Dis);
    int item3Dis = item3.finalDiscount();
    System.out.println("Item3 discount: " + item3Dis);
    assertEquals(16, item3Dis);
  }
}
