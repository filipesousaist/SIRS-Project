// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: loc_claim.proto

package Proj.Proto;

public final class LocClaimProto {
  private LocClaimProto() {}
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
    internal_static_Proj_Proto_SignedLocationClaim_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_SignedLocationClaim_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017loc_claim.proto\022\nProj.Proto\032\031google/pr" +
      "otobuf/any.proto\032\016loc_time.proto\032\017signat" +
      "ure.proto\"\270\001\n\rLocationClaim\022\017\n\007claimId\030\001" +
      " \001(\t\022\020\n\010proverId\030\002 \001(\t\022&\n\010location\030\003 \001(\013" +
      "2\024.Proj.Proto.Location\022\036\n\004time\030\004 \001(\0132\020.P" +
      "roj.Proto.Time\022\024\n\014evidenceType\030\005 \001(\t\022&\n\010" +
      "evidence\030\006 \001(\0132\024.google.protobuf.Any\"o\n\023" +
      "SignedLocationClaim\022(\n\005claim\030\001 \001(\0132\031.Pro" +
      "j.Proto.LocationClaim\022.\n\017proverSignature" +
      "\030\002 \001(\0132\025.Proj.Proto.SignatureB\035\n\nProj.Pr" +
      "otoB\rLocClaimProtoP\001b\006proto3"
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
          com.google.protobuf.AnyProto.getDescriptor(),
          Proj.Proto.LocTimeProto.getDescriptor(),
          Proj.Proto.SignatureProto.getDescriptor(),
        }, assigner);
    internal_static_Proj_Proto_LocationClaim_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Proj_Proto_LocationClaim_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_LocationClaim_descriptor,
        new java.lang.String[] { "ClaimId", "ProverId", "Location", "Time", "EvidenceType", "Evidence", });
    internal_static_Proj_Proto_SignedLocationClaim_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Proj_Proto_SignedLocationClaim_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_SignedLocationClaim_descriptor,
        new java.lang.String[] { "Claim", "ProverSignature", });
    com.google.protobuf.AnyProto.getDescriptor();
    Proj.Proto.LocTimeProto.getDescriptor();
    Proj.Proto.SignatureProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}