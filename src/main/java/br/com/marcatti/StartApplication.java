package br.com.marcatti;

import br.com.marcatti.dto.PessoaDto;
import br.com.marcatti.vo.PessoaVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	List<PessoaVo> pessoaVoList = new ArrayList<>();


	@Bean
	public Function<String, PessoaVo> function(){
		return  input -> find(input);

	}

	@Bean
	public Consumer<PessoaDto> consume(){
		return input ->
				pessoaVoList.add(
					PessoaVo.builder()
							.uuid(UUID.randomUUID())
							.nome(input.getNome())
							.email(input.getEmail())
							.build()
				);
	}

	@Bean
	public Supplier<List<PessoaVo>> supply(){
		return () -> pessoaVoList;
	}


	private PessoaVo find(String nome){
		return  pessoaVoList.stream()
						.filter(p -> nome.equals(p.getNome()))
						.findAny()
						.orElse(null);
	}

}
