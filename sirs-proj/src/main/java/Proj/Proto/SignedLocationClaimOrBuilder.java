// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: loc_claim.proto

package Proj.Proto;

public interface SignedLocationClaimOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Proj.Proto.SignedLocationClaim)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * claim
   * </pre>
   *
   * <code>.Proj.Proto.LocationClaim claim = 1;</code>
   */
  boolean hasClaim();
  /**
   * <pre>
   * claim
   * </pre>
   *
   * <code>.Proj.Proto.LocationClaim claim = 1;</code>
   */
  Proj.Proto.LocationClaim getClaim();
  /**
   * <pre>
   * claim
   * </pre>
   *
   * <code>.Proj.Proto.LocationClaim claim = 1;</code>
   */
  Proj.Proto.LocationClaimOrBuilder getClaimOrBuilder();

  /**
   * <pre>
   * prover's signature
   * </pre>
   *
   * <code>.Proj.Proto.Signature proverSignature = 2;</code>
   */
  boolean hasProverSignature();
  /**
   * <pre>
   * prover's signature
   * </pre>
   *
   * <code>.Proj.Proto.Signature proverSignature = 2;</code>
   */
  Proj.Proto.Signature getProverSignature();
  /**
   * <pre>
   * prover's signature
   * </pre>
   *
   * <code>.Proj.Proto.Signature proverSignature = 2;</code>
   */
  Proj.Proto.SignatureOrBuilder getProverSignatureOrBuilder();
}
