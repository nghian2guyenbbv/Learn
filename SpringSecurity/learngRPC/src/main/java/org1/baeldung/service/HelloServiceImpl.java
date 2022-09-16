package org1.baeldung.service;

import io.grpc.stub.StreamObserver;
import org1.baeldung.grpc.HelloRequest;
import org1.baeldung.grpc.HelloResponse;
import org1.baeldung.grpc.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    String greeting  = new StringBuilder().append("Hello ").append(request.getFirstName()).append(" ").append(request.getLastName()).toString();
    HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
    }
}
