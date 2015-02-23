package deabak.base.mapper;

import org.springframework.stereotype.Repository;

@Repository("helloMapper")
public interface HelloMapper {

	public int selectOne() throws Exception;
}
