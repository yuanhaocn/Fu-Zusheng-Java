
package com.syc.spring.jdbc02;

public class PersonDao extends DataSourceTemplate {

	@Override
	public int update(String sql) {
		return super.update(sql);
	}
}
