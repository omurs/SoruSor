<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ask a Question Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 	
    <div class="generic-container">
    <div class="well lead">Ask a Question Form</div>
    <form:form method="POST" modelAttribute="question" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="text">Question</label>
                <div class="col-md-7">
                    <form:input type="text" path="text" id="text" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="text" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
 
        
<!--                 <label class="col-md-3 control-lable" for="subjects">Subjects</label> -->
<!--                 <div class="col-md-7"> -->
<%--                     <form:select path="id" items="${subjects}" multiple="true" itemValue="name" itemLabel="name" class="form-control input-sm" /> --%>
<!--                     <div class="has-error"> -->
<%--                         <form:errors path="subject" class="help-inline"/> --%>
<!--                     </div> -->
<!--                 </div> -->
           
        
        <div class="row">
            <div class="form-group col-md-12">
             <div class="col-md-7">
				<form:select path="subject.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${subjects}" itemValue="id" itemLabel="name"/>
        		</form:select>
					
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
                        <input type="submit" value="Save Question" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listQuestions' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>