package ru.belenko.steam.invest.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.belenko.steam.invest.app.exceptionhandling.dto.ErrorInfo;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private Boolean success;
    private T body;
    private ErrorInfo error;

    public static <T> BaseResponse<T> success(T body) {
        BaseResponse<T> response = new BaseResponse<>();
        response.success = true;
        response.body = body;
        return response;
    }
    public static <T> BaseResponse<T> fail(ErrorInfo body) {
        BaseResponse<T> response = new BaseResponse<>();
        response.success = false;
        response.error = body;
        return response;
    }
}
