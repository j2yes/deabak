package deabak.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import deabak.base.domain.Hello;
import deabak.base.mapper.HelloMapper;
import deabak.base.service.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Resource(name="helloMapper")
	HelloMapper helloMapper;

	@Override
	public int selectOne() throws Exception {
		return helloMapper.selectOne();
	}

	@Override
	public List<Hello> getHellos(Hello hello) throws Exception {
		
		List<Hello> hellos = new ArrayList<Hello>();
		Hello hello1 = new Hello();
		hello1.setKorean("안녕");
		hello1.setEnglish("hi");
		Hello hello2 = new Hello();
		hello2.setKorean("잘가");
		hello2.setEnglish("bye");
		hellos.add(hello1);
		hellos.add(hello2);
		
		return hellos;
	}

	@Override
	public Hello getHello(String id) throws Exception {
		Hello hello = new Hello();
		hello.setId(id);
		hello.setKorean("안녕");
		hello.setEnglish("hi");
		return hello;
	}

	@Override
	public Hello createHello(Hello hello) throws Exception {
		return getHello(hello.getId());
	}

	@Override
	public Hello updateHello(Hello hello) throws Exception {
		return getHello(hello.getId());
	}

	@Override
	public Hello deleteHello(String id) throws Exception {
		return new Hello();
	}
	
	
}
