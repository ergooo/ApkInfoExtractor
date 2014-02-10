import scala.sys.process._

object ApkInfoExtractor{
	def main(args : Array[String]) : Unit = {
	  println("Hello World")
	  
	  // aapt l -a <apkファイル>
	  // aapt l -a 20121003_M777KH1_release-signed.apk | grep package | grep name
	  val res = (Process("./libs/aapt l -a ./res/ApkDistributor.apk") #| Process("grep package") #| Process("grep name")).lines.toList
	  res.foreach(println)
	  if(!res.isEmpty){
	    val line = res(0)
	    
	    val splitted = line.split("name=")
	    splitted.foreach(println)
	    println(splitted(1))
	  }
	} 
	def getNameLine(arr: Array[String]): Some[String]= {
	  val names = for(e <- arr; if e.startsWith("name=")) yield e
	  Some(names(0))
	}
}