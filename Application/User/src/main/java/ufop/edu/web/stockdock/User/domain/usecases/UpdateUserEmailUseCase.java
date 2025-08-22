package ufop.edu.web.stockdock.User.domain.usecases;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateUserEmailUseCase {
    
    private String emailModel;
    private String emailPassed;

    public void validate(){
        validateEmail();
    }

    public void validateEmail(){
        if(!emailModel.equals(emailPassed)){
            throw new RuntimeException("Email já está em uso");
        }
    }

}
