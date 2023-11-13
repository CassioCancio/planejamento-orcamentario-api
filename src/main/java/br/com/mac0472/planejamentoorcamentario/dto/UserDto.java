package br.com.mac0472.planejamentoorcamentario.dto;

import br.com.mac0472.planejamentoorcamentario.entity.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class UserDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String nusp;

    @NotNull
    private Profile profile;
}
