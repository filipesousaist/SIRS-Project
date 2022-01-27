// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LocationClaim.proto

package proj_contract.proto;

/**
 * Protobuf type {@code Proj.Proto.LocationClaim}
 */
public  final class LocationClaim extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Proj.Proto.LocationClaim)
    LocationClaimOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LocationClaim.newBuilder() to construct.
  private LocationClaim(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LocationClaim() {
    claimId_ = 0;
    proverId_ = 0;
    timestep_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LocationClaim(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            claimId_ = input.readInt32();
            break;
          }
          case 16: {

            proverId_ = input.readInt32();
            break;
          }
          case 24: {

            timestep_ = input.readInt32();
            break;
          }
          case 34: {
            proj_contract.proto.EntityData.Builder subBuilder = null;
            if (entityData_ != null) {
              subBuilder = entityData_.toBuilder();
            }
            entityData_ = input.readMessage(proj_contract.proto.EntityData.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(entityData_);
              entityData_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proj_contract.proto.LocationClaimOuterClass.internal_static_Proj_Proto_LocationClaim_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proj_contract.proto.LocationClaimOuterClass.internal_static_Proj_Proto_LocationClaim_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proj_contract.proto.LocationClaim.class, proj_contract.proto.LocationClaim.Builder.class);
  }

  public static final int CLAIMID_FIELD_NUMBER = 1;
  private int claimId_;
  /**
   * <code>int32 claimId = 1;</code>
   */
  public int getClaimId() {
    return claimId_;
  }

  public static final int PROVERID_FIELD_NUMBER = 2;
  private int proverId_;
  /**
   * <code>int32 proverId = 2;</code>
   */
  public int getProverId() {
    return proverId_;
  }

  public static final int TIMESTEP_FIELD_NUMBER = 3;
  private int timestep_;
  /**
   * <code>int32 timestep = 3;</code>
   */
  public int getTimestep() {
    return timestep_;
  }

  public static final int ENTITYDATA_FIELD_NUMBER = 4;
  private proj_contract.proto.EntityData entityData_;
  /**
   * <code>.Proj.Proto.EntityData entityData = 4;</code>
   */
  public boolean hasEntityData() {
    return entityData_ != null;
  }
  /**
   * <code>.Proj.Proto.EntityData entityData = 4;</code>
   */
  public proj_contract.proto.EntityData getEntityData() {
    return entityData_ == null ? proj_contract.proto.EntityData.getDefaultInstance() : entityData_;
  }
  /**
   * <code>.Proj.Proto.EntityData entityData = 4;</code>
   */
  public proj_contract.proto.EntityDataOrBuilder getEntityDataOrBuilder() {
    return getEntityData();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (claimId_ != 0) {
      output.writeInt32(1, claimId_);
    }
    if (proverId_ != 0) {
      output.writeInt32(2, proverId_);
    }
    if (timestep_ != 0) {
      output.writeInt32(3, timestep_);
    }
    if (entityData_ != null) {
      output.writeMessage(4, getEntityData());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (claimId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, claimId_);
    }
    if (proverId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, proverId_);
    }
    if (timestep_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, timestep_);
    }
    if (entityData_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getEntityData());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof proj_contract.proto.LocationClaim)) {
      return super.equals(obj);
    }
    proj_contract.proto.LocationClaim other = (proj_contract.proto.LocationClaim) obj;

    boolean result = true;
    result = result && (getClaimId()
        == other.getClaimId());
    result = result && (getProverId()
        == other.getProverId());
    result = result && (getTimestep()
        == other.getTimestep());
    result = result && (hasEntityData() == other.hasEntityData());
    if (hasEntityData()) {
      result = result && getEntityData()
          .equals(other.getEntityData());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CLAIMID_FIELD_NUMBER;
    hash = (53 * hash) + getClaimId();
    hash = (37 * hash) + PROVERID_FIELD_NUMBER;
    hash = (53 * hash) + getProverId();
    hash = (37 * hash) + TIMESTEP_FIELD_NUMBER;
    hash = (53 * hash) + getTimestep();
    if (hasEntityData()) {
      hash = (37 * hash) + ENTITYDATA_FIELD_NUMBER;
      hash = (53 * hash) + getEntityData().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static proj_contract.proto.LocationClaim parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proj_contract.proto.LocationClaim parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proj_contract.proto.LocationClaim parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proj_contract.proto.LocationClaim parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proj_contract.proto.LocationClaim parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proj_contract.proto.LocationClaim parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proj_contract.proto.LocationClaim parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proj_contract.proto.LocationClaim parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static proj_contract.proto.LocationClaim parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static proj_contract.proto.LocationClaim parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proj_contract.proto.LocationClaim parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proj_contract.proto.LocationClaim parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(proj_contract.proto.LocationClaim prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Proj.Proto.LocationClaim}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Proj.Proto.LocationClaim)
      proj_contract.proto.LocationClaimOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proj_contract.proto.LocationClaimOuterClass.internal_static_Proj_Proto_LocationClaim_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proj_contract.proto.LocationClaimOuterClass.internal_static_Proj_Proto_LocationClaim_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proj_contract.proto.LocationClaim.class, proj_contract.proto.LocationClaim.Builder.class);
    }

    // Construct using proj_contract.proto.LocationClaim.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      claimId_ = 0;

      proverId_ = 0;

      timestep_ = 0;

      if (entityDataBuilder_ == null) {
        entityData_ = null;
      } else {
        entityData_ = null;
        entityDataBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proj_contract.proto.LocationClaimOuterClass.internal_static_Proj_Proto_LocationClaim_descriptor;
    }

    @java.lang.Override
    public proj_contract.proto.LocationClaim getDefaultInstanceForType() {
      return proj_contract.proto.LocationClaim.getDefaultInstance();
    }

    @java.lang.Override
    public proj_contract.proto.LocationClaim build() {
      proj_contract.proto.LocationClaim result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proj_contract.proto.LocationClaim buildPartial() {
      proj_contract.proto.LocationClaim result = new proj_contract.proto.LocationClaim(this);
      result.claimId_ = claimId_;
      result.proverId_ = proverId_;
      result.timestep_ = timestep_;
      if (entityDataBuilder_ == null) {
        result.entityData_ = entityData_;
      } else {
        result.entityData_ = entityDataBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof proj_contract.proto.LocationClaim) {
        return mergeFrom((proj_contract.proto.LocationClaim)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(proj_contract.proto.LocationClaim other) {
      if (other == proj_contract.proto.LocationClaim.getDefaultInstance()) return this;
      if (other.getClaimId() != 0) {
        setClaimId(other.getClaimId());
      }
      if (other.getProverId() != 0) {
        setProverId(other.getProverId());
      }
      if (other.getTimestep() != 0) {
        setTimestep(other.getTimestep());
      }
      if (other.hasEntityData()) {
        mergeEntityData(other.getEntityData());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      proj_contract.proto.LocationClaim parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (proj_contract.proto.LocationClaim) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int claimId_ ;
    /**
     * <code>int32 claimId = 1;</code>
     */
    public int getClaimId() {
      return claimId_;
    }
    /**
     * <code>int32 claimId = 1;</code>
     */
    public Builder setClaimId(int value) {
      
      claimId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 claimId = 1;</code>
     */
    public Builder clearClaimId() {
      
      claimId_ = 0;
      onChanged();
      return this;
    }

    private int proverId_ ;
    /**
     * <code>int32 proverId = 2;</code>
     */
    public int getProverId() {
      return proverId_;
    }
    /**
     * <code>int32 proverId = 2;</code>
     */
    public Builder setProverId(int value) {
      
      proverId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 proverId = 2;</code>
     */
    public Builder clearProverId() {
      
      proverId_ = 0;
      onChanged();
      return this;
    }

    private int timestep_ ;
    /**
     * <code>int32 timestep = 3;</code>
     */
    public int getTimestep() {
      return timestep_;
    }
    /**
     * <code>int32 timestep = 3;</code>
     */
    public Builder setTimestep(int value) {
      
      timestep_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 timestep = 3;</code>
     */
    public Builder clearTimestep() {
      
      timestep_ = 0;
      onChanged();
      return this;
    }

    private proj_contract.proto.EntityData entityData_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        proj_contract.proto.EntityData, proj_contract.proto.EntityData.Builder, proj_contract.proto.EntityDataOrBuilder> entityDataBuilder_;
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public boolean hasEntityData() {
      return entityDataBuilder_ != null || entityData_ != null;
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public proj_contract.proto.EntityData getEntityData() {
      if (entityDataBuilder_ == null) {
        return entityData_ == null ? proj_contract.proto.EntityData.getDefaultInstance() : entityData_;
      } else {
        return entityDataBuilder_.getMessage();
      }
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public Builder setEntityData(proj_contract.proto.EntityData value) {
      if (entityDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        entityData_ = value;
        onChanged();
      } else {
        entityDataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public Builder setEntityData(
        proj_contract.proto.EntityData.Builder builderForValue) {
      if (entityDataBuilder_ == null) {
        entityData_ = builderForValue.build();
        onChanged();
      } else {
        entityDataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public Builder mergeEntityData(proj_contract.proto.EntityData value) {
      if (entityDataBuilder_ == null) {
        if (entityData_ != null) {
          entityData_ =
            proj_contract.proto.EntityData.newBuilder(entityData_).mergeFrom(value).buildPartial();
        } else {
          entityData_ = value;
        }
        onChanged();
      } else {
        entityDataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public Builder clearEntityData() {
      if (entityDataBuilder_ == null) {
        entityData_ = null;
        onChanged();
      } else {
        entityData_ = null;
        entityDataBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public proj_contract.proto.EntityData.Builder getEntityDataBuilder() {
      
      onChanged();
      return getEntityDataFieldBuilder().getBuilder();
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    public proj_contract.proto.EntityDataOrBuilder getEntityDataOrBuilder() {
      if (entityDataBuilder_ != null) {
        return entityDataBuilder_.getMessageOrBuilder();
      } else {
        return entityData_ == null ?
            proj_contract.proto.EntityData.getDefaultInstance() : entityData_;
      }
    }
    /**
     * <code>.Proj.Proto.EntityData entityData = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        proj_contract.proto.EntityData, proj_contract.proto.EntityData.Builder, proj_contract.proto.EntityDataOrBuilder> 
        getEntityDataFieldBuilder() {
      if (entityDataBuilder_ == null) {
        entityDataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            proj_contract.proto.EntityData, proj_contract.proto.EntityData.Builder, proj_contract.proto.EntityDataOrBuilder>(
                getEntityData(),
                getParentForChildren(),
                isClean());
        entityData_ = null;
      }
      return entityDataBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Proj.Proto.LocationClaim)
  }

  // @@protoc_insertion_point(class_scope:Proj.Proto.LocationClaim)
  private static final proj_contract.proto.LocationClaim DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proj_contract.proto.LocationClaim();
  }

  public static proj_contract.proto.LocationClaim getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LocationClaim>
      PARSER = new com.google.protobuf.AbstractParser<LocationClaim>() {
    @java.lang.Override
    public LocationClaim parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LocationClaim(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LocationClaim> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LocationClaim> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proj_contract.proto.LocationClaim getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

