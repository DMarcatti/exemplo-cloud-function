package br.com.marcatti.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaVo {

    private UUID uuid;
    private String nome;
    private String email;
}

