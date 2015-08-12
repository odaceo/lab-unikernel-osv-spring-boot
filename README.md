# osv-app-springboot

[![License](https://img.shields.io/github/license/odaceo/osv-app-springboot.svg)](LICENSE)
[![Build Status](https://travis-ci.org/odaceo/osv-app-springboot.svg?branch=develop)](https://travis-ci.org/odaceo/osv-app-springboot)

## Description

A Spring Boot application running on OSv.

## Prerequisites

You need to have [Capstan](https://github.com/cloudius-systems/capstan)
installed on your computer.

```
$ export PATH=$HOME/bin:$PATH 
$ export CAPSTAN_QEMU_PATH=`which qemu-system-x86_64` 
```

## Build

The ``build`` command create image.  If you make changes to the application, 
you need rebuild the image with:

```
$ capstan build -p 'vbox' -v
```

## Run

You can launch the application under VirtualBox with:

```
$ capstan run -p 'vbox' -f '8080:8080' -f '9090:9090' -v
```

Check out the service:

```
$ curl http://localhost:8080/greeting
```

Check the health of the app:

```
$ curl http://localhost:9090/health
```

## Deploy on CloudSgima

First, build the disk image for KVM:

```
$ capstan build -p 'qemu' -v
```

Convert the disk image in RAW format: 

```
$ qemu-img convert -f qcow2 -O raw ~/.capstan/repository/osv-app-springboot/osv-app-springboot.qemu osv-app-springboot.raw
```

Sign in to your [CloudSigma](https://zrh.cloudsigma.com/ui) account and create a new disk from the RAW image.

Create a new machine with sufficient resources, 1GHz of CPU and 256 MB of RAM are more than enough.

Start the machine. 

Now that the machine is running, visit the OSv dashboard: 

* http://public-ip:8000/dashboard/

Replace localhost with the public IP to get access to the service and the health status.

## Reporting Issues

All issues can be reported at [https://github.com/odaceo/osv-app-springboot/issues](https://github.com/odaceo/osv-app-springboot/issues)

## Code

All code can be found at [https://github.com/odaceo/osv-app-springboot](https://github.com/odaceo/osv-app-springboot)

## License

All code distributed under [ASL 2.0](LICENSE).

## Copyright

© 2015 [Odaceo](http://odaceo.ch). All rights reserved.