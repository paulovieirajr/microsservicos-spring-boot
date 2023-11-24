package io.github.paulovieirajr.msclientes.core.domain.entities;

import io.github.paulovieirajr.msclientes.core.domain.exception.ClientException;

public class Client {

    private String name;
    private String cpf;
    private Integer age;

    public Client(String name, String cpf, Integer age) {
        if (!isNameValid(name)) {
            throw new ClientException("Nome é obrigatório");
        }
        if (!isCpfValid(cpf)) {
            throw new ClientException("CPF inválido");
        }
        if (!isAgeValid(age)) {
            throw new ClientException("Idade é obrigatória");
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
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }
        if ((cpf.charAt(9) - '0') != digito1) {
            return false;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }
        return (cpf.charAt(10) - '0') == digito2;
    }

    boolean isAgeValid(Integer age) {
        return age != null && age > 0;
    }
}
