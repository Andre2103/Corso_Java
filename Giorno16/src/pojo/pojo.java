package pojo;

import java.sql.Connection;

public interface pojo {

	public boolean updateDB(Connection conn);
	public boolean insertDB(Connection conn);
	
}
