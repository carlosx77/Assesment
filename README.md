# Assessment
Assessment


To execute this application you need to install<br />
apache-maven-3.9.1<br />
Openjdk-11.0.2<br />
Once installed make sure your environment variables are pointing to bin directories of these two applications and that you are using the correct versions.<br />
Then using any git tool checkout this repository: https://github.com/carlosx77/Assessment.git<br />
On a CMD navigate to the directory where you checked out the code <br />
locate and navigate to Assesment/rewardsApp directory<br />
run: mvn clean install<br />
This will build and unit test the application <br />
Now run the application using: mvn spring-boot:run<br />
To test the application, to do it: open another cmd and run: <br />
curl -X GET http://localhost:8080/api/v1/reward-points/rewards/{customerid}/{year}<br />
where {customer} can be '1' or '2' and year '2023' or '2022' the data that is being loaded into the database at startup contains valid information for this data.<br />
For example:<br />
curl -X GET http://localhost:8080/api/v1/reward-points/rewards/1/2022<br />
You should get a JSON response similar to this one:<br />
{"year":2022,"pointsPerMonth":[{"month":"JANUARY","pointsPerYear":0},{"month":"FEBRUARY","pointsPerYear":180},{"month":"APRIL","pointsPerYear":250},{"month":"MAY","pointsPerYear":150},{"month":"AUGUST","pointsPerYear":50},{"month":"SEPTEMBER","pointsPerYear":25}],"pointsPerYear":655}<br />
Also you can test the application using swagger, go to: http://localhost:8080/swagger-ui.html<br />
Set the customerId and year and click "Try out!<br />
<br /><br />
