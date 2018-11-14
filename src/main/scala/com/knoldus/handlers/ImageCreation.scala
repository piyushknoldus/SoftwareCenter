package com.knoldus.handlers

import com.knoldus.utils.Constants

import scala.sys.process.Process

object ImageCreation {

  def buildTestDockerImage(userName : String, repoName:String, tagName:String): Boolean = {
    val pathToTestImage = "/home/piyush/workstation/SoftwareCenter/src/main/scala/com/knoldus/docker/testdockerfile"
    val testDockerImageCmd = s"docker build -t $repoName:$tagName --build-arg USERNAME=$userName $pathToTestImage"

    val res = try {
      println(s"${Console.GREEN} ${Constants.started} ${Console.RESET}")
      val res = Process(testDockerImageCmd).lineStream
      println(res)
      true
    }
    catch
      {
        case ex:Exception => println(s"Something goes wrong!!! ${ex.getMessage}")
          false
      }
    println(s"${Console.GREEN} ${Constants.completed} ${Console.RESET}")
    res
  }

}
