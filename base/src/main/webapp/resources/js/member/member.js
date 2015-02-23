/**
 * module 생성 
 * module 이름을 ngMember로 설정
 * 두번째 인자를 이용하여 다른 여러 모듈을 참조할 수 있다. (ngCookies,ngResource...)
 * ng-app diretive에서 모듈명을 ng-app 속성값으로 지정할 수 있다.
 * ex) ng-app='ngMember'
 */

//MVC 패턴을 위한 모듈 설정

//1.
//ngMember 모듈을 화면템플릿구성을 위한 ngRoute 모듈과 member와 관련된 모듈을 참조한다.
//member의 모든 모듈은 ngMember.member로 표현
angular.module("ngMember",['ngRoute','ngMember.member']);

//2.
//ngMember.member 모듈은 member와 관련된 모든 모듈을 참조하도록 설정한다.
//ngMember.member.controller,ngMember.member.service .. 등 (filter, diretive...)
angular.module("ngMember.member",['ngMember.member.controller','ngMember.member.service']);

//3.
//ngMember.member.controller 설정
angular.module("ngMember.member.controller",[]);

//4.
//ngMember.member.service에 RESTful 서비스 구현을 위한 ngResource모듈과 context url설정을 위한 ngContext모듈 참조
angular.module("ngMember.member.service",['ngResource','ngContext']);

//VIEW 설정
//ngMember모듈 config : route를 이용하여 url별 템플릿 설정
//list와 detail처럼 화면전환 시 데이터가 필요한 경우 resolve처리를 한다.
angular.module("ngMember")
	.config(['$routeProvider',function($routeProvider){
		$routeProvider
			.when('/members/page/:page',
				{ templateUrl : 'resources/template/member/member-list.tmpl.html',
				  controller : 'memberListController',
				  resolve : {
					  result : function(memberService,$rootScope,$route){
						//page에 따라 url 변경!!
						//url 변경을 통해 같은 템플릿에서 히스토리 이동이 가능하도록 하기 위해서!!
						if($rootScope.member==undefined){$rootScope.member={};};
						$rootScope.member.page = $route.current.params.page;
						return memberService.selectList($rootScope.member).$promise;
					}
				}})
			.when('/members/new',
				{ templateUrl : 'resources/template/member/member-new.tmpl.html',
				  controller : 'memberNewController'
				})	
			.when('/members/:id',
				{ templateUrl : 'resources/template/member/member-detail.tmpl.html',
				  controller : 'memberDetailController',
				  resolve : {
					  //$routeParams는 route가 변경된 후에 사용할 수 있다. 
					  //그래서 $route를 이용하여 파라미터 전달
					  detail : function(memberService,$route){
						return memberService.selectDetail($route.current.params.id).$promise;
					}
				}})
			.when('/members/update/:id',
				{ templateUrl : 'resources/template/member/member-update.tmpl.html',
				  controller : 'memberUpdateController',
				  resolve : {
					  detail : function(memberService,$route){
						return memberService.selectDetail($route.current.params.id).$promise;
					}
				}})
			.otherwise({redirectTo:'/members/page/1'});
	}])
	.run(function($rootScope) {
		/*
		$rootScope.$on('$locationChangeStart', function (event,newUrl,oldUrl) {
	        console.log('$locationChangeStart !', new Date());
	    });
		
		$rootScope.$on('$locationChangeSuccess', function ($location,$rootScope) {
	        console.log('$locationChangeSuccess changed!', new Date());
	    });
		*/
		
	})
	.controller('mainController',['$scope','$rootScope',function($scope,$rootScope){
		
		//$scope.$emit('menu:active',true);
		
		//검색버튼 클릭할 경우 - 검색어 객체를 rootScope에서 받아서 저장해 두기
		/*
		$rootScope.$on("search:keywords",function(e,object){
			
		});
		*/
	}]);





