// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ServerService.proto

package proj_contract.services;

public final class ServerServiceOuterClass {
  private ServerServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_ServerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_ServerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023ServerService.proto\022\nProj.Proto\032\020Conne" +
      "ction.proto\032\023LocationClaim.proto\032\031Locati" +
      "onEndorsement.proto\032\016Register.proto\"?\n\016S" +
      "erverResponse\022\027\n\017responseMessage\030\001 \001(\t\022\024" +
      "\n\014responseCode\030\002 \001(\0052\210\005\n\rServerService\022C" +
      "\n\010register\022\033.Proj.Proto.RegisterRequest\032" +
      "\032.Proj.Proto.ServerResponse\022X\n\036broadcast" +
      "ConnectionInfoRequest\022\032.Proj.Proto.Conne" +
      "ctionInfo\032\032.Proj.Proto.ServerResponse\022T\n" +
      "\022sendConnectionInfo\022\".Proj.Proto.Connect" +
      "ionInfoResponse\032\032.Proj.Proto.ServerRespo" +
      "nse\022O\n\rsendSecretKey\022\".Proj.Proto.Secret" +
      "KeyMessageWithId\032\032.Proj.Proto.ServerResp" +
      "onse\022Y\n\021sendLocationClaim\022(.Proj.Proto.E" +
      "ncryptedLocationClaimWithId\032\032.Proj.Proto" +
      ".ServerResponse\022o\n\032requestLocationEndors" +
      "ement\0225.Proj.Proto.EncryptedLocationEndo" +
      "rsementRequestWithId\032\032.Proj.Proto.Server" +
      "Response\022e\n\027sendLocationEndorsement\022..Pr" +
      "oj.Proto.EncryptedLocationEndorsementWit" +
      "hId\032\032.Proj.Proto.ServerResponseB\032\n\026proj_" +
      "contract.servicesP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          proj_contract.services.Connection.getDescriptor(),
          proj_contract.proto.LocationClaimOuterClass.getDescriptor(),
          proj_contract.proto.LocationEndorsementOuterClass.getDescriptor(),
          proj_contract.services.Register.getDescriptor(),
        }, assigner);
    internal_static_Proj_Proto_ServerResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Proj_Proto_ServerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_ServerResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "ResponseCode", });
    proj_contract.services.Connection.getDescriptor();
    proj_contract.proto.LocationClaimOuterClass.getDescriptor();
    proj_contract.proto.LocationEndorsementOuterClass.getDescriptor();
    proj_contract.services.Register.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
