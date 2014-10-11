package com.example.tutorial;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ResponseBodyData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0"})
public class AddressBookControllerTest {
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void testPerson() throws Exception {
        ResponseBodyData body = when().get("/person")
                .then()
                .extract()
                .body();
        AddressBookProtos.Person person = AddressBookProtos.Person.parseFrom(body.asInputStream());

        assertThat(person.getName(), is("John Doe"));
        assertThat(person.getId(), is(1234));
        assertThat(person.getEmail(), is("jdoe@example.com"));
        assertThat(person.getPhoneList(), hasSize(1));
        assertThat(person.getPhone(0).getNumber(), is("555-4321"));
        assertThat(person.getPhone(0).getType(), is(AddressBookProtos.Person.PhoneType.HOME));
    }
}