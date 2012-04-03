package dojo

import items.artifacts.{MachineGunUnicorn, Unicorn}
import items.fashion.Hat
import items.house.{JukeBox, Chair}
import items.{Item, Purchasable, TimedItem, User}
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class FunsWithOOTests extends FunSuite with ShouldMatchers{

  // all items should have an id
  test("Unicorn should have id of 1"){
    val id = new Unicorn(1).id
    id should equal (1)
  }

  test("anonymous items should have an id"){
    val id = 5
    val anon = new Item(5){}

    anon.id should equal (id)
  }

  // all fashion and house items should be able to be bought for cash deducted from user

  test("should buy hat and deduct 5 cash from user"){
    val hat: Hat = new Hat()
    hat.price = 5
    assertPurchasableItemCashDeduction(hat)
  }

  test("should buy chair and deduct 3 cash from user"){
    val chair = new Chair()
    chair.price = 3
    assertPurchasableItemCashDeduction(chair)
  }

  def assertPurchasableItemCashDeduction(item:Purchasable){
    val balance = 10
    val user = new User(balance)
    user.buy(item)
    // result needs to be asserted
    user.cash should equal (balance - item.price)
  }

  // MachineGunUnicorn and JukeBox have special actions that are available a set time after creation
  // * MachineGunUnicorn prints Bam-Bam
  // * JukeBox prints Blah-Blah

  test("MachineGunUnicorn goes Bam-Bam"){
    val machineGunUnicorn = new MachineGunUnicorn
    val delay = 10
    machineGunUnicorn.delay = delay
    assertTimedItem(Some("Bam-Bam"), machineGunUnicorn, delay)
  }

  test("JukeBox goes Blah-Blah"){
    val jukeBox = new JukeBox
    val delay = 10
    jukeBox.delay = delay
    assertTimedItem(Some("Blah-Blah"), jukeBox, delay)
  }

  def assertTimedItem(expected: Some[Any], timedItem: TimedItem, delay: Int){
    val now = 10
    timedItem.startClock(now)

    timedItem.ready(now)          should  equal (false)
    timedItem.act(now + delay -1) should  equal (None)

    timedItem.ready(now + delay)  should  equal (true)
    timedItem.act(now + delay)    should  equal (expected)
  }

}
