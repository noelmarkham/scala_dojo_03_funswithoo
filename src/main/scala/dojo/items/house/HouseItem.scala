package dojo.items.house

import dojo.items.{Purchasable, Item}


abstract class HouseItem(id:Int) extends Item(id) with Purchasable {

}
