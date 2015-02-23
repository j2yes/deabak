<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/template/top.jsp"%>


<body ng-app="ngBookmark">
<div ng-controller="bookmarkMainCtrl">

	<div class="container">
		<ng-view></ng-view>
	</div>

	<script src="resources/js/bookmark/app.js"></script>
	<script src="resources/js/bookmark/service/bookmarkSvc.js"></script>
	<script src="resources/js/bookmark/controller/bookmarkDetailCtrl.js"></script>
	<script src="resources/js/bookmark/controller/bookmarkAddCtrl.js"></script>
	<script src="resources/js/bookmark/controller/bookmarkListCtrl.js"></script>
</div>
</body>


<%@include file="/WEB-INF/jsp/template/bottom.jsp"%>

