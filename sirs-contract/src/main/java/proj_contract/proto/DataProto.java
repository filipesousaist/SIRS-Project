// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Data.proto

package proj_contract.proto;

public final class DataProto {
  private DataProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_Coordinates_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_Coordinates_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_TimestepData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_TimestepData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_EntityData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_EntityData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_EntitiesData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_EntitiesData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Proj_Proto_Id_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Proj_Proto_Id_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nData.proto\022\nProj.Proto\"#\n\013Coordinates\022" +
      "\t\n\001x\030\001 \001(\005\022\t\n\001y\030\002 \001(\005\"N\n\014TimestepData\022\020\n" +
      "\010timestep\030\001 \001(\005\022,\n\013coordinates\030\002 \001(\0132\027.P" +
      "roj.Proto.Coordinates\"T\n\nEntityData\022\n\n\002i" +
      "d\030\001 \001(\005\022\014\n\004type\030\002 \001(\t\022,\n\013coordinates\030\003 \001" +
      "(\0132\027.Proj.Proto.Coordinates\":\n\014EntitiesD" +
      "ata\022*\n\nentityData\030\001 \003(\0132\026.Proj.Proto.Ent" +
      "ityData\"\020\n\002Id\022\n\n\002id\030\001 \001(\005B\"\n\023proj_contra" +
      "ct.protoB\tDataProtoP\001b\006proto3"
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
    internal_static_Proj_Proto_Coordinates_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Proj_Proto_Coordinates_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_Coordinates_descriptor,
        new java.lang.String[] { "X", "Y", });
    internal_static_Proj_Proto_TimestepData_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Proj_Proto_TimestepData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_TimestepData_descriptor,
        new java.lang.String[] { "Timestep", "Coordinates", });
    internal_static_Proj_Proto_EntityData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Proj_Proto_EntityData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_EntityData_descriptor,
        new java.lang.String[] { "Id", "Type", "Coordinates", });
    internal_static_Proj_Proto_EntitiesData_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Proj_Proto_EntitiesData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_EntitiesData_descriptor,
        new java.lang.String[] { "EntityData", });
    internal_static_Proj_Proto_Id_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Proj_Proto_Id_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Proj_Proto_Id_descriptor,
        new java.lang.String[] { "Id", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
