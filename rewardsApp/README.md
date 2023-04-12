# Assesment
Assesment


To execute this application you need to install
apache-maven-3.9.1
Openjdk-11.0.2
Once installed make sure your environment variables are pointing to bin directories of these to applications and that you are using the correct versions.
Then using any git tool checkout this repository: https://github.com/carlosx77/Assesment.git
On a CMD navigate to the directory where you checked out the code 
locate and navigate to Assesment/rewardsApp directory
run: mvn clean install
This will build and unit test the application 
Now run the application using: mvn spring-boot:run
To test the application, to do it: open another cmd and run: 
curl -X GET http://localhost:8080/api/v1/reward-points/rewards/{customerid}/{year}
where {customer} can be '1' or '2' and year '2023' or '2022' the data that is being loaded into the database at startup contains valid information for this data.
For example:
curl -X GET http://localhost:8080/api/v1/reward-points/rewards/1/2022
You should get a JSON response similar to this one:
{"year":2022,"pointsPerMonth":[{"month":"JANUARY","pointsPerYear":0},{"month":"FEBRUARY","pointsPerYear":180},{"month":"APRIL","pointsPerYear":250},{"month":"MAY","pointsPerYear":150},{"month":"AUGUST","pointsPerYear":50},{"month":"SEPTEMBER","pointsPerYear":25}],"pointsPerYear":655}

