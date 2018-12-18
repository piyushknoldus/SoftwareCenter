package main.scala

import com.knoldus.handlers.ImageCreation
import com.knoldus.utils.Menu

import scala.io.StdIn

object SearchMe extends App with Menu{

  var input: String = ""
  println(s"${Console.YELLOW} WELCOME TO !!! s Ꮎ f T Ꮃ Ꭺ Ꮢ Ꭼ  -  Ꮯ Ꭼ Ꮑ t Ꭼ Ꮢ !!!  ${Console.RESET} ")
  println(s"${Console.YELLOW} ------ GET ALL YOUR DOCKER IMAGES CREATED NOW ------ ${Console.RESET} ")
  do {
    menuMap.toSeq.sortBy(_._1) foreach {case (key, value) => println ("Enter " + key + "-->" + value)}
    input = StdIn.readLine()
    input match {
      case "1" => {
        println("Please enter your name you want in your test image")
        val userName = StdIn.readLine()
        println("Please enter your repo name")
        val repoName = StdIn.readLine()
        println("Please enter the tag name for your image")
        val tagName = StdIn.readLine()
        ImageCreation.buildTestDockerImage(userName,repoName,tagName)
      }

      case "2" => println("Kafka coming soon !!!!!!!!!!!!!!!!!!!!!!!!!!!!")
      case "3" => println("Cassandra coming soon !!!!!!!!!!!!!!!!!!!!!!!!")
      case "4" => {
        println("Please enter your scala version")
        val scalaVersion = StdIn.readLine()
        println("Please enter your sbt version")
        val sbtVersion = StdIn.readLine()
        println("Please enter your repo name")
        val repoName = StdIn.readLine()
        println("Please enter the tag name for your image")
        val tagName = StdIn.readLine()
        ImageCreation.scalaDockerImage(scalaVersion,sbtVersion,repoName,tagName)
      }
      case "5" => println("Hdfs coming soon !!!!!!!!!!!!!!!!!!!!!!!!!!!!!")

      case "q"|"Q" => System.exit(0)
      case _ => println(s"${Console.BLUE}${Console.BOLD} Not a valid Input-- please type what's in options! ${Console.RESET}")
    }
  } while (input != "q")
}
