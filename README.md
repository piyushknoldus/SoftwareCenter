# SoftwareCenter
Get All Docker Images for your Beloved Software's.

Usage Example - 

Running the Software - 

sbt run

output - 

 WELCOME TO !!! s Ꮎ f T Ꮃ Ꭺ Ꮢ Ꭼ  -  Ꮯ Ꭼ Ꮑ t Ꭼ Ꮢ !!!   
 ------ GET ALL YOUR DOCKER IMAGES CREATED NOW ------  
Enter 1-->HelloMe Images
Enter 2-->kafka Images
Enter 3-->Cassandra Images
Enter 4-->Scala/Sbt Images
Enter 5-->HDFS Images
Enter Q/q-->Quit The App

If you select 1 (i.e Type 1 in console)

1
Please enter your name you want in your test image
PiyushRana
Please enter your repo name
test
Please enter the tag name for your image
helloImage

Started building your docker image 
...... Docker Image Created Successfully ......
Type in another shell command : 'docker images' to view AND 
to run :'docker run -it imageID /bin/bash' 

Sample Docker File used to create this Image -

FROM ubuntu
ARG USERNAME
ENV USERNAME ${USERNAME:-"SoftwareCenter"}
CMD ["sh", "-c", "echo env var: ${USERNAME}"]

For Testing - 

- Check the docker image that has been created on your Local - 

docker images -a
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
test                helloImage          ea0b46c6f198        3 hours ago         85.8MB
ubuntu              latest              ea4c82dcd15a        3 weeks ago         85.8MB


- Run image and check the ENV variable name we override i.e "PiyushRana"
docker run -it test:helloImage

Output - Hello: PiyushRana

- Run image and Print your own name i.e "KnoldusSoftware"
docker run -it -e USERNAME=KnoldusSoftware test:helloImage

Output - Hello: KnoldusSoftware
