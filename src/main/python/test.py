import httplib
import addressbook_pb2

conn = httplib.HTTPConnection("localhost", 8080)
conn.request("GET", "/person")
res = conn.getresponse()
body = res.read()
conn.close()

person = addressbook_pb2.Person()
person.ParseFromString(body)
print person
