package com.abc.springboot2.properties;

import java.util.Enumeration;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hutool.setting.dialect.Props;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2PropertiesApplicationTests {

	@Test
	public void contextLoads() {

		String dev = "d:/space/architect/springBoot2Properties/src/main/resources/acctin-dev.properties";
		String test = "d:/space/architect/springBoot2Properties/src/main/resources/acctin-test.properties";

		Props propsA = new Props(dev);

		Set<String> set = new TreeSet<String>();

		Enumeration<Object> keys = propsA.keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			set.add(String.valueOf(key));
		}

		Props propsB = new Props(test);

		keys = propsB.keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			set.add(String.valueOf(key));
		}

		System.out.println("--------------------------------------------------------------------------------");
		set.forEach(e -> {
//			System.out.println(e + "=" + propsA.getStr(e));
//			System.out.println(e + "=" + propsB.getStr(e));
			if (propsA.containsKey(e) && propsB.containsKey(e)) {
				if (propsA.getStr(e).equals(propsB.getStr(e)) == false) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>");
					System.out.println(e + "=" + propsA.getStr(e));
					System.out.println("====================");
					System.out.println(e + "=" + propsB.getStr(e));
					System.out.println("<<<<<<<<<<<<<<<<<<<<");
				}
			} else if (propsA.containsKey(e) && propsB.containsKey(e) == false) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>");
				System.out.println(e + "=" + propsA.getStr(e));
				System.out.println("====================");
				System.out.println("<<<<<<<<<<<<<<<<<<<<");
			} else if (propsA.containsKey(e) == false && propsB.containsKey(e)) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>");
				System.out.println("====================");
				System.out.println(e + "=" + propsB.getStr(e));
				System.out.println("<<<<<<<<<<<<<<<<<<<<");
			}

		});
		
		System.out.println("--------------------------------------------------------------------------------");
	}

}
