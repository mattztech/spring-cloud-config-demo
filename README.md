# spring-cloud-config-demo
[![CircleCI](https://circleci.com/gh/mattztech/spring-cloud-config-demo/tree/master.svg?style=svg)](https://circleci.com/gh/mattztech/spring-cloud-config-demo/tree/master)

This project demonstrates usage of the [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/) server by way of a simple client/server project.

## Building the docs

The documentation can be found in the /docs directory. This is Sphinx built and so requires [Python](https://www.python.org/) installed. A make.bat file is provided for convenience when working on windows without [Make](http://gnuwin32.sourceforge.net/packages/make.htm) installed:

```bash
cd docs/
make html
```

Once built the html files can be found in the docs/build directory, with index.html being the root

## Getting up and running

The easiest way to get this project up and running is through Docker. 

Running docker-compose up in the root directory will set up a test server and client. Hit http://localhost:8080/message to see it in action.

The above command starts up the server and client, with the client pulling configuration about what message to show from the server. For more information abotu this refer to the docs.
