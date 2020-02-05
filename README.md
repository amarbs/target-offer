# Promotions Evaluation

Amarnath B S <amarbs@gmail.com>

## Use-cases

1) Input an example model - Supported attributes:  name, assigned-discount.
2) Add child-categories.
3) Add items.
4) Modify assigned-discount.
5) Modify a category by adding or removing a parent category.

## Brief Design and Current Progress

### Model & Algorithm

* Every category/item represented as a DealsNode Java object.
* Every DealsNode has a set of parent DealsNodes and set of child DealsNodes.
* At node creation or modification time, the inherited discount is calculated.
  * Modification include parent addition/deletion, child addition/deletion
  * Recursion based DFS traversal (tree is shallow with 4 levels) is used to compute inherited discount.
  * Category or Item creation or modification is rare and hence computation is preferrable then.
  * Discount fetch becomes a constant time operation.
* Unit Tests to test the different use-cases.

### API - *TBD*

* A gRPC based interface is planned with Java implementation
  * Provides language agnostic interface.
  * Efficient transport and payload encoding.
  * Ease of programming.
  
 ### Deployment - *TBD*
 * A docker container is preferred.
 * A helm chart describing the deployment.
 
 ### Scalability - *TBD*
 * The DealsNode tree itself could be stored in a distributed cache like Redis.
 * DealsNode tree modifications concurrency control could be achieved using Redis transactions or [Redlock](https://redis.io/topics/distlock)
 
