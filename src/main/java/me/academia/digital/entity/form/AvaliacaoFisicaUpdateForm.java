package me.academia.digital.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Data
public class AvaliacaoFisicaUpdateForm {

  @NotNull(message = "Preencha o campo corretamente.")
  @Past( message = "Data '${validatedValue}' é inválida.")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Past( message = "Data '${validatedValue}' é inválida.")
  private double altura;
}
