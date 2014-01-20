import scalaxb._
import mypackage._

object DataRecordUsage {

  def main(args: Array[String]) = {

    val subject =
        <person xmlns="http://www.microsoft.com"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://www.microsoft.com family.xsd http://www.w3schools.com children.xsd">
          <firstname>Hege</firstname>
          <lastname>Refsnes</lastname>
          <children>
            <childname>Cecilie</childname>
          </children>
        </person>

    val obj: Person = fromXML[Person](subject)

  // val children: Children =

    obj.any match {
      case Some(DataRecord(Some("http://www.microsoft.com"), Some("children"), any)) =>
        val elem = any.asInstanceOf[scala.xml.Elem]

        //parser error "`{http://www.w3schools.com}childname' expected but {http://www.microsoft.com}childname found" while parsing /{http://www.microsoft.com}children/{http://www.microsoft.com}childname
        val children = fromXML[Children](elem)

      case None =>
    }
  }
}
