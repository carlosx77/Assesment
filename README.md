# Assesment
Assesment


To execute this application you need to install
apache-maven-3.9.1
Openjdk-11.0.2
Checkout https://github.com/carlosx77/Assesment.git
Once installed make sure your environment variables are pointing to bin directories of these to applications
On a CMD navigate to the directory where you checked out the code 
locate and navigate to Assesment/rewardsApp directory
run: mvn clean install
This will build and unit test the application 
Now run the application using: mvn spring-boot:run
To test the application open another cmd and run: 
curl -X GET http://localhost:8080/api/v1/reward-points/rewards/1/2022
You should get a JSON response similar to this one:
{"year":2022,"pointsPerMonth":[{"month":"FEBRUARY","pointsPerYear":60},{"month":"MARCH","pointsPerYear":700},{"month":"JUNE","pointsPerYear":210},{"month":"JULY","pointsPerYear":450},{"month":"OCTOBER","pointsPerYear":40}],"pointsPerYear":1460}
