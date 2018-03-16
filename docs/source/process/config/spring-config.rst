.. _ref-spring-config:

Spring configuration
********************

The following are the possible Spring configuration items in the validation API.

System configuration
====================

Configuration is done via the yml files. A default configuration is provided under the src/main/resources directory
called 'application.yml'. Spring Boot will always autowire any files named application.yml and application.properties
that are on the classpath.

Additional configuration files can be provided using the following syntax:

.. code-block:: bash

    mvn spring-boot:run -Dsping.config.location=<location/of/properties.yml>

Additionally, profiles may be present using the following syntax in a yml file:

.. code-block:: yaml

    spring:
        profiles:
            active: profile-name

These can be activated from the command line using:

.. code-block:: bash

    mvn spring-boot:run -Dspring.profiles.active=profile-name
