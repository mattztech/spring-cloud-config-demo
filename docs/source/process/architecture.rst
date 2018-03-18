.. _ref-architecture:

Architecture
************

This project demonstrates usage of `Spring Cloud Config <https://cloud.spring.io/spring-cloud-config/>`_ via use of
a simple Spring Boot Rest client service, which contains a single REST controller, exposing the /message end-point.

The controller simply returns a message based on a property. That property is not present in the clients config, and
is retrieved from the remote config server, which decrypts the value before sending it across HTTP(S).

The only things needed to enable this functionality are for the application to be a Spring Boot application,
with the spring-cloud-starter-config dependency:

.. code-block:: xml

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>

Note that the MessageRestController also has the @RefreshScope annotation. This forces Spring to refresh the bean on
each call and refresh the config call. This is not strictly necessary, but allows live refresh of config which is
convenient for testing.

Other options
=============

Several options were considered as a competitor to Spring Cloud Config:

LastPass Enterprise
-------------------

One of the most popular options, it has an extensive (And very good) management interface, as well as proven
security credentials with regular published audit reports.

The major problem with LastPass is its lack of an on-prem option. In some (most) situations this could be considered
a benefit, but at PSL we have to consider that the lead up time to getting all ~25 clients to agree to use a third
party in the cloud to store sensitive information is far too long.

LastPass is also not really designed to be

There is also a potential GDPR issue - this may not be an actual problem since we aren't likely to store any
customer information in this way, but the data is stored in the US (Though an EU solution is in beta).
