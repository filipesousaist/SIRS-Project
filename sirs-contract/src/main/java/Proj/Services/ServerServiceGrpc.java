package Proj.Services;

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
  private static volatile io.grpc.MethodDescriptor<Proj.Services.RegisterRequest,
      Proj.Services.ServerResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = Proj.Services.RegisterRequest.class,
      responseType = Proj.Services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Proj.Services.RegisterRequest,
      Proj.Services.ServerResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<Proj.Services.RegisterRequest, Proj.Services.ServerResponse> getRegisterMethod;
    if ((getRegisterMethod = ServerServiceGrpc.getRegisterMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getRegisterMethod = ServerServiceGrpc.getRegisterMethod) == null) {
          ServerServiceGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<Proj.Services.RegisterRequest, Proj.Services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Proj.Services.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Proj.Services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Proj.Proto.LocationClaim,
      Proj.Services.ServerResponse> getBroadcastLocationClaimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "broadcastLocationClaim",
      requestType = Proj.Proto.LocationClaim.class,
      responseType = Proj.Services.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Proj.Proto.LocationClaim,
      Proj.Services.ServerResponse> getBroadcastLocationClaimMethod() {
    io.grpc.MethodDescriptor<Proj.Proto.LocationClaim, Proj.Services.ServerResponse> getBroadcastLocationClaimMethod;
    if ((getBroadcastLocationClaimMethod = ServerServiceGrpc.getBroadcastLocationClaimMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getBroadcastLocationClaimMethod = ServerServiceGrpc.getBroadcastLocationClaimMethod) == null) {
          ServerServiceGrpc.getBroadcastLocationClaimMethod = getBroadcastLocationClaimMethod = 
              io.grpc.MethodDescriptor.<Proj.Proto.LocationClaim, Proj.Services.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ServerService", "broadcastLocationClaim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Proj.Proto.LocationClaim.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Proj.Services.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("broadcastLocationClaim"))
                  .build();
          }
        }
     }
     return getBroadcastLocationClaimMethod;
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
    public void register(Proj.Services.RegisterRequest request,
        io.grpc.stub.StreamObserver<Proj.Services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void broadcastLocationClaim(Proj.Proto.LocationClaim request,
        io.grpc.stub.StreamObserver<Proj.Services.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBroadcastLocationClaimMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Proj.Services.RegisterRequest,
                Proj.Services.ServerResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getBroadcastLocationClaimMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Proj.Proto.LocationClaim,
                Proj.Services.ServerResponse>(
                  this, METHODID_BROADCAST_LOCATION_CLAIM)))
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
    public void register(Proj.Services.RegisterRequest request,
        io.grpc.stub.StreamObserver<Proj.Services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void broadcastLocationClaim(Proj.Proto.LocationClaim request,
        io.grpc.stub.StreamObserver<Proj.Services.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBroadcastLocationClaimMethod(), getCallOptions()), request, responseObserver);
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
    public Proj.Services.ServerResponse register(Proj.Services.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public Proj.Services.ServerResponse broadcastLocationClaim(Proj.Proto.LocationClaim request) {
      return blockingUnaryCall(
          getChannel(), getBroadcastLocationClaimMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<Proj.Services.ServerResponse> register(
        Proj.Services.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Proj.Services.ServerResponse> broadcastLocationClaim(
        Proj.Proto.LocationClaim request) {
      return futureUnaryCall(
          getChannel().newCall(getBroadcastLocationClaimMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_BROADCAST_LOCATION_CLAIM = 1;

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
          serviceImpl.register((Proj.Services.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<Proj.Services.ServerResponse>) responseObserver);
          break;
        case METHODID_BROADCAST_LOCATION_CLAIM:
          serviceImpl.broadcastLocationClaim((Proj.Proto.LocationClaim) request,
              (io.grpc.stub.StreamObserver<Proj.Services.ServerResponse>) responseObserver);
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
      return Proj.Services.ServerServiceOuterClass.getDescriptor();
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
              .addMethod(getBroadcastLocationClaimMethod())
              .build();
        }
      }
    }
    return result;
  }
}
