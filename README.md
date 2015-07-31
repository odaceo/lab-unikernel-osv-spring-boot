# osv-app-springboot

[![Apache License 2](https://img.shields.io/badge/license-ASF2-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.txt)

## Description

A Spring Boot application running on OSv.

## Prerequisites

You need to have [Capstan](https://github.com/cloudius-systems/capstan)
installed on your computer.

```
$ export PATH=$HOME/bin:$PATH 
$ export CAPSTAN_QEMU_PATH=/usr/local/bin/qemu-system-x86_64 
```

## Usage

The ``build`` command create image.  If you make changes to the application, 
you need rebuild the image with:

```
$ capstan build -v
```

You can launch the application under VirtualBox with:

```
$ capstan run -p vbox -n bridge -b en1 -v
```

## Reporting Issues

All issues can be reported at [https://github.com/odaceo/osv-app-springboot/issues](https://github.com/odaceo/osv-app-springboot/issues)

## Code

All code can be found at [https://github.com/odaceo/osv-app-springboot](https://github.com/odaceo/osv-app-springboot)

## License

All code distributed under [ASL 2.0](LICENSE).

## Copyright

2012, [odaceo](http://odaceo.ch)