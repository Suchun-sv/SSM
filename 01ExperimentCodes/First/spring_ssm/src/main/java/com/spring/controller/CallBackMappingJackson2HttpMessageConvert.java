package com.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CallBackMappingJackson2HttpMessageConvert extends MappingJackson2HttpMessageConverter {
    //做jsonP统一支持标识
    private String callbackName;
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String callbackParam=request.getParameter(callbackName);
        if(StringUtils.isEmpty(callbackParam)){
            super.writeInternal(object, outputMessage);//调用父类方法直接返回。
        }else{
            JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
            try {
                String result =callbackParam+"("+super.getObjectMapper().writeValueAsString(object)+");";
                IOUtils.write(result, outputMessage.getBody(),encoding.getJavaName());
            }
            catch (JsonProcessingException ex) {
                throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
            }
        }

        super.writeInternal(object, outputMessage);
    }

    public void setCallbackName(String callbackName) {
        this.callbackName = callbackName;
    }

    public String getCallbackName() {
        return callbackName;
    }
}
