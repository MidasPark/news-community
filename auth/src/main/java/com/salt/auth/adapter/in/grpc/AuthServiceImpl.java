package com.salt.auth.adapter.in.grpc;

import com.salt.auth.port.in.UserService;
import com.salt.auth.AuthServiceGrpc;
import com.salt.auth.AuthProto.UserRequest;
import com.salt.auth.AuthProto.UserResponse;
import io.grpc.stub.StreamObserver;
import com.salt.auth.domain.User;

public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {
    private final UserService userService;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void registerUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = new User();
        user.setUsername(request.getUsername());
        userService.registerUser(user);

        String message = "User " + request.getUsername() + " registered successfully!";
        UserResponse response = UserResponse.newBuilder().setMessage(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
} 