Sample app using ProtocolBuffers + Spring MVC

### Get protobuf

``` bash
$ curl -v http://localhost:8080/person
> GET /person HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: */*
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< X-Protobuf-Schema: src/main/proto/tutorial/addressbook.proto
< X-Protobuf-Message: tutorial.Person
< Content-Type: application/x-protobuf;charset=UTF-8
< Content-Length: 45
< Date: Sun, 14 Dec 2014 15:39:05 GMT
<

John Doe�	jdoe@example.com"
```

### Get JSON

``` bash
$ curl -v http://localhost:8080/person.json
> GET /person.json HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: */*
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 14 Dec 2014 15:39:42 GMT
<
{"name": "John Doe","id": 1234,"email": "jdoe@example.com","phone": [{"number": "555-4321","type": "HOME"}]}
```

or

``` bash
$ curl -v -H "Accept: application/json" http://localhost:8080/person
> GET /person HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: application/json
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 14 Dec 2014 15:40:35 GMT
<
{"name": "John Doe","id": 1234,"email": "jdoe@example.com","phone": [{"number": "555-4321","type": "HOME"}]}
```
### Get XML

``` bash
$ curl -v http://localhost:8080/person.xml
> GET /person.xml HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: */*
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Content-Type: application/xml;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 14 Dec 2014 15:41:48 GMT
<
<Person><name>John Doe</name><id>1234</id><email>jdoe@example.com</email><phone><number>555-4321</number><type>HOME</type></phone></Person>
```

or

``` bash
$ curl -v -H "Accept: application/xml" http://localhost:8080/person
> GET /person HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: application/xml
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Content-Type: application/xml;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 14 Dec 2014 15:42:26 GMT
<
<Person><name>John Doe</name><id>1234</id><email>jdoe@example.com</email><phone><number>555-4321</number><type>HOME</type></phone></Person>
```
