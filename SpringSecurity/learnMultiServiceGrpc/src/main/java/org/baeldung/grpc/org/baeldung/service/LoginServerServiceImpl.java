package org.baeldung.grpc.org.baeldung.service;

import io.grpc.stub.StreamObserver;
import org.baeldung.grpc.LoginRequest;
import org.baeldung.grpc.LoginResponse;
import org.baeldung.grpc.LoginServiceGrpc;

public class LoginServerServiceImpl extends LoginServiceGrpc.LoginServiceImplBase {
    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        //super.login(request, responseObserver);
        LoginResponse response = LoginResponse.newBuilder().setMessageResponse(responseMessage).build();
    }
}
