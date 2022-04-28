package com.ywh.spring.read.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * -
 *
 * @author yanwenhui
 * @date 2022/4/27
 */
@Service
public class AtService {

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void getOne() {
		System.out.println("事务A");
	}

}
