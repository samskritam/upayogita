package net.pragyah.samskritam.upyogita.uchchaaran

/**
 * Created by vipul on 3/30/14.
 */



object Sthaan extends Enumeration{
  type Sthaan = Value
  val kanthy = Value(1)
  val talvy  = Value(2)
  val murdhany= Value(3)
  val danty = Value(4)
  val oshty = Value(5)
}

object Praan extends Enumeration{
  type Praan = Value

  val alp = Value(1)
  val maha = Value(2)
  val na = Value(3)
}

import Sthaan._
import Praan._


abstract class akshar(sth: Sthaan,
                      prn: Praan,
                      sparsh:Boolean,      // जिह्वा स्पर्ष करोति/न करोति
                      anunasik:Boolean,
                      antsth:Boolean,
                      ushm:Boolean,
                      sankuchit:Boolean    // जिह्वा संकुचित अस्ति/नास्ति
                       )




