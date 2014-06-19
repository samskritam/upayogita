package net.pragyah.samskritam.upyogita.uchchaaran

import net.pragyah.samskritam.upyogita.uchchaaran.types.एकं_स्पर्ष
import scala._
import scala.Some
import scala.collection.immutable.HashSet

/**
 * Created by vipul on 3/30/14.
 */



object सत्य extends Enumeration{
  type  सत्य = Value
  val ना = Value(0)     // न के स्थान पर ना - क्योंकि न अपने में एक _अक्षर है
  val अाम् = Value(1)
}



object समय extends Enumeration{
  type समय = Value
  val न्यून = Value(1)
  val ह्रस्व= Value(2)
  val दीर्घ = Value(4)
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
  val अन्तस्थ = Value(9)//
  val पादोन = Value(7)  // 3/4th
  val अर्ध = Value(5)
  val शून्य = Value(0)



}



class स्पर्ष(val _स्पर्ष:List[List[ एकं_स्पर्ष]]) {

  def this(ए_स : एकं_स्पर्ष){
    this(List(List(ए_स)))
  }

  /**
   *
   * एकं_स्पर्ष स्वीकरोति , नवीन  स्पर्षम् ददाति
   * @param ए_स
   * @return
   */

  def +=(ए_स: एकं_स्पर्ष): स्पर्ष = +=(List(List(ए_स)))

  /**
   *
   * @param अन्य
   * @return
   */
  def +=(अन्य:स्पर्ष): स्पर्ष = += (अन्य._स्पर्ष)

  /**
   *
   * एषा सूचि
   *
   *
   * @param ए_स_सूचि
   * @return
   */
  def +=(ए_स_सूचि: List[List[एकं_स्पर्ष]]): स्पर्ष  = {
    val __स्पर्ष  = this._स्पर्ष ::: ए_स_सूचि
    new स्पर्ष(__स्पर्ष)
  }


  def ++=(अन्य:स्पर्ष): स्पर्ष = ++= (अन्य._स्पर्ष)

  /**
   *
   * @param अन्य_सूचि
   * @return
   */
  def ++=(अन्य_सूचि: List[List[एकं_स्पर्ष]]): स्पर्ष = {
     val (head, tail) = _स्पर्ष.splitAt(_स्पर्ष.length -1)
     val (other_head,other_tail) = अन्य_सूचि.splitAt(अन्य_सूचि.length - 1)
     if(other_head.size > 0)
       new स्पर्ष(head::: List(tail(0):::other_head(0)) ::: other_tail)
     else
       new स्पर्ष(head::: List(tail(0):::other_tail(0)))
  }

}

//  def ++=(अन्य:स्पर्ष): स्पर्ष = ++=(अन्य._स्पर्ष)


object प्राण extends Enumeration{
  type प्राण = Value

  val मा = Value(0)
  val अल्पप्राण = Value(1)
  val महाप्राण = Value(2)
}

// स्वरों में
object जिह्वा_संकुचित extends Enumeration{
  type जिह्वा_संकुचित = Value
  val संकुचित_न = Value(1)   // अ   अा
  val संकुचित_अल्प = Value(2)  //उ,ऊ,
  val संकुचित_दीर्घ = Value(3)     //अो अौ
}


object _घोष_ extends Enumeration{
  type घोष = Value
  val अघोष = Value(0)
  val घोष = Value(1)
}

object _अनुनासिक_ extends Enumeration{
  type _अनुनासिक_ = Value
  val अनुनासिक_न = Value(0)
  val अनुनासिक = Value(1)
}

object _ऊष्म_ extends Enumeration{
  type ऊष्म = Value
  val ऊष्म_न = Value(0)
  val ऊष्म = Value(1)
}


object types{
  type एकं_स्पर्ष = (स्पर्ष_स्थान.स्पर्ष_स्थान,  स्पर्ष_मात्रा.स्पर्ष_मात्रा )
}

object implicites {
  import types.एकं_स्पर्ष
  implicit def स्पर्ष_संयोजक  (स: एकं_स्पर्ष )= new स्पर्ष(List(List(स)))
  implicit def स्पर्ष_सूचि_संयोजक  (स: एकं_स्पर्ष )= List(List(स))
  implicit def सूचि_स्पर्ष_संयोजक  (सूचि: List[List[एकं_स्पर्ष]])= new स्पर्ष(सूचि)

  implicit def स्वरम्_अक्षर (स:स्वर) = स.asInstanceOf[अक्षर]
  implicit def व्यन्जनम्_अक्षर (व:व्यन्जन) = व.asInstanceOf[अक्षर]
  implicit def अनुनासिक_वा (अ:_अनुनासिक_._अनुनासिक_) = अ.id == 1

}

import सत्य._
import प्राण._
import समय._
import जिह्वा_संकुचित._
import स्पर्ष_मात्रा._
import _घोष_._
import _अनुनासिक_._
import _ऊष्म_._
import स्पर्ष_स्थान._

import implicites._

import scala.Predef._
import scala.Some


trait व्यन्जन
trait स्वर {
  def मात्रा:String
}
trait सन्युक्त{
  def समकालीन :सत्य = ना
}

case class अक्षर(
    _अक्षर : String,
    _स्पर्ष : स्पर्ष,
    _प्राण : प्राण,
    _समय : समय,
    _जिह्वा_संकुचित:जिह्वा_संकुचित,// जिह्वा संकुचित अस्ति/नास्ति
    _घोष : घोष,
    _अनुनासिक:_अनुनासिक_,
    _ऊष्म:ऊष्म
) {

  val sb = new StringBuilder()
  sb ++= _अक्षर ++= " : (";
  sb ++=  (if(this.isInstanceOf[सन्युक्त])"सन्युक्त:"else "")
  sb ++= (if(this.isInstanceOf[स्वर])"स्वर)"else "व्यन्जन)")

  sb ++= "( सपर्ष => { "

   _स्पर्ष._स्पर्ष.foreach(x => {
     sb ++= "["
     sb ++=  x.mkString(":")
     sb ++=   "] "
   })


  sb ++= "}, "
  sb ++= "_प्राण : " ++= _प्राण.toString ++= ", "
  sb ++= "_समय : " ++= _समय.toString ++= ", "
  sb ++= "_जिह्वा_संकुचित : " ++= _जिह्वा_संकुचित.toString ++= ", "
  sb ++= "_घोष : " ++= _घोष.toString ++= ", "
  sb ++= "_अनुनासिक : " ++= _अनुनासिक.toString ++= ", "
  sb ++= "_ऊष्म : " ++= _ऊष्म.toString ++= ") "

  lazy val string = sb.toString()

  override def toString = string

}



object अक्षर{

  val स्वर_कोष= scala.collection.mutable.Map[String,अक्षर] ()
  val मात्रा_कोष= scala.collection.mutable.Map[String,अक्षर] ()


  val व्यन्जन_कोष= scala.collection.mutable.Map[String,अक्षर] ()
  val अनुनासिक_कोष= scala.collection.mutable.Map[स्पर्ष_स्थान,अक्षर] ()

  val हलन्त = '्'
  val बिन्दु = 'ं'
  val चंद्रबिन्दु ='ँ'


  def apply(
                    _अक्षर : String,
                    _स्पर्ष : स्पर्ष,
                    _प्राण : प्राण,
                    _समय : समय,
                    _जिह्वा_संकुचित:जिह्वा_संकुचित,// जिह्वा संकुचित अस्ति/नास्ति
                    _घोष : घोष,
                    _अनुनासिक:_अनुनासिक_,
                    _ऊष्म:ऊष्म,
                    _मात्रा : Option[String]
                    ):अक्षर ={
       _मात्रा match{
         case Some(matra) =>{
           val स = new अक्षर(_अक्षर,_स्पर्ष,_प्राण ,_समय,_जिह्वा_संकुचित,_घोष,_अनुनासिक,_ऊष्म) with स्वर { override def मात्रा = matra}
           स्वर_कोष(_अक्षर) = स
           मात्रा_कोष(matra) = स
           स
         }
         case None => {
           val  व =  new अक्षर(_अक्षर,_स्पर्ष,_प्राण ,_समय,_जिह्वा_संकुचित,_घोष,_अनुनासिक,_ऊष्म) with व्यन्जन
           व्यन्जन_कोष(_अक्षर) = व
           if(_अनुनासिक){
             अनुनासिक_कोष(_स्पर्ष._स्पर्ष.head.head._1) = व
           }
           व

         }
      }
    }

  def सन्युक्त(_अक्षर:String, घटक_१ : अक्षर,घटक_२:अक्षर,मात्रा : Option[String] =None)  ={

     val _प्राण  =प्राण( Math.max(  घटक_१._प्राण.id, घटक_२._प्राण.id))
     val _समय = समय( Math.max(  घटक_१._समय.id, घटक_२._समय.id))
     val _जिह्वा_संकुचित  = जिह्वा_संकुचित( Math.max(  घटक_१._जिह्वा_संकुचित.id, घटक_२._जिह्वा_संकुचित.id))
     val _घोष  = _घोष_ ( Math.max(  घटक_१._घोष.id, घटक_२._घोष.id))
     val _अनुनासिक  = _अनुनासिक_( Math.max(  घटक_१._अनुनासिक.id, घटक_२._अनुनासिक.id))
     val _ऊष्म  = _ऊष्म_ ( Math.max(  घटक_१._ऊष्म.id, घटक_२._ऊष्म.id))

     मात्रा match{
       case Some(matra) => {     //   ऐ, औ, अ:


         val _स्पर्ष = घटक_१._स्पर्ष +=  घटक_२._स्पर्ष

         val स्वर = new अक्षर(_अक्षर,_स्पर्ष,_प्राण ,_समय,_जिह्वा_संकुचित,_घोष,_अनुनासिक,_ऊष्म)  with सन्युक्त with स्वर
              { override def मात्रा = matra;
                override def समकालीन = ना}

         स्वर_कोष(_अक्षर) = स्वर
         मात्रा_कोष(matra) = स्वर
         स्वर
       }
       case None => {


         (घटक_१ , घटक_२) match {
           case    (_:स्वर,_:स्वर) =>  require(false," घटकौ स्वर: स्त:, _मात्रा नास्ति  ")
           case (_:व्यन्जन,_ :व्यन्जन)  =>{//क्ष त्र ज्ञ

             val _स्पर्ष = घटक_१._स्पर्ष += घटक_२._स्पर्ष
             val व्यन्जन = new अक्षर(_अक्षर,_स्पर्ष,_प्राण ,_समय,_जिह्वा_संकुचित,_घोष,_अनुनासिक,_ऊष्म)  with सन्युक्त with व्यन्जन{ override def समकालीन = ना}
             व्यन्जन_कोष(_अक्षर) = व्यन्जन
             व्यन्जन
           }
           case (_:व्यन्जन,_ :स्वर)  => {//प्रमुख: अस्ति

             val _स्पर्ष = घटक_१._स्पर्ष ++= घटक_२._स्पर्ष

             val व्यन्जन = new अक्षर(_अक्षर,_स्पर्ष,_प्राण ,_समय,_जिह्वा_संकुचित,_घोष,_अनुनासिक,_ऊष्म)  with सन्युक्त with व्यन्जन { override def समकालीन = अाम्}
              व्यन्जन_कोष(_अक्षर) = व्यन्जन
              व्यन्जन
           }

           case (_:स्वर,_)  => require(false," घटक_१ स्वर अस्ति , व्यन्जन भवेत  ")
           case     _ => {
             require(false,"   घटकौ किम् अस्ति न जानामि")
           }

         }

       }
     }
   }

  /**
   * स्वर
   */

  val अ =   अक्षर("अ", (अस्पर्ष,शून्य),अल्पप्राण, ह्रस्व, संकुचित_न,  अघोष ,  अनुनासिक_न, ऊष्म_न,Some(""))
  val आ =  अक्षर("आ",(अस्पर्ष,शून्य),अल्पप्राण, दीर्घ, संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म_न,Some("ा"))

  val इ =   अक्षर("इ",(तालव्य,पादोन),अल्पप्राण, ह्रस्व, संकुचित_न,  अघोष ,  अनुनासिक_न, ऊष्म_न,Some("ि"))
  val ई =   अक्षर("ई",(तालव्य,पादोन),अल्पप्राण, दीर्घ, संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म_न,Some("ी"))

  val उ =   अक्षर("उ",(अोष्ठ्य,पादोन),अल्पप्राण, ह्रस्व, संकुचित_अल्प,  अघोष ,  अनुनासिक_न, ऊष्म_न,Some("ु"))
  val ऊ =   अक्षर("ऊ",(अोष्ठ्य,पादोन),अल्पप्राण, दीर्घ, संकुचित_अल्प,  घोष ,  अनुनासिक_न, ऊष्म_न,Some("ू"))

  val ए =   अक्षर("ए",(तालव्य,अर्ध),अल्पप्राण, ह्रस्व, संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म_न,Some("े"))
  val ऐ =   अक्षर.सन्युक्त("ऐ",अ,ई,Some("ै"))

  val अो =   अक्षर("ओ",(अोष्ठ्य,अर्ध),अल्पप्राण, ह्रस्व, संकुचित_दीर्घ,  घोष ,  अनुनासिक_न, ऊष्म_न,Some("ो"))
  val औ =   अक्षर.सन्युक्त("अौ",अ,ऊ,Some("ौ"))


  val अं =   अक्षर("अं",List(List((अस्पर्ष,शून्य)),List((कण्ठ्य,पूर्ण))),अल्पप्राण, ह्रस्व, संकुचित_न,  अघोष ,  अनुनासिक, ऊष्म_न)  // changed to aghosh
  val अँ =   अक्षर("अँ",List(List((अस्पर्ष,शून्य)),List((कण्ठ्य,पूर्ण))),अल्पप्राण, ह्रस्व, संकुचित_न,  घोष ,  अनुनासिक, ऊष्म_न)


  /**
   * व्यन्जन
   */


  //असपर्ष
  val ह् =   अक्षर("ह्",(अस्पर्ष,शून्य),महाप्राण, न्यून, संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म,None)

  val अह् =   अक्षर.सन्युक्त("अः",अ,ह्,Some("ः"))



  // कण्ठ्य
  val क् =   अक्षर("क्",(कण्ठ्य,पूर्ण),अल्पप्राण, न्यून,  संकुचित_न,  अघोष,  अनुनासिक_न,  ऊष्म_न,None)
  val ख् =   अक्षर("ख्",(कण्ठ्य,पूर्ण),महाप्राण , न्यून, संकुचित_न,  अघोष,  अनुनासिक_न,  ऊष्म_न,None)
  val ग् =   अक्षर("ग्",(कण्ठ्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val घ् =   अक्षर("घ्",(कण्ठ्य,पूर्ण),महाप्राण , न्यून, संकुचित_न,  घोष ,अनुनासिक_न,  ऊष्म_न,None);
  val ङ् =   अक्षर("ङ्",(कण्ठ्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,  घोष ,  अनुनासिक, ऊष्म_न,None);


  // तालव्य
  val च् =   अक्षर("च्",(तालव्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न, अघोष,  अनुनासिक_न,  ऊष्म_न,None);
  val छ् =   अक्षर("छ्",(तालव्य,पूर्ण),महाप्राण , न्यून,संकुचित_न,अघोष, अनुनासिक_न,  ऊष्म_न,None);
  val ज् =   अक्षर("ज्",(तालव्य,पूर्ण),अल्पप्राण, न्यून,संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val झ् =   अक्षर("झ्",(तालव्य,पूर्ण),महाप्राण , न्यून,संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val ञ् =   अक्षर("ञ्",(तालव्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,  घोष ,  अनुनासिक, ऊष्म_न,None);

  val य् =   अक्षर("य्",(तालव्य,अन्तस्थ),अल्पप्राण, न्यून,संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म_न,None);

  val श् =   अक्षर("श्",(तालव्य,पादोन),महाप्राण, न्यून, संकुचित_न,  अघोष,  अनुनासिक_न, ऊष्म,None);

  // मूर्धन्य
  val ट् =   अक्षर("ट्",(मूर्धन्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न, अघोष,  अनुनासिक_न,  ऊष्म_न,None);
  val ठ् =   अक्षर("ठ्",(मूर्धन्य,पूर्ण),महाप्राण , न्यून,संकुचित_न, अघोष,  अनुनासिक_न,  ऊष्म_न,None);
  val ड् =   अक्षर("ड्",(मूर्धन्य,पूर्ण),अल्पप्राण, न्यून,संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val ढ् =   अक्षर("ढ्",(मूर्धन्य,पूर्ण),महाप्राण , न्यून,संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val ण् =   अक्षर("ण्",(मूर्धन्य,पूर्ण),अल्पप्राण, न्यून,संकुचित_न,  घोष ,  अनुनासिक, ऊष्म_न,None);

  val र् =   अक्षर("र्",(मूर्धन्य,अन्तस्थ),अल्पप्राण, न्यून, संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म_न,None);

  val ष् =   अक्षर("ष्",(मूर्धन्य,पादोन),महाप्राण, न्यून, संकुचित_न,  अघोष, अनुनासिक_न, ऊष्म,None);

  // दन्त्य
  val त् =   अक्षर("त्",(दन्त्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,  अघोष,  अनुनासिक_न,  ऊष्म_न,None);
  val थ् =   अक्षर("थ्",(दन्त्य,पूर्ण),महाप्राण , न्यून, संकुचित_न,  अघोष,  अनुनासिक_न,  ऊष्म_न,None);
  val द् =   अक्षर("द्",(दन्त्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val ध् =   अक्षर("ध्",(दन्त्य,पूर्ण),महाप्राण , न्यून, संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val न् =   अक्षर("न्",(दन्त्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,  घोष ,  अनुनासिक, ऊष्म_न,None);

  val ल् =   अक्षर("ल्",(दन्त्य,अन्तस्थ),अल्पप्राण, न्यून,संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म_न,None);

  val स् =   अक्षर("स्",(दन्त्य,पादोन),महाप्राण, न्यून, संकुचित_न,  अघोष,  अनुनासिक_न, ऊष्म,None);

  // अोष्ठ्य
  val प् =   अक्षर("प्",(अोष्ठ्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,अघोष,  अनुनासिक_न,  ऊष्म_न,None);
  val फ् =   अक्षर("फ्",(अोष्ठ्य,पूर्ण),महाप्राण , न्यून, संकुचित_न, अघोष,  अनुनासिक_न,  ऊष्म_न,None);
  val ब् =   अक्षर("ब्",(अोष्ठ्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val भ् =   अक्षर("भ्",(अोष्ठ्य,पूर्ण),महाप्राण , न्यून, संकुचित_न,  घोष , अनुनासिक_न,  ऊष्म_न,None);
  val म् =   अक्षर("म्",(अोष्ठ्य,पूर्ण),अल्पप्राण, न्यून, संकुचित_न, घोष ,  अनुनासिक, ऊष्म_न,None);

  val व् =   अक्षर("व्",(अोष्ठ्य,अन्तस्थ),अल्पप्राण, न्यून, संकुचित_न,  घोष ,  अनुनासिक_न, ऊष्म_न,None);
  val विराम =   अक्षर(" ",(अस्पर्ष, पूर्ण),मा , दीर्घ , संकुचित_न,  अघोष ,  अनुनासिक_न, ऊष्म_न,None);



  val  ऋ =   अक्षर.सन्युक्त("ऋ", र्  ,इ,Some( "ृ"))


  val क्ष् =   अक्षर.सन्युक्त("क्ष्",क्,ष्)
  val त्र्  =   अक्षर.सन्युक्त("त्र्",त्,र्)
  val ज्ञ्=   अक्षर.सन्युक्त("ज्ञ्",ज्,ञ्)

  व्यन्जन_कोष.toList.filter(_._1.endsWith("्")).foreach( _ match{
    case (_,v:अक्षर) =>{
      स्वर_कोष.values.foreach(_स्वर => {
        val _अक्षर =  v._अक्षर.dropRight(1) concat _स्वर.asInstanceOf[स्वर].मात्रा
        अक्षर.सन्युक्त(_अक्षर,v,_स्वर)
      })
    }
  })

  def मात्रा_वा(_म_ :Char)= मात्रा_कोष.contains(_म_.toString())


  def अक्षर_ददातु(अ:String) : Option[अक्षर]= {
    if(अ == बिन्दु.toString){
      Some(म्)
    }
    else if(अ == चंद्रबिन्दु .toString){
      Some(अँ)
    }
    else if(स्वर_कोष.contains(अ)){
      Some(स्वर_कोष(अ))
    }else if(व्यन्जन_कोष.contains(अ)){
      Some(व्यन्जन_कोष(अ))
    }else{
      println(" something's wrong, unable to get अक्षर  "+अ)
      None
    }

  }

  /**
   *
   * एतत् क्रमादेश वाक्यम् स्वीकरोति, विश्लेषण कृत्वा अक्षराणि ध्वनि सूचिका ददाति
   *
   * @param वाक्य
   * @return
   */
  def विश्लेषण(वाक्य:String) : List[अक्षर] = {

            val  नियन्त्रक_वर्ण = HashSet('\r','\n')

    def  सूचि_वृद्धी(s:String,lo:(List[अक्षर],Option[Char]),o: => Option[Char])  : (List[अक्षर],Option[Char]) =
      अक्षर_ददातु(s) match{
        case Some(_अ_) =>(_अ_ ::lo._1,o)
        case None =>(lo._1,o)
      }

    val (l,o)  = वाक्य.foldLeft[(List[अक्षर],Option[Char])]((List(),None))( (lo,current) => {



              if(lo._2 == None || नियन्त्रक_वर्ण.contains(lo._2.get )){
                  (lo._1,Some(current))
              }else{
                val carry_over = lo._2.get

                 if(carry_over == बिन्दु){

                  val new_carry_over = if(current.equals(' ') || नियन्त्रक_वर्ण.contains(current)) "म्"
                  else //"म्"  // fix this ..{
                  {
                    val आ = अक्षर_ददातु(current.toString)
                    अनुनासिक_कोष(आ.get._स्पर्ष._स्पर्ष.head.head._1)._अक्षर
                  }


                  सूचि_वृद्धी(new_carry_over,lo,Some(current))
                }else if( current == हलन्त ||  मात्रा_वा(current)){
                   सूचि_वृद्धी( carry_over.toString+current.toString,lo,None)
                 }
                else{
                  सूचि_वृद्धी(carry_over.toString,lo,Some(current))
                 }

              }
            })


        o match {
          case Some(c) => {
            सूचि_वृद्धी( c.toString,(l,o),None)._1.reverse
          }
          case None => l.reverse
        }


  }

  def main(args:Array[String]){

    println("++++++++++++++++++++++++++मात्रा_कोष++++++++++++++++++++++++++++++++++")
    मात्रा_कोष.toList.sortBy(_._2._अक्षर).foreach(println)
    println("++++++++++++++++++++++++++++स्वर_कोष++++++++++++++++++++++++++++++++")
    स्वर_कोष.values.toList.sortBy(_._अक्षर).foreach(println)
    println("++++++++++++++++++++++++++++व्यन्जन_कोष++++++++++++++++++++++++++++++++")
    व्यन्जन_कोष.values.toList.sortBy(_._अक्षर).foreach(println)
    println("++++++++++++++++++++++++++++अनुनासिक_कोष++++++++++++++++++++++++++++++++")
    अनुनासिक_कोष.foreach(println)
    println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    println(मात्रा_कोष('ः'.toString))
           println(मात्रा_वा('ः'))

    var वाक्य = readLine()

    while(वाक्य.trim != ""){
      val _विश्लेषण =विश्लेषण(वाक्य)
      _विश्लेषण.foreach(println)
      println("     -----     ")
      वाक्य = readLine()
    }
  }


}

