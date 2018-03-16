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

If a URL, then note that additional authentication config may be required

.. code-block:: yaml

    spring:
      cloud:
        config:
          server:
            git:
              uri: ${HOME}/spring-test/config
