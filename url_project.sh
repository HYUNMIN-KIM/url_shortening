#!/bin/sh
#!/bin/bash

mvn clean
mvn package
java -jar target/url_shortening-0.1 jar