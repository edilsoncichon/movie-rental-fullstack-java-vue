# WebService API (JAVA) + Client (Vue.js)

This is software for managing a movie rental company.
The `client` folder contains the frontend built in Vue.js.
And the `web-service` folder contains the backend built in Java.

## Highlights
* Implementation of Hibernate;
* Frontend is a SPA;
* Layered architecture in Backend;
* Isolated domain / business rule;
* Code clean;

## Backend Installation
You will need to install the following requirements:
* MySQL 5.7 or higher.
* GlassFish 3 or higher.

Netbeans IDE 8 was used.
Set up the database connection in the Hibernate configuration file: `webservice / src / java / config / database / hibernate.cfg.xml`.

Import the `backup_banco.sql` file to MySQL, this will already create the structure and populate the base with test information.

## Frontend Installation
You will need the following requirements:
* Node.js 9 or higher;
* NPM

Commands:

npm install

npm run dev
