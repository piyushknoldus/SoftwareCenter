package main.scala

import scala.sys.process.Process

object SearchMe extends App {

  var input: String = ""
  do {
    println("Get all the docker images self created right now-------")
    println("Enter 1 for Test Image")
    println("Enter 2 for Kakfa related images")
    println("Enter q for Test Image")

    input = readLine()

    input match {
      case "1" => {
        println("Goona give you a test docker image .. Please enter the version you want-")
        val input_for_version = readLine()
        buildTestDockerImage(input_for_version)
      }
      case "2" => println("coming soon !!!!!!!!!!!!!!!!!!!!!!!!!!!!")
      case "q" => System.exit(0)
      case _ => println("not a valid input-- please type what's in options!")
    }
  } while (input != "q")

  def buildTestDockerImage(version : String) = {
    val pathToTestImage = "/home/piyush/workstation/SoftwareCenter/src/main/scala/com/knoldus/docker/testdockerfile"
    val testDockerImageCmd = s"docker build --build-arg CONT_IMG_VER=$version $pathToTestImage"
    println("started building your docker image")
    Thread.sleep(2000)
    Process(testDockerImageCmd).lineStream_!
    println("done.. docker images to view and docker run imageiD -it /bin/bash to get into it")
  }
}
