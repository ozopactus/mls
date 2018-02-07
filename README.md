 
# Java mls test task

This application realizes servlet that outputs list of Parts in HTML format, using Tomcat, Postgresql, Maven, Servlets, JDBC and JSP, no ORM, no Spring.

### Running
To use this application you must have:

1)Postgresql installed and running, if not please check out download page and follow installation instructions.
All database settings are in the \src\main\resources\db.properties file. Use it to define driver of your DB, base url, login and password. 
it is assumed that in the database you have a table or view with the following fields: part_number varchar, part_name varchar, vendor varchar, qty integer, shipped date, received date.

2)Maven, if not please check out maven installation page.

3)Java version 1.8 and higher.

Clone the repository from github.com to your workspace folder:
```
$ git clone https://github.com/ozopactus/mls.git
```
Navigate to the repository folder:
```
$ cd mls
```
Run app, using maven:
```
mvn clean install tomcat7:run
```
open browser at http://localhost:8080/mls/

### Requirements:
- List of Parts is a table with the columns corresponding to Part fields.
- Before the table on page there is a filter which allows to filter output Part records.
- If none of the filter fields is specified then all Parts should be shown.
- The table can be sorted by any of the columns by clicking on their header (one click - ASC order, next click - DESC order).
- Sorting performed only by one column at a time.
- When user uses sorting - filtering is still applied.
- Output and input format for dates is “MMM dd, yyyy”
- Parts are stored in database.
- No interfaces to edit or add Part are needed.
Filter notes:
- Text fields are filtered using “like” criteria.
- Integer fields are filtered using “not less” criteria.
- Date fields are filtered using range (after, before) criteria.
