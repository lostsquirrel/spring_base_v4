package demo.spring.aspect.app.service.impl;

import org.springframework.stereotype.Service;

import demo.spring.aspect.app.domain.Foo;
import demo.spring.aspect.app.service.FooService;

@Service
public class FooServiceImpl implements FooService {

	public Foo getFoo(String name, int age) {
        return new Foo(name, age);
    }
}
