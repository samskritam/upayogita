package net.pragyah.samskritam.upyogita.aavyuh

import net.pragyah.samskritam.upyogita.uchchaaran.अक्षर
import net.pragyah.samskritam.upyogita.aavyuh.लिञ्ग.लिञ्ग

/**
 * Created by vipul on 5/3/14.
 */
trait त्रिवचन {
  val columns = 3

}



object लिञ्ग extends Enumeration{
  type लिञ्ग =Value
  val पु = Value(-1)
  val न = Value(0)
  val  स्त्रि= Value(1)
}

class वििभक्ति (val लिञ्ग:लिञ्ग,अन्त:अक्षर) {


}