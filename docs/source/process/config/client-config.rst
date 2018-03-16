.. _ref-client-config:

Client configuration
********************

The following is an explanation and list of the configuration options present in the client application

Spring Boot standard properties
===============================

These configuration options are standard to Spring Boot and not specific to Spring Cloud Config

server.port
-----------

The port of the server, defaults to 8080

.. code-block:: yaml

    server:
      port: 8080

management.security.enabled
---------------------------

Whether the Spring Boot health and info end points are secured, this defaults to true, but is set to false for
diagnostics.

.. code-block:: yaml

    management:
      security:
        enabled: false

Spring Cloud Config specific properties
=======================================

This configuration relates specifically to Spring Cloud Config and cannot be ignored

spring.application.name
-----------------------

This is the name of the properties file requested from the config server and must be set

.. code-block:: yaml

    spring:
      application:
        name: client-config-demo

spring.cloud.config.url
-----------------------

This is the URL of the config server and must be set

.. code-block:: yaml

    spring:
      cloud:
        config:
          uri: http://localhost:8888
