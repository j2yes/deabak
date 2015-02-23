/**
 * controller module 구현 
 * 템플릿별 controller 따로 구현
 * 등록화면 템플릿용 controller
 */
angular.module('ngMember.member.controller')
	.controller('memberNewController',['$scope','memberService','$location','$rootScope',function($scope,memberService,$location,$rootScope){
		
		$scope.member = {};
		
		//'가입' 버튼에 기능 추가
		$scope.insertMember = function(member){
			var insertPromise = memberService.insertData(member).$promise;
			
			//데이터 추가 후 목록화면으로 전환
			insertPromise.then(function(){
				//목록화면으로 이동
				$location.url('/members/page/'+$rootScope.member.page);
			});
		};
		
	}]);
