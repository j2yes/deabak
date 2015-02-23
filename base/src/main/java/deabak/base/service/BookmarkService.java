package deabak.base.service;

import java.util.List;

import deabak.base.domain.Bookmark;

public interface BookmarkService {

	public List<Bookmark> getBookmarks(Bookmark bookmark) throws Exception;
	public Bookmark getBookmark(String bookmarkId) throws Exception;
	public void createBookmark(Bookmark bookmark)throws Exception;
	public void updateBookmark(Bookmark bookmark)throws Exception;
	public void deleteBookmark(String id)throws Exception;
}
