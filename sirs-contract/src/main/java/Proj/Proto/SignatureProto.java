// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: signature.proto

package Proj.Proto;

public final class SignatureProto {
  private SignatureProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_Signature_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_Signature_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017signature.proto\022\nProj.Proto\"=\n\tSignatu" +
      "re\022\r\n\005value\030\001 \001(\014\022\022\n\ncryptoAlgo\030\002 \001(\t\022\r\n" +
      "\005nonce\030\003 \001(\003B\036\n\nProj.ProtoB\016SignaturePro" +
      "toP\001b\006proto3"
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
        }, assigner);
    internal_static_Proj_Proto_Signature_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Proj_Proto_Signature_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_Signature_descriptor,
        new java.lang.String[] { "Value", "CryptoAlgo", "Nonce", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
