/*
 * WSO2 API Manager - Developer Portal
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Developer Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.store.v1/src/main/resources/devportal-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication The Developer Portal REST API is protected using OAuth2 and access control is achieved through scopes. Before you start invoking the API, you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_devportal\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown below to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_devportal\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_devportal\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for devportal REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_password>&scope=<scopes separated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<servlet_port>/oauth2/token ``` **Sample request** ``` curl https://localhost:9443/oauth2/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:subscribe apim:api_key\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:subscribe apim:api_key\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5bc0161b8aa7e701d7bf) 
 *
 * The version of the OpenAPI document: v3
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
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* KeyManagerApplicationConfigurationDTO
*/

public class KeyManagerApplicationConfigurationDTO {
        public static final String SERIALIZED_NAME_NAME = "name";
        @SerializedName(SERIALIZED_NAME_NAME)
            private String name;

        public static final String SERIALIZED_NAME_LABEL = "label";
        @SerializedName(SERIALIZED_NAME_LABEL)
            private String label;

        public static final String SERIALIZED_NAME_TYPE = "type";
        @SerializedName(SERIALIZED_NAME_TYPE)
            private String type;

        public static final String SERIALIZED_NAME_REQUIRED = "required";
        @SerializedName(SERIALIZED_NAME_REQUIRED)
            private Boolean required;

        public static final String SERIALIZED_NAME_MASK = "mask";
        @SerializedName(SERIALIZED_NAME_MASK)
            private Boolean mask;

        public static final String SERIALIZED_NAME_MULTIPLE = "multiple";
        @SerializedName(SERIALIZED_NAME_MULTIPLE)
            private Boolean multiple;

        public static final String SERIALIZED_NAME_TOOLTIP = "tooltip";
        @SerializedName(SERIALIZED_NAME_TOOLTIP)
            private String tooltip;

        public static final String SERIALIZED_NAME_DEFAULT = "default";
        @SerializedName(SERIALIZED_NAME_DEFAULT)
            private Object _default;

        public static final String SERIALIZED_NAME_VALUES = "values";
        @SerializedName(SERIALIZED_NAME_VALUES)
            private List<Object> values = null;


        public KeyManagerApplicationConfigurationDTO name(String name) {
        
        this.name = name;
        return this;
        }

    /**
        * Get name
    * @return name
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "consumer_key", value = "")
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


        public KeyManagerApplicationConfigurationDTO label(String label) {
        
        this.label = label;
        return this;
        }

    /**
        * Get label
    * @return label
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Consumer Key", value = "")
    
    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }


        public KeyManagerApplicationConfigurationDTO type(String type) {
        
        this.type = type;
        return this;
        }

    /**
        * Get type
    * @return type
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "select", value = "")
    
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


        public KeyManagerApplicationConfigurationDTO required(Boolean required) {
        
        this.required = required;
        return this;
        }

    /**
        * Get required
    * @return required
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isRequired() {
        return required;
    }


    public void setRequired(Boolean required) {
        this.required = required;
    }


        public KeyManagerApplicationConfigurationDTO mask(Boolean mask) {
        
        this.mask = mask;
        return this;
        }

    /**
        * Get mask
    * @return mask
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isMask() {
        return mask;
    }


    public void setMask(Boolean mask) {
        this.mask = mask;
    }


        public KeyManagerApplicationConfigurationDTO multiple(Boolean multiple) {
        
        this.multiple = multiple;
        return this;
        }

    /**
        * Get multiple
    * @return multiple
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isMultiple() {
        return multiple;
    }


    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }


        public KeyManagerApplicationConfigurationDTO tooltip(String tooltip) {
        
        this.tooltip = tooltip;
        return this;
        }

    /**
        * Get tooltip
    * @return tooltip
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Enter username to connect to key manager", value = "")
    
    public String getTooltip() {
        return tooltip;
    }


    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }


        public KeyManagerApplicationConfigurationDTO _default(Object _default) {
        
        this._default = _default;
        return this;
        }

    /**
        * Get _default
    * @return _default
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "admin", value = "")
    
    public Object getDefault() {
        return _default;
    }


    public void setDefault(Object _default) {
        this._default = _default;
    }


        public KeyManagerApplicationConfigurationDTO values(List<Object> values) {
        
        this.values = values;
        return this;
        }

    /**
        * Get values
    * @return values
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<Object> getValues() {
        return values;
    }


    public void setValues(List<Object> values) {
        this.values = values;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            KeyManagerApplicationConfigurationDTO keyManagerApplicationConfiguration = (KeyManagerApplicationConfigurationDTO) o;
            return Objects.equals(this.name, keyManagerApplicationConfiguration.name) &&
            Objects.equals(this.label, keyManagerApplicationConfiguration.label) &&
            Objects.equals(this.type, keyManagerApplicationConfiguration.type) &&
            Objects.equals(this.required, keyManagerApplicationConfiguration.required) &&
            Objects.equals(this.mask, keyManagerApplicationConfiguration.mask) &&
            Objects.equals(this.multiple, keyManagerApplicationConfiguration.multiple) &&
            Objects.equals(this.tooltip, keyManagerApplicationConfiguration.tooltip) &&
            Objects.equals(this._default, keyManagerApplicationConfiguration._default) &&
            Objects.equals(this.values, keyManagerApplicationConfiguration.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, label, type, required, mask, multiple, tooltip, _default, values);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class KeyManagerApplicationConfigurationDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    mask: ").append(toIndentedString(mask)).append("\n");
    sb.append("    multiple: ").append(toIndentedString(multiple)).append("\n");
    sb.append("    tooltip: ").append(toIndentedString(tooltip)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

