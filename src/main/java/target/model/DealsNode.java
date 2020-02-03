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

  public void setAssignedDiscount(int assignedDiscount) {
    int prevFinDisc = finalDiscount();
    this.assignedDiscount = assignedDiscount;
    for (DealsNode child: children) {
      child.updateInherited(prevFinDisc, this);
    }
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
      parents.add(parent);
      //since parent in newly added, preview inherited discount from this parent is 0
      updateInherited(0, parent);
    }
  }

  private void updateInherited(int parentPreviousFinDisc, DealsNode parent) {
    int prevFinDisc = finalDiscount();
    inhertiedDiscount -= parentPreviousFinDisc;
    inhertiedDiscount += parent.finalDiscount();
    for (DealsNode child: children) {
      child.updateInherited(prevFinDisc, this);
    }
  }

  public int finalDiscount() {
    return assignedDiscount + inhertiedDiscount;
  }
}
