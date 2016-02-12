<?xml version="1.0" encoding="UTF-8"?> 
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<contents>
<c:forEach items="${list}" var="contentVO">
	<content>
		<content_title>${contentVO.content_title}</content_title>
		<content_OriPrice>${contentVO.content_OriPrice}</content_OriPrice>
		<content_deadline>${contentVO.content_deadline}</content_deadline>
		<content_SellingPrice>${contentVO.content_SellingPrice}</content_SellingPrice>
		<user_kakao>${contentVO.user_kakao}</user_kakao>
	</content>
</c:forEach>	
</contents> 

