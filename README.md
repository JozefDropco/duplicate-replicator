# duplicate-replicator

This project uses Quarkus, the Supersonic Subatomic Java Framework.

This is a replicator for duplicate class generation in uber-jar file

## How to replicate the issue

run ```mvn package``` and check uber jar. In com.example package GreetingResource class will be generated twice however Greeting2Resource only once.

