package org.baeldung.grpc.org.baeldung.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.baeldung.grpc.*;

public class grpcService {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8080).usePlaintext().build();
        HelloServiceGrpc.HelloServiceBlockingStub helloStub = HelloServiceGrpc.newBlockingStub(channel);
        LoginServiceGrpc.LoginServiceBlockingStub loginStub = LoginServiceGrpc.newBlockingStub(channel);
        HelloRequest helloRequest = HelloRequest.newBuilder().setFirstName("nghia").setLastName("nguyen").build();
        HelloResponse helloResponse = helloStub.hello(helloRequest);
        System.out.println("helloResponse: "+helloResponse);

        LoginRequest loginRequest = LoginRequest.newBuilder().setUser("nghia").setPassword("123456").setMyRole("admin").build();
        LoginResponse response = loginStub.login(loginRequest);
        System.out.println("Login response: "+response);


    }
}
