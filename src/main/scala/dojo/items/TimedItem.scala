package dojo.items

trait TimedItem {

  var delay = 0

  var now = -1

  def setDelay(delay:Int) {this.delay = delay}

  def ready(now:Int):Boolean = {
    now >= (this.now + this.delay)
  }

  def act(now:Int) : Option[Any]
  
  def startClock(now:Int) {
    this.now = now
  }

}
