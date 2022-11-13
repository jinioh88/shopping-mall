package com.shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotEmpty
    @Length(min = 8, max = 16)
    private String password;
    @NotEmpty
    private String address;
}
