package org.baeldung.grpc.org.baeldung.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MultiSeriveGrpc {
    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(8080).addService(new HelloServerServiceImpl()).addService(new LoginServerServiceImpl()).build();
        try {
            server.start();
            server.awaitTermination();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
