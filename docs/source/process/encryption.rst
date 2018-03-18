.. _ref-encryption:

Encryption
**********

The config server enables encryption of properties in either a symmetric or asymmetric way.

**To use symmetric cryptography**, you simply have to set the property ‘encrypt.key’ in your application.properties
to a secret of your choice. Alternatively you can pass-in the environment variable ENCRYPT_KEY.

**For asymmetric cryptography**, you can set ‘encrypt.key’ to a PEM-encoded string value or configure a keystore to use.

While symmetric keys are easier to set up, asymmetric keys are far more secure, so are advised in a production
environment. The following assumes asymmetric encryption. For more details see the
`Spring Cloud Config docs <http://cloud.spring.io/spring-cloud-static/spring-cloud-config/1.4.2.RELEASE/single/spring-cloud-config.html>`_

Enabling and using encryption
=============================

Note that the bulk of this document is taken from `here <http://www.baeldung.com/spring-cloud-configuration>`_ so
refer to there for further information

The first step is to set up the keystore for use with the server. The easiest way to do so is via the java keytool:

.. code-block:: bash

    keytool -genkeypair -alias config-server-key \
           -keyalg RSA -keysize 4096 -sigalg SHA512withRSA \
           -dname 'CN=Config Server,OU=Spring Cloud,O=Baeldung' \
           -keypass my-k34-s3cr3t -keystore config-server.jks \
           -storepass my-s70r3-s3cr3t

.. warning:: The above settings are lifted directly from the official docs, don't use them in production

Once the keystore is generated, it can be placed in the src/main/resources directory and the following properties
added to the server:

.. code-block:: yaml

    encrypt:
      key-store:
        location: classpath:/config-server.jks
        password: my-s70r3-s3cr3t
        alias: config-server-key
        secret: my-k34-s3cr3t

.. warning:: This must be in a bootstrap.yml file, rather than application.yml. Spring Boot will load any bootstrap.yml
             files before initialization of the server. Failure to do this will result in properties not being
             decrypted.

Once done, we can start up the config server, then run the following curl script to retrieve our encrypted password:

.. code-block:: bash

    export PASSWORD=$(curl -X POST --data-urlencode d3v3L \
           http://localhost:8888/encrypt)


File based storage
------------------

We can then add that password to the secret config file in our config git repository:

.. code-block:: bash

    echo "user.password: '{cipher}$PASSWORD'" >> config-client-development.yml
    git commit -am "Added encrypted password"

.. note:: The use of {cipher} here denotes that what follows is a base64 encoded, encrypted string. Without it,
          we would get the full encoded string back when trying to use the property. Also be aware that the single
          quotes are essential in yml files, but must not be present in .properties files.

If this is set up correctly, you will be able to start up both the client and server applications, then get
the following output:

.. code-block:: bash

    curl localhost:8080/message
    The encrypted password is: d3v3L

Database storage
----------------








