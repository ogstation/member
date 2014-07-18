[![Build Status](https://travis-ci.org/ogstation/member.svg)](https://travis-ci.org/ogstation/member)

member
======

Og station member

How to build ?
======
mvn clean install

How to run ?
======
mvn jetty:run
 
API
======
* /api/error/400: handle 400 error
* /api/error/401: handle 401 error
* /api/error/403: handle 403 error
* /api/error/404: handle 404 error
* /api/error/500: handle 500 error

* /api/member/search(POST): search gas station by gas station