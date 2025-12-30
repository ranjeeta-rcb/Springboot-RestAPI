# Springboot-RestAPI- IN ECLIPSE
Spring boot rest api project 
1. right click on the project
2. run on spring boot app
3. to chech the mapping and all
4. go for the post man in collections
5. to get employees - select get method,  localhost/api/v1/employees
6. to post employees select post method , localhost/api/v1/employees go to body select raw ang write the commands in json format   {
        "department": "ECE",
        "id": 3,
        "name": "Sitha",
        "phno": 7685937530,
        "salary": 11500.0
    } in this format and send the request.
7. to update entire information of the employee in postman select "PUT" method and enter the -  localhost/api/v1/employees/5
8. to update partial information of the employee in postman select "PATCH" method and enter the - localhost/api/v1/employees/7
9. to delete select "DELETE" method and  enter this url -localhost/api/v1/employees/7
10. select GET method in postman --> to take perticular recors for page - localhost/api/v1/employees?page=2
11. select GET method in postman --> to sort by phono number -localhost/api/v1/employees?sort=phno
12. select GET method in postman --> to sort by name -localhost/api/v1/employees?sort=name
13. select GET method in postman -->sort by size and salary -  localhost/api/v1/employees?size=1&sort=salary  ---> this is for least paid employee
14. select GET method in postman -->sort by size and descending order of salary - localhost/api/v1/employees?size=1&sort=salary&desc=true ----> highest paid employee

Pagenation---> specifying the records per page i.e(size)


