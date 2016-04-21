package to.my.code.common.dao;

import java.util.List;

public interface GenericDao<T> {
	public abstract T insertOne(final T t);
	public abstract List<T> insertList(final List<T> t);
	
	public abstract T selectOne(final T t);
	public abstract List<T> selectListAll();
	
	public abstract T updateOne(final T t);
	public abstract List<T> updateList(final List<T> t);

	public abstract T deleteOne(final T t);
	public abstract List<T> deleteList(final List<T> t);
}
