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
  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.LocationClaim,
      proj_contract.services.ClientResponse> getReceiveLocationClaimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveLocationClaim",
      requestType = proj_contract.proto.LocationClaim.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.LocationClaim,
      proj_contract.services.ClientResponse> getReceiveLocationClaimMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.LocationClaim, proj_contract.services.ClientResponse> getReceiveLocationClaimMethod;
    if ((getReceiveLocationClaimMethod = ClientServiceGrpc.getReceiveLocationClaimMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getReceiveLocationClaimMethod = ClientServiceGrpc.getReceiveLocationClaimMethod) == null) {
          ClientServiceGrpc.getReceiveLocationClaimMethod = getReceiveLocationClaimMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.LocationClaim, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "receiveLocationClaim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.LocationClaim.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("receiveLocationClaim"))
                  .build();
          }
        }
     }
     return getReceiveLocationClaimMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.Entities,
      proj_contract.services.ClientResponse> getCollectDataFromSensorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectDataFromSensors",
      requestType = proj_contract.proto.Entities.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.Entities,
      proj_contract.services.ClientResponse> getCollectDataFromSensorsMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.Entities, proj_contract.services.ClientResponse> getCollectDataFromSensorsMethod;
    if ((getCollectDataFromSensorsMethod = ClientServiceGrpc.getCollectDataFromSensorsMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getCollectDataFromSensorsMethod = ClientServiceGrpc.getCollectDataFromSensorsMethod) == null) {
          ClientServiceGrpc.getCollectDataFromSensorsMethod = getCollectDataFromSensorsMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.Entities, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "collectDataFromSensors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.Entities.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("collectDataFromSensors"))
                  .build();
          }
        }
     }
     return getCollectDataFromSensorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proj_contract.proto.Position,
      proj_contract.services.ClientResponse> getUpdateTimeStepMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateTimeStep",
      requestType = proj_contract.proto.Position.class,
      responseType = proj_contract.services.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proj_contract.proto.Position,
      proj_contract.services.ClientResponse> getUpdateTimeStepMethod() {
    io.grpc.MethodDescriptor<proj_contract.proto.Position, proj_contract.services.ClientResponse> getUpdateTimeStepMethod;
    if ((getUpdateTimeStepMethod = ClientServiceGrpc.getUpdateTimeStepMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getUpdateTimeStepMethod = ClientServiceGrpc.getUpdateTimeStepMethod) == null) {
          ClientServiceGrpc.getUpdateTimeStepMethod = getUpdateTimeStepMethod = 
              io.grpc.MethodDescriptor.<proj_contract.proto.Position, proj_contract.services.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proj.Proto.ClientService", "updateTimeStep"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.proto.Position.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proj_contract.services.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("updateTimeStep"))
                  .build();
          }
        }
     }
     return getUpdateTimeStepMethod;
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
    public void receiveLocationClaim(proj_contract.proto.LocationClaim request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReceiveLocationClaimMethod(), responseObserver);
    }

    /**
     */
    public void collectDataFromSensors(proj_contract.proto.Entities request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCollectDataFromSensorsMethod(), responseObserver);
    }

    /**
     */
    public void updateTimeStep(proj_contract.proto.Position request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTimeStepMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReceiveLocationClaimMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.LocationClaim,
                proj_contract.services.ClientResponse>(
                  this, METHODID_RECEIVE_LOCATION_CLAIM)))
          .addMethod(
            getCollectDataFromSensorsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.Entities,
                proj_contract.services.ClientResponse>(
                  this, METHODID_COLLECT_DATA_FROM_SENSORS)))
          .addMethod(
            getUpdateTimeStepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proj_contract.proto.Position,
                proj_contract.services.ClientResponse>(
                  this, METHODID_UPDATE_TIME_STEP)))
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
    public void receiveLocationClaim(proj_contract.proto.LocationClaim request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReceiveLocationClaimMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void collectDataFromSensors(proj_contract.proto.Entities request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCollectDataFromSensorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTimeStep(proj_contract.proto.Position request,
        io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTimeStepMethod(), getCallOptions()), request, responseObserver);
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
    public proj_contract.services.ClientResponse receiveLocationClaim(proj_contract.proto.LocationClaim request) {
      return blockingUnaryCall(
          getChannel(), getReceiveLocationClaimMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse collectDataFromSensors(proj_contract.proto.Entities request) {
      return blockingUnaryCall(
          getChannel(), getCollectDataFromSensorsMethod(), getCallOptions(), request);
    }

    /**
     */
    public proj_contract.services.ClientResponse updateTimeStep(proj_contract.proto.Position request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTimeStepMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> receiveLocationClaim(
        proj_contract.proto.LocationClaim request) {
      return futureUnaryCall(
          getChannel().newCall(getReceiveLocationClaimMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> collectDataFromSensors(
        proj_contract.proto.Entities request) {
      return futureUnaryCall(
          getChannel().newCall(getCollectDataFromSensorsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proj_contract.services.ClientResponse> updateTimeStep(
        proj_contract.proto.Position request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTimeStepMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECEIVE_LOCATION_CLAIM = 0;
  private static final int METHODID_COLLECT_DATA_FROM_SENSORS = 1;
  private static final int METHODID_UPDATE_TIME_STEP = 2;

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
        case METHODID_RECEIVE_LOCATION_CLAIM:
          serviceImpl.receiveLocationClaim((proj_contract.proto.LocationClaim) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_COLLECT_DATA_FROM_SENSORS:
          serviceImpl.collectDataFromSensors((proj_contract.proto.Entities) request,
              (io.grpc.stub.StreamObserver<proj_contract.services.ClientResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TIME_STEP:
          serviceImpl.updateTimeStep((proj_contract.proto.Position) request,
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
              .addMethod(getReceiveLocationClaimMethod())
              .addMethod(getCollectDataFromSensorsMethod())
              .addMethod(getUpdateTimeStepMethod())
              .build();
        }
      }
    }
    return result;
  }
}
