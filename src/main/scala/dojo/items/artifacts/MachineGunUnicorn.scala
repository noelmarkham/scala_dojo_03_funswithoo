package dojo.items.artifacts

import dojo.items.TimedItem


class MachineGunUnicorn(id:Int = -99) extends ArtifactItem(id) with TimedItem {
  def act(now: Int) = {
    if (ready(now)) {
      Some("Bam-Bam")
    } else {
      None
    }
  }
}
