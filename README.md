# Health-Care-Backend

##Overview

* Health Care is an Epidemic data collection system for the Epidemiology department of Ministry of Health. The system comprise of
a mobile application using android along with a server built using java spring framework. 

* The repository contains the server of the application, which will be handling the centralized services of the system. 

  
##Frameworks Used

* The web backend of the system has been built with spring framework with NO ORM.

* The application uses JWT token based authentication scheme without the token refreshing or expiration. 

* The authentication middleware of the application has been custom built as a component of the controller mappings with the URL.

* The layers above the persistent layer runs independent of the database used for the service. The repository contains the implementation for MySQL, and the support can be extended for other database systems as well.

##Backend Software Design
![alt tag](https://raw.githubusercontent.com/ThejanW/Health-Care-Backend/master/Software Design.png)


##Database Design
![alt tag](https://raw.githubusercontent.com/ThejanW/Health-Care-Backend/master/DB_Schema.png)


##Mobile application

https://github.com/prasannadeshappriya/HealthCare-MobileApp


##Image courtesy

Thejan Wijesinghe ( https://github.com/ThejanW  ) 
