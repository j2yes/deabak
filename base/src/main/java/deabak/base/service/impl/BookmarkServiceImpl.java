package deabak.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import deabak.base.domain.Bookmark;
import deabak.base.mapper.BookmarkMapper;
import deabak.base.service.BookmarkService;

@Service("bookmarkService")
public class BookmarkServiceImpl implements BookmarkService {

	@Resource(name="bookmarkMapper")
	BookmarkMapper bookmarkMapper;

	@Override
	public List<Bookmark> getBookmarks(Bookmark bookmark) throws Exception {
		return bookmarkMapper.getBookmarks(bookmark);
	}

	@Override
	public Bookmark getBookmark(String bookmarkId) throws Exception {
		return  bookmarkMapper.getBookmark(bookmarkId);
	}

	@Override
	public void createBookmark(Bookmark bookmark) throws Exception {
		bookmarkMapper.createBookmark(bookmark);
	}

	@Override
	public void updateBookmark(Bookmark bookmark) throws Exception {
		bookmarkMapper.updateBookmark(bookmark);
	}

	@Override
	public void deleteBookmark(String bookmarkId) throws Exception {
		bookmarkMapper.deleteBookmark(bookmarkId);
	}
	
	
}
