<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  <center>
<!-- <h1>Students List</h1> -->
<h1>Beneficiary List</h1>  
<form action = "fundTranser">
<table border="5" cellpadding= '8' >  
<tr>

<th>Select</th>
<th>A/C No</th>
<th>Name</th>

</tr>  
   <c:forEach var="customer" items="${BeneficiaryList}">   
   <tr> 
    
   
   <td><input type = "radio" name = "acno2" value = "${customer.acNo}" ></td>
    
   <td>${customer.acNo}</td>  
   <td>${customer.name}</td>  
  
   
   </tr>  
   </c:forEach>  
   </table>
   <br>
   <br>
   
   <input type = "hidden" name = "acno1" value = "${acNum}" ><br><br>
   Enter Amount : <input type = "text" name = "amount"><br><br>
   Enter your pin    : <input type = "password" name = "pin"> <br> <br>
   				  <input type = "submit" value = "Transfer">
   				  </form>
   				  <br><br>
     <!-- <input type = "submit" name = "action" value = "update"> 
      <input type = "submit" name = "action" value = "delete"> -->
    
        
   <br/>  
   <!-- <form action = "updateStudent">
   <input type = "submit" value = "update">
    <form action = "deleteStudent">
   <input type = "submit" value = "delete"> -->
  <form action = "index.jsp">
<input type = "submit" value = "Homepage">
</form> 
   
   </center>