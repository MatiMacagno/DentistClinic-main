# DentistClinic
Integration TP for Backend I
Integrating work
Shift reservation system
You want to implement a system that allows you to manage the reservation of shifts for a
dental clinic. This must meet the following requirements:
● Dentist data management: list, add, modify and delete
dentists. Register last name, first name and license plate of the same.
● Patient data management: list, add, modify and delete
patients. For each one, the following are stored: name, surname, address, ID and date of
high.
● Register shift: it must be possible to allow a patient to be assigned a shift with
a dentist at a certain date and time.
● Login: validate the entry to the system by means of a login with username and password. HE
must allow any logged in user (ROLE_USER) to register a turn, but
only those who have an administration role (ROLE_ADMIN) can manage
dentists and patients. A user can have a single role and they can be
They will be entered directly into the database.
Technical requirements
The application must be developed in layers:
● Business entities layer: they are the Java classes of our business
modeled through the object-oriented paradigm.
● Data access layer (Repository): these are the classes that will be in charge of
access the database.
● Data layer (database): it is the database of our system
modeled through an entity-relationship model. We will use the H2 base for its
practicality.
● Business layer: these are the service classes that are in charge of decoupling the
view data access.
● Presentation layer: these are the web screens that we will have to develop
using the Spring Boot MVC framework with controllers and some of
these two options: HTML+JavaScript or React for the view.
It is important to perform exception handling by logging any exceptions that are
can generate and carry out unit tests to guarantee the quality of the
developments.
progress
The work will have a single final delivery, but to help you organize, we will
We suggest that you proceed as follows:
Sprint 0 (Start)
Initiated the subject with the knowledge already acquired in Programming Oriented to
Objects, Database I and Front End I, you can start building your UML model of the
classes that you will need for the integrative project as well as everything related
to the relational database tables that you will need to persist the data and the
HTML screens with their styles to enter them. Do not worry that during
All the course you will learn to integrate all these parts!!!
Sprint 1 (Start of week 1 to End of week 2)
With what you have learned during these weeks you will be able to carry out unit tests of the
Java classes you programmed. To make sure from now on that with each
change your software continues to work unit tests are very important.
Sprint 2 (Start of week 3 to End of week 4)
During this sprint with everything learned during the course in class 18 you will be able to
work with Maven on your project to reference your libraries and with what we saw in the
class 14 you will be able to build your DAO classes (data access layer with JDBC) and the classes
service (business layer) for each of the entities of your project, being able to
always guarantee the operation of everything you build using
unit tests.
Sprint 3 (Start of week 5 to End of week 6)
Throughout this sprint you will be refactoring the data access layer to be able to
access and retrieve them through an ORM. Creating the mappings and classes
Repository that will be replaced by the DAO fulfilling the same function.
With everything learned in classes 25, 27 and 28 you will be able to build during this sprint the
APIs (through the development of the controllers) and the integration with the layer of
presentation, that is, the HTML screens, through javascript.
Sprint 4 (Start of week 7 to End of week 8)
The simplest remains for last. With the knowledge acquired in class 43
You can very easily add a login to your project with Spring Security.
Class 48 delivery. You will have time throughout the day to deliver until 23:59
hours.
