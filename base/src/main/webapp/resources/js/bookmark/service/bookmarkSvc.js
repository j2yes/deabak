angular.module("ngBookmark.bookmark.service")
 //.value('mogolabApiKey','50728d46e4b088be4c29ea02') //개인 API-KEY로 변경해야 함
 .factory('Bookmark', ['$resource','$route',function ($resource,$route) {
  /* ex)
   * var UserResource = $resource('/user/:userId',{userId:'jay'});
   * -> 해당 사용자 리소스 생성자 함수로 액션이 취해지면(get,post,put..), 
   *    매개변수의 기본 값 설정에 의하여 'user/jay'라는 URL이 만들어지게 된다.
   */
  var url='/bookmarks/:bookmarkId';
  
  var bookmarkResource = 
	  	$resource(url
	   ,{bookmarkId: '@bookmarkId'}
	   ,{
		   'update' : {method: 'PUT'}
	   	 , 'remove' : {method: 'DELETE'}
	   	 , 'query'  : {method:'GET', isArray:true}
	   }
 );

  return bookmarkResource;
 }]);