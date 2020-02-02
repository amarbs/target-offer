package target.model;

import java.util.HashSet;
import java.util.Set;

public class DealsNode {
  public DealsNode(String name) {
    this.name = name;
  }

  public DealsNode(String name, int assignedDiscount) {
    this.assignedDiscount = assignedDiscount;
    this.name = name;
  }

  private int inhertiedDiscount = 0;

  private Set<DealsNode> parents = new HashSet<DealsNode>();

  private Set<DealsNode> getParents() {
    return parents;
  }

  private void setParents(Set<DealsNode> parents) {
    this.parents = parents;
  }

  private Set<DealsNode> children = new HashSet<DealsNode>();

  private int assignedDiscount;

  private int getAssignedDiscount() {
    return assignedDiscount;
  }

  //TODO - for now cannot change assigned discount.
  private void setAssignedDiscount(int assignedDiscount) {
    this.assignedDiscount = assignedDiscount;
    //TODO propogate to descendents
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addChild(DealsNode child) {
    if(! children.contains(child)) {
      children.add(child);
      child.addParent(this);
    }
  }

  private void addParent(DealsNode parent) {
    //TODO For now assume parent is not added when child present.
    assert children.isEmpty();
    if (!parents.contains(parent)) {
      inhertiedDiscount += parent.finalDiscount();
      parents.add(parent);
      // TODO propogate to descendents
    }
  }

  public int finalDiscount() {
    return assignedDiscount + inhertiedDiscount;
  }
}
