启动`jetty`服务器：

```bash
$ mvn jetty:run
```

如果需要调试，在执行上面的命令之前，添加下面的选项：

```bash
$ export MAVEN_OPTS='-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005'
```

测试请求：

```bash
$ http localhost:8080/app/foo
HTTP/1.1 200 OK
Content-Length: 13
Content-Type: application/octet-stream
Date: Thu, 12 Sep 2019 03:07:40 GMT
Server: Jetty(9.4.17.v20190418)

Hello, world!

$
```

`RESTEASY-1784`的测试：

```bash
$ http -v localhost:8080/1784/ErrorAfterFlushWithoutBody
GET /1784/ErrorAfterFlushWithoutBody HTTP/1.1
Accept: */*
Accept-Encoding: gzip, deflate
Connection: keep-alive
Host: localhost:8080
User-Agent: HTTPie/1.0.3



HTTP/1.1 200 OK
Date: Thu, 19 Dec 2019 08:36:55 GMT
Server: Jetty(9.4.17.v20190418)
Transfer-Encoding: chunked



$
```

