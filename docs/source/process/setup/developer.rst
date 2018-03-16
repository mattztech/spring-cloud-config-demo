.. _ref-developer:

Developer Instructions
**********************

These are the instructions which need to be performed to get a workspace set for developing
on this project.

It is assumed the developer will be using windows.

It is assumed that you have checked out the relevant repositories under C:\dev\git
(therefore have Git installed and your SSH keys configured).

It is assumed that you have Maven installed and configured to point to the PSL
Artifactory server.

1. Build the project
--------------------

This project is a multi-moduled Maven project, which uses Maven Reactor feature to build all sub modules.

The following will build the whole project, installing all dependencies in to your .m2 repository and placing the
build outputs in the target directory of each project.

.. note:: The following command skips Docker functionality. The skipDocker parameter can be removed if you wish for
          your local Docker instance to build the images, but this is in general not required.

.. code-block:: bash

    mvn -DskipDocker


2. Start up the servers
-----------------------

This allows starting up both services contained within this project. The server should be started up prior to the
client.

This can be done in two ways, either via command line:

.. code-block:: bash

    cd spring-cloud-config-server
    mvn spring-boot:run

    cd spring-cloud-config-server
    mvn spring-boot:run

Or via the main classes, located under:

.. code-block:: bash

    spring-cloud-config-client/src/main/java/com/mattztech/demo/springcloudconfig/ConfigServerApplication.java
    spring-cloud-config-server/src/main/java/com/mattztech/demo/springcloudconfig/ConfigClientApplication.java

You are good to go!
-------------------
