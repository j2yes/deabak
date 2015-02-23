/**
 * service module 구현 
 * ngResource 모듈을 참조하여 RESTful 서비스 구현
 * ngResource모듈은 ../member.js에서 참조하였음
 */
angular.module('ngMember.member.service')
	.factory('memberService',['$resource','CONTEXT',function($resource,CONTEXT){
		var URL = CONTEXT + 'members/:id'
		var memberResource = $resource(URL,
				{id:'@id'},
				{'update':{
					method: 'PUT'
					}
				});
		
		return {
			selectList : function(member){
				//목록 데이터 호출할 경우 query method 실행
				//return memberResource.query(member);
				// 목록정보와 검색어정보를 포함한 하나의 object만 반환하므로 get method 사용
				return memberResource.get(member);
			},
			selectDetail : function(id){
				return memberResource.get({id:id});
			},
			insertData : function(member){
				return memberResource.save(member);
			},
			modifyData : function(member){
				return memberResource.update(member);
			},
			deleteData : function(id){
				return memberResource.remove({id:id});
			}
		}
	}]);

