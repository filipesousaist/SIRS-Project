// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wi_fi.proto

package Proj.Proto.wi_fi;

public final class WiFiProto {
  private WiFiProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_AP_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_AP_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013wi_fi.proto\022\020Proj.Proto.wi_fi\"|\n\024WiFiN" +
      "etworksEvidence\022\n\n\002id\030\001 \001(\t\0226\n\003aps\030\002 \003(\013" +
      "2).Proj.Proto.wi_fi.WiFiNetworksEvidence" +
      ".AP\032 \n\002AP\022\014\n\004ssid\030\001 \001(\t\022\014\n\004rssi\030\002 \001(\tB\037\n" +
      "\020Proj.Proto.wi_fiB\tWiFiProtoP\001b\006proto3"
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
    internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_descriptor,
        new java.lang.String[] { "Id", "Aps", });
    internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_AP_descriptor =
      internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_descriptor.getNestedTypes().get(0);
    internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_AP_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_wi_fi_WiFiNetworksEvidence_AP_descriptor,
        new java.lang.String[] { "Ssid", "Rssi", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}