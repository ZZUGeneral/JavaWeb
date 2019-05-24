package com.zzu.yhl.demo02;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;

	/**
	 * @param bookdao the bookDao to set
	 */
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void addBook() {
		this.bookDao.addBook();
	}

}
