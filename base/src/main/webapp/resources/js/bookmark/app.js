angular.module("ngBookmark",['ngRoute','ngBookmark.bookmark']);

angular.module("ngBookmark.bookmark",['ngBookmark.bookmark.controller','ngBookmark.bookmark.service']);
angular.module("ngBookmark.bookmark.controller",[]);
angular.module("ngBookmark.bookmark.service",['ngResource']);

angular.module("ngBookmark")
 .config(['$routeProvider', function ($routeProvider) {
  $routeProvider
   .when('/bookmarks', 
    { templateUrl: 'resources/template/bookmark/bookmark-list.tmpl.html',
      controller: 'bookmarkListCtrl',
      /* 
       * 라우팅 처리시 북마크 목록 템플릿을 <ng-view> 영역에 삽입하고 나서 
       * 북마크 데이터가 DB로 부터 먼저 로드 될 수 있음.
       * 그럼 화면 깜빡임 현상이 발생하는데 이를 방지하기 위해 북마크 목록 화면의 
       * 라우트 설정에 resolve 속성을 추가하는 것임. 
       */
      resolve: {
      	bookmarks : function (Bookmark) {
      	/*
      	 * query(매개변수 객체, 성공 콜백 함수, 실패 콜백 함수)
      	 *  매개변수 객체에 의해 만들어진 URL과 HTTP GET 메서드를 요청한다.
      	 *  성공 시 성공 콜백 함수를 호출하고, 실패 시 샐패 콜백 함수를 호출한다.
      	 *  get 메서드와 다른 점은 배열로 반환한다는 점이다.
      	 *  
      	 * Bookmark.query()를 호출해 $promise를 통해 promise 객체를 얻어온다.
      	 * 그리고 해당 약속을 반환하면 북마크 데이터를 가지고 오겠다는 약속이 다 지켜지고 나서
      	 * 라우팅 처리를 하게 된다.
      	 */
      	 return Bookmark.query().$promise;
      	}
      } 
    })
   .when('/bookmarks/:bookmarkId', 
    { templateUrl: 'resources/template/bookmark/bookmark-detail.tmpl.html',
      controller: 'bookmarkDetailCtrl',
      resolve: {
        bookmark : function (Bookmark, $route) {
          return Bookmark.get({bookmarkId : $route.current.params.bookmarkId}).$promise;
        }
      }
    })
   .when('/new-bookmark', 
    { templateUrl: 'resources/template/bookmark/bookmark-new.tmpl.html',
      controller: 'bookmarkAddCtrl'
    })
   .otherwise({ redirectTo: '/bookmarks' });
 }])
 .controller('bookmarkMainCtrl', ['$scope','$route', function ($scope,$route) {
   $scope.bookmarkListViewType = 'grid';
   $scope.searchInfo = {
    bookmarkName : ''
   };

   $scope.toggleBookmarkListViewType = function (type) {
    if($scope.bookmarkListViewType != type){
		if($scope.bookmarkListViewType === 'grid'){
	      $scope.bookmarkListViewType = 'list';
	    }else{
	      $scope.bookmarkListViewType = 'grid';
	    }
    }
   };

   $scope.search = function (searchInfo) {
	//Dispatches an event name downwards to all child scopes (and their children) notifying the registered $rootScope.Scope listeners.
    $scope.$broadcast('search:newSearchInfo',searchInfo);
   };
 }]);