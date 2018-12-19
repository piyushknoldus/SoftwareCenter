package com.knoldus.handlers

import com.knoldus.utils.{Constants, DockerConfig, Logging}

import scala.sys.process.Process

object ImageCreation extends Logging{

  def buildTestDockerImage(userName : String, repoName:String, tagName:String): Boolean = {
    val pathToTestImage = DockerConfig.getValue("test.image")
    val testDockerImageCmd = s"""docker build -t $repoName:$tagName --build-arg USERNAME="$userName" $pathToTestImage"""
    debug(testDockerImageCmd)
    val res = try {
      info(s"${Console.GREEN} ${Constants.started} ${Console.RESET}")
      Process(testDockerImageCmd).lineStream_!.foreach(debug)
      info(s"${Console.GREEN} ${Constants.completed} ${Console.RESET}")
      true
    }
    catch
      {
        case ex:Exception => error(s"Something goes wrong!!! ${ex.printStackTrace()}")
          false
      }
    res
  }

  def scalaDockerImage(scalaVersion : String,sbtVersion : String, repoName:String, tagName:String): Boolean = {
    val pathToTestImage = DockerConfig.getValue("scala.image")
    val testDockerImageCmd = s"docker build -t $repoName:$tagName --build-arg SCALA_VERSION=$scalaVersion --build-arg SBT_VERSION=$sbtVersion $pathToTestImage"
      debug(testDockerImageCmd)
    val res = try {
      info(s"${Console.GREEN} ${Constants.started} ${Console.RESET}")
      Process(testDockerImageCmd).lineStream_!.foreach(info)
      true
    }
    catch
      {
        case ex:Exception => error(s"Something goes wrong!!! ${ex.getMessage}")
          false
      }
    info(s"${Console.GREEN} ${Constants.completed} ${Console.RESET}")
    res
  }

}
