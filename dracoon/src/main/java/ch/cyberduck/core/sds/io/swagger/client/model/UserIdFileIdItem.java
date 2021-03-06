/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.20.1  - built at: 2020-04-05 23:00:17<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.20.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User ID and file ID mapping
 */
@ApiModel(description = "User ID and file ID mapping")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-08T17:57:49.759+02:00")
public class UserIdFileIdItem {
  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("fileId")
  private Long fileId = null;

  public UserIdFileIdItem userId(Long userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Unique identifier for the user
   * @return userId
  **/
  @ApiModelProperty(value = "Unique identifier for the user")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public UserIdFileIdItem fileId(Long fileId) {
    this.fileId = fileId;
    return this;
  }

   /**
   * File ID
   * @return fileId
  **/
  @ApiModelProperty(value = "File ID")
  public Long getFileId() {
    return fileId;
  }

  public void setFileId(Long fileId) {
    this.fileId = fileId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserIdFileIdItem userIdFileIdItem = (UserIdFileIdItem) o;
    return Objects.equals(this.userId, userIdFileIdItem.userId) &&
        Objects.equals(this.fileId, userIdFileIdItem.fileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, fileId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserIdFileIdItem {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
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

