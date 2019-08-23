"# springsecurity" 

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





[Spring Security(四)--核心过滤器源码分析](http://blog.didispace.com/xjf-spring-security-4/)
[Spring Security Reference](https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/)
