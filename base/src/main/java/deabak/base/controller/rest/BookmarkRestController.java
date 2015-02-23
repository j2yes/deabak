package deabak.base.controller.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import deabak.base.domain.Bookmark;
import deabak.base.service.BookmarkService;

@RestController
@RequestMapping(value="bookmarks")
public class BookmarkRestController {
 
	@Resource(name="bookmarkService")
	BookmarkService bookmarkService;
	
	/** 목록 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Bookmark>> getBookmarks(Bookmark bookmark) throws Exception{
		String bookmarkName="";
		if(bookmark.getBookmarkName() != null) {
			bookmarkName = bookmark.getBookmarkName();
		}
		List<Bookmark> bookmarks = bookmarkService.getBookmarks(bookmark); 
		return new ResponseEntity<List<Bookmark>>(bookmarks, HttpStatus.OK);
	}
	
	/** 상세 */
	@RequestMapping(value="/{bookmarkId}", method = RequestMethod.GET)
	public ResponseEntity<Bookmark> getBookmark(@PathVariable("bookmarkId") String bookmarkId) throws Exception{
		Bookmark selectedBookmark = bookmarkService.getBookmark(bookmarkId); 
		return new ResponseEntity<Bookmark>(selectedBookmark,HttpStatus.OK);
	}
	
	
	/** 등록 */
	/**
	 * @param bookmark
	 * @return
	 * @throws Exception
	 * @description Json Data -> Java Object
	 * 여러 object를 사용해야하는 경우 RequestWrapper를 사용한다.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bookmark> createBookmarkByJson(@RequestBody Bookmark bookmark) throws Exception{
		bookmarkService.createBookmark(bookmark); 
		return new ResponseEntity(null,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Bookmark> createBookmark(Bookmark bookmark) throws Exception{
		bookmarkService.createBookmark(bookmark); 
		return new ResponseEntity(null,HttpStatus.CREATED);
	}
	
	/** 수정 */
	@RequestMapping(value="/{bookmarkId}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bookmark> updateBookmarkByJson(@PathVariable("bookmarkId") String bookmarkId, @RequestBody Bookmark bookmark) throws Exception{
		bookmark.setId(bookmarkId);
		bookmarkService.updateBookmark(bookmark); 
		Bookmark updatedBookmark = bookmarkService.getBookmark(bookmarkId); 
		return new ResponseEntity<Bookmark>(updatedBookmark,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{bookmarkId}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Bookmark> updateBookmark(Bookmark bookmark) throws Exception{
		bookmarkService.updateBookmark(bookmark); 
		Bookmark updatedBookmark = bookmarkService.getBookmark(bookmark.getBookmarkId()); 
		return new ResponseEntity<Bookmark>(updatedBookmark,HttpStatus.OK);	
	}
	
	/** 삭제 */
	@RequestMapping(value="/{bookmarkId}", method = RequestMethod.DELETE)
	public ResponseEntity<Bookmark> deleteBookmark(@PathVariable("bookmarkId") String bookmarkId) throws Exception{
		bookmarkService.deleteBookmark(bookmarkId); 
		return new ResponseEntity(null,HttpStatus.OK);
	}
}
