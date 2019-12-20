# munApp background

MUN.ly is a Model United Nations Conference Web Application 
that organizes various aspects of the organizational and logistical
needs that a Model United Nations Conference organizers and its members
may need to operate, which is why many features of the application are suited 
specifically to MUNs. However, this same application could be extended for use by any 
other conference organizers and their members. One of our goals was to solve the challenge of
attendance organization: conventionally, Model UN Conferences use pen and paper to keep
track of attendance, and having this information in a database can help answer questions 
relating to the future amount of materials needed for conference needs based on past attendance,
which schools contributed the most members or even the integrity of members. Registration in 
conventional Model UN Conferences is done through Google Form/Excel Spreadsheet, but this 
unnormalized data cannot be connected to other information – thus, for example, a member can 
register but not attend their designated meetings. Scheduling is also inefficiently done at the 
conferences – generally, members are given a paper schedule at the beginning of the conference that
they can lose. Having a digital schedule would also lessen paper use. Our application supports, 
inserts, updates, and deletes data for people, blocs, and events.


Architecture: We use an instance of a SQL Database and MySQL for downsteam inserts, updates, 
and deletes for the object data. The MySQL database is connected to Java through a JDBC. 
For our front-end, we use JSP instead of HTML in order to dynamically display information from Java,
and JSP and Java are connected by a servlet. 

# munApp project

This includes all we have written for this MUN project. We used JDBC to connect Java to MySQL database; Java Servlet and
JSP to dynamically generate HTML page for frond end. We used Tomcat server as a localhost to test out the frond end.

## Project Structure

### `lib`

this is where all external jar files used in this project are placed.

### `out`

this is where all compiled artifacts and Java classes are placed.

### `src`

this is where all Java code is placed. it has three packages: database, Objects and web;

#### `src/database`

we used a json file as our configuration for url, username and password to connect to database; DBUtils is the class reads in the configuration and connect to db; ConnectionTest is used to test db connection;

#### `src/Objects`

we have classes: Args, Bloc, etc to enumerate the corresponding tables in the database;

#### `src/web`

it has two packages: admin and view; admin hosted all Java Servlets of adding, updating, deleting operations. view hosted all Java Servlets of viewing and relating objects.

### `web`

this is where all JSP files and web.xml are located.

#### `web/admin`

it hosted a single admin.jsp for backed by those Servlets in admin package;

####  `web/view`

all JSP files to views objects;

####  `web/WEB-INF`

web.xml to to map Servlets name to Servlets class and Servlets name to url pattern.
