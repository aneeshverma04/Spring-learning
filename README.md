# Spring-learning

1. start.spring.io => spring initializer and backing service
					quick way to start projects
2. Download and unzip 

3. subl src/main/resources/static/index.html ==> for static pages

4.  $ mvn clean package
	$ java -jar target/initial-boot-app-0.0.1-SNAPSHOT.jar

/*
A JavaBean is just a standard

All properties private (use getters/setters)

A public no-argument constructor

Implements Serializable.

*/


/*
@EnableAutoConfiguration
allows for config classes to be scanned dynamically
usually the jars on classpath

driven off of spring.factories

order of autoconfiguration:
@AutoConfigureBefore
@AutoConfigureAfter

Conditional loading
@ConditionalOnClass
@ConditionalOnBean
@ConditionalOnProperty
@ConditionalOnMissingBean

@EnableCofigurationProperties ==> Preconfigured "default" properties for AutoConfiguration classes
*Properties can always be overridden

*/

5. PROPERTY BASED CONFIGURATIONS:

application.properties =>
C:\Users\aneesh.verma\Desktop\initial-boot-app\src\main\resources

environment variables =>
modify the run time environment to give specific configuration properties for that environment itself

command line injections =>
inject at command line different properties of spring app

cloud configurations =>
inject in cloud


6. BEAN BASED CONFIGURATION =>
Add beans to default app class
Add beans to separate config class
importing xml-based configurations
component scanning


7. Profiles:
Flex configuration based on environment
application.yml

spring.profiles.active  ==>env variable

application.yml file is superset of json..easier to read.
set multiple profiles on multiple ports on application.yml file

java -jar -Dspring.profiles.active=dev target/initial-boot-app-0.0.1-SNAPSHOT.jar
=> runs on port 8000

java -jar -Dspring.profiles.active=test target/initial-boot-app-0.0.1-SNAPSHOT.jar
=> runs on port 9000


8.THIRD PARTY DEPENDENCIES:
with a config server

9. ACTUATORS
After disabling security
	http://localhost:9000/env => environment variables
	http://localhost:9000/health => status etc
 	http://localhost:9000/mapping => all mappings

10. Spring boot default web dependencies:
	a. Embedded Tomcat Server 	
 	b. JSON Marshaller 
 	c. Logging Frameworks (Slf4J)
 	d. Spring libraries including auto configure,boot starter,core,AOP,beans,context,expression
 	e. Other libraries:
 		SnakeYAML => allows to read those YAML files and convert them to properties at runtime
 		Validators => javax and hibernate
 
 11. Configuring embedded Tomcat:
 	as default configurations of tomcat can be a flaw to security
 			
 	Spring boot autoconfigures the default servlet for all reponses at "/"
 	
 	Own servlets,listeners,filters etc:
 		To do that configure them as beans
 			2 ways of doing that		
				a. Property Based: 
					Just like in server.port..others server.address,server.contextPath
					session based configs (cookies,timeouts, etc)
					Error page path
					
					Compression
					server.compression.enabled=true
					Response must be 2mb to compress by default
					
					Migrate servet container from Http to TLS/SSL
						Native SSL support
						everything should be encrypted
						native ssl support via property management
						requires a java keystore that contains the certificate
						HashiCorp vault
						
						cd src/main/resources
						keytool -genkey -keyalg RSA -alias linkedin -keystore keystore.jks -storepass password -validity 4000 -keysize 2048
						http --verify=no https://localhost:8071/api/greeting  //just like curl for fetching data in terminal
						
						in applications.yml
						server:
  							port: 8071
  							ssl:
   							 key-store: classpath:keystore.jks
   							 key-store-password: password
   							 key-store-type: JKS
   							 key-alias: linkedin
  						 	 key-password: password
  						
  						THIS WILL DISABLE ALL HTTP REQUESTS AND ONLY HTTPS REQUESTS WILL WORK 	 
12. MVC
							
						
						
