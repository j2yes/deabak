angular.module("ngBookmark.bookmark.controller")
 .controller('bookmarkDetailCtrl', ['$scope','bookmark','$route','Bookmark','$location', function ($scope,bookmark,$route,Bookmark,$location) {
  $scope.bookmark = bookmark;

  $scope.edit = function (){
   $scope.isEditing = true;
  };

  $scope.save = function (bookmark) {
   var updatePormise = Bookmark.update({
	bookmarkId : bookmark.bookmarkId
   },
   bookmark).$promise;
   
   updatePormise.then(function () {
    $route.reload();
   });
  };

  $scope.cancel = function () {
   $route.reload();
  };

  $scope.remove = function (bookmark) {
    var deletePromise = Bookmark.remove({
    	bookmarkId : bookmark.bookmarkId
    }).$promise;

    deletePromise.then(function () {
     $location.url("/bookmarks");
    });
  };
 }]);