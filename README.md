# SpringBoot-Example <br />
*Project Name*: 	reward-system<br />
*Build*:	Maven<br />
*Frameworks*:	Spring Boot, Spring MVC for REST<br />
*Maven command to run project*: 	mvn spring-boot:run<br />
*API Endpoint*:	http://localhost:8181/rewards<br />
*Server port*: 8181 (Configured in application.properties)<br />
*Implementation*:	Implemented a REST web service (POST /rewards)  which will accept json payload and return expected result as a json response.<br /> <br />

*Assumptions*: <br />
1) Assuming that input payload will have following structure (for brevity)<br />
{ <br />
   "vouchers":[ ] <br />
   "credits":[ ]  <br />
} <br />
2) Response will be list/array of type Reward <br />
[     { <br />
        "credit": [     ],  <br />
        "voucher": [   ], <br />
        "firstname":  <br />
        "lastname":   <br />
    }   ] <br />
