.. _ref-server-config:

Server configuration
********************

The following is an explanation and list of the configuration options present in the server application

Spring Boot standard properties
===============================

These configuration options are standard to Spring Boot and not specific to Spring Cloud Config

server.port
-----------

The port of the server, set to 8888 as a default

.. code-block:: yaml

    server:
      port: 8888

Spring Cloud Config specific properties
=======================================

These configuration options are standard to Spring Boot and not specific to Spring Cloud Config

spring.cloud.config.server.git.url
----------------------------------

This specifies the URL of a git repository to retrieve properties from. If a file-path, that directory must be
initialised as a Git repository with:

.. code-block:: bash

    git init

For testing purposes a hard-coded file path is an easiest way to get up and running. The following sets up a
the server to look under ~/spring-test/config for all properties. Under that directory, place .properties or
.yml files corresponding to the spring.application.name of the client

.. code-block:: yaml

    spring:
      cloud:
        config:
          server:
            git:
              uri: ${HOME}/spring-test/config

A URL can also be set, using either HTTPS or SSH access to your preferred git provider. Note that HTTPS connections
may require additional user detail config, and SSH access will only work if your machine has SSH access to the remote
server.

.. code-block:: yaml

    spring:
      cloud:
        config:
          server:
            git:
              uri: git@github.com:mattztech/super-secret-passwords.git
