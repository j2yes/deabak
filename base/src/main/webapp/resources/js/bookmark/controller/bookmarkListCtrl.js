angular.module("ngBookmark.bookmark.controller")
 .controller('bookmarkListCtrl', ['$scope','bookmarks','Bookmark','$location','$q', function ($scope,bookmarks,Bookmark,$location,$q) {
   $scope.bookmarkList = bookmarks;
   //$scope.bookmarkList = $.map($scope.bookmarkList.results, function(el) { return el; });	

 	/* $on(name, listener);
 	 * Param	    Type					  Details
	   name	        string					  Event name to listen on.
	   listener	    function(event, ...args)  Function to call when the event is emitted.
 	 */
 	 
   $scope.$on('search:newSearchInfo',function(e, searchInfo) {
    
	/*var deferred = $q.defer();
	deffered.resolve(Bookmark.query({bookmarkName : searchInfo.bookmarkName}));
	var promise = deferred.promise;
	promise.then(function(bookmarks){
		$scope.bookmarkList = bookmarks;
	});*/
	//var searchQuery = '{"bookmarkName" : {"$regex": "^'+searchInfo.bookmarkName+'" } }';
	/*
	 * get(매개변수 객체, 성공 콜백함수, 실패 콜백함수)
	 */
    var schBookmarks = Bookmark.query({bookmarkName : searchInfo.bookmarkName});
    schBookmarks.$promise.then(function(data){
    	$scope.bookmarkList = data;
    });
    //bookmarks = Bookmark.query().$promise;
    //$scope.bookmarkList = bookmarks;
   });

   $scope.newBookmark = function () {
    $location.url("/new-bookmark");
   }
 }]);

function jsonToArray (bookmarkList) {
	
}