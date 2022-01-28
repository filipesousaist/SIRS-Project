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
    comments = "Source: ClientService.proto")
public final class ClientServiceGrpc {

  private ClientServiceGrpc() {}

  public static final String SERVICE_NAME = "Proj.Proto.ClientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfo,
      proj_contract.services.ClientResponse> getRequestConnectionInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestConnectionInfo",
      requestType = proj_contract.services.ConnectionInfo.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfo,
      proj_contract.services.ClientResponse> getRequestConnectionInfoMethod() {
    io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfo, proj_contract.services.ClientResponse> getRequestConnectionInfoMethod;
    if ((getRequestConnectionInfoMethod = ClientServiceGrpc.getRequestConnectionInfoMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getRequestConnectionInfoMethod = ClientServiceGrpc.getRequestConnectionInfoMethod) == null) {
          ClientServiceGrpc.getRequestConnectionInfoMethod = getRequestConnectionInfoMethod = 
              io.grpc.MethodDescriptor.<proj_contract.services.ConnectionInfo, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "requestConnectionInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ConnectionInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("requestConnectionInfo"))
                  .build();
          }
        }
     }
     return getRequestConnectionInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfoResponse,
      proj_contract.services.ClientResponse> getSendConnectionInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendConnectionInfo",
      requestType = proj_contract.services.ConnectionInfoResponse.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfoResponse,
      proj_contract.services.ClientResponse> getSendConnectionInfoMethod() {
    io.grpc.MethodDescriptor<proj_contract.services.ConnectionInfoResponse, proj_contract.services.ClientResponse> getSendConnectionInfoMethod;
    if ((getSendConnectionInfoMethod = ClientServiceGrpc.getSendConnectionInfoMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getSendConnectionInfoMethod = ClientServiceGrpc.getSendConnectionInfoMethod) == null) {
          ClientServiceGrpc.getSendConnectionInfoMethod = getSendConnectionInfoMethod = 
              io.grpc.MethodDescriptor.<proj_contract.services.ConnectionInfoResponse, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "sendConnectionInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ConnectionInfoResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("sendConnectionInfo"))
                  .build();
          }
        }
     }
     return getSendConnectionInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.services.SecretKeyMessage,
      proj_contract.services.ClientResponse> getSendSecretKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendSecretKey",
      requestType = proj_contract.services.SecretKeyMessage.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.services.SecretKeyMessage,
      proj_contract.services.ClientResponse> getSendSecretKeyMethod() {
    io.grpc.MethodDescriptor<proj_contract.services.SecretKeyMessage, proj_contract.services.ClientResponse> getSendSecretKeyMethod;
    if ((getSendSecretKeyMethod = ClientServiceGrpc.getSendSecretKeyMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getSendSecretKeyMethod = ClientServiceGrpc.getSendSecretKeyMethod) == null) {
          ClientServiceGrpc.getSendSecretKeyMethod = getSendSecretKeyMethod = 
              io.grpc.MethodDescriptor.<proj_contract.services.SecretKeyMessage, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "sendSecretKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.SecretKeyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("sendSecretKey"))
                  .build();
          }
        }
     }
     return getSendSecretKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.EntitiesData,
      proj_contract.services.ClientResponse> getCollectDataFromSensorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectDataFromSensors",
      requestType = proj_contract.proto.EntitiesData.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.EntitiesData,
      proj_contract.services.ClientResponse> getCollectDataFromSensorsMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.EntitiesData, proj_contract.services.ClientResponse> getCollectDataFromSensorsMethod;
    if ((getCollectDataFromSensorsMethod = ClientServiceGrpc.getCollectDataFromSensorsMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getCollectDataFromSensorsMethod = ClientServiceGrpc.getCollectDataFromSensorsMethod) == null) {
          ClientServiceGrpc.getCollectDataFromSensorsMethod = getCollectDataFromSensorsMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.EntitiesData, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "collectDataFromSensors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.EntitiesData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("collectDataFromSensors"))
                  .build();
          }
        }
     }
     return getCollectDataFromSensorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.TimestepData,
      proj_contract.services.ClientResponse> getUpdateTimestepDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateTimestepData",
      requestType = proj_contract.proto.TimestepData.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.TimestepData,
      proj_contract.services.ClientResponse> getUpdateTimestepDataMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.TimestepData, proj_contract.services.ClientResponse> getUpdateTimestepDataMethod;
    if ((getUpdateTimestepDataMethod = ClientServiceGrpc.getUpdateTimestepDataMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getUpdateTimestepDataMethod = ClientServiceGrpc.getUpdateTimestepDataMethod) == null) {
          ClientServiceGrpc.getUpdateTimestepDataMethod = getUpdateTimestepDataMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.TimestepData, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "updateTimestepData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.TimestepData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("updateTimestepData"))
                  .build();
          }
        }
     }
     return getUpdateTimestepDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationClaim,
      proj_contract.services.ClientResponse> getSendLocationClaimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendLocationClaim",
      requestType = proj_contract.proto.EncryptedLocationClaim.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationClaim,
      proj_contract.services.ClientResponse> getSendLocationClaimMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationClaim, proj_contract.services.ClientResponse> getSendLocationClaimMethod;
    if ((getSendLocationClaimMethod = ClientServiceGrpc.getSendLocationClaimMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getSendLocationClaimMethod = ClientServiceGrpc.getSendLocationClaimMethod) == null) {
          ClientServiceGrpc.getSendLocationClaimMethod = getSendLocationClaimMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.EncryptedLocationClaim, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "sendLocationClaim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.EncryptedLocationClaim.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("sendLocationClaim"))
                  .build();
          }
        }
     }
     return getSendLocationClaimMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementRequest,
      proj_contract.services.ClientResponse> getRequestLocationEndorsementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestLocationEndorsement",
      requestType = proj_contract.proto.EncryptedLocationEndorsementRequest.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementRequest,
      proj_contract.services.ClientResponse> getRequestLocationEndorsementMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsementRequest, proj_contract.services.ClientResponse> getRequestLocationEndorsementMethod;
    if ((getRequestLocationEndorsementMethod = ClientServiceGrpc.getRequestLocationEndorsementMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getRequestLocationEndorsementMethod = ClientServiceGrpc.getRequestLocationEndorsementMethod) == null) {
          ClientServiceGrpc.getRequestLocationEndorsementMethod = getRequestLocationEndorsementMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.EncryptedLocationEndorsementRequest, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "requestLocationEndorsement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.EncryptedLocationEndorsementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("requestLocationEndorsement"))
                  .build();
          }
        }
     }
     return getRequestLocationEndorsementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsement,
      proj_contract.services.ClientResponse> getSendLocationEndorsementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendLocationEndorsement",
      requestType = proj_contract.proto.EncryptedLocationEndorsement.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsement,
      proj_contract.services.ClientResponse> getSendLocationEndorsementMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.EncryptedLocationEndorsement, proj_contract.services.ClientResponse> getSendLocationEndorsementMethod;
    if ((getSendLocationEndorsementMethod = ClientServiceGrpc.getSendLocationEndorsementMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getSendLocationEndorsementMethod = ClientServiceGrpc.getSendLocationEndorsementMethod) == null) {
          ClientServiceGrpc.getSendLocationEndorsementMethod = getSendLocationEndorsementMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.EncryptedLocationEndorsement, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "sendLocationEndorsement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.EncryptedLocationEndorsement.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("sendLocationEndorsement"))
                  .build();
          }
        }
     }
     return getSendLocationEndorsementMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientServiceStub newStub(io.grpc.Channel channel) {
    return new ClientServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestConnectionInfo(proj_contract.services.ConnectionInfo request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestConnectionInfoMethod(), responseObserver);
    }

    /**
     */
    public void sendConnectionInfo(proj_contract.services.ConnectionInfoResponse request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendConnectionInfoMethod(), responseObserver);
    }

    /**
     */
    public void sendSecretKey(proj_contract.services.SecretKeyMessage request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendSecretKeyMethod(), responseObserver);
    }

    /**
     */
    public void collectDataFromSensors(proj_contract.proto.EntitiesData request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCollectDataFromSensorsMethod(), responseObserver);
    }

    /**
     */
    public void updateTimestepData(proj_contract.proto.TimestepData request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTimestepDataMethod(), responseObserver);
    }

    /**
     */
    public void sendLocationClaim(proj_contract.proto.EncryptedLocationClaim request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendLocationClaimMethod(), responseObserver);
    }

    /**
     */
    public void requestLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementRequest request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestLocationEndorsementMethod(), responseObserver);
    }

    /**
     */
    public void sendLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsement request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendLocationEndorsementMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestConnectionInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.services.ConnectionInfo,
                proj_contract.services.ClientResponse>(
                  this, METHODID_REQUEST_CONNECTION_INFO)))
          .addMethod(
            getSendConnectionInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.services.ConnectionInfoResponse,
                proj_contract.services.ClientResponse>(
                  this, METHODID_SEND_CONNECTION_INFO)))
          .addMethod(
            getSendSecretKeyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.services.SecretKeyMessage,
                proj_contract.services.ClientResponse>(
                  this, METHODID_SEND_SECRET_KEY)))
          .addMethod(
            getCollectDataFromSensorsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.EntitiesData,
                proj_contract.services.ClientResponse>(
                  this, METHODID_COLLECT_DATA_FROM_SENSORS)))
          .addMethod(
            getUpdateTimestepDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.TimestepData,
                proj_contract.services.ClientResponse>(
                  this, METHODID_UPDATE_TIMESTEP_DATA)))
          .addMethod(
            getSendLocationClaimMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.EncryptedLocationClaim,
                proj_contract.services.ClientResponse>(
                  this, METHODID_SEND_LOCATION_CLAIM)))
          .addMethod(
            getRequestLocationEndorsementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.EncryptedLocationEndorsementRequest,
                proj_contract.services.ClientResponse>(
                  this, METHODID_REQUEST_LOCATION_ENDORSEMENT)))
          .addMethod(
            getSendLocationEndorsementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.EncryptedLocationEndorsement,
                proj_contract.services.ClientResponse>(
                  this, METHODID_SEND_LOCATION_ENDORSEMENT)))
          .build();
    }
  }

  /**
   */
  public static final class ClientServiceStub extends io.grpc.stub.AbstractStub<ClientServiceStub> {
    private ClientServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestConnectionInfo(proj_contract.services.ConnectionInfo request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestConnectionInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendConnectionInfo(proj_contract.services.ConnectionInfoResponse request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendConnectionInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendSecretKey(proj_contract.services.SecretKeyMessage request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendSecretKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void collectDataFromSensors(proj_contract.proto.EntitiesData request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCollectDataFromSensorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTimestepData(proj_contract.proto.TimestepData request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTimestepDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendLocationClaim(proj_contract.proto.EncryptedLocationClaim request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendLocationClaimMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementRequest request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestLocationEndorsementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsement request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendLocationEndorsementMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientServiceBlockingStub> {
    private ClientServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proj_contract.services.ClientResponse requestConnectionInfo(proj_contract.services.ConnectionInfo request) {
      return blockingUnaryCall(
          getChannel(), getRequestConnectionInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse sendConnectionInfo(proj_contract.services.ConnectionInfoResponse request) {
      return blockingUnaryCall(
          getChannel(), getSendConnectionInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse sendSecretKey(proj_contract.services.SecretKeyMessage request) {
      return blockingUnaryCall(
          getChannel(), getSendSecretKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse collectDataFromSensors(proj_contract.proto.EntitiesData request) {
      return blockingUnaryCall(
          getChannel(), getCollectDataFromSensorsMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse updateTimestepData(proj_contract.proto.TimestepData request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTimestepDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse sendLocationClaim(proj_contract.proto.EncryptedLocationClaim request) {
      return blockingUnaryCall(
          getChannel(), getSendLocationClaimMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse requestLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsementRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestLocationEndorsementMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse sendLocationEndorsement(proj_contract.proto.EncryptedLocationEndorsement request) {
      return blockingUnaryCall(
          getChannel(), getSendLocationEndorsementMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientServiceFutureStub extends io.grpc.stub.AbstractStub<ClientServiceFutureStub> {
    private ClientServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> requestConnectionInfo(
        proj_contract.services.ConnectionInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestConnectionInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> sendConnectionInfo(
        proj_contract.services.ConnectionInfoResponse request) {
      return futureUnaryCall(
          getChannel().newCall(getSendConnectionInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> sendSecretKey(
        proj_contract.services.SecretKeyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSendSecretKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> collectDataFromSensors(
        proj_contract.proto.EntitiesData request) {
      return futureUnaryCall(
          getChannel().newCall(getCollectDataFromSensorsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> updateTimestepData(
        proj_contract.proto.TimestepData request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTimestepDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> sendLocationClaim(
        proj_contract.proto.EncryptedLocationClaim request) {
      return futureUnaryCall(
          getChannel().newCall(getSendLocationClaimMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> requestLocationEndorsement(
        proj_contract.proto.EncryptedLocationEndorsementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestLocationEndorsementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> sendLocationEndorsement(
        proj_contract.proto.EncryptedLocationEndorsement request) {
      return futureUnaryCall(
          getChannel().newCall(getSendLocationEndorsementMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_CONNECTION_INFO = 0;
  private static final int METHODID_SEND_CONNECTION_INFO = 1;
  private static final int METHODID_SEND_SECRET_KEY = 2;
  private static final int METHODID_COLLECT_DATA_FROM_SENSORS = 3;
  private static final int METHODID_UPDATE_TIMESTEP_DATA = 4;
  private static final int METHODID_SEND_LOCATION_CLAIM = 5;
  private static final int METHODID_REQUEST_LOCATION_ENDORSEMENT = 6;
  private static final int METHODID_SEND_LOCATION_ENDORSEMENT = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_CONNECTION_INFO:
          serviceImpl.requestConnectionInfo((proj_contract.services.ConnectionInfo) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_SEND_CONNECTION_INFO:
          serviceImpl.sendConnectionInfo((proj_contract.services.ConnectionInfoResponse) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_SEND_SECRET_KEY:
          serviceImpl.sendSecretKey((proj_contract.services.SecretKeyMessage) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_COLLECT_DATA_FROM_SENSORS:
          serviceImpl.collectDataFromSensors((proj_contract.proto.EntitiesData) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TIMESTEP_DATA:
          serviceImpl.updateTimestepData((proj_contract.proto.TimestepData) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_SEND_LOCATION_CLAIM:
          serviceImpl.sendLocationClaim((proj_contract.proto.EncryptedLocationClaim) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_REQUEST_LOCATION_ENDORSEMENT:
          serviceImpl.requestLocationEndorsement((proj_contract.proto.EncryptedLocationEndorsementRequest) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_SEND_LOCATION_ENDORSEMENT:
          serviceImpl.sendLocationEndorsement((proj_contract.proto.EncryptedLocationEndorsement) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
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

  private static abstract class ClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proj_contract.services.ClientServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientService");
    }
  }

  private static final class ClientServiceFileDescriptorSupplier
      extends ClientServiceBaseDescriptorSupplier {
    ClientServiceFileDescriptorSupplier() {}
  }

  private static final class ClientServiceMethodDescriptorSupplier
      extends ClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientServiceFileDescriptorSupplier())
              .addMethod(getRequestConnectionInfoMethod())
              .addMethod(getSendConnectionInfoMethod())
              .addMethod(getSendSecretKeyMethod())
              .addMethod(getCollectDataFromSensorsMethod())
              .addMethod(getUpdateTimestepDataMethod())
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
