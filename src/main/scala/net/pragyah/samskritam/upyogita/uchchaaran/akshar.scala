package net.pragyah.samskritam.upyogita.uchchaaran

/**
 * Created by vipul on 3/30/14.
 */



object सत्य extends Enumeration{
  type  सत्य = Value
  val न = Value(1)
  val अाम् = Value(2)
}

//implicit  def devnagriToBool


object समय extends Enumeration{
  type समय = Value
  val ह्रस्व= Value(1)
  val दीर्घ = Value(2)
}

object स्पर्ष_स्थान extends Enumeration{
  type स्पर्ष_स्थान = Value

  val अस्पर्ष = Value(0)
  val कण्ठ्य = Value(1)
  val तालव्य  = Value(2)
  val मूर्धन्य = Value(3)
  val दन्त्य = Value(4)
  val अोष्ठ्य = Value(5)
}

/**
 *
 */
object स्पर्ष_मात्रा extends Enumeration{
  type स्पर्ष_मात्रा = Value
  val पूर्ण = Value(10)
  val अन्तस्थ = Value(9)
  val पादोन = Value(7)  // 3/4th
  val अर्ध = Value(5)


}


object प्राण extends Enumeration{
  type प्राण = Value

  val अल्पप्राण = Value(1)
  val महाप्राण = Value(2)
  val मा = Value(3)
}

// स्वरों में
object  जिह्वा_संकुचित extends Enumeration{
  type जिह्वा_संकुचित = Value
  val न_संकुचित = Value(1)   // अ   अा
  val अल्प_संकुचित = Value(2)  //उ,ऊ,
  val दीर्घ_संकुचित = Value(3)     //अो अौ
}



import सत्य._
import स्पर्ष_स्थान._
import प्राण._
import समय._
import स्पर्ष_मात्रा._
import जिह्वा_संकुचित._

case class अक्षर(
    स्थान : स्पर्ष_स्थान,
    प्राण : प्राण,
    समय : समय,
    स्पर्ष_मात्रा : स्पर्ष_मात्रा,
    जिह्वा_संकुचित:जिह्वा_संकुचित,// जिह्वा संकुचित अस्ति/नास्ति
    घोष : सत्य,
    अनुनासिक:सत्य,
    ऊष्म:सत्य
)


object अक्षर{

  val क = new अक्षर(कण्ठ्य,अल्पप्राण, ह्रस्व,पूर्ण, न_संकुचित,  न,  न,  न)
  val ख = new अक्षर(कण्ठ्य,महाप्राण , ह्रस्व,पूर्ण, न_संकुचित,  न,  न,  न)
  val ग = new अक्षर(कण्ठ्य,अल्पप्राण, ह्रस्व,पूर्ण, न_संकुचित,  अाम्, न,  न)
  val घ = new अक्षर(कण्ठ्य,महाप्राण , ह्रस्व,पूर्ण, न_संकुचित,  अाम्, न,  न)
  val ञ = new अक्षर(कण्ठ्य,अल्पप्राण, ह्रस्व,पूर्ण, न_संकुचित,  न,  अाम्, न)






}

