# netty-example
Netty Example using v4.1.6.Final

Implements a simple Server to receive packet > 1024 bytes

### Pre-requisites
- JDK 1.7/1.8
- Maven 2.x

### Build
Download all sources and build with maven. Maven will download the correct dependencies.

    $ git clone https://github.com/rahulsh1/netty-example.git
    $ cd netty-example
    $ mvn install
    

### Run

    # This will start a server on port 8080 by default
    $ mvn install -Prun
    
    # To change port and run
    $ mvn install -Prun -Dport=9191

#### Test 

    # Using netcat
    $ nc localhost 8080 < file_2148.dat
    
    # Multiple packets at one
    $ nc localhost 8080 < file_2148.dat & nc localhost 8080 < file_1500.dat

