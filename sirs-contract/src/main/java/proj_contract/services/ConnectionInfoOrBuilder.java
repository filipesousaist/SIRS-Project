// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Connection.proto

package proj_contract.services;

public interface ConnectionInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Proj.Proto.ConnectionInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>.google.protobuf.Any certificate = 2;</code>
   */
  boolean hasCertificate();
  /**
   * <code>.google.protobuf.Any certificate = 2;</code>
   */
  com.google.protobuf.Any getCertificate();
  /**
   * <code>.google.protobuf.Any certificate = 2;</code>
   */
  com.google.protobuf.AnyOrBuilder getCertificateOrBuilder();

  /**
   * <code>string type = 3;</code>
   */
  java.lang.String getType();
  /**
   * <code>string type = 3;</code>
   */
  com.google.protobuf.ByteString
      getTypeBytes();
}
