Spring-boot RestController With Virtualan
==========================================

*Prerequisites:* (If you have already done set up JDK and Maven - skip this step)
- JDK(Mandatory) -  http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
    - JDK Installation:(Refer following Video and Article
    	- https://www.youtube.com/watch?v=r0jN33ZOmWM 
		- https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html (till step 4)
     - JAVA_HOME set up(Mandatory) :
     	- http://roufid.com/no-compiler-is-provided-in-this-environment/
- Apache Maven(Mandatory)  - https://maven.apache.org
     - Apache Maven: (Refer following Video and Article)
     	- https://www.youtube.com/watch?v=3ODSQ0EpoQI
		- https://www.mkyong.com/maven/how-to-install-maven-in-windows/-
- GIT (optional)
     - GIT Setup(Optional): (Refer following Video and Article)
     	- https://www.youtube.com/watch?v=albr1o7Z1nw
		- https://www.codecademy.com/articles/git-setup
  
*Download the project and extract the project file*:

- Navigate to root directory of the folder where pom.xml was present:

- Build:

         - mvn clean install  
	 
	 - If you have any proxy issue use this command:  mvn -Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2 clean install 
                  
- Run using standalone JAR:
	
	- java -jar target/virtualan-springboot-controller-example-1.0.0.jar         

- To set up mock data:
      
      - Using Virtualan-UI:       
      	https://github.com/elan-venture/virtualan/wiki/Test-Data-Set-up-using-Virtualan
      
      - Using Virtualan-Rest service:
      	https://github.com/elan-venture/virtualan/blob/master/test/virtualan-test-data/src/main/resources/features/pet/pet.feature
	  	https://github.com/elan-venture/virtualan/tree/master/samples/virtualan-openapi-spring-mapping/src/test/java/io/virtualan/test

- Invoke User REST service:  
     using your rest client or curl http://localhost:8080/users

- Invoke Virtualan UI:  			
	- Navigate to http://localhost:8080/virtualan-ui.html 
	- More details about the user interface refer: https://github.com/elan-venture/virtualan/wiki 
