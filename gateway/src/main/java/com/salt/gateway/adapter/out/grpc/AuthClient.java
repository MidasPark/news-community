package com.salt.gateway.adapter.out.grpc;

import com.salt.auth.AuthServiceGrpc;
import com.salt.auth.AuthProto.UserRequest;
import com.salt.auth.AuthProto.UserResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AuthClient {
    private final AuthServiceGrpc.AuthServiceBlockingStub blockingStub;

    public AuthClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = AuthServiceGrpc.newBlockingStub(channel);
    }

    public void registerUser(String username, String password) {
        UserRequest request = UserRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();
        UserResponse response = blockingStub.registerUser(request);
        System.out.println(response.getMessage());
    }

    public static void main(String[] args) {
        AuthClient client = new AuthClient("localhost", 50051);
        client.registerUser("testuser", "password123");
    }
} 