package io.github.paulovieirajr.msclientes.core.domain.entities;

import io.github.paulovieirajr.msclientes.core.domain.exception.ClientException;
import io.github.paulovieirajr.msclientes.core.domain.util.CpfValidator;

public class Client {

    private String name;
    private String cpf;
    private Integer age;

    public Client(String name, String cpf, Integer age) {
        if (!isNameValid(name)) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (!isCpfValid(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        if (!isAgeValid(age)) {
            throw new IllegalArgumentException("Idade é obrigatória");
        }
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getAge() {
        return age;
    }

    boolean isNameValid(String name) {
        return name != null && !name.isBlank() && !name.isEmpty();
    }

    boolean isCpfValid(String cpf) {
        var cpfValidator = new CpfValidator();
        return cpfValidator.isCpfValid(cpf);
    }

    boolean isAgeValid(Integer age) {
        return age != null && age > 0;
    }
}
