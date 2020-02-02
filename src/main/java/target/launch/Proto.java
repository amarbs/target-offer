package target.launch;

import target.model.DealsNode;

public class Proto {
  public static void main(String[] args) {
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
    DealsNode newBorn = new DealsNode("New Born");
    boys.addChild(newBorn);
    //New Born
    newBorn.addChild(item1);

    System.out.println("Item1 discount: " + item1.finalDiscout());
  }
}
