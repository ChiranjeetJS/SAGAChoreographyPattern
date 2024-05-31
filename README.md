# SAGAChoreographyPattern
SAGA Chorography pattern is apopular design pattern used for handling microservices communication asynchronously using a messaging system.
The microservice perform their task and publish an event to notify other microservices. The events are then consumed by other microservices which perform their task.
In this project there are 3 different microservices Order Service,Payment Service,Email Service.
The Order Service gets triggered when a user request for a product.
The Order Service triggers an event to Payment Service which processes the payment.
The Payment Service after completing payment triggers event to Email Service for notification
