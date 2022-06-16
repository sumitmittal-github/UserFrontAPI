## Validation Rules - 
1. Addition and Multiplication can have more than 2 argument<br />
2. Subtraction and Division should have only 2 arguments<br />
3. In Division, 2nd number can not be 0<br />


### Addition EndPoint : 
POST URL  : localhost:8081/calculator/add<br />
JSON Body : [123.1,789.1]

### Subtraction EndPoint : 
POST URL  : localhost:8081/calculator/subtract<br />
JSON Body : [123.1,789.1]

### Multiplication EndPoint : 
POST URL  : localhost:8081/calculator/multiply<br />
JSON Body : [123.1,789.1]

### Division EndPoint : 
POST URL  : localhost:8081/calculator/divide<br />
JSON Body : [123.1,789.1]