/**
 * controller module 구현 
 * 템플릿별 controller 따로 구현
 * 상세화면 템플릿용 controller
 */
angular.module('ngMember.member.controller')
	.controller('memberDetailController',['$scope','detail','memberService','$location','$rootScope',function($scope,detail,memberService,$location,$rootScope){
		
		//resolve되어 넘어온 상세정보 detail을 scope에 setting
		$scope.member = detail;
		
		
		//목록버튼에 기능 설정
		$scope.memberList = function(){
			//목록화면으로 이동
			$location.url('/members/page/'+$rootScope.member.page);
		};
		
		//수정버튼에 기능 설정
		$scope.modifyMember = function(member){
			//수정화면으로 이동
			$location.url('/members/update/'+member.id);
		};

		//삭제버튼에 기능 설정
		$scope.deleteMember = function(member){
			var deletePromise = memberService.deleteData(member.id).$promise;
			
			deletePromise.then(function(){
				//목록화면으로 이동
				$location.url('/members/page/'+$rootScope.member.page);
			});
		};
	}]);

