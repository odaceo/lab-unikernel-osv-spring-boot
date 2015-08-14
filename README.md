# osv-app-springboot

[![License](https://img.shields.io/github/license/odaceo/osv-app-springboot.svg)](LICENSE)
[![Build Status](https://travis-ci.org/odaceo/osv-app-springboot.svg)](https://travis-ci.org/odaceo/osv-app-springboot)

## Description

A Spring Boot application configured to run on OSv.

## Prerequisites

You need to have [Capstan](https://github.com/cloudius-systems/capstan)
installed on your computer.

```
$ export PATH=$HOME/bin:$PATH 
$ export CAPSTAN_QEMU_PATH=`which qemu-system-x86_64` 
```

## Building the application

The ``build`` command creates a Capstan virtual machine image.
If you modify the application, you will need rebuild the image with the following command:

```
$ capstan build -p 'vbox' -v
```

## Running the application

To launch the application under VirtualBox use the following command:

```
$ capstan run -p 'vbox' -f '8080:8080' -f '9090:9090' -v
```

To run the service use the following command: 

```
$ curl http://localhost:8080/greeting
```

To check the application's health use the following command:

```
$ curl http://localhost:9090/health
```

## Deploying the application on CloudSgima

First, build the disk image for KVM using the following command:

```
$ capstan build -p 'qemu' -v
```

To convert the disk image into a RAW format use the following command: 

```
$ qemu-img convert -f qcow2 -O raw ~/.capstan/repository/osv-app-springboot/osv-app-springboot.qemu osv-app-springboot.raw
```

Sign into your [CloudSigma](http://tracking.cloudsigma.com/aff_c?offer_id=2&aff_id=2295&url_id=19&source=osv-app-springboot) account and create a new disk using the previously created RAW image.

Create a new machine with sufficient resources. Typically 1GHz of CPU and 256MB of RAM are more than enough.

Start the machine. 

Now that the machine is running, go to the OSv dashboard: 

* http://public-ip:8000/dashboard/

Replace ``localhost`` with the public IP to get access to the service and the service health status.

## Reporting Issues

Issues can be reported at [https://github.com/odaceo/osv-app-springboot/issues](https://github.com/odaceo/osv-app-springboot/issues)

## Source code

The source code is available at [https://github.com/odaceo/osv-app-springboot](https://github.com/odaceo/osv-app-springboot)

## License

All the source code is distributed under [ASL 2.0](LICENSE).

## Copyright

© 2015 [Odaceo](http://odaceo.ch). All rights reserved.