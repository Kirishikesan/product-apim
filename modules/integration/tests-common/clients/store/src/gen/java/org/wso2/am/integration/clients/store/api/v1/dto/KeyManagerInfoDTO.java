/*
 * WSO2 API Manager - Developer Portal
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Developer Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.store.v1/src/main/resources/store-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the API, you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_devportal\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown below to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_store\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_devportal\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for devportal REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_password>&scope=<scopes separated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:subscribe apim:api_key\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:subscribe apim:api_key\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5bc0161b8aa7e701d7bf) 
 *
 * The version of the OpenAPI document: v1.1
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.wso2.am.integration.clients.store.api.v1.dto.KeyManagerApplicationConfigurationDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* KeyManagerInfoDTO
*/

public class KeyManagerInfoDTO {
        public static final String SERIALIZED_NAME_ID = "id";
        @SerializedName(SERIALIZED_NAME_ID)
            private String id;

        public static final String SERIALIZED_NAME_NAME = "name";
        @SerializedName(SERIALIZED_NAME_NAME)
            private String name;

        public static final String SERIALIZED_NAME_TYPE = "type";
        @SerializedName(SERIALIZED_NAME_TYPE)
            private String type;

        public static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
        @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
            private String displayName;

        public static final String SERIALIZED_NAME_DESCRIPTION = "description";
        @SerializedName(SERIALIZED_NAME_DESCRIPTION)
            private String description;

        public static final String SERIALIZED_NAME_ENABLED = "enabled";
        @SerializedName(SERIALIZED_NAME_ENABLED)
            private Boolean enabled;

        public static final String SERIALIZED_NAME_AVAILABLE_GRANT_TYPES = "availableGrantTypes";
        @SerializedName(SERIALIZED_NAME_AVAILABLE_GRANT_TYPES)
            private List<String> availableGrantTypes = null;

        public static final String SERIALIZED_NAME_TOKEN_ENDPOINT = "tokenEndpoint";
        @SerializedName(SERIALIZED_NAME_TOKEN_ENDPOINT)
            private String tokenEndpoint;

        public static final String SERIALIZED_NAME_REVOKE_ENDPOINT = "revokeEndpoint";
        @SerializedName(SERIALIZED_NAME_REVOKE_ENDPOINT)
            private String revokeEndpoint;

        public static final String SERIALIZED_NAME_USER_INFO_ENDPOINT = "userInfoEndpoint";
        @SerializedName(SERIALIZED_NAME_USER_INFO_ENDPOINT)
            private String userInfoEndpoint;

        public static final String SERIALIZED_NAME_ENABLE_TOKEN_GENERATION = "enableTokenGeneration";
        @SerializedName(SERIALIZED_NAME_ENABLE_TOKEN_GENERATION)
            private Boolean enableTokenGeneration;

        public static final String SERIALIZED_NAME_ENABLE_TOKEN_ENCRYPTION = "enableTokenEncryption";
        @SerializedName(SERIALIZED_NAME_ENABLE_TOKEN_ENCRYPTION)
            private Boolean enableTokenEncryption = false;

        public static final String SERIALIZED_NAME_ENABLE_TOKEN_HASHING = "enableTokenHashing";
        @SerializedName(SERIALIZED_NAME_ENABLE_TOKEN_HASHING)
            private Boolean enableTokenHashing = false;

        public static final String SERIALIZED_NAME_ENABLE_O_AUTH_APP_CREATION = "enableOAuthAppCreation";
        @SerializedName(SERIALIZED_NAME_ENABLE_O_AUTH_APP_CREATION)
            private Boolean enableOAuthAppCreation = true;

        public static final String SERIALIZED_NAME_ENABLE_MAP_O_AUTH_CONSUMER_APPS = "enableMapOAuthConsumerApps";
        @SerializedName(SERIALIZED_NAME_ENABLE_MAP_O_AUTH_CONSUMER_APPS)
            private Boolean enableMapOAuthConsumerApps = false;

        public static final String SERIALIZED_NAME_APPLICATION_CONFIGURATION = "applicationConfiguration";
        @SerializedName(SERIALIZED_NAME_APPLICATION_CONFIGURATION)
            private List<KeyManagerApplicationConfigurationDTO> applicationConfiguration = null;

        public static final String SERIALIZED_NAME_ADDITIONAL_PROPERTIES = "additionalProperties";
        @SerializedName(SERIALIZED_NAME_ADDITIONAL_PROPERTIES)
            private Object additionalProperties;


        public KeyManagerInfoDTO id(String id) {
        
        this.id = id;
        return this;
        }

    /**
        * Get id
    * @return id
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "01234567-0123-0123-0123-012345678901", value = "")
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


        public KeyManagerInfoDTO name(String name) {
        
        this.name = name;
        return this;
        }

    /**
        * Get name
    * @return name
    **/
      @ApiModelProperty(example = "Resident Key Manager", required = true, value = "")
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


        public KeyManagerInfoDTO type(String type) {
        
        this.type = type;
        return this;
        }

    /**
        * Get type
    * @return type
    **/
      @ApiModelProperty(example = "default", required = true, value = "")
    
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


        public KeyManagerInfoDTO displayName(String displayName) {
        
        this.displayName = displayName;
        return this;
        }

    /**
        * display name of Keymanager 
    * @return displayName
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Resident Key Manager", value = "display name of Keymanager ")
    
    public String getDisplayName() {
        return displayName;
    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


        public KeyManagerInfoDTO description(String description) {
        
        this.description = description;
        return this;
        }

    /**
        * Get description
    * @return description
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "This is Resident Key Manager", value = "")
    
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


        public KeyManagerInfoDTO enabled(Boolean enabled) {
        
        this.enabled = enabled;
        return this;
        }

    /**
        * Get enabled
    * @return enabled
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


        public KeyManagerInfoDTO availableGrantTypes(List<String> availableGrantTypes) {
        
        this.availableGrantTypes = availableGrantTypes;
        return this;
        }

    /**
        * Get availableGrantTypes
    * @return availableGrantTypes
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<String> getAvailableGrantTypes() {
        return availableGrantTypes;
    }


    public void setAvailableGrantTypes(List<String> availableGrantTypes) {
        this.availableGrantTypes = availableGrantTypes;
    }


        public KeyManagerInfoDTO tokenEndpoint(String tokenEndpoint) {
        
        this.tokenEndpoint = tokenEndpoint;
        return this;
        }

    /**
        * Get tokenEndpoint
    * @return tokenEndpoint
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "https://localhost:9443/oauth2/token", value = "")
    
    public String getTokenEndpoint() {
        return tokenEndpoint;
    }


    public void setTokenEndpoint(String tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }


        public KeyManagerInfoDTO revokeEndpoint(String revokeEndpoint) {
        
        this.revokeEndpoint = revokeEndpoint;
        return this;
        }

    /**
        * Get revokeEndpoint
    * @return revokeEndpoint
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "https://localhost:9443/oauth2/revoke", value = "")
    
    public String getRevokeEndpoint() {
        return revokeEndpoint;
    }


    public void setRevokeEndpoint(String revokeEndpoint) {
        this.revokeEndpoint = revokeEndpoint;
    }


        public KeyManagerInfoDTO userInfoEndpoint(String userInfoEndpoint) {
        
        this.userInfoEndpoint = userInfoEndpoint;
        return this;
        }

    /**
        * Get userInfoEndpoint
    * @return userInfoEndpoint
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public String getUserInfoEndpoint() {
        return userInfoEndpoint;
    }


    public void setUserInfoEndpoint(String userInfoEndpoint) {
        this.userInfoEndpoint = userInfoEndpoint;
    }


        public KeyManagerInfoDTO enableTokenGeneration(Boolean enableTokenGeneration) {
        
        this.enableTokenGeneration = enableTokenGeneration;
        return this;
        }

    /**
        * Get enableTokenGeneration
    * @return enableTokenGeneration
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isEnableTokenGeneration() {
        return enableTokenGeneration;
    }


    public void setEnableTokenGeneration(Boolean enableTokenGeneration) {
        this.enableTokenGeneration = enableTokenGeneration;
    }


        public KeyManagerInfoDTO enableTokenEncryption(Boolean enableTokenEncryption) {
        
        this.enableTokenEncryption = enableTokenEncryption;
        return this;
        }

    /**
        * Get enableTokenEncryption
    * @return enableTokenEncryption
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "")
    
    public Boolean isEnableTokenEncryption() {
        return enableTokenEncryption;
    }


    public void setEnableTokenEncryption(Boolean enableTokenEncryption) {
        this.enableTokenEncryption = enableTokenEncryption;
    }


        public KeyManagerInfoDTO enableTokenHashing(Boolean enableTokenHashing) {
        
        this.enableTokenHashing = enableTokenHashing;
        return this;
        }

    /**
        * Get enableTokenHashing
    * @return enableTokenHashing
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "")
    
    public Boolean isEnableTokenHashing() {
        return enableTokenHashing;
    }


    public void setEnableTokenHashing(Boolean enableTokenHashing) {
        this.enableTokenHashing = enableTokenHashing;
    }


        public KeyManagerInfoDTO enableOAuthAppCreation(Boolean enableOAuthAppCreation) {
        
        this.enableOAuthAppCreation = enableOAuthAppCreation;
        return this;
        }

    /**
        * Get enableOAuthAppCreation
    * @return enableOAuthAppCreation
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isEnableOAuthAppCreation() {
        return enableOAuthAppCreation;
    }


    public void setEnableOAuthAppCreation(Boolean enableOAuthAppCreation) {
        this.enableOAuthAppCreation = enableOAuthAppCreation;
    }


        public KeyManagerInfoDTO enableMapOAuthConsumerApps(Boolean enableMapOAuthConsumerApps) {
        
        this.enableMapOAuthConsumerApps = enableMapOAuthConsumerApps;
        return this;
        }

    /**
        * Get enableMapOAuthConsumerApps
    * @return enableMapOAuthConsumerApps
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "")
    
    public Boolean isEnableMapOAuthConsumerApps() {
        return enableMapOAuthConsumerApps;
    }


    public void setEnableMapOAuthConsumerApps(Boolean enableMapOAuthConsumerApps) {
        this.enableMapOAuthConsumerApps = enableMapOAuthConsumerApps;
    }


        public KeyManagerInfoDTO applicationConfiguration(List<KeyManagerApplicationConfigurationDTO> applicationConfiguration) {
        
        this.applicationConfiguration = applicationConfiguration;
        return this;
        }

    /**
        * Get applicationConfiguration
    * @return applicationConfiguration
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<KeyManagerApplicationConfigurationDTO> getApplicationConfiguration() {
        return applicationConfiguration;
    }


    public void setApplicationConfiguration(List<KeyManagerApplicationConfigurationDTO> applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }


        public KeyManagerInfoDTO additionalProperties(Object additionalProperties) {
        
        this.additionalProperties = additionalProperties;
        return this;
        }

    /**
        * Get additionalProperties
    * @return additionalProperties
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public Object getAdditionalProperties() {
        return additionalProperties;
    }


    public void setAdditionalProperties(Object additionalProperties) {
        this.additionalProperties = additionalProperties;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            KeyManagerInfoDTO keyManagerInfo = (KeyManagerInfoDTO) o;
            return Objects.equals(this.id, keyManagerInfo.id) &&
            Objects.equals(this.name, keyManagerInfo.name) &&
            Objects.equals(this.type, keyManagerInfo.type) &&
            Objects.equals(this.displayName, keyManagerInfo.displayName) &&
            Objects.equals(this.description, keyManagerInfo.description) &&
            Objects.equals(this.enabled, keyManagerInfo.enabled) &&
            Objects.equals(this.availableGrantTypes, keyManagerInfo.availableGrantTypes) &&
            Objects.equals(this.tokenEndpoint, keyManagerInfo.tokenEndpoint) &&
            Objects.equals(this.revokeEndpoint, keyManagerInfo.revokeEndpoint) &&
            Objects.equals(this.userInfoEndpoint, keyManagerInfo.userInfoEndpoint) &&
            Objects.equals(this.enableTokenGeneration, keyManagerInfo.enableTokenGeneration) &&
            Objects.equals(this.enableTokenEncryption, keyManagerInfo.enableTokenEncryption) &&
            Objects.equals(this.enableTokenHashing, keyManagerInfo.enableTokenHashing) &&
            Objects.equals(this.enableOAuthAppCreation, keyManagerInfo.enableOAuthAppCreation) &&
            Objects.equals(this.enableMapOAuthConsumerApps, keyManagerInfo.enableMapOAuthConsumerApps) &&
            Objects.equals(this.applicationConfiguration, keyManagerInfo.applicationConfiguration) &&
            Objects.equals(this.additionalProperties, keyManagerInfo.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, displayName, description, enabled, availableGrantTypes, tokenEndpoint, revokeEndpoint, userInfoEndpoint, enableTokenGeneration, enableTokenEncryption, enableTokenHashing, enableOAuthAppCreation, enableMapOAuthConsumerApps, applicationConfiguration, additionalProperties);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class KeyManagerInfoDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    availableGrantTypes: ").append(toIndentedString(availableGrantTypes)).append("\n");
    sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
    sb.append("    revokeEndpoint: ").append(toIndentedString(revokeEndpoint)).append("\n");
    sb.append("    userInfoEndpoint: ").append(toIndentedString(userInfoEndpoint)).append("\n");
    sb.append("    enableTokenGeneration: ").append(toIndentedString(enableTokenGeneration)).append("\n");
    sb.append("    enableTokenEncryption: ").append(toIndentedString(enableTokenEncryption)).append("\n");
    sb.append("    enableTokenHashing: ").append(toIndentedString(enableTokenHashing)).append("\n");
    sb.append("    enableOAuthAppCreation: ").append(toIndentedString(enableOAuthAppCreation)).append("\n");
    sb.append("    enableMapOAuthConsumerApps: ").append(toIndentedString(enableMapOAuthConsumerApps)).append("\n");
    sb.append("    applicationConfiguration: ").append(toIndentedString(applicationConfiguration)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

