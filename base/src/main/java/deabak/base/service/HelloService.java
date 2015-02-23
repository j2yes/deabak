package deabak.base.service;

import java.util.List;

import deabak.base.domain.Hello;

public interface HelloService {

	public int selectOne() throws Exception;
	public List<Hello> getHellos(Hello hello) throws Exception;
	public Hello getHello(String id) throws Exception;
	public Hello createHello(Hello hello)throws Exception;
	public Hello updateHello(Hello hello)throws Exception;
	public Hello deleteHello(String id)throws Exception;
}
