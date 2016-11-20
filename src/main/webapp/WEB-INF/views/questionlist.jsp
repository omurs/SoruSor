<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Questions List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
  
        
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Questions List</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Question</th>
                        <th>Subject</th>
                        <th>Asked by</th>
                        <th width="100"></th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${questions}" var="question">
                    <tr>
                        <td>${question.text}</td>
                        <td>${question.subject.name}</td>
                        <td>${question.user.email}</td>
                        <td><a href="<c:url value='/answer-question-${question.id}' />" class="btn btn-success 
 
custom-width">Answer</a></td>
                        
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/newquestion' />">Add AskQuestion</a>
        </div>
    </div>
</body>
</html>