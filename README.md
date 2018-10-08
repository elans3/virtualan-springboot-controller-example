Spring-boot RestController With Virtualan
==========================================

- Build:

         mvn clean install
                  
- Run using standalone JAR:

	java -jar target/virtualan-spring-controller-example-1.0.0.jar         

- To set up mock data:
     
     -Using Virtualan-UI:   
          
	  https://github.com/elan-venture/virtualan/wiki/Test-Data-Set-up-using-Virtualan
      
      - Using Virtualan-Rest service:
      
          https://github.com/elan-venture/virtualan/blob/master/test/virtualan-test-data/src/main/resources/features/pet/pet.feature
	  https://github.com/elan-venture/virtualan/tree/master/samples/virtualan-openapi-spring-mapping/src/test/java/io/virtualan/test

- Invoke User REST service:  
     
     curl http://localhost/users

- Invoke Virtualan UI:  			
  
  	Navigate to http://localhost/virtualan-ui.html 
	More details about the user interface refer: https://github.com/elan-venture/virtualan/wiki 
