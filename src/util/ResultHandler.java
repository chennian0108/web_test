package util;

import java.sql.ResultSet;

public interface ResultHandler {

	Object handler(ResultSet rs)throws Exception;

}
