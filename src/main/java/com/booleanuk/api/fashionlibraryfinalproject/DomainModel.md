# Basket

| US | Members             | Method                             | scenario                                                  | Outcome/Output                                                                     |
|----|---------------------|------------------------------------|-----------------------------------------------------------|------------------------------------------------------------------------------------|
|    | List<ItemInterface> |                                    |                                                           |                                                                                    |
|    | double totalPrice   |                                    |                                                           |                                                                                    |
|    | double discountBuy  |                                    |                                                           |                                                                                    |
|    | double borrowPrice  |                                    |                                                           |                                                                                    |
|    |                     | basket( Inventory inventory)       |                                                           |                                                                                    |
|    |                     | boolean addItem (String itemId)    | Items are successfully added to your basket               | Return true.                                                                       |
|    |                     |                                    | Items not successfully added to your basket               |                                                                                    |
|    |                     | boolean removeItem (String itemId) | Item removed successfully from the basket.                | Return true.                                                                       |
|    |                     |                                    | Item not removed because it does not exist in the basket. | Print message stating that the item does not exist in the basket and return false. |
|    |                     | boolean updateStock                | Stock successfully updated.                               |                                                                                    |


# Inventory

| US | Members                                 | Method                                            | scenario                                                  | Outcome/Output                                                            |
|----|-----------------------------------------|---------------------------------------------------|-----------------------------------------------------------|---------------------------------------------------------------------------|
|    | List<ItemInterface> itemArrayList       |                                                   |                                                           |                                                                           |
|    | HashMap<String, ItemInterface> allItems |                                                   |                                                           |                                                                           |
|    |                                         | Inventory (ArrayList<ItemInterface>itemArrayList) |                                                           |                                                                           |
|    |                                         | ItemInterface searchItem (String, itemId)         | Item exists                                               | Returns true.                                                             |
|    |                                         |                                                   | Item does not exist                                       | Prints a message stating that the item does not exist and returns false.  |

# ItemInterface

| US | Members  | Method     |
|----|----------|------------|
|    | Pants    |            |
|    | Skirts   |            |
|    | Dresses  |            |
|    | Tshirts  |            |
|    | PullOver |            |
|    | Jackets  |            |
|    |          | Getter     |
|    |          | Setter     |
|    |          | toString() |

# Manager

| US | Members             | Method                          | scenario                                                   | Outcome/Output                                                                       |
|----|---------------------|---------------------------------|------------------------------------------------------------|--------------------------------------------------------------------------------------|
|    | List<ItemInterface> |                                 |                                                            |                                                                                      |
|    | Inventory??         | boolean addItemToLibrary()      | Items are successfully added to the library.               | Return true                                                                          |
|    |                     |                                 | Item not successfully added to library                     | Print message stating basket is full and return false.                               |
|    |                     | boolean removeItemFromLibrary() | Item removed successfully from the library.                | Return true                                                                          |
|    |                     |                                 | Item not removed because it does not exist in the library. | Print message stating that the bagel does not exist in the library and return false. |
|    |                     | updateStockFromLibrary()        |                                                            | Return true                                                                          |



# Members

| US | Members                  | Method                           | scenario                   | Outcome/Output      |
|----|--------------------------|----------------------------------|----------------------------|---------------------|
|    | List<ItemInterface>      |                                  |                            |                     |
|    | double totalBorrowPrice  |                                  |                            |                     |
|    | double discountBuy       |                                  |                            |                     |
|    | double borrowPricePerDay |                                  |                            |                     |
|    | String searchItemById    |                                  |                            |                     |
|    |                          | getAll()                         |                            |                     |
|    |                          | getItemById()                    |                            |                     |
|    |                          | filterItemByCategory()           |                            |                     |
|    |                          | double totalCostBorrowedItems()  | The basket is empty        | Return 0.0          |
|    |                          |                                  | The basket contains items. | Return total costs. |
|    |                          | double borrowPricePerDay()       |                            |                     |
|    |                          | String returnDateTime(createdAt) |                            |                     |
|    |                          | int daysBorrowedItem             |                            |                     |
|    |                          |                                  |                            |                     |
|    |                          |                                  |                            |                     |

# Customer

| US | Members             | Method              | scenario                   | Outcome/Output      |
|----|---------------------|---------------------|----------------------------|---------------------|
|    | List<ItemInterface> |                     |                            |                     |
|    | double totalPrice   |                     | The basket is empty.       | Return 0.0          |
|    |                     |                     | The basket contains items. | Return total costs  |
|    |                     |                     |                            |                     |
|    |                     | void printReceipt() |                            |                     |
|
