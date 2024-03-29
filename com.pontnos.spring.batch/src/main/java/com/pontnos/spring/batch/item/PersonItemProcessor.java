package com.pontnos.spring.batch.item;

import com.pontnos.spring.batch.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;


/**
 * @author zhengzz
 * @version 1.0.0
 * @className PersonItemProcessor
 * @description TODO
 * @date 2021/12/9
 */
@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
