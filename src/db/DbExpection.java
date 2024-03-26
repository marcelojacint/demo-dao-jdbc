package db;

public class DbExpection extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DbExpection(String msg) {
		super(msg);
	}

}
