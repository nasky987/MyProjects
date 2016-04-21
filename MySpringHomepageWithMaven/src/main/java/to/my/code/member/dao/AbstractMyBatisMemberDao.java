package to.my.code.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import to.my.code.common.dao.GenericDao;

public abstract class AbstractMyBatisMemberDao<T> implements GenericDao<T>{
	@Autowired
	protected SqlSessionTemplate sqlsessionTemplate;
	
	public void setSqlsessionTemplate(final SqlSessionTemplate sqlSessionTemplate) {
		this.sqlsessionTemplate = sqlSessionTemplate;
	}

	@Deprecated
	@Override
	public final List<T> insertList(final List<T> t) {
		return new ArrayList<T>();
	}

	@Deprecated
	@Override
	public final List<T> updateList(final List<T> t) {
		return new ArrayList<T>();
	}

	@Deprecated
	@Override
	public final List<T> deleteList(final List<T> t) {
		return new ArrayList<T>();
	}
}
