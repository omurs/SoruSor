<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Answer a Question </title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 	
    <div class="generic-container">
    <div class="well lead">Answer a Question </div>
    <form:form method="POST" modelAttribute="answer" class="form-horizontal">
    
        <form:input type="hidden" path="id" id="id"/>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="text">Question :</label>
                <div class="col-md-7">${question.text}</div> 
                    <div class="has-error">
                        <form:errors path="text" class="help-inline"/>
                    </div>
                </div>
            </div>
        
 
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="text">Answer</label>
                <div class="col-md-7">
                    <form:input type="text" path="text" id="text" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="text" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        
          <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listQuestions' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Save Answer" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listQuestions' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        
        <div class="panel-heading"><span class="lead">Previous Answers</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Posted by</th>
                         <th>Answer</th>
                    </tr>
                </thead>
                <tbody>
	                <c:forEach items="${answers}" var="answer">
	                    <tr>
	                        <td>${answer.user.email}</td>
	                         <td>${answer.text}</td>
	                    </tr>
	                </c:forEach>
                </tbody>
            </table>
    </form:form>
    </div>
    </body>
	</html>