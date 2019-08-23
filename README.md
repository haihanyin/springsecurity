## spring security

### hellosecurity
basic configuration to enable security in mvc

### hellosecurity-initializer
basic configuration with initializer to enable security in mvc
no boilerplate configuration for filters in web.xml 

### authorization
- in memory authentication
- url access control
- form login
- logout handling
- test with "withMockUser"

### userdetails
- dao authentication with customized UserDetailService
- customized UserDetails
- UserDetails is returned if user is found, otherwise throws UsernameNotFoundException

### authentication provider
- customize the way how a UsernamePasswordAuthenticationToken is authenticated
- in the previous example, in mememory authentication and dao authentication are used
- notice that the AuthenticationProvider uses a typical strategy pattern style

### authentication token
- customize the form of "information" to be authenticated,
- the corresponding authentication provider 
- to start the authenticate of the "information", a customized filter is needed

[Spring Security(四)--核心过滤器源码分析](http://blog.didispace.com/xjf-spring-security-4/)
[Spring Security Reference](https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/)

## owasp top10
- injection, e.g., sql inject, html inject
- xss, csrf
- misconfiguration, e.g., using default password
- sensitive information exposure, e.g., passing user sensitive info to client
- insecure deserialization, e.g., jackson calls contrstructor in deserialization
- use vulnerable libraries
- broken acl, e.g., no method level check
- broken authentication, e.g., weak passwork management

## cryptography
[](http://tutorials.jenkov.com/java-cryptography/cipher.html)

### hashing
- md4, md5 (used in maven artifact signature)
- sha256, sha512 (used in git versions)

### symmetric encryption
- des, 3des
- aes
- what we are using: AES/GCM/NoPadding

### asymmetric encryption
- rsa256
- ecc (Elliptic Curve Cryptography)
- dsa


### some notes
- init vector is the "salt" to the first block 
- confusion and diffusion are important to measure the qualify of an algorithm, 
a minor change in the plain text or the key should lead to significant change in the encrypted result.
- signature is signed by the public key
- mac is signed by the secret key
- digest is a hashed text

### format
- all encrypted result are in binary form, it can be encoded as a string in base64 format.
- pem: prefix/suffixed base64 version of certificate or keys
- crt/csr: binary form of certificate (microsoft/linux)


### https handshake
[](https://zhuanlan.zhihu.com/p/25587986)
- start with http, client sends a random number and supported ciphers
- server replies the chosen cipher a random number, certificate signed by the server's public key
- client validate the certificate and send data encrypted by a secret key (called session key) calculated from the random numbers(client, server) 

### security headers
[](https://www.keycdn.com/blog/http-security-headers)
- content-security-policy
- x-xss-protection
- HSTS (HTTP Strict Transport Security)
- x-frame-options: deny
- x-content-type-options: nosniff
- httponly, Secure in set-cookie
- CacheControl
- Access-Control-Allow-Origin

### pki
[](https://en.wikipedia.org/wiki/Public_key_certificate)

### java keystore





