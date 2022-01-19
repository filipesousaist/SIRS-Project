// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: loc_time.proto

package Proj.Proto;

public interface PoIOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Proj.Proto.PoI)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * unique identifier
   * </pre>
   *
   * <code>string id = 1;</code>
   */
  java.lang.String getId();
  /**
   * <pre>
   * unique identifier
   * </pre>
   *
   * <code>string id = 1;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   * name of point-of-interest
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * name of point-of-interest
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * name in different locales
   * </pre>
   *
   * <code>repeated .Proj.Google.LocalizedText localizedName = 3;</code>
   */
  java.util.List<Proj.Google.LocalizedText> 
      getLocalizedNameList();
  /**
   * <pre>
   * name in different locales
   * </pre>
   *
   * <code>repeated .Proj.Google.LocalizedText localizedName = 3;</code>
   */
  Proj.Google.LocalizedText getLocalizedName(int index);
  /**
   * <pre>
   * name in different locales
   * </pre>
   *
   * <code>repeated .Proj.Google.LocalizedText localizedName = 3;</code>
   */
  int getLocalizedNameCount();
  /**
   * <pre>
   * name in different locales
   * </pre>
   *
   * <code>repeated .Proj.Google.LocalizedText localizedName = 3;</code>
   */
  java.util.List<? extends Proj.Google.LocalizedTextOrBuilder> 
      getLocalizedNameOrBuilderList();
  /**
   * <pre>
   * name in different locales
   * </pre>
   *
   * <code>repeated .Proj.Google.LocalizedText localizedName = 3;</code>
   */
  Proj.Google.LocalizedTextOrBuilder getLocalizedNameOrBuilder(
      int index);
}
