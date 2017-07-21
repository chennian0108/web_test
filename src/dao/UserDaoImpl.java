package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtils;
import util.ResultHandler;

import bean.User;

public class UserDaoImpl implements IUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAll() throws Exception {
		String sql = "select * from user";
		Object o = JDBCUtils.executeSelect(sql, new ResultHandler() {
			public Object handler(ResultSet rs) throws Exception {
				List<User> list = new ArrayList<>();
				User u = null;
				while (rs.next()) {
					long id = rs.getLong("id");
					String name = rs.getString("name");
					u = new User(id, name);
					list.add(u);
					System.out.println(list);
				}
				return list;
			}
		});
		return (List<User>) o;

	}

}
