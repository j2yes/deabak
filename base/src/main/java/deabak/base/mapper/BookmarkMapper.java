package deabak.base.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import deabak.base.domain.Bookmark;

@Repository("bookmarkMapper")
public interface BookmarkMapper {

	public int selectOne() throws Exception;

	public List<Bookmark> getBookmarks(Bookmark bookmark) throws Exception;

	public Bookmark getBookmark(String bookmarkId) throws Exception;

	public void updateBookmark(Bookmark bookmark) throws Exception;

	public void createBookmark(Bookmark bookmark) throws Exception;

	public void deleteBookmark(String bookmarkId) throws Exception;
}
