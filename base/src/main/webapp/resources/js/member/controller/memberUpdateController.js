/**
 * controller module 구현 
 * 템플릿별 controller 따로 구현
 * 수정화면 템플릿용 controller
 */
angular.module('ngMember.member.controller')
	.controller('memberUpdateController',['$scope','detail','memberService','$location',function($scope,detail,memberService,$location){
		
		//resolve되어 넘어온 상세정보 detail을 scope에 setting
		$scope.member = detail;

		//취소버튼에 기능 설정
		$scope.memberList = function(member){
			//상세화면으로 이동
			$location.url('/members/'+member.id);
		};
		
		//수정버튼에 기능 설정
		$scope.updateMember = function(member){
			var updatePromise = memberService.modifyData(member).$promise;
			
			updatePromise.then(function(){
				//상세화면으로 이동
				$location.url('/members/'+member.id);
			});
		};
		
	}]);

