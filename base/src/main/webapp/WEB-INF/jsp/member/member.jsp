<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/template/top.jsp"%>
	
<div class="container" ng-app="ngMember">
	<ng-view></ng-view>
</div>
	
	<script src="resources/js/member/member.js"></script>
	<script src="resources/js/member/service/memberService.js"></script>
	<script src="resources/js/member/controller/memberDetailController.js"></script>
	<script src="resources/js/member/controller/memberUpdateController.js"></script>
	<script src="resources/js/member/controller/memberNewController.js"></script>
	<script src="resources/js/member/controller/memberListController.js"></script>
	
<%@include file="/WEB-INF/jsp/template/bottom.jsp"%>