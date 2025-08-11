# personal-blog
Basic blog application, based of Spring Framework, using Java 17.

## Main takeaways:
## [Project Structure & Gradle]
### - `gradle init` initialized a basic Gradle project structure.
### - I had to create a file structure manually, using `mkdir -p` to create directories.

## [Tomcat and Spring MVC]
- There is no `main()` method for Spring MVC applications. Tomcat will start the application and load the context.
- It loads your WAR, detects WebApplicationInitializer (your AppInitializer), and from there your Spring context + DispatcherServlet are initialized.
- The DispatcherServlet is the front controller for all requests, and it will delegate to the appropriate controllers based on the request mappings.
- 