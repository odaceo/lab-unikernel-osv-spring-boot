# Lab :: Unikernel :: OSv + Spring Boot

[![License](https://img.shields.io/github/license/odaceo/lab-unikernel-osv-spring-boot.svg)](LICENSE)

## Description

A Spring Boot application configured to run on OSv.

## Prerequisites

You need to have [Capstan](https://github.com/cloudius-systems/capstan)
installed on your computer.

``` shell
export PATH=$HOME/bin:$PATH 
export CAPSTAN_QEMU_PATH=`which qemu-system-x86_64` 
```

## Building the application

The build command creates a virtual machine running on Virtual Box.

If you modify [Capstanfile](Capstanfile), you will need rebuild 
the image with the following command:

``` shell
capstan build -p 'vbox' -v
```

## Running the application

To launch the application under VirtualBox use the following command:

``` shell
capstan run -p 'vbox' -f '8080:8080' -f '9090:9090' -v
```

To run the service use the following command: 

``` shell
curl http://localhost:8080/greeting?name=Odaceo
```

To check the application's health use the following command:

``` shell
curl http://localhost:9090/health
```

## Deploying the application on CloudSgima

First, build the disk image for KVM using the following command:

``` shell
capstan build -p 'qemu' -v
```

To convert the disk image into a RAW format use the following command: 

``` shell
qemu-img convert -f qcow2 -O raw ~/.capstan/repository/lab-unikernel-osv-spring-boot/lab-unikernel-osv-spring-boot.qemu lab-unikernel-osv-spring-boot.raw
```

Sign into your [CloudSigma](http://cloudsigma.com) account and create a new disk using the previously created RAW image.

Create a new machine with sufficient resources. Typically 1GHz of CPU and 256MB of RAM are more than enough.

Start the machine. 

Now that the virtual machine is running, go to the OSv dashboard: 

```
http://public-ip:8000/dashboard/
```

Replace ``public-ip`` with the public IP to get access to the service and the service health status page.

## Reporting Issues

Issues can be reported at [https://github.com/odaceo/lab-unikernel-osv-spring-boot/issues](https://github.com/odaceo/lab-unikernel-osv-spring-boot/issues)

## Source code

The source code is available at [https://github.com/odaceo/lab-unikernel-osv-spring-boot](https://github.com/odaceo/lab-unikernel-osv-spring-boot)

## License

All the source code is distributed under [ASL 2.0](LICENSE).

## Copyright

© 2015 [Odaceo](http://odaceo.ch). All rights reserved.