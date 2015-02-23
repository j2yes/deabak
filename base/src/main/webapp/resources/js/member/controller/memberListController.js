/**
 * controller module 구현 
 * 템플릿별 controller 따로 구현
 * 목록화면 템플릿용 controller
 */
angular.module('ngMember.member.controller')
	.controller('memberListController',['$scope','result','$location','memberService','$rootScope',function($scope,result,$location,memberService,$rootScope){

		//resolve되어 넘어온 result에서 list값 get
		$scope.memberList = result.list;
		
		
		//검색어 및 페이징 처리를 위한 parameter용 member객체
		$scope.member = result.defaultObj;
		
		
		//list템플릿에서 '새로가입' 버튼을 클릭 시 호출될 함수 
		$scope.createMember = function(){
			$location.url('/members/new');
		};
		
		
		//페이지이동
		$scope.moveMemberPage = function(member){
			
			var pagingParameter = {};
			pagingParameter.page = member.page;
			pagingParameter.limit = member.limit;
			
			//페이지와 관련된 파라미터만 기존 검색어&페이징 처리 parameter 객체어 덮어 씌우기
			//기존 검색어는 유지
			angular.extend($rootScope.member,pagingParameter);
			
			$location.url('/members/page/'+member.page);
			
		};
		
		
		//검색기능
		$scope.search = function(member){
			
			//검색 버튼 클릭 시 rootScope에 검색어 object 저장
			$rootScope.member = member;
			
			//검색 시 항상 초기 페이지는 1페이지로 설정
			if(member.page!=1){
				$location.url('/members/page/1');
			
			//1페이지에서 검색할 경우 url 변경없이 데이터만 갱신
			}else{
				var searchPromise = memberService.selectList(member).$promise;
				
				searchPromise.then(function(searchedResult){
					//검색된 데이터 setting
					//url 변화없이 데이터 갱신
					$scope.memberList = searchedResult.list;
					$scope.member = searchedResult.defaultObj;
				});
			}
			
		};
		
		
	}]);

