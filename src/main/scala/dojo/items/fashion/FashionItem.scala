package dojo.items.fashion

import dojo.items.{Purchasable, Item}


abstract class FashionItem(id:Int) extends Item(id) with Purchasable {

}
