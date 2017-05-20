package com.github.mituba.crawler
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

object Main{
  def getDocument(html:String):Document = Jsoup.parse(html)
  def getUrlDocument(url:String):Document = Jsoup.parse(Jsoup.connect(url).userAgent("Mozilla").get().outerHtml())
  def getFilterTaga() = getUrlDocument("http://dropbooks.tv/tops/index/sort:download_count/direction:desc/term:24h/page:1")
      .select("a[href]")
  def main(args:Array[String]){
    getFilterTaga().toString().split("\n").filter { x => x.contains("/detail/") }.foreach { x => println(x) }
//    println(getDocument((getFilterTaga())))
  }
}
