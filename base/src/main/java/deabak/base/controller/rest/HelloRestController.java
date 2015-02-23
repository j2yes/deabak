package deabak.base.controller.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import deabak.base.domain.Hello;
import deabak.base.service.HelloService;

@RestController
@RequestMapping(value="/hellos")
public class HelloRestController {

	@Resource(name="helloService")
	HelloService helloService;
	
	/** 목록 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hello>> getHellos(Hello hello) throws Exception{
		List<Hello> hellos = helloService.getHellos(hello); 
		return new ResponseEntity<List<Hello>>(hellos, HttpStatus.OK);
	}
	
	/** 상세 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hello> getHello(@PathVariable("id") String id) throws Exception{
		Hello selectedHello = helloService.getHello(id); 
		return new ResponseEntity<Hello>(selectedHello,HttpStatus.OK);
	}
	
	
	/** 등록 */
	/**
	 * @param hello
	 * @return
	 * @throws Exception
	 * @description Json Data -> Java Object
	 * 여러 object를 사용해야하는 경우 RequestWrapper를 사용한다.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hello> createHelloByJson(@RequestBody Hello hello) throws Exception{
		Hello createdHello = helloService.createHello(hello); 
		return new ResponseEntity<Hello>(createdHello,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Hello> createHello(Hello hello) throws Exception{
		Hello createdHello = helloService.createHello(hello); 
		return new ResponseEntity<Hello>(createdHello,HttpStatus.CREATED);
	}
	
	/** 수정 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hello> updateHelloByJson(@PathVariable("id") String id, @RequestBody Hello hello) throws Exception{
		hello.setId(id);
		Hello updatedHello = helloService.updateHello(hello); 
		return new ResponseEntity<Hello>(updatedHello,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Hello> updateHello(Hello hello) throws Exception{
		Hello updatedHello = helloService.updateHello(hello); 
		return new ResponseEntity<Hello>(updatedHello,HttpStatus.OK);	
	}
	
	/** 삭제 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Hello> deleteHello(@PathVariable("id") String id) throws Exception{
		Hello deletedHello = helloService.deleteHello(id); 
		return new ResponseEntity<Hello>(deletedHello,HttpStatus.OK);
	}
}
