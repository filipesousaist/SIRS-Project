// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Data.proto

package proj_contract.proto;

public interface EntityDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Proj.Proto.EntityData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>string type = 2;</code>
   */
  java.lang.String getType();
  /**
   * <code>string type = 2;</code>
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>.Proj.Proto.Coordinates coordinates = 3;</code>
   */
  boolean hasCoordinates();
  /**
   * <code>.Proj.Proto.Coordinates coordinates = 3;</code>
   */
  proj_contract.proto.Coordinates getCoordinates();
  /**
   * <code>.Proj.Proto.Coordinates coordinates = 3;</code>
   */
  proj_contract.proto.CoordinatesOrBuilder getCoordinatesOrBuilder();
}
