// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LocationClaim.proto

package proj_contract.proto;

public final class LocationClaimOuterClass {
  private LocationClaimOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_LocationClaim_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_LocationClaim_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_EncryptedLocationClaim_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_EncryptedLocationClaim_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_EncryptedLocationClaimWithId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_EncryptedLocationClaimWithId_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023LocationClaim.proto\022\nProj.Proto\032\nData." +
      "proto\"p\n\rLocationClaim\022\017\n\007claimId\030\001 \001(\005\022" +
      "\020\n\010proverId\030\002 \001(\005\022\020\n\010timestep\030\003 \001(\005\022*\n\ne" +
      "ntityData\030\004 \001(\0132\026.Proj.Proto.EntityData\"" +
      "D\n\026EncryptedLocationClaim\022\014\n\004data\030\001 \001(\014\022" +
      "\034\n\024initializationVector\030\002 \001(\014\"v\n\034Encrypt" +
      "edLocationClaimWithId\022B\n\026encryptedLocati" +
      "onClaim\030\001 \001(\0132\".Proj.Proto.EncryptedLoca" +
      "tionClaim\022\022\n\nreceiverId\030\002 \001(\005B\027\n\023proj_co" +
      "ntract.protoP\001b\006proto3"
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
          proj_contract.proto.Data.getDescriptor(),
        }, assigner);
    internal_static_Proj_Proto_LocationClaim_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Proj_Proto_LocationClaim_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_LocationClaim_descriptor,
        new java.lang.String[] { "ClaimId", "ProverId", "Timestep", "EntityData", });
    internal_static_Proj_Proto_EncryptedLocationClaim_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Proj_Proto_EncryptedLocationClaim_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_EncryptedLocationClaim_descriptor,
        new java.lang.String[] { "Data", "InitializationVector", });
    internal_static_Proj_Proto_EncryptedLocationClaimWithId_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Proj_Proto_EncryptedLocationClaimWithId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_EncryptedLocationClaimWithId_descriptor,
        new java.lang.String[] { "EncryptedLocationClaim", "ReceiverId", });
    proj_contract.proto.Data.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}