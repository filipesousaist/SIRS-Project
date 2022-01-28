package proj_contract.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ServerService.proto")
public final class ServerServiceGrpc {

  private ServerServiceGrpc() {}

  public static final String SERVICE_NAME = "Proj.Proto.ServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proj_contract.services.RegisterRequest,
      proj_contract.services.ServerResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = proj_contract.services.RegisterRequest.class,
      responseType = proj_contract.services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.services.RegisterRequest,
      proj_contract.services.ServerResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<proj_contract.services.RegisterRequest, proj_contract.services.ServerResponse> getRegisterMethod;
    if ((getRegisterMethod = ServerServiceGrpc.getRegisterMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getRegisterMethod = ServerServiceGrpc.getRegisterMethod) == null) {
          ServerServiceGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<proj_contract.services.RegisterRequest, proj_contract.services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfo,
      proj_contract.services.ServerResponse> getBroadcastConnectionInfoRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "broadcastConnectionInfoRequest",
      requestType = proj_contract.services.ConnectionInfo.class,
      responseType = proj_contract.services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfo,
      proj_contract.services.ServerResponse> getBroadcastConnectionInfoRequestMethod() {
    io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfo, proj_contract.services.ServerResponse> getBroadcastConnectionInfoRequestMethod;
    if ((getBroadcastConnectionInfoRequestMethod = ServerServiceGrpc.getBroadcastConnectionInfoRequestMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getBroadcastConnectionInfoRequestMethod = ServerServiceGrpc.getBroadcastConnectionInfoRequestMethod) == null) {
          ServerServiceGrpc.getBroadcastConnectionInfoRequestMethod = getBroadcastConnectionInfoRequestMethod = 
              io.grpc.MethodDescriptor.<proj_contract.services.ConnectionInfo, proj_contract.services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "broadcastConnectionInfoRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ConnectionInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("broadcastConnectionInfoRequest"))
                  .build();
          }
        }
     }
     return getBroadcastConnectionInfoRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfoResponse,
      proj_contract.services.ServerResponse> getSendConnectionInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendConnectionInfo",
      requestType = proj_contract.services.ConnectionInfoResponse.class,
      responseType = proj_contract.services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfoResponse,
      proj_contract.services.ServerResponse> getSendConnectionInfoMethod() {
    io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfoResponse, proj_contract.services.ServerResponse> getSendConnectionInfoMethod;
    if ((getSendConnectionInfoMethod = ServerServiceGrpc.getSendConnectionInfoMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getSendConnectionInfoMethod = ServerServiceGrpc.getSendConnectionInfoMethod) == null) {
          ServerServiceGrpc.getSendConnectionInfoMethod = getSendConnectionInfoMethod = 
              io.grpc.MethodDescriptor.<proj_contract.services.ConnectionInfoResponse, proj_contract.services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "sendConnectionInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ConnectionInfoResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("sendConnectionInfo"))
                  .build();
          }
        }
     }
     return getSendConnectionInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.services.SecretKeyMessageWithId,
      proj_contract.services.ServerResponse> getSendSecretKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendSecretKey",
      requestType = proj_contract.services.SecretKeyMessageWithId.class,
      responseType = proj_contract.services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.services.SecretKeyMessageWithId,
      proj_contract.services.ServerResponse> getSendSecretKeyMethod() {
    io.grpc.MethodDescriptor<proj_contract.services.SecretKeyMessageWithId, proj_contract.services.ServerResponse> getSendSecretKeyMethod;
    if ((getSendSecretKeyMethod = ServerServiceGrpc.getSendSecretKeyMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getSendSecretKeyMethod = ServerServiceGrpc.getSendSecretKeyMethod) == null) {
          ServerServiceGrpc.getSendSecretKeyMethod = getSendSecretKeyMethod = 
              io.grpc.MethodDescriptor.<proj_contract.services.SecretKeyMessageWithId, proj_contract.services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "sendSecretKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.SecretKeyMessageWithId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("sendSecretKey"))
                  .build();
          }
        }
     }
     return getSendSecretKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationClaimWithId,
      proj_contract.services.ServerResponse> getSendLocationClaimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendLocationClaim",
      requestType = proj_contract.proto.EncryptedLocationClaimWithId.class,
      responseType = proj_contract.services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationClaimWithId,
      proj_contract.services.ServerResponse> getSendLocationClaimMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationClaimWithId, proj_contract.services.ServerResponse> getSendLocationClaimMethod;
    if ((getSendLocationClaimMethod = ServerServiceGrpc.getSendLocationClaimMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getSendLocationClaimMethod = ServerServiceGrpc.getSendLocationClaimMethod) == null) {
          ServerServiceGrpc.getSendLocationClaimMethod = getSendLocationClaimMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.EncryptedLocationClaimWithId, proj_contract.services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "sendLocationClaim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.EncryptedLocationClaimWithId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("sendLocationClaim"))
                  .build();
          }
        }
     }
     return getSendLocationClaimMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementRequestWithId,
      proj_contract.services.ServerResponse> getRequestLocationEndorsementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestLocationEndorsement",
      requestType = proj_contract.proto.EncryptedLocationEndorsementRequestWithId.class,
      responseType = proj_contract.services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementRequestWithId,
      proj_contract.services.ServerResponse> getRequestLocationEndorsementMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementRequestWithId, proj_contract.services.ServerResponse> getRequestLocationEndorsementMethod;
    if ((getRequestLocationEndorsementMethod = ServerServiceGrpc.getRequestLocationEndorsementMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getRequestLocationEndorsementMethod = ServerServiceGrpc.getRequestLocationEndorsementMethod) == null) {
          ServerServiceGrpc.getRequestLocationEndorsementMethod = getRequestLocationEndorsementMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.EncryptedLocationEndorsementRequestWithId, proj_contract.services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "requestLocationEndorsement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.EncryptedLocationEndorsementRequestWithId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("requestLocationEndorsement"))
                  .build();
          }
        }
     }
     return getRequestLocationEndorsementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementWithId,
      proj_contract.services.ServerResponse> getSendLocationEndorsementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendLocationEndorsement",
      requestType = proj_contract.proto.EncryptedLocationEndorsementWithId.class,
      responseType = proj_contract.services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementWithId,
      proj_contract.services.ServerResponse> getSendLocationEndorsementMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementWithId, proj_contract.services.ServerResponse> getSendLocationEndorsementMethod;
    if ((getSendLocationEndorsementMethod = ServerServiceGrpc.getSendLocationEndorsementMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getSendLocationEndorsementMethod = ServerServiceGrpc.getSendLocationEndorsementMethod) == null) {
          ServerServiceGrpc.getSendLocationEndorsementMethod = getSendLocationEndorsementMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.EncryptedLocationEndorsementWithId, proj_contract.services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "sendLocationEndorsement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.EncryptedLocationEndorsementWithId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("sendLocationEndorsement"))
                  .build();
          }
        }
     }
     return getSendLocationEndorsementMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerServiceStub newStub(io.grpc.Channel channel) {
    return new ServerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ServerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(proj_contract.services.RegisterRequest request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void broadcastConnectionInfoRequest(proj_contract.services.ConnectionInfo request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBroadcastConnectionInfoRequestMethod(), responseObserver);
    }

    /**
     */
    public void sendConnectionInfo(proj_contract.services.ConnectionInfoResponse request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendConnectionInfoMethod(), responseObserver);
    }

    /**
     */
    public void sendSecretKey(proj_contract.services.SecretKeyMessageWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendSecretKeyMethod(), responseObserver);
    }

    /**
     */
    public void sendLocationClaim(proj_contract.proto.EncryptedLocationClaimWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendLocationClaimMethod(), responseObserver);
    }

    /**
     */
    public void requestLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementRequestWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestLocationEndorsementMethod(), responseObserver);
    }

    /**
     */
    public void sendLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendLocationEndorsementMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.services.RegisterRequest,
                proj_contract.services.ServerResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getBroadcastConnectionInfoRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.services.ConnectionInfo,
                proj_contract.services.ServerResponse>(
                  this, METHODID_BROADCAST_CONNECTION_INFO_REQUEST)))
          .addMethod(
            getSendConnectionInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.services.ConnectionInfoResponse,
                proj_contract.services.ServerResponse>(
                  this, METHODID_SEND_CONNECTION_INFO)))
          .addMethod(
            getSendSecretKeyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.services.SecretKeyMessageWithId,
                proj_contract.services.ServerResponse>(
                  this, METHODID_SEND_SECRET_KEY)))
          .addMethod(
            getSendLocationClaimMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.EncryptedLocationClaimWithId,
                proj_contract.services.ServerResponse>(
                  this, METHODID_SEND_LOCATION_CLAIM)))
          .addMethod(
            getRequestLocationEndorsementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.EncryptedLocationEndorsementRequestWithId,
                proj_contract.services.ServerResponse>(
                  this, METHODID_REQUEST_LOCATION_ENDORSEMENT)))
          .addMethod(
            getSendLocationEndorsementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.EncryptedLocationEndorsementWithId,
                proj_contract.services.ServerResponse>(
                  this, METHODID_SEND_LOCATION_ENDORSEMENT)))
          .build();
    }
  }

  /**
   */
  public static final class ServerServiceStub extends io.grpc.stub.AbstractStub<ServerServiceStub> {
    private ServerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(proj_contract.services.RegisterRequest request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void broadcastConnectionInfoRequest(proj_contract.services.ConnectionInfo request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBroadcastConnectionInfoRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendConnectionInfo(proj_contract.services.ConnectionInfoResponse request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendConnectionInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendSecretKey(proj_contract.services.SecretKeyMessageWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendSecretKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendLocationClaim(proj_contract.proto.EncryptedLocationClaimWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendLocationClaimMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementRequestWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestLocationEndorsementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementWithId request,
        io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendLocationEndorsementMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServerServiceBlockingStub extends io.grpc.stub.AbstractStub<ServerServiceBlockingStub> {
    private ServerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proj_contract.services.ServerResponse register(proj_contract.services.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ServerResponse broadcastConnectionInfoRequest(proj_contract.services.ConnectionInfo request) {
      return blockingUnaryCall(
          getChannel(), getBroadcastConnectionInfoRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ServerResponse sendConnectionInfo(proj_contract.services.ConnectionInfoResponse request) {
      return blockingUnaryCall(
          getChannel(), getSendConnectionInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ServerResponse sendSecretKey(proj_contract.services.SecretKeyMessageWithId request) {
      return blockingUnaryCall(
          getChannel(), getSendSecretKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ServerResponse sendLocationClaim(proj_contract.proto.EncryptedLocationClaimWithId request) {
      return blockingUnaryCall(
          getChannel(), getSendLocationClaimMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ServerResponse requestLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementRequestWithId request) {
      return blockingUnaryCall(
          getChannel(), getRequestLocationEndorsementMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ServerResponse sendLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementWithId request) {
      return blockingUnaryCall(
          getChannel(), getSendLocationEndorsementMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServerServiceFutureStub extends io.grpc.stub.AbstractStub<ServerServiceFutureStub> {
    private ServerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ServerResponse> register(
        proj_contract.services.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ServerResponse> broadcastConnectionInfoRequest(
        proj_contract.services.ConnectionInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getBroadcastConnectionInfoRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ServerResponse> sendConnectionInfo(
        proj_contract.services.ConnectionInfoResponse request) {
      return futureUnaryCall(
          getChannel().newCall(getSendConnectionInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ServerResponse> sendSecretKey(
        proj_contract.services.SecretKeyMessageWithId request) {
      return futureUnaryCall(
          getChannel().newCall(getSendSecretKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ServerResponse> sendLocationClaim(
        proj_contract.proto.EncryptedLocationClaimWithId request) {
      return futureUnaryCall(
          getChannel().newCall(getSendLocationClaimMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ServerResponse> requestLocationEndorsement(
        proj_contract.proto.EncryptedLocationEndorsementRequestWithId request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestLocationEndorsementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ServerResponse> sendLocationEndorsement(
        proj_contract.proto.EncryptedLocationEndorsementWithId request) {
      return futureUnaryCall(
          getChannel().newCall(getSendLocationEndorsementMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_BROADCAST_CONNECTION_INFO_REQUEST = 1;
  private static final int METHODID_SEND_CONNECTION_INFO = 2;
  private static final int METHODID_SEND_SECRET_KEY = 3;
  private static final int METHODID_SEND_LOCATION_CLAIM = 4;
  private static final int METHODID_REQUEST_LOCATION_ENDORSEMENT = 5;
  private static final int METHODID_SEND_LOCATION_ENDORSEMENT = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((proj_contract.services.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse>) responseObserver);
          break;
        case METHODID_BROADCAST_CONNECTION_INFO_REQUEST:
          serviceImpl.broadcastConnectionInfoRequest((proj_contract.services.ConnectionInfo) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse>) responseObserver);
          break;
        case METHODID_SEND_CONNECTION_INFO:
          serviceImpl.sendConnectionInfo((proj_contract.services.ConnectionInfoResponse) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse>) responseObserver);
          break;
        case METHODID_SEND_SECRET_KEY:
          serviceImpl.sendSecretKey((proj_contract.services.SecretKeyMessageWithId) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse>) responseObserver);
          break;
        case METHODID_SEND_LOCATION_CLAIM:
          serviceImpl.sendLocationClaim((proj_contract.proto.EncryptedLocationClaimWithId) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse>) responseObserver);
          break;
        case METHODID_REQUEST_LOCATION_ENDORSEMENT:
          serviceImpl.requestLocationEndorsement((proj_contract.proto.EncryptedLocationEndorsementRequestWithId) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse>) responseObserver);
          break;
        case METHODID_SEND_LOCATION_ENDORSEMENT:
          serviceImpl.sendLocationEndorsement((proj_contract.proto.EncryptedLocationEndorsementWithId) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ServerResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proj_contract.services.ServerServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerService");
    }
  }

  private static final class ServerServiceFileDescriptorSupplier
      extends ServerServiceBaseDescriptorSupplier {
    ServerServiceFileDescriptorSupplier() {}
  }

  private static final class ServerServiceMethodDescriptorSupplier
      extends ServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getBroadcastConnectionInfoRequestMethod())
              .addMethod(getSendConnectionInfoMethod())
              .addMethod(getSendSecretKeyMethod())
              .addMethod(getSendLocationClaimMethod())
              .addMethod(getRequestLocationEndorsementMethod())
              .addMethod(getSendLocationEndorsementMethod())
              .build();
        }
      }
    }
    return result;
  }
}
