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
* /api/error/405: handle 404 error
* /api/error/415: handle 404 error
* /api/error/500: handle 500 error

* /api/members(POST): create member
```
Error if mandatory fields not filled.
{
    "fieldErrors": [
        {
            "field": "telephone",
            "message": "telephone should not be empty"
        }
    ]
}
```
* /api/members(GET): retrieve a list of members by paging
```
Default size is 10, customize by /api/stations?page=2&size=20
```
* /api/members/{id}: get member by id
```
Error 404 if not found
```
* /api/members/{id}(PUT): update member by id
```
Error 404 if not found
```
* /api/members/{id}(DELETE): delete member by id
```
Error 404 if not found
```
* /api/members/search(POST): search member by member