package lk.ijse.dep11.pos.advisor;

import lk.ijse.dep11.pos.exeception.NotFoundException;
import lk.ijse.dep11.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,
                        "Error!",
                        notFoundException.getMessage()), HttpStatus.NOT_FOUND
        );
    }
}
