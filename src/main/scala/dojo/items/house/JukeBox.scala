package dojo.items.house

import dojo.items.TimedItem

class JukeBox(id:Int = -99) extends HouseItem(id) with TimedItem {
  def act(now: Int) = {
    if (ready(now)) {
      Some("Blah-Blah")
    } else {
      None
    }
  }
}
