package net.pragyah.samskritam.upyogita.sutr


import net.pragyah.samskritam.upyogita.uchchaaran.अक्षर._
import net.pragyah.samskritam.upyogita.uchchaaran.अक्षर
import scala.collection.mutable.ListBuffer

/**
 *
 *
 * Created by vipul on 8/3/14.
 */
class शिवसूत्राणि {
  /**
   * नृत्तावसाने नटराजराजो ननाद ढक्कां नवपञ्चवारम्।
   * उद्धर्त्तुकामो सनकादिसिद्धादिनेतद्विमर्शे शिवसूत्रजालम्॥
   *
   * At the end of His Cosmic Dance, Śiva, the Lord of Dance,
   * with a view to bless the sages Sanaka and so on, played on His ḍamarū fourteen times,
   * from which emerged the fourteen sūtras, popularly known as Śivasūtras or Māheśvara sutras.
   */



  case class सूत्र(सूत्र:String, अक्षराणि: List[अक्षर], इत:अक्षर)
  case class प्रत्याहार (प्रत्याहारः :String, अक्षराणि: List[अक्षर],सूत्राणि: List[सूत्र], इत:अक्षर)

  def सूत्र_ददातु(वाक्य: String) ={
    val अक्षराणि = विश्लेषण(वाक्य)
    सूत्र(वाक्य,अक्षराणि.dropRight(1),अक्षराणि.last)
  }


  def प्रत्याहार_ददातु(वाक्य: String) : प्रत्याहार ={
    if(प्रत्याहाराः.contains(वाक्य)) return प्रत्याहाराः(वाक्य)

    val अक्षराणि = विश्लेषण(वाक्य)
    assert(अक्षराणि.size == 2)
    val अ = अक्षराणि.head
    val इत = अक्षराणि.last
    प्रत्याहार(वाक्य, List(अ),List[सूत्र](),इत )
  }

  private def प्रत्याहार_सृजतु(वाक्य: String) : प्रत्याहार ={

//   if(प्रत्याहाराः.contains(वाक्य)) return प्रत्याहाराः(वाक्य)

    val अक्षराणि = विश्लेषण(वाक्य)
    assert(अक्षराणि.size == 2)
    val अ = अक्षराणि.head
    val इत = अक्षराणि.last


    val अ_स = सर्वे_आक्षराणि.dropWhile(_._1 != अ).takeWhile(_._1  != इत)
    var प्र : प्रत्याहार=null
    if(अ_स.size != 0) {
      val _अक्षराणि  = अ_स.map(_._1).toList.filter(!_._अक्षर.endsWith("्"))
      val _सूत्राणि = अ_स.map(_._2).distinct
      प्रत्याहार(वाक्य,_अक्षराणि,_सूत्राणि,इत )
    }else{
      प्रत्याहार(वाक्य, List(अ),List[सूत्र](),इत )
    }
  }


  private def सूचि_ददातु(अक्षराणि:String*) = अक्षराणि.map(अक्षर_ददातु(_).get).toList



    val सूत्र_१ = सूत्र_ददातु("अइउण्")
    val सूत्र_२ = सूत्र_ददातु("ॠॡक्")
    val सूत्र_३ = सूत्र_ददातु("एओङ्" )
    val सूत्र_४ = सूत्र_ददातु("ऐऔच्" )
    val सूत्र_५= सूत्र_ददातु( "हयवरट्" )
    val सूत्र_६ = सूत्र_ददातु( "लण्" )
    val सूत्र_७= सूत्र_ददातु( "ञमङणनम्")
    val सूत्र_८ = सूत्र_ददातु("झभञ्")
    val सूत्र_९ = सूत्र_ददातु( "घढधष्")
    val सूत्र_१० = सूत्र_ददातु( "जबगडदश्")
    val सूत्र_११ = सूत्र_ददातु( "खफछठथचटतव्" )
    val सूत्र_१२ = सूत्र_ददातु( "कपय्")
    val सूत्र_१३ = सूत्र_ददातु("शषसर्" )
    val सूत्र_१४ = सूत्र_ददातु("हल्" )

    val सूत्राणि = सूत्र_१ :: सूत्र_२ ::सूत्र_३  :: सूत्र_४ :: सूत्र_५ :: सूत्र_६ :: सूत्र_७ :: सूत्र_८ :: सूत्र_९ :: सूत्र_१० :: सूत्र_११ :: सूत्र_१२ :: सूत्र_१३ :: सूत्र_१४ ::  Nil



    val _प्रत्याहाराः = "अण्" :: "अक्" ::"इक" ::"एङ्" :: "अच्" :: "इच्" :: "एच्" :: "ऐच्" :: "अट्" :: "यण्" ::   "अण्" :: "इण्" :: "ञम्" ::"अम्" :: "यञ्" ::"झष्" ::"भष्" ::"अश्" ::"हश्" ::  "झश्" ::"जश्" ::"चव्" ::"छव््" :: "यय्" ::  "झय्" ::  "खय्" ::"शर्" ::  "यर्" ::  "झर्" ::  "खर्" ::  "अल्" ::  "हल्" ::  "झल" ::  Nil
            println(_प्रत्याहाराः.size)
    val प्रत्याहाराः = _प्रत्याहाराः.map(प्र => (प्र -> प्रत्याहार_सृजतु(प्र) )) .toMap

    lazy val  सर्वे_आक्षराणि = सूत्राणि.flatMap(x => x.अक्षराणि.map(y => (y,x)) ::: (x.इत,x)::Nil )
}

object       शिवसूत्राणि {


  def main(args:Array[String]) {


    val     शिवसूत्राणि  = new शिवसूत्राणि()
    import शिवसूत्राणि._
    सर्वे_आक्षराणि.foreach(x => println(x._1._अक्षर))
    println
    val प१ = प्रत्याहार_ददातु("अच्")
    प१.अक्षराणि.foreach(println)
    println(प१.इत)
    println

    val प२ = प्रत्याहार_ददातु("आत्")
    प२.अक्षराणि.foreach(println)
    println(प१.इत)
    println


    println (प्रत्याहाराः.size)

    प्रत्याहाराः.foreach(println)


  }


}
