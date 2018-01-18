# Webontwikkeling 3
Deze repo bevat de website, de theorie en de labs die gemaakt moesten worden voor het project webontwikkeling 3. 

## Web.xml
Dit is een mavenproject gemaakt in Intellij. Om dit project te doen werken moet
er nog wel een web.xml file worden gemaakt. De paramaters van deze file zijn: 
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
        version="3.1">
    <jsp-config>
        <jsp-property-group>
            <url-pattern>*.jsp</url-pattern>
            <scripting-invalid>true</scripting-invalid>
        </jsp-property-group>
    </jsp-config>
    <error-page>
        <exception-type>java.lang.Throwable</exception-type>
        <location>/error.jsp</location>
    </error-page>
    <context-param>
        <param-name>url</param-name>
        <param-value>jdbc:postgresql://link-database:port/db-name?currentSchema=schema</param-value>
    </context-param>
        <!-- user-name not YET Used in current version--> 
    <context-param>
        <param-name>db-name</param-name>
        <param-value>test</param-value>
    </context-param>
    <context-param>
        <param-name>user-name</param-name>
        <param-value>name</param-value>
    </context-param>
    <context-param>
        <param-name>password</param-name>
        <param-value>secretpass</param-value>
    </context-param>
</web-app>
```

## Sql tables

##### Persoon
| persoon_id    | fname | lname  | email | password | salt | role |
|:-------------: |:----:| :-----:|:-----:|:-------: |:----:|:----:|
| serial | varchar(30) | varchar(30)  | varchar(50) | varchar(128) | varchar(40) | varchar(20) 

##### Product
| id_product    | naam | omschrijving  | prijs | 
|:-------------:|:----:|:-------------:|:-----:|
| serial | varchar(30) | varchar(200)  | real | 


