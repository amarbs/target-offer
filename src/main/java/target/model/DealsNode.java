package target.model;

import java.util.Set;

public class DealsNode {
  public DealsNode(String name) {
    this.name = name;
  }

  public DealsNode(String name, int assignedDiscount) {
    this.assignedDiscount = assignedDiscount;
    this.name = name;
  }

  private Set<DealsNode> parents;

  public Set<DealsNode> getParents() {
    return parents;
  }

  public void setParents(Set<DealsNode> parents) {
    this.parents = parents;
  }

  private int assignedDiscount;

  public int getAssignedDiscount() {
    return assignedDiscount;
  }

  public void setAssignedDiscount(int assignedDiscount) {
    this.assignedDiscount = assignedDiscount;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addChild(DealsNode child) {
    //TODO
  }

  public int finalDiscout() {
    //TODO
    return 0;
  }
}
