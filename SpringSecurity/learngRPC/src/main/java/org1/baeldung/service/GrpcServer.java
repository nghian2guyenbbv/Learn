package org1.baeldung.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(8080).addService(new HelloServiceImpl()).build();
        try {
            server.start();
            server.awaitTermination();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
}
