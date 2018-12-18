#
# Scala and sbt Dockerfile
#
# https://github.com/piyushknoldus/SoftwareCenter.git
#

# Pull base image
FROM openjdk:11.0.1-jdk

# Env variables
ARG SCALA_VERSION
ENV SCALA_VERSION ${SCALA_VERSION:-2.12.0}

ARG SBT_VERSION
ENV SBT_VERSION ${SBT_VERSION:-1.0.0}

# Scala expects this file
RUN touch /usr/lib/jvm/java-11-openjdk-amd64/release

RUN echo "installing the scala - " $SCALA_VERSION
RUN echo "installing sbt version - " $SBT_VERSION

# Install Scala
## Piping curl directly in tar
RUN \
  curl -fsL https://downloads.typesafe.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz | tar xfz - -C /root/ && \
  echo >> /root/.bashrc && \
  echo "export PATH=~/scala-$SCALA_VERSION/bin:$PATH" >> /root/.bashrc

# Install sbt
RUN \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion

# Define working directory
WORKDIR /root