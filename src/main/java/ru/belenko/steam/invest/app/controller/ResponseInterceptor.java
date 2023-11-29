package ru.belenko.steam.invest.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.belenko.steam.invest.app.controller.dto.BaseResponse;
import ru.belenko.steam.invest.app.exceptionhandling.dto.ErrorInfo;

@RestControllerAdvice
@RequiredArgsConstructor
public class ResponseInterceptor implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        Object responseBody = new Object();
        System.out.println("hello");
        if(body instanceof ErrorInfo) {
            responseBody = BaseResponse.fail((ErrorInfo) body);
        } else if (!(body instanceof BaseResponse) && !(body instanceof String)) {
            responseBody = BaseResponse.success(body);
        }
        return responseBody;
    }
}
