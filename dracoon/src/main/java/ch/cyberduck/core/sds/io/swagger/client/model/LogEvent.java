/*
 * DRACOON
 * Version 4.4.0 - built at: 2017-12-04 04:14:43, API server: https://demo.dracoon.com/api/v4
 *
 * OpenAPI spec version: 4.4.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * LogEvent
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class LogEvent {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("time")
  private java.util.Date time = null;

  @JsonProperty("operationId")
  private Integer operationId = null;

  @JsonProperty("operationName")
  private String operationName = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("userClient")
  private String userClient = null;

  @JsonProperty("customerId")
  private Long customerId = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("userIp")
  private String userIp = null;

  @JsonProperty("authParentSource")
  private String authParentSource = null;

  @JsonProperty("authParentTarget")
  private String authParentTarget = null;

  @JsonProperty("objectId1")
  private Long objectId1 = null;

  @JsonProperty("objectType1")
  private Integer objectType1 = null;

  @JsonProperty("objectName1")
  private String objectName1 = null;

  @JsonProperty("objectId2")
  private Long objectId2 = null;

  @JsonProperty("objectType2")
  private Integer objectType2 = null;

  @JsonProperty("objectName2")
  private String objectName2 = null;

  @JsonProperty("attribute1")
  private String attribute1 = null;

  @JsonProperty("attribute2")
  private String attribute2 = null;

  @JsonProperty("attribute3")
  private String attribute3 = null;

  public LogEvent id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Event Id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Event Id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LogEvent time(java.util.Date time) {
    this.time = time;
    return this;
  }

   /**
   * Event timestamp (2015-12-31T23:59:00)
   * @return time
  **/
  @ApiModelProperty(required = true, value = "Event timestamp (2015-12-31T23:59:00)")
  public java.util.Date getTime() {
    return time;
  }

  public void setTime(java.util.Date time) {
    this.time = time;
  }

  public LogEvent operationId(Integer operationId) {
    this.operationId = operationId;
    return this;
  }

   /**
   * Operation type ID
   * @return operationId
  **/
  @ApiModelProperty(value = "Operation type ID")
  public Integer getOperationId() {
    return operationId;
  }

  public void setOperationId(Integer operationId) {
    this.operationId = operationId;
  }

  public LogEvent operationName(String operationName) {
    this.operationName = operationName;
    return this;
  }

   /**
   * Operation name
   * @return operationName
  **/
  @ApiModelProperty(value = "Operation name")
  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public LogEvent userId(Long userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User Id
   * @return userId
  **/
  @ApiModelProperty(required = true, value = "User Id")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public LogEvent status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * Status code: 0&#x3D;SUCCESS, 2&#x3D;ERROR
   * @return status
  **/
  @ApiModelProperty(value = "Status code: 0=SUCCESS, 2=ERROR")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public LogEvent message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Event description
   * @return message
  **/
  @ApiModelProperty(required = true, value = "Event description")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LogEvent userClient(String userClient) {
    this.userClient = userClient;
    return this;
  }

   /**
   * Client
   * @return userClient
  **/
  @ApiModelProperty(value = "Client")
  public String getUserClient() {
    return userClient;
  }

  public void setUserClient(String userClient) {
    this.userClient = userClient;
  }

  public LogEvent customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Customer ID
   * @return customerId
  **/
  @ApiModelProperty(value = "Customer ID")
  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public LogEvent userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * User Name
   * @return userName
  **/
  @ApiModelProperty(value = "User Name")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public LogEvent userIp(String userIp) {
    this.userIp = userIp;
    return this;
  }

   /**
   * User IP
   * @return userIp
  **/
  @ApiModelProperty(value = "User IP")
  public String getUserIp() {
    return userIp;
  }

  public void setUserIp(String userIp) {
    this.userIp = userIp;
  }

  public LogEvent authParentSource(String authParentSource) {
    this.authParentSource = authParentSource;
    return this;
  }

   /**
   * authParentSource
   * @return authParentSource
  **/
  @ApiModelProperty(value = "authParentSource")
  public String getAuthParentSource() {
    return authParentSource;
  }

  public void setAuthParentSource(String authParentSource) {
    this.authParentSource = authParentSource;
  }

  public LogEvent authParentTarget(String authParentTarget) {
    this.authParentTarget = authParentTarget;
    return this;
  }

   /**
   * authParentTarget
   * @return authParentTarget
  **/
  @ApiModelProperty(value = "authParentTarget")
  public String getAuthParentTarget() {
    return authParentTarget;
  }

  public void setAuthParentTarget(String authParentTarget) {
    this.authParentTarget = authParentTarget;
  }

  public LogEvent objectId1(Long objectId1) {
    this.objectId1 = objectId1;
    return this;
  }

   /**
   * objectId1
   * @return objectId1
  **/
  @ApiModelProperty(value = "objectId1")
  public Long getObjectId1() {
    return objectId1;
  }

  public void setObjectId1(Long objectId1) {
    this.objectId1 = objectId1;
  }

  public LogEvent objectType1(Integer objectType1) {
    this.objectType1 = objectType1;
    return this;
  }

   /**
   * objectType1
   * @return objectType1
  **/
  @ApiModelProperty(value = "objectType1")
  public Integer getObjectType1() {
    return objectType1;
  }

  public void setObjectType1(Integer objectType1) {
    this.objectType1 = objectType1;
  }

  public LogEvent objectName1(String objectName1) {
    this.objectName1 = objectName1;
    return this;
  }

   /**
   * objectName1
   * @return objectName1
  **/
  @ApiModelProperty(value = "objectName1")
  public String getObjectName1() {
    return objectName1;
  }

  public void setObjectName1(String objectName1) {
    this.objectName1 = objectName1;
  }

  public LogEvent objectId2(Long objectId2) {
    this.objectId2 = objectId2;
    return this;
  }

   /**
   * objectId2
   * @return objectId2
  **/
  @ApiModelProperty(value = "objectId2")
  public Long getObjectId2() {
    return objectId2;
  }

  public void setObjectId2(Long objectId2) {
    this.objectId2 = objectId2;
  }

  public LogEvent objectType2(Integer objectType2) {
    this.objectType2 = objectType2;
    return this;
  }

   /**
   * objectType2
   * @return objectType2
  **/
  @ApiModelProperty(value = "objectType2")
  public Integer getObjectType2() {
    return objectType2;
  }

  public void setObjectType2(Integer objectType2) {
    this.objectType2 = objectType2;
  }

  public LogEvent objectName2(String objectName2) {
    this.objectName2 = objectName2;
    return this;
  }

   /**
   * objectName2
   * @return objectName2
  **/
  @ApiModelProperty(value = "objectName2")
  public String getObjectName2() {
    return objectName2;
  }

  public void setObjectName2(String objectName2) {
    this.objectName2 = objectName2;
  }

  public LogEvent attribute1(String attribute1) {
    this.attribute1 = attribute1;
    return this;
  }

   /**
   * attribute1
   * @return attribute1
  **/
  @ApiModelProperty(value = "attribute1")
  public String getAttribute1() {
    return attribute1;
  }

  public void setAttribute1(String attribute1) {
    this.attribute1 = attribute1;
  }

  public LogEvent attribute2(String attribute2) {
    this.attribute2 = attribute2;
    return this;
  }

   /**
   * attribute2
   * @return attribute2
  **/
  @ApiModelProperty(value = "attribute2")
  public String getAttribute2() {
    return attribute2;
  }

  public void setAttribute2(String attribute2) {
    this.attribute2 = attribute2;
  }

  public LogEvent attribute3(String attribute3) {
    this.attribute3 = attribute3;
    return this;
  }

   /**
   * attribute3
   * @return attribute3
  **/
  @ApiModelProperty(value = "attribute3")
  public String getAttribute3() {
    return attribute3;
  }

  public void setAttribute3(String attribute3) {
    this.attribute3 = attribute3;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogEvent logEvent = (LogEvent) o;
    return Objects.equals(this.id, logEvent.id) &&
        Objects.equals(this.time, logEvent.time) &&
        Objects.equals(this.operationId, logEvent.operationId) &&
        Objects.equals(this.operationName, logEvent.operationName) &&
        Objects.equals(this.userId, logEvent.userId) &&
        Objects.equals(this.status, logEvent.status) &&
        Objects.equals(this.message, logEvent.message) &&
        Objects.equals(this.userClient, logEvent.userClient) &&
        Objects.equals(this.customerId, logEvent.customerId) &&
        Objects.equals(this.userName, logEvent.userName) &&
        Objects.equals(this.userIp, logEvent.userIp) &&
        Objects.equals(this.authParentSource, logEvent.authParentSource) &&
        Objects.equals(this.authParentTarget, logEvent.authParentTarget) &&
        Objects.equals(this.objectId1, logEvent.objectId1) &&
        Objects.equals(this.objectType1, logEvent.objectType1) &&
        Objects.equals(this.objectName1, logEvent.objectName1) &&
        Objects.equals(this.objectId2, logEvent.objectId2) &&
        Objects.equals(this.objectType2, logEvent.objectType2) &&
        Objects.equals(this.objectName2, logEvent.objectName2) &&
        Objects.equals(this.attribute1, logEvent.attribute1) &&
        Objects.equals(this.attribute2, logEvent.attribute2) &&
        Objects.equals(this.attribute3, logEvent.attribute3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, time, operationId, operationName, userId, status, message, userClient, customerId, userName, userIp, authParentSource, authParentTarget, objectId1, objectType1, objectName1, objectId2, objectType2, objectName2, attribute1, attribute2, attribute3);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogEvent {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    operationId: ").append(toIndentedString(operationId)).append("\n");
    sb.append("    operationName: ").append(toIndentedString(operationName)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    userClient: ").append(toIndentedString(userClient)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    userIp: ").append(toIndentedString(userIp)).append("\n");
    sb.append("    authParentSource: ").append(toIndentedString(authParentSource)).append("\n");
    sb.append("    authParentTarget: ").append(toIndentedString(authParentTarget)).append("\n");
    sb.append("    objectId1: ").append(toIndentedString(objectId1)).append("\n");
    sb.append("    objectType1: ").append(toIndentedString(objectType1)).append("\n");
    sb.append("    objectName1: ").append(toIndentedString(objectName1)).append("\n");
    sb.append("    objectId2: ").append(toIndentedString(objectId2)).append("\n");
    sb.append("    objectType2: ").append(toIndentedString(objectType2)).append("\n");
    sb.append("    objectName2: ").append(toIndentedString(objectName2)).append("\n");
    sb.append("    attribute1: ").append(toIndentedString(attribute1)).append("\n");
    sb.append("    attribute2: ").append(toIndentedString(attribute2)).append("\n");
    sb.append("    attribute3: ").append(toIndentedString(attribute3)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}
